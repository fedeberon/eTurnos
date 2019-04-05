<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML>
<html>
<jsp:include page="../header.jsp"/>
<link rel="stylesheet" href="<c:url value='/resources/plugins/datatables/dataTables.bootstrap.css'/>">

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../menu.jsp"/>
    <jsp:include page="../panel-usuario.jsp"/>
    <div class="content-wrapper">

        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Usuarios<small>Todos</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Usuarios</a></li>
                <li class="active">Todos</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Usuarios de Sistema</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="usuarios" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Login</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Mail</th>
                                    <th>Rol</th>
                                    <th>Last Loguin</th>
                                    <sec:authorize access="hasAnyRole('ROLE_CONFIG','ROLE_ADMIN')">
                                        <th>Actividad</th>
                                    </sec:authorize>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${usuarios}" var="bo">
                                    <tr>
                                        <td>${bo.id}</td>
                                        <td><a href="<c:url value='/usuarios/get/${bo.username}'/>">${bo.username}</a></td>
                                        <td>${bo.nombre}</td>
                                        <td>${bo.apellido}</td>
                                        <td>${bo.mail}</td>
                                        <td>${bo.rol}</td>
                                        <td><fmt:formatDate value="${bo.lastLoguin}" pattern="dd/MM/yyyy HH:mm"/></td>
                                        <sec:authorize access="hasAnyRole('ROLE_CONFIG','ROLE_ADMIN')">
                                            <td><a href="/turnos/actividad/porUsuario?id=${bo.username}"><span class="glyphicon glyphicon-list-alt"></span></a></td>
                                        </sec:authorize>

                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->

                <div class="col-xs-12">
                    <div class="col-xs-2">
                        <a href="/turnos/usuarios/list?page=${page - 1}" class="btn btn-block btn-primary">Atras</a>
                    </div>
                    <div class="col-xs-2">
                        <a href="/turnos/usuarios/list?page=${page + 1}" class="btn btn-block btn-primary">Siguiente</a>
                    </div>
                </div>

            </div>
            <!-- /.row -->


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
            "paging": false,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": false,
            "autoWidth": false
        });
    });
</script>

</body>
</html>
