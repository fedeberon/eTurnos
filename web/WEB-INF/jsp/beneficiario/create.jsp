<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <%--Style CSS--%>
    <link href="../resources/beneficiario/create.css" rel="stylesheet" type="text/css">
</head>
<jsp:include page="../header.jsp"/>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../menu.jsp"/>
    <jsp:include page="../panel-usuario.jsp"/>
    <div class="content-wrapper">

        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Beneficiarios
                <small>Extension de Socio: ${socio}</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Beneficiario</a></li>
                <li class="active">Crear</li>
            </ol>
        </section>

        <!-- Main content -->
        <div class="box">
            <div class="box-header">

                <div id="scrollable">

                    <form:form name="form" modelAttribute="beneficiario" action="save" method="post">
                        <div class="form-style-8">
                            <input type="hidden" name="socioExtension.id" value="${socio.id}"/>
                            <p>
                                <label for="nombre" class="campo">Nombre:</label>
                                <form:input path="nombre" required="required"/>
                                <form:errors cssClass="form-text text-muted red" path="nombre"/>
                            </p>

                            <p class="odd">
                                <label for="apellido" class="campo">Apellido:</label>
                                <form:input path="apellido"/>
                                <form:errors cssClass="form-text text-muted red" path="apellido"/>
                            </p>

                            <p>
                                <label for="dni" class="campo" id="dni">DNI:</label>
                                <form:input path="dni"/>
                                <form:errors cssClass="form-text text-muted red" path="dni"/>
                            </p>

                            <a onclick="document.forms['form'].submit();" class="btn btn-primary">Guardar</a>
                        </div>
                    </form:form>

                </div>

            </div>

        </div>

    </div>


<jsp:include page="../footer.jsp"/>

<jsp:include page="../menu-derecho.jsp"/>

<div class="control-sidebar-bg"></div>
</div>

<!-- jQuery 2.2.0 -->
<script src="<c:url value='/resources/plugins/jQuery/jQuery-2.2.0.min.js'/>"></script>
<script src="<c:url value='/resources/plugins/jQueryUI/jquery-ui.js'/>"></script>
<!-- Bootstrap 3.3.5 -->
<script src="<c:url value='/webjarslocator/bootstrap/js/bootstrap.min.js'/>"></script>
<!-- DataTables -->
<script src="<c:url value='/resources/plugins/datatables/jquery.dataTables.min.js'/>"></script>
<!-- AdminLTE App -->
<script src="<c:url value='/resources/dist/js/app.min.js'/>"></script>

<!-- InputMask -->
<script src="<c:url value='/resources/plugins/input-mask/jquery.inputmask.js'/>"></script>
<script src="<c:url value='/resources/plugins/input-mask/jquery.inputmask.date.extensions.js'/>"></script>
<script src="<c:url value='/resources/plugins/input-mask/jquery.inputmask.extensions.js'/>"></script>

<!-- date-range-picker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.min.js"></script>

<script type="text/javascript" src="//cdn.jsdelivr.net/momentjs/latest/moment-with-locales.min.js"></script>

<script src="<c:url value='/resources/plugins/daterangepicker/daterangepicker.js'/>"></script>
<!-- bootstrap color picker -->
<script src="<c:url value='/resources/plugins/colorpicker/bootstrap-colorpicker.min.js'/>"></script>
<!-- bootstrap time picker -->
<script src="<c:url value='/resources/plugins/timepicker/bootstrap-timepicker.min.js'/>"></script>

<script src="<c:url value='/resources/dist/js/datepicker.js'/>"></script>

</body>
</html>
