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
                        <%--<div class="box-header">--%>

                            <%--<form action="<c:url value='/socio/buscar'/>">--%>
                                <%--<div class="input-group input-group-sm">--%>
                                    <%--<input type="text" class="form-control" name="valor" value="${valor}" placeholder="Ingrese datos del socio a buscar ..">--%>
                                    <%--<span class="input-group-btn">--%>
                                      <%--<button type="submit" class="btn btn-info btn-flat">Buscar!</button>--%>
                                    <%--</span>--%>
                                <%--</div>--%>
                            <%--</form>--%>

                        <%--</div>--%>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="notificacion" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>Codigo</th>
                                    <th>Mensaje</th>
                                    <th>Desde</th>
                                    <th>Hasta</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${notificacion}" var="bo">
                                    <tr>
                                        <td><a href="<c:url value='/notificacion/${bo.id}'/>">${bo.id}</a></td>
                                        <td>${bo.message}</td>
                                        <td>${bo.desde}</td>
                                        <td>${bo.hasta}</td>
                                        <td><span class="glyphicon glyphicon-remove"></span></td>
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
                    <%--<form action="<c:url value='/socio/exportarQR'/>">--%>
                        <%--<div class="col-xs-2">--%>
                            <%--<input type="hidden" value="${valor}" name="valor"/>--%>
                            <%--<button type="submit" class="btn btn-block btn-primary">Exportar QR</button>--%>
                        <%--</div>--%>
                    <%--</form>--%>
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
