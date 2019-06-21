<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML>
<html>
<jsp:include page="../header.jsp"/>

<head>

    <style>
        .modal-dialog{
            position: absolute;
            left: 50%;
            /* now you must set a margin left under zero - value is a half width your window */
            margin-left: -312px;
            /* this same situation is with height - example */
            height: 500px;
            top: 50%;
            margin-top: -250px;
        }
    </style>

</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../menu.jsp"/>
    <jsp:include page="../panel-usuario.jsp"/>
    <div class="content-wrapper">

        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Turnos
                <small>Llamadas</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Turnos</a></li>
                <li class="active">Panel de administraci&oacute;n</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="row">

            <sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_CONFIG')">
                <c:if test="${!empty turnosPendientesDePuesto}">
                    <jsp:include page="panel-turnos/panel-turno-pendiente.jsp"/>
                </c:if>

                <jsp:include page="panel-turnos/panel-llamador-turno.jsp"/>
            </sec:authorize>
            </div>

            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <jsp:include page="modales/modal-llamar-turno.jsp"/>

    </div>

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
