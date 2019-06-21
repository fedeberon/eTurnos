<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>
<!DOCTYPE HTML>
<html>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="menu.jsp"/>
    <jsp:include page="panel-usuario.jsp"/>
    <div class="content-wrapper">

        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Area de acceso restringido<small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Permisos</a></li>
                <li class="active">accesos</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">


            <div class="error-page">
                <%--<h2 class="headline text-yellow"> 404</h2>--%>

                <div class="error-content">
                    <h3><i class="fa fa-warning text-yellow"></i> No tiene permisos.</h3>

                    <p>
                        Solicite al administrador los permisos para el acceso a la pagina solicitada.
                    </p>

                </div>
                <!-- /.error-content -->
            </div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <jsp:include page="footer.jsp"/>

    <jsp:include page="menu-derecho.jsp"/>

    <div class="control-sidebar-bg"></div>
</div>

<!-- jQuery 2.2.0 -->
<script src="<c:url value='/resources/plugins/jQuery/jQuery-2.2.0.min.js'/>"></script>
<!-- Bootstrap 3.3.5 -->
<script src="<c:url value='/webjarslocator/bootstrap/js/bootstrap.min.js'/>"></script>
<!-- AdminLTE App -->
<script src="<c:url value='/resources/dist/js/app.min.js'/>"></script>
</body>
</html>
