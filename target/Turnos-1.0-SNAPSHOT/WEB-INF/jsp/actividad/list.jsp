<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://localhost:8083/turnos/functions" prefix="f" %>

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
                Actividades <small> Todos</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Actividades</a></li>
                <li class="active">Todos</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">

                            <%--<form action="<c:url value='/socio/buscar'/>">--%>
                                <%--<div class="input-group input-group-sm">--%>
                                    <%--<input type="text" class="form-control" name="valor" placeholder="Ingrese datos del socio a buscar ..">--%>
                                    <%--<span class="input-group-btn">--%>
                                      <%--<button type="submit" class="btn btn-info btn-flat">Buscar!</button>--%>
                                    <%--</span>--%>
                                <%--</div>--%>
                            <%--</form>--%>

                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="usuarios" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>Codigo</th>
                                    <th>Momento</th>
                                    <th>Actividad</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${actividades}" var="bo">
                                    <tr>
                                        <td>${bo.id}</td>
                                        <td>${f:formatLocalDateTime(bo.momento, 'dd/MM/yyyy HH:mm:ss')}</td>
                                        <td>${bo.actividad}</td>
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
                        <a href="/turnos/actividad/porUsuario?id=${bo.id}&page=${page - 1}" class="btn btn-block btn-primary">Atras</a>
                    </div>
                    <div class="col-xs-2">
                        <a href="/turnos/actividad/porUsuario?id=${bo.id}&page=${page + 1}" class="btn btn-block btn-primary">Siguiente</a>
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
