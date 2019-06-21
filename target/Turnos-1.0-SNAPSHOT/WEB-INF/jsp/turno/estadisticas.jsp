<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<jsp:include page="../header.jsp"/>
<head>
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
                Turnos <small>Estadisticas</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Estadisticas de Turnos</a></li>
                <li class="active">Todos</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="row">

                <div class="box box-primary">
                    <div class="box-header">
                        <h3 class="box-title">Rango de fechas de busqueda</h3>
                    </div>
                    <div class="box-body">

                    <form action="<c:url value='/estadistica/porFecha'/>" method="post">
                        <div class="col-xs-3">
                            <div class="form-group">
                                <label>Desde:</label>
                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                    <input name="fechaInicio" value = "${fechaInicio}" type="text" class="form-control date">
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
                                    <input name="fechaFin" value="${fechaFin}" type="text" class="form-control date">
                                </div>
                            </div>
                        </div>

                        <div class="col-xs-5">
                            <button  type="submit" class="btn btn-default" style="margin-top:25px;"> <span class="glyphicon glyphicon-search"></span> Buscar</button>
                        </div>


                    </form>

                    </div>
                    <!-- /.box-body -->
                </div>


                <!-- BAR CHART -->
                <div class="box box-success">
                    <div class="box-header with-border">
                        <h3 class="box-title">Informe de Turnos por mes</h3>

                        <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                        </div>
                    </div>
                    <div class="box-body">
                        <div class="chart">
                            <canvas id="canvas_bar" style="height:230px"></canvas>
                        </div>

                        <div>
                            <table class="table table-bordered">
                                <tr>
                                    <td></td>
                                    <th>Socio</th>
                                    <th>No Socio</th>
                                </tr>

                                <c:forEach items="${turnosView}" var="turno">

                                <tr>
                                    <td><fmt:formatDate value="${turno.fecha}" pattern="dd/MM/yyyy"/></td>
                                    <td>${turno.cantidadDeTurnoSocio}</td>
                                    <td>${turno.cantidadDeTurnoNoSocio}</td>
                                </tr>

                                </c:forEach>

                            </table>
                        </div>

                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
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

<!-- ChartJS 1.0.1 -->
<script src="<c:url value='/resources/plugins/chartjs/Chart.min.js'/>"></script>

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
