<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<jsp:include page="../header.jsp"/>
<head>
    <%--<link rel="stylesheet" type='text/css' href="<c:url value='https://code.jquery.com/ui/1.12.0/themes/smoothness/jquery-ui.css'/>"/>--%>

    <%--<script src="https://code.jquery.com/jquery-1.12.4.js"></script>--%>
    <%--<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>--%>
    <%--<script>--%>
        <%--$( function() {--%>
            <%--function log( message ) {--%>
                <%--$( "<div>" ).text( message ).prependTo( "#log" );--%>
                <%--$( "#log" ).scrollTop( 0 );--%>
            <%--}--%>

            <%--$( "#birds" ).autocomplete({--%>
                <%--source: function( request, response ) {--%>
                    <%--$.ajax( {--%>
                        <%--url: "http://localhost:8082/turnos/restSocio/list",--%>
                        <%--dataType: "json",--%>
                        <%--data: {--%>
                            <%--term: request.term--%>
                        <%--},--%>
                        <%--success: function(data){--%>
                            <%--if(data.length == 0) return response(["No matching cities found for " + request.term]);--%>
                            <%--response( $.map(data, function(item){--%>
                                        <%--return{--%>
                                            <%--label: item.nombre,--%>
                                            <%--value: item.apellido--%>
                                        <%--};--%>
                                    <%--})--%>
                            <%--);--%>
                        <%--}--%>
                    <%--} );--%>

                <%--},--%>
                <%--minLength: 4,--%>
                <%--select: function( event, ui ) {--%>
                    <%--log( "Selected: " + ui.item.value + " aka " + ui.item.nombre );--%>
                <%--}--%>
            <%--} );--%>
        <%--} );--%>
    <%--</script>--%>

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
                <li><a href="#"><i class="fa fa-dashboard"></i> Banners</a></li>
                <li class="active">Todos</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-6">
                    <div class="box box-primary">
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form:form modelAttribute="notificacion" action="/turnos/notificacion/save"  method="post">
                            <div class="box-body">
                                <div class="row">
                                    <div class="form-group col-md-6">
                                        <h4 for="desde"><span class="label label-primary">Desde</span></h4>
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-calendar"></i>
                                            </div>
                                            <input name="desde" type="text" class="form-control date">
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="form-group col-md-6">
                                        <h4 for="hasta"><span class="label label-primary">Hasta</span></h4>
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-calendar"></i>
                                            </div>
                                            <input name="hasta" type="text" class="form-control date">
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="form-group col-md-12">
                                        <h4 for="message"><span class="label label-primary">Mensaje</span></h4>
                                        <textarea name="message" class="form-control" maxlength="255" placeholder="Ingrese el mensaje de la notificacion" rows="3" required></textarea>
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary">Guardar</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </section>
        <%--<br /><br />--%>
        <%--<div class="ui-widget">--%>
            <%--<label for="birds">Birds: </label>--%>
            <%--<input id="birds">--%>
        <%--</div>--%>

        <%--<div class="ui-widget" style="margin-top:2em; font-family:Arial">--%>
            <%--Result:--%>
            <%--<div id="log" style="height: 200px; width: 300px; overflow: auto;" class="ui-widget-content"></div>--%>
        <%--</div>--%>

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

</body>
</html>
