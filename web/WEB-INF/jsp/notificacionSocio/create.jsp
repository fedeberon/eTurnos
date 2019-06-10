<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<jsp:include page="../header.jsp"/>
<head>
    <link rel="stylesheet" type="text/css" href="../../../resources/notificacionSocio/create.css">
    <style>
        .ui-autocomplete-loading {
            background: white url('/resources/dist/img/giphy.gif') right center no-repeat;
        }

        .itemSocioANotificar {
            background-color: #E5E5E5;
            border-radius: 10px;
            border-color: #367fa9;
            text-transform: capitalize;
            color: #000000;
            padding: 4px;
            margin: 4px;
            font-size: 14px;
            height: 50px;
            font-weight: normal;
        }
        .my-custom-scrollbar {
            position: relative;
            height: 300px;
            overflow: auto;
        }
        .table-wrapper-scroll-y {
            display: block;
        }
        .column{
            margin-top: 15px;
        }

    </style>

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $( function() {
            var indice = 0;
            function log(id, message ) {

                var inputSocio = $('<input>',{
                    type:'hidden',
                    name: 'notificaciones[' + indice  + '].socio.id',
                    value: id,
                    class: 'socio-' + indice
                });

                var inputNotificacion = $('<input>',{
                    type:'hidden',
                    name: 'notificaciones[' + indice  + '].notificacion.id',
                    value: ${notificacion.id},
                    class:'socio-' + indice,
                });

                $( "<label id='labelSocioANotificar' class='itemSocioANotificar socio-" + indice + "'>" ).text( message ).prependTo( "#log" );
                $( "#log" ).scrollTop( 0 );

                inputSocio.prependTo("#formSocios");
                inputNotificacion.prependTo("#formSocios");
                indice++;

                $("#log").on('click', 'label', indice, function () {

                    $(this).remove();
                    var clase = $(this).attr('class');
                    clase = clase.substr(20, clase.length );
                    $('.'+ clase).remove();
                });
            }



            $( "#socios" ).autocomplete({
                source: function( request, response ) {
                    $.ajax( {
                        url: "/turnos/restSocio/list",
                        dataType: "json",
                        data: {
                            term: request.term
                        },
                        success: function(data){
                            var re = $.ui.autocomplete.escapeRegex(request.term);
                            var matcher = new RegExp("^" + re, "i");
                            if(data.length == 0) return response(["No matching cities found for " + request.term]);
                            response($.grep(($.map(data, function (v, i) {
                                return {
                                    value: v.nombre,
                                    apellido: v.apellido,
                                    cuit: v.cuit,
                                    id: v.id,
                                    label: v.nombre + ' ' + v.apellido + ' - ' + v.cuit,
                                };
                            })), function (item) {
                                return matcher.test(item.label);

                            }))
                        }});
                },
                minLength: 2,
                select: function( event, ui ) {
                    log(ui.item.id,  ui.item.label);
                }
            } );
        } );
        $(document).on('ready', function (){
            $.getJSON("/turnos/restSocio/list", function(data) {
                $.each(data, function(key, value) {
                    $("#firmaNotificacion").append('<option name="' + value.id + '">' + value.firma + '</option>');
                }); // close each()
            }); // close getJSON()
        });
    </script>

</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../menu.jsp"/>
    <jsp:include page="../panel-usuario.jsp"/>
    <div class="content-wrapper">

        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1> Notificaciones <small>Crear nueva notificacion</small></h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Notificacion-Socio</a></li>
                <li class="active">A&ntilde;adir socio a una notificacion</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <form:form modelAttribute="notificacionSocio" action="save" method="post" id="formSocios" data-toggle="validator" role="form" path="notificaciones">
                <div class="row">
                    <div class="box">
                        <div class="box box-body">

                            <div class="col-md-12 column">
                                <label for="socios" class="dropdown-menu"></label>
                                <input id="socios" type="text" class="form-control" placeholder="Agregar Socios" onclick="this.select()" required>
                            </div>
                            <div class="col-md-6 column">
                                <h4><span class="label label-primary">Socios a notificar</span></h4>
                                <div id="log" style="height: 280px; overflow: auto;" class="ui-widget-content"></div>
                            </div>


                            <div  class="col-sm-6 column">
                                <div class="table-wrapper-scroll-y my-custom-scrollbar">
                                    <table class="table table-striped small">
                                        <thead class="bg-primary">
                                        <tr>
                                            <th>Codigo interno</th>
                                            <th>Socio</th>
                                            <th>Estado</th>
                                            <th>Eliminar</th>
                                        </tr>
                                        </thead>
                                        <c:forEach items="${sociosNotificados}" var="bo">
                                            <tr>
                                                <td> ${bo.id} </td>
                                                <td> ${bo.socio}</td>
                                                <td> ${bo.estado}</td>
                                                <td class="text-center"><a href="delete?id=${bo.id}"><span class="glyphicon glyphicon-trash"></span></a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                            </div>

                            <c:if test='${empty notificacion}'>
                                <%--<form:errors cssClass="text-danger bg-danger" path="notificaciones"/>--%>
                                <div class="container">
                                    <p class="text-danger">Socio no encontrado</p>
                                </div>
                            </c:if>


                            <div class="col-md-12 column">
                                <h4><span class="label label-primary">Mensaje</span></h4>
                                <p class="itemSocioANotificar" >${notificacion.message}</p>
                            </div>


                            <div class="col-md-6 column">
                            <button type="submit" class="btn btn-primary" action="save"  method="post">Guardar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form:form>

        </section>
        <!-- /.box -->
    </div>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->


<jsp:include page="../footer.jsp"/>

<jsp:include page="../menu-derecho.jsp"/>

<div class="control-sidebar-bg"></div>
</div>

<!-- jQuery 2.2.0 -->
<script src="<c:url value='/resources/plugins/jQuery/jQuery-2.2.0.min.js'/>"></script>
<script src="<c:url value='/resources/plugins/jQueryUI/jquery-ui.js'/>"></script>
<!-- Bootstrap 3.3.5 -->
<script src="<c:url value='/webjarslocator/bootstrap/js/bootstrap.min.js'/>"></script>
<!-- DataTables -->
<script src="<c:url value='/resources/plugins/datatables/jquery.dataTables.min.js'/>"></script>
<!-- AdminLTE App -->
<script src="<c:url value='/resources/dist/js/app.min.js'/>"></script>

<!-- InputMask -->
<script src="<c:url value='/resources/plugins/input-mask/jquery.inputmask.js'/>"></script>
<script src="<c:url value='/resources/plugins/input-mask/jquery.inputmask.date.extensions.js'/>"></script>
<script src="<c:url value='/resources/plugins/input-mask/jquery.inputmask.extensions.js'/>"></script>

<!-- date-range-picker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.min.js"></script>

<script type="text/javascript" src="//cdn.jsdelivr.net/momentjs/latest/moment-with-locales.min.js"></script>

<script src="<c:url value='/resources/plugins/daterangepicker/daterangepicker.js'/>"></script>
<!-- bootstrap color picker -->
<script src="<c:url value='/resources/plugins/colorpicker/bootstrap-colorpicker.min.js'/>"></script>
<!-- bootstrap time picker -->
<script src="<c:url value='/resources/plugins/timepicker/bootstrap-timepicker.min.js'/>"></script>

<script src="<c:url value='/resources/dist/js/datepicker.js'/>"></script>

<!-- style jquery-ui -->
<link rel="stylesheet" type='text/css' href="<c:url value='https://code.jquery.com/ui/1.12.0/themes/smoothness/jquery-ui.css'/>"/>
y
</body>
</html>