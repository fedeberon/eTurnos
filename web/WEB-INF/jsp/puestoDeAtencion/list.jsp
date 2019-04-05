<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                Puestos <small> Todos</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Puesto de Atencion</a></li>
                <li class="active">Todos</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-md-12">

                    <c:forEach items="${puestos}" var="puesto">

                        <div class="col-md-4">
                            <!-- Widget: user widget style 1 -->
                            <div class="box box-widget widget-user">
                                <!-- Add the bg color to the header using any of the bg-* classes -->
                                <div class="widget-user-header ${puesto.estado == 'DISPONIBLE' ? 'bg-aqua-active' : 'bg-green-active' }">

                                    <%--<c:if test="${puesto.usuarioAsiganado != null}">--%>
                                        <h3 class="widget-user-username">${puesto.usuarioAsiganado}</h3>

                                       <c:choose>
                                           <c:when test="${puesto.usuarioAsiganado != null}">
                                               <h5 class="widget-user-desc">Logueado desde: <fmt:formatDate value="${puesto.ultimoLogueo}" pattern="dd/MM/yyyy HH:mm"/></h5>
                                               <h5 class="widget-user-desc">Tiempo Atendiendo: ${tiempoActivoDeUsuario}</h5>
                                           </c:when>
                                           <c:otherwise>
                                                <h5 class="widget-user-desc">&Uacute;ltimo logueo: <fmt:formatDate value="${puesto.ultimoLogueo}" pattern="dd/MM/yyyy HH:mm"/></h5>
                                           </c:otherwise>
                                       </c:choose>

                                    <%--</c:if>--%>


                                </div>
                                <div class="widget-user-image">
                                    <%--<img class="img-circle" src="" alt="User Avatar">--%>
                                </div>

                                    <div class="box-footer">
                                        <div class="row">
                                            <div class="col-sm-4 border-right">
                                                <div class="description-block">
                                                    <span class="description-text">Puesto</span>
                                                    <h5 class="description-header">${puesto.id}</h5>
                                                </div>
                                                <!-- /.description-block -->
                                            </div>
                                            <!-- /.col -->
                                            <div class="col-sm-4 border-right">
                                                <div class="description-block">
                                                    <span class="description-text">Atenciones de hoy</span>
                                                    <h5 class="description-header">${puesto.turnosAtendidos}</h5>
                                                </div>
                                                <!-- /.description-block -->
                                            </div>
                                            <!-- /.col -->
                                            <div class="col-sm-4">
                                                <div class="description-block">
                                                    <span class="description-text">Ausentes</span>
                                                    <h5 class="description-header">${puesto.turnosAusentes}</h5>
                                                </div>
                                                <!-- /.description-block -->
                                            </div>
                                            <!-- /.col -->
                                        </div>
                                        <!-- /.row -->
                                    </div>
                            </div>
                            <!-- /.widget-user -->
                        </div>
                    </c:forEach>
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
</body>
</html>
