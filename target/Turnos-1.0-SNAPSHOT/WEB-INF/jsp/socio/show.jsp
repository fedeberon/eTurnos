<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                Socio
                <small>Datos Personales</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Socio</a></li>
                <li class="active">Datos Personales</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-xs-12">

                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">Datos del Socio</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table class="table table-bordered">
                                <tbody>

                                <tr>
                                    <th>Numero</th>
                                    <td>${socio.numero}</td>
                                </tr>

                                <tr>
                                    <th>Nombre y Apellido</th>
                                    <td>${socio.nombre} ${socio.apellido}</td>
                                </tr>


                                <tr>
                                    <th>Nacionalidad</th>
                                    <td>${socio.nacionalidad}</td>
                                </tr>


                                <tr>
                                    <th>mail</th>
                                    <td>${socio.eMail}</td>
                                </tr>


                                <tr>
                                    <th>Firma</th>
                                    <td>${socio.firma}</td>
                                </tr>


                                <tr>
                                    <th>Tipo de Empresa</th>
                                    <td>${socio.tipoEmpresa}</td>
                                </tr>


                                <tr>
                                    <th>Domicilio</th>
                                    <td>${socio.domicilio}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                </div>
                <!-- /.col -->

                <div class="col-xs-12">
                    <div class="col-xs-2">
                        <a href="<c:url value='/socio/list'/>" class="btn btn-block btn-primary">Volver</a>
                    </div>
                    <div class="col-xs-2">
                        <a href="/turnos/socio/exportarCredencial/${socio.id}" onclick="$('#Searching_Modal').modal('show')"  class="btn btn-block btn-primary">Exportar Credencial</a>
                    </div>
                </div>


            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->


    <div id="Searching_Modal" class="modal fade" tabindex="-1" role="dialog" data-keyboard="false"
         data-backdrop="static">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header" style="text-align: center">
                    <h3>Creando Credencial ...</h3>
                </div>
                <div class="modal-body" >
                    <br>
                    <br>
                    <br>
                    <div id="searching_spinner_center" style="position:fixed; left:50%"></div>
                    <br>
                    <br>
                    <br>
                </div>
                <div class="modal-footer" style="text-align: center"></div>
            </div>
        </div>
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

<script>

    var opts = {
        lines: 13, // The number of lines to draw
        length: 20, // The length of each line
        width: 10, // The line thickness
        radius: 30, // The radius of the inner circle
        corners: 1, // Corner roundness (0..1)
        rotate: 0, // The rotation offset
        direction: 1, // 1: clockwise, -1: counterclockwise
        color: '#000', // #rgb or #rrggbb or array of colors
        speed: 1, // Rounds per second
        trail: 60, // Afterglow percentage
        shadow: false, // Whether to render a shadow
        hwaccel: false, // Whether to use hardware acceleration
        className: 'spinner', // The CSS class to assign to the spinner
        zIndex: 2e9, // The z-index (defaults to 2000000000)
        top: 'auto', // Top position relative to parent in px
        left:'auto' // Left position relative to parent in px
    };

    var target = document.getElementById('searching_spinner_center');
    var spinner = new Spinner(opts).spin(target);
</script>

</body>
</html>
