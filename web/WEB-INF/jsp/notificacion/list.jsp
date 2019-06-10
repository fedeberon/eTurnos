<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
                Notificaciones <small> Todas</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Notificaciones</a></li>
                <li class="active">Todos</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-body">
                            <table id="notificacion" class="table table-bordered table-hover">
                                <thead class="thead-dark">
                                <tr>
                                    <th>Codigo</th>
                                    <th>Mensaje</th>
                                    <th>Desde</th>
                                    <th>Hasta</th>
                                    <th>Agregar socio a notificar</th>
                                    <th>Editar notificaci&oacute;n</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${notificacion}" var="bo" >
                                    <tr>
                                        <td class="col-md-1">${bo.id}</td>
                                        <td class="col-md-5">${bo.message}</td>
                                        <td class="col-md-2"><fmt:formatDate value="${bo.desde}" pattern="dd-MM-yyyy"/></td>
                                        <td class="col-md-2"><fmt:formatDate value="${bo.hasta}" pattern="dd-MM-yyyy"/></td>
                                        <td class="col-md-1"> <a class="btn btn-primary" href="<c:url value='/notificacionSocio/create?id=${bo.id}'/>"/>Agregar Socios</td>
                                        <td class="col-md-1"> <a class="btn btn-primary" href="<c:url value='/notificacion/update?id=${bo.id}'/>"/>Editar</td>
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
                        <a href="/turnos/notificacion/list?page=${page - 1}" class="btn btn-block btn-primary">Atras</a>
                    </div>
                    <div class="col-xs-2">
                        <a href="/turnos/notificacion/list?page=${page + 1}" class="btn btn-block btn-primary">Siguiente</a>
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
<script src="<c:url value='/resources/plugins/datatables/jquery.dataTables.js'/>"></script>
<!-- AdminLTE App -->
<script src="<c:url value='/resources/dist/js/app.js'/>"></script>

<script>
</script>

</body>
</html>
