<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML>
<html>
<jsp:include page="../header.jsp"/>

<head>
    <link rel="stylesheet" type='text/css' href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" type='text/css' href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css"/>
    <link rel="stylesheet" type='text/css' href="https://cdn.datatables.net/buttons/1.3.1/css/buttons.bootstrap.min.css"/>
    <!-- Bootstrap Color Picker -->
    <link rel="stylesheet" href="<c:url value='/resources/plugins/colorpicker/bootstrap-colorpicker.min.css'/>">
    <!-- Bootstrap time Picker -->
    <link rel="stylesheet" href="<c:url value='/resources/plugins/timepicker/bootstrap-timepicker.min.css'/>">

    <link rel="stylesheet" href="<c:url value='/resources/plugins/daterangepicker/daterangepicker-bs3.css'/>">

</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../menu.jsp"/>
    <jsp:include page="../panel-usuario.jsp"/>
    <div class="content-wrapper">

        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Turnos <small> Todos</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Turnos</a></li>
                <li class="active">Todos</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">

                           <div class="box box-primary">
                            <div class="box-header">
                                <h3 class="box-title">Busqueda de turnos</h3>
                            </div>
                            <div class="box-body">

                                <form action="<c:url value='/turno/buscar'/>" method="post">
                                    <div class="col-xs-3">
                                        <div class="form-group">
                                            <label>Valor:</label>
                                            <div class="input-group">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-info"></i>
                                                </div>
                                                <input name="value" value = "${value}" type="text" class="form-control">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-xs-3">
                                        <div class="form-group">
                                            <label>Desde:</label>
                                            <div class="input-group">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input name="fechaDesde" value = "${fechaDesde}" type="text" class="form-control date">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-xs-3">
                                        <div class="form-group">
                                            <label>Hasta:</label>
                                            <div class="input-group">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input name="fechaHasta" value="${fechaHasta}" type="text" class="form-control date">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-xs-3">
                                        <button  type="submit" class="btn btn-default" style="margin-top:25px;"> <span class="glyphicon glyphicon-search"></span> Buscar</button>
                                    </div>


                                </form>

                            </div>
                            <!-- /.box-body -->
                        </div>

                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="turnos" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>Cod Int</th>
                                    <th>Numero</th>
                                    <th>Solicitado</th>
                                    <th>Llamado</th>
                                    <th>Estado</th>
                                    <th>Cliente</th>
                                    <th>Puesto</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${turnos}" var="bo">
                                    <tr>
                                        <td>${bo.id}</td>
                                        <td>${bo.numeroTicket}</td>
                                        <td><fmt:formatDate value="${bo.fechaSolicitado}" pattern="dd/MM/yyyy HH:mm"/></td>
                                        <td><fmt:formatDate value="${bo.fechaLlamado}" pattern="dd/MM/yyyy HH:mm"/></td>
                                        <td>${bo.estado}</td>
                                        <td>${bo.cliente}</td>
                                        <td>${bo.puesto}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <th>Cod Int</th>
                                    <th>Numero</th>
                                    <th>Solicitado</th>
                                    <th>Llamado</th>
                                    <th>Estado</th>
                                    <th>Cliente</th>
                                    <th>Puesto</th>
                                </tr>
                                </tfoot>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->

                <div class="col-xs-12">
                    <div class="col-xs-2">
                        <a href="/turnos/turno/list?page=${page - 1}" class="btn btn-block btn-primary">Atras</a>
                    </div>
                    <div class="col-xs-2">
                        <a href="/turnos/turno/list?page=${page + 1}" class="btn btn-block btn-primary">Siguiente</a>
                    </div>
                    <sec:authorize access="hasAnyRole('ROLE_CONFIG','ROLE_ADMIN')">
                    <div class="col-xs-2">
                        <a href="/turnos/turno/report" class="btn btn-block btn-primary">Exportar</a>
                    </div>
                    </sec:authorize>
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


<%--<script src="https://cdn.datatables.net/buttons/1.3.1/js/dataTables.buttons.min.js"></script>--%>

<script src="<c:url value="/resources/plugins/datatables/extensions/Buttons/js/dataTables.buttons.min.js" />"></script>

<%--<script src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.bootstrap.min.js"></script>--%>
<script src="<c:url value="/resources/plugins/datatables/extensions/Buttons/js/buttons.bootstrap.min.js" />"></script>

<script src="//cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src="//cdn.rawgit.com/bpampuch/pdfmake/0.1.27/build/pdfmake.min.js"></script>
<script src="//cdn.rawgit.com/bpampuch/pdfmake/0.1.27/build/vfs_fonts.js"></script>

<%--<script src="//cdn.datatables.net/buttons/1.3.1/js/buttons.html5.min.js"></script>--%>
<script src="<c:url value="/resources/plugins/datatables/extensions/Buttons/js/buttons.html5.min.js" />"></script>
<%--<script src="//cdn.datatables.net/buttons/1.3.1/js/buttons.print.min.js"></script>--%>
<script src="<c:url value="/resources/plugins/datatables/extensions/Buttons/js/buttons.print.min.js" />"></script>
<%--<script src="//cdn.datatables.net/buttons/1.3.1/js/buttons.colVis.min.js"></script>--%>
<script src="<c:url value="/resources/plugins/datatables/extensions/Buttons/js/buttons.colVis.min.js" />"></script>
<script>

    $(document).ready(function() {
        var urlArchivoLenguaje = '<c:url value="/resources/plugins/datatables/Spanish.json" />';

        var table = $('#turnos').DataTable( {
            dom: 'Brti',

        buttons: [
            {
                extend: 'pdfHtml5',
                text: 'PDF'

            },
            {
                extend: 'excelHtml5',
                text: 'Excel',
                exportOptions: {
                    modifier: {
                        page: 'current'
                    }
                }
            },
            {
                extend: 'colvis',
                text: 'Filtro de Columnas',
                columnText: function (dt, idx, title) {
                    return (idx + 1) + ': ' + title;
                }
            },
            {
                extend: 'copyHtml5',
                text: 'Copiar en Portapapeles',
                copySuccess: {
                    1: "Copied one row to clipboard",
                    _: "Copied %d rows to clipboard"
                },
                copyTitle: 'Copiar en portapapeles',
                copyKeys: 'Press <i>ctrl</i> or <i>\u2318</i> + <i>C</i> to copy the table data<br>to your system clipboard.<br><br>To cancel, click this message or press escape.'
            },
            {
                extend: 'print',
                text: 'Imprimir resultados',
                exportOptions: {
                    modifier: {
                        page: 'current'
                    }
                }
            }
        ],
            language:{ "url": urlArchivoLenguaje }
        } );
    } );

</script>

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

<script src="<c:url value='/resources/dist/js/chart-estadisticas.js'/>"></script>

<script src="<c:url value='/resources/dist/js/datepicker.js'/>"></script>

</body>
</html>
