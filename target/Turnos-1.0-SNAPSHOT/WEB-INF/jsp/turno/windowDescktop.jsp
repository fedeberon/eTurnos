<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML>
<html>
<jsp:include page="../header.jsp"/>
<head>
    <style>
        .content {
            min-height: 100px;
        }
    </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <header class="main-header">

        <nav class="navbar navbar-static-top" role="navigation">

            <div class="navbar-custom-menu">

                <ul class="nav navbar-nav">
                    <li class="dropdown user user-menu">
                        <a href="#" class="logo">
                            <span class="logo-lg">
                                <b>Turnos </b>C.C.I.B.
                            </span>
                        </a>
                    </li>
                </ul>
            </div>

            <a href="#" class="sidebar-toggle" data-toggle="control-sidebar" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>

        </nav>

    </header>

    <div class="content-wrapper">
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <sec:authorize access="hasAnyRole('ROLE_USER')">
                    <c:choose>
                        <c:when test="${!empty turnosPendientesDePuesto}">
                            <div id="turnos-content" class="box-body">

                                <c:forEach items="${turnosPendientesDePuesto}" var="turnoPendiente">
                                    <div id="turno-box-template" class="col-md-12">
                                        <div class="info-box">
                                        <span id="box-nro-turno" class="info-box-icon bg-yellow">
                                                ${turnoPendiente.turno.numeroTicket}
                                        </span>

                                            <div class="box-body">

                                                <a class="btn btn-app" href="#">
                                                    <i class="fa">${turnoPendiente.turno.rellamados != null ? turnoPendiente.turno.rellamados : "Sin"}</i>
                                                    Rellamadas
                                                </a>

                                                <a class="btn btn-app"
                                                   href="<c:url value='/turno/desktopAtendido?idTurno=${turnoPendiente.turno.id}'/>">
                                                    <i class="fa fa-play"></i>Atendido.
                                                </a>

                                                <a class="btn btn-app"
                                                   href="<c:url value='/turno/desktopAusentar?idTurno=${turnoPendiente.turno.id}'/>">
                                                    <i class="fa fa-hourglass-end"></i> Ausentar
                                                </a>

                                                <a class="btn btn-app"
                                                   href="<c:url value='/turno/desktopRellamar?idTurno=${turnoPendiente.turno.id}'/>">
                                                    <i class="fa fa-repeat"></i> Rellamar
                                                </a>

                                            </div>

                                        </div>
                                    </div>
                                </c:forEach>
                                <!-- fix for small devices only -->
                                <div class="clearfix visible-sm-block"></div>

                            </div>
                        </c:when>

                        <c:otherwise>

                            <c:choose>
                                <c:when test="${ultimaActividad.actividad == 'ATENDIENDO'}">
                                    <a class="btn btn-app ${cantidadTurnosPorAtender == 0 ? 'disabled' : ''}"
                                       href="/turnos/turno/solicitar">
                                        <span class="badge bg-yellow">${cantidadTurnosPorAtender}</span>
                                        <i class="fa fa-bullhorn"></i> Llamar
                                    </a>

                                    <a class="btn btn-app" href="/turnos/usuarios/desktopDejarDeAtender">
                                        <span class="badge bg-green"></span>
                                        <i class="fa fa-coffee"></i> Dejar de Atender
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a class="btn btn-app" href="/turnos/usuarios/desktopAtender">
                                        <span class="badge bg-green"></span>
                                        <i class="fa fa-coffee"></i> Atender
                                    </a>
                                </c:otherwise>
                            </c:choose>

                        </c:otherwise>

                    </c:choose>
                </sec:authorize>
            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>

<%--<jsp:include page="../footer.jsp"/>--%>

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

<c:if test="${cantidadTurnosPorAtender == 0}">
    <script type="text/javascript">
        setTimeout(function () {
            location.reload();
        }, 5000);
    </script>
</c:if>

</body>
</html>
