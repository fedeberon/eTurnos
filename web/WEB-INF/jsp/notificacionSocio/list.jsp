<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<jsp:include page="../header.jsp"/>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../menu.jsp"/>
    <jsp:include page="../panel-usuario.jsp"/>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Notificaciones del socio <small> Todas</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Socios</a></li>
                <li class="active">Todos</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-body">
                            <table id="usuarios" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>Codigo</th>
                                    <th>Notificacion</th>
                                    <th>Desde</th>
                                    <th>Hasta</th>
                                    <th>Socio</th>
                                    <th>Estado</th>
                                    <th></th>

                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${notificaciones}" var="bo">
                                    <tr>
                                        <td>${bo.id}</td>
                                        <td>${bo.notificacion.message}</td>
                                        <td>${bo.notificacion.desde}</td>
                                        <td>${bo.notificacion.hasta}</td>
                                        <td>${bo.socio.nombre} ${bo.socio.apellido}</td>
                                        <td>${bo.estado}</td>
                                        <td>
                                            <a href="activar?id=${bo.id}"><span class="glyphicon glyphicon-ok" title="Activar notificacion"></span></a>
                                            <a href="desactivar?id=${bo.id}"><span class="iconoActivar glyphicon glyphicon-remove" title="Desactivar notificacion"></span></a>
                                        </td>
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
<script src="<c:url value='/resources/plugins/datatables/jquery.dataTables.js'/>"></script>
<!-- AdminLTE App -->
<script src="<c:url value='/resources/dist/js/app.js'/>"></script>


</body>
</html>
