<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<jsp:include page="../header.jsp"/>
<head>

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
            font-weight: normal;
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

                $( "<label id='labelSocioANotificar' class='itemSocioANotificar socio-)'>" ).text( message ).prependTo( "#log" );
                $( "#log" ).scrollTop( 0 );

                inputSocio.prependTo("#formSocios");
                inputNotificacion.prependTo("#formSocios");
                indice++;

                $("#log").on('click', 'label', indice, function () {

                    $(this).remove();
                    var clase = $(this).attr('class' + indice);
                    alert(clase);
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
                                    label: v.nombre,
                                    cuit: v.cuit,
                                    apellido: v.apellido,
                                    id: v.id
                                };
                            })), function (item) {
                                return matcher.test(item.label);
                            }))
                        }});
                },
                minLength: 2,
                select: function( event, ui ) {
                    log(ui.item.id,  ui.item.label + "  " + ui.item.apellido + ui.item.cuit);
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
            <br>
            <br>
        </section>

        <!-- Main content -->
        <section class="content">

            <form:form modelAttribute="notificacionSocio" action="save" method="post" id="formSocios" data-toggle="validator" role="form" path="notificaciones">
                <div class="row">
                    <div class="col-md-10 input-group ">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <label for="socios" class="dropdown-menu"></label>
                        <input id="socios" type="text" class="form-control" placeholder="Agregar Socios" onclick="this.select()" required>
                    </div>
                    <c:if test='${empty notificacion}'>
                        <%--<form:errors cssClass="text-danger bg-danger" path="notificaciones"/>--%>
                        <div class="container">
                            <p class="text-danger">Socio no encontrado</p>
                        </div>
                    </c:if>
                </div>
                <br>
                <br>

                <div class="row">
                    <div class="col-md-10 ui-widget">
                        <h4><span class="label label-primary">Socios a notificar</span></h4>
                        <div id="log" style="height: 150px; overflow: auto;" class="ui-widget-content"></div>
                    </div>
                </div>

                <br/>

                <div class="row">
                    <div class="col-md-10">
                        <h4><span class="label label-primary">Mensaje</span></h4>
                        <p class="itemSocioANotificar" >${notificacion.message}</p>
                    </div>
                </div>

                <br/>

                <div class="">
                    <button type="submit" class="btn btn-primary" action="save"  method="post">Guardar</button>
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