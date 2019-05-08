<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<jsp:include page="../header.jsp"/>
<head>


</head>

<body class="hold-transition skin-blue sidebar-mini">
<script>
    $(document).ready(function(){
        $.ajaxSetup({ cache: false });
        $('#search').keyup(function(){
            $('#result').html('');
            $('#state').val('');
            var searchField = $('#search').val();
            var expression = new RegExp(searchField, "i");
            $.getJSON('http://localhost:8082/turnos/restSocio/list', function(data) {
                $.each(data, function(key, value){
                    if (value.nombre.search(expression) != -1 || value.apellido.search(expression) != -1)
                    {
                        $
                    }('#result').append('<li class="list-group-item link-class"> '+value.nombre+' | <span class="text-muted">'+value.apellido+'</span></li>');
                });
            });
        });
        $('#result').on('click', 'li', function() {
            var click_text = $(this).text().split('|');
            $('#search').val($.trim(click_text[0]));
            $("#result").html('');
        });
    });
</script>
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

            <%--<div class="row">--%>
                <%--<div class="col-md-6">--%>
                    <%--<form>--%>
                        <%--<div class="form-group">--%>
                            <%--<label for="exampleFormControlTextarea1">Mensaje</label>--%>
                            <%--<textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>--%>
                        <%--</div>--%>
                        <%--<div class="form-group">--%>
                            <%--<label for="exampleFormControlSelect2">Lista de socios</label>--%>
                            <%--<select multiple class="form-control" id="exampleFormControlSelect2">--%>
                            <%--</select>--%>
                        <%--</div>--%>
                    <%--</form>--%>
                <%--</div>--%>

            <div class="row">
                <div class="col-md-6">
                    <div class="box box-primary">
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form:form modelAttribute="notificacion" action="/turnos/notificacion/save"  method="post">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="message">Mensaje</label>
                                    <textarea name="message" class="form-control" placeholder="Ingrese el mensaje de la notificacion" rows="3"></textarea>
                                </div>

                                <div class="form-group">
                                    <label for="desde">Desde:</label>
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input name="desde" type="text" class="form-control date">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="hasta">Hasta:</label>
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input name="hasta" type="text" class="form-control date">
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
