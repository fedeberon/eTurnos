<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                Turnos <small> Por orden de llamada</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Turnos</a></li>
                <li class="active">Todos</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Turnos por Orden de llamada</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="turnosOrdenados" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>Cod Int</th>
                                    <th>Turno</th>
                                    <th>Estado</th>
                                    <th>Orden</th>
                                    <th>Fecha</th>
                                    <th>Cliente</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${turnosOrdenados}" var="bo">
                                    <tr>
                                        <td>${bo.turno.id}</td>
                                        <td>${bo.turno.numeroTicket}</td>
                                        <td>${bo.estado}</td>
                                        <td>${bo.orden}</td>
                                        <td><fmt:formatDate value="${bo.fecha}" pattern="dd/MM/yyyy HH:mm"/></td>
                                        <td>
                                        <c:choose>
                                            <c:when test="${bo.turno.cliente != null}">
                                                Socio ${bo.turno.cliente.apellido} - ${bo.turno.cliente.nombre}
                                            </c:when>
                                            <c:otherwise>
                                                No Socio
                                            </c:otherwise>
                                        </c:choose>


                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <th>Cod Int</th>
                                    <th>Orden</th>
                                    <th>Estado</th>
                                    <th>Fecha</th>
                                </tr>
                                </tfoot>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->

                <div class="col-xs-12">
                    <div class="col-xs-2">
                        <a href="/turnos/turno/list?page=${page - 1}" class="btn btn-block btn-primary">Atras</a>
                    </div>
                    <div class="col-xs-2">
                        <a href="/turnos/turno/list?page=${page + 1}" class="btn btn-block btn-primary">Siguiente</a>
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
    $(function () {
        $('#turnosOrdenados').DataTable({
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
