<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
<jsp:include page="../header.jsp"/>
<link rel="stylesheet" href="../../plugins/datatables/dataTables.bootstrap.css">

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../menu.jsp"/>
    <jsp:include page="../panel-usuario.jsp"/>
    <div class="content-wrapper">

        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Inicio<small>Turnos en atenci&oacute;n</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Usuarios</a></li>
                <li class="active">Nuevo</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
            <div class="col-md-6">
                <!-- general form elements -->
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">Nuevo Usuario</h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <form:form modelAttribute="usuario" action="save">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="username">Login</label>
                                <form:input cssClass="form-control" path="username" placeholder="Login"/>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <form:password cssClass="form-control" path="password" placeholder="Password"/>
                            </div>
                            <div class="form-group">
                                <label>Select</label>
                                <form:select path="rol" cssClass="form-control">
                                    <form:option value="ROL_USER"/>
                                    <form:option value="ROL_ADMIN"/>
                                </form:select>
                            </div>
                        </div>
                        <!-- /.box-body -->

                        <div class="box-footer">
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </form:form>
                </div>
                <!-- /.box -->
                </div>
            </div>
        </section>
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

<script>
    $(function () {
        $('#usuarios').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false
        });
    });
</script>

</body>
</html>
