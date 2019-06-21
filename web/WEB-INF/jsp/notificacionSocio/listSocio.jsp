<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<jsp:include page="../header.jsp"/>
<head>
    <link rel="stylesheet" type="text/css" href="../../../resources/notificacionSocio/create.css">
    <style>
        .ui-autocomplete-loading {
            background: white url('/resources/dist/img/giphy.gif') right center no-repeat;
        }

        .itemSocioANotificar {
            background-color: #E5E5E5;
            border-radius: 10px;
            border-color: #367fa9;
            text-transform: capitalize;
            color: #000000;
            padding: 4px;
            margin: 4px;
            font-size: 14px;
            height: 50px;
            font-weight: normal;
        }
        .my-custom-scrollbar {
            position: relative;
            height: 300px;
            overflow: auto;
        }
        .table-wrapper-scroll-y {
            display: block;
        }
        .column{
            margin-top: 15px;
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
            <h1> Notificaciones <small>Lista de socios notificados</small></h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Notificacion-Socio</a></li>
                <li class="active">Lista de socios notificados</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <form:form modelAttribute="notificacionSocio" action="save" method="post" id="formSocios" data-toggle="validator" role="form" path="notificaciones">
                <input type="hidden" name="grupo" value="SOCIOS_ASIGNADOS"/>
                <input name="notificacion.id" type="hidden"/>
                <div class="row">
                    <div class="box">
                        <div class="box box-body">
                            <div class="col-md-12 column">
                                <h4><span class="label label-primary">Mensaje</span></h4>
                                <p class="itemSocioANotificar" >${notificacion.message}</p>
                            </div>
                            <div  class="col-sm-12 column">
                                <div class="table-wrapper-scroll-y my-custom-scrollbar">
                                    <table class="table table-striped">
                                        <thead class="bg-primary">
                                        <tr>
                                            <th class="text-center">Codigo interno</th>
                                            <th class="text-center">Socio</th>
                                            <th class="text-center">Estado</th>
                                            <th class="text-center">Notificaciones</th>
                                            <th class="text-center">Eliminar</th>
                                        </tr>
                                        </thead>
                                        <c:forEach items="${sociosNotificados}" var="bo">
                                            <tr>
                                                <td class="text-center">${bo.id}</td>
                                                <td class="text-center">${bo.socio}</td>
                                                <td class="text-center">${bo.estado}</td>

                                                <td class="text-center">
                                                    <a href="<c:url value='/notificacionSocio/list?idSocio=${bo.socio.id}'/>"target="_blank">
                                                        <span class="glyphicon glyphicon-eye-open"></span>
                                                    </a>
                                                </td>
                                                <td class="text-center"><a href="<c:url value='/notificacionSocio/delete?id=${bo.id}'/>"><span class="glyphicon glyphicon-trash"></span></a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form:form>

        </section>
        <!-- /.box -->
    </div>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->

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

<!-- style jquery-ui -->
<link rel="stylesheet" type='text/css' href="<c:url value='https://code.jquery.com/ui/1.12.0/themes/smoothness/jquery-ui.css'/>"/>

</body>
</html>