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
                Banners <small> Todos</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Banners</a></li>
                <li class="active">Todos</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">

                            <form action="<c:url value='/banner/buscar'/>">
                                <div class="input-group input-group-sm">
                                    <input type="text" class="form-control" name="valor" placeholder="Ingrese datos del Banner a buscar ..">
                                    <span class="input-group-btn">
                                      <button type="submit" class="btn btn-info btn-flat">Buscar!</button>
                                    </span>
                                </div>
                            </form>

                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="usuarios" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>Codigo</th>
                                    <th>Nombre</th>
                                    <th>Publicado</th>
                                    <th>Imagen</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${banners}" var="bo">
                                    <tr>
                                        <td>${bo.id}</td>
                                        <td>${bo.nombre}</td>
                                        <td>${bo.publicar}</td>
                                        <td>${bo.nombreDeLaImagen}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${bo.publicar}">
                                                    <a href="/turnos/banner/noPublicar?id=${bo.id}" class="btn btn-danger">No Publicar</a>
                                                </c:when>
                                                <c:otherwise>
                                                    <a href="/turnos/banner/publicar?id=${bo.id}" class="btn btn-default">Publicar</a>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <th>Codigo</th>
                                    <th>Nombre</th>
                                    <th>Publicado</th>
                                    <th>Imagen</th>
                                    <th></th>
                                </tr>
                                </tfoot>
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
