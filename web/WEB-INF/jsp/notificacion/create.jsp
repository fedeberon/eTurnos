<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                Banners
                <small>Subir Archivo</small>
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
                        <div class="box-header with-border">
                            <h3 class="box-title">Subir Archivo de publicidad</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form modelAttribute="banner" action="/turnos/bannerUpload/uploadFile" enctype="multipart/form-data"  method="post">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="nombre">Nombre de Publicidad</label>
                                    <input name="nombre" class="form-control" placeholder="Ingrese una descripcion de la publicidad"/>
                                </div>

                                <div class="form-group">
                                    <label>
                                        <input type="checkbox" name="publicar" class="minimal"/>
                                        Publicar en cartel
                                    </label>
                                </div>

                            </div>
                            <!-- /.box-body -->

                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary">Guardar</button>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
            <!-- /.box -->
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

<script src="<c:url value='/resources/plugins/websocket/sockjs.js'/>"></script>
<script src="<c:url value='/resources/plugins/websocket/stomp.js'/>"></script>
<script src="<c:url value='/resources/websocket/websocket.js'/>"></script>


</body>
</html>
