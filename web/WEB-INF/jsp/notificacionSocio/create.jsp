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
                    value: id
                });

                var inputNotificacion = $('<input>',{
                    type:'hidden',
                    name: 'notificaciones[' + indice  + '].notificacion.id',
                    value: ${notificacion.id}
                });

                $( "<div>" ).text( message ).prependTo( "#log" );
                $( "#log" ).scrollTop( 0 );

                inputSocio.prependTo("#formSocios");
                inputNotificacion.prependTo("#formSocios");

                indice++;
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
                        dni: v.dni,
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
     log(ui.item.id,  ui.item.label + "  " + ui.item.apellido);
    }
    } );
    } );
    </script>

</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../menu.jsp"/>
    <jsp:include page="../panel-usuario.jsp"/>
    <div class="content-wrapper">

        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Notificaciones
                <small>Crear nueva notificacion</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Notificacion-Socio</a></li>
                <li class="active">Añadir socio a una notificacion</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <form:form modelAttribute="notificionesSocios" action="save" method="post" id="formSocios">

                <div class="ui-widget">
                    <label for="socios">Socios: </label>
                    <input id="socios">
                </div>

                <div class="ui-widget" style="margin-top:2em; font-family:Arial">
                    Socios a notificar:
                    <div id="log" style="height: 200px; width: 300px; overflow: auto;" class="ui-widget-content"></div>
                </div>


                <div class="ui-widget">
                    <label for="socios">Mensaje: ${notificacion.message}</label>
                </div>

                <br/>

                <div class="box-footer">
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


</body>
</html>
