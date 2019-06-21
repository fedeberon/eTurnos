<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
                Notificaciones <small> Todas</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Notificaciones</a></li>
                <li class="active">Todos</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-body">
                            <table id="notificacion" class="table table-bordered table-hover">
                                <thead class="thead-dark">
                                <tr>
                                    <th class="text-center">ID</th>
                                    <th class="text-center">Mensaje</th>
                                    <th class="text-center">Desde</th>
                                    <th class="text-center">Hasta</th>
                                    <th class="text-center">Agregar socio a notificar</th>
                                    <th class="text-center">Editar notificaci&oacute;n</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${notificacion}" var="bo" >
                                    <tr>
                                        <td class="col-md-1 text-center"><a class="btn btn-primary" href="<c:url value='/notificacionSocio/listSocio?id=${bo.id}'/>">${bo.id}</a></td>
                                        <td class="col-md-5 text-center">${bo.message}</td>
                                        <td class="col-md-2 text-center"><fmt:formatDate value="${bo.desde}" pattern="dd-MM-yyyy"/></td>
                                        <td class="col-md-2 text-center"><fmt:formatDate value="${bo.hasta}" pattern="dd-MM-yyyy"/></td>
                                        <td class="col-md-1 text-center">

                                            <div class="btn-group">
                                                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                                                    Notificar <span class="caret"></span></button>
                                                <ul class="dropdown-menu" role="menu">
                                                    <li><a href="<c:url value='/notificacionSocio/create?id=${bo.id}'/>">Socios</a></li>
                                                    <li><a id="${bo.id}" href="#" class="btn-notificacion-rubro">Rubros</a></li>
                                                    <li><a id="${bo.id}" href="#" class="btn-notificacion-segmento">Segmentos</a></li>
                                                </ul>
                                            </div>
                                            <!--
                                                <a class="btn btn-primary" href="<c:url value='/notificacionSocio/create?id=${bo.id}'/>"/>Agregar Socios
                                            -->
                                        </td>
                                        <td class="col-md-1 text-center"> <a class="btn btn-primary" href="<c:url value='/notificacion/update?id=${bo.id}'/>"/>Editar</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->

                <div class="col-xs-12">
                    <div class="col-xs-2">
                        <a href="/turnos/notificacion/list?page=${page - 1}" class="btn btn-block btn-primary">Atras</a>
                    </div>
                    <div class="col-xs-2">
                        <a href="/turnos/notificacion/list?page=${page + 1}" class="btn btn-block btn-primary">Siguiente</a>
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


<!-- Modal -->
<div class="modal fade" id="modal-rubros" role="dialog">
    <div class="modal-dialog">


        <form:form action="../notificacionSocio/save" modelAttribute="notificaciones">
             <input name="notificacion.id" type="hidden" id="notificacion-id-rubro"/>
            <input type="hidden" name="grupo" value="SOCIOS_POR_RUBRO">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Rubros</h4>
            </div>
            <div class="modal-body">

                <p>Selecciones un rubro</p>

                <select class="form-control" name="rubro.id">
                    <c:forEach items="${rubros}" var="bo">
                        <option value="${bo.id}">${bo.nombre}</option>
                    </c:forEach>

                </select>

            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-default">Guadar</button>
            </div>
            </form:form>
        </div>

    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="modal-segmentos" role="dialog">
    <div class="modal-dialog">

        <form:form action="../notificacionSocio/save" modelAttribute="notificaciones">
            <input name="notificacion.id" type="hidden" id="notificacion-id-segmento"/>
            <input name="grupo" type="hidden" value="SOCIOS_POR_SEGMENTO">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Segmentos</h4>
            </div>
            <div class="modal-body">

                <p>Seleccione un segmento</p>

                <select class="form-control" name="segmento.id">
                    <c:forEach items="${segmentos}" var="seg">
                        <option value="${seg.id}" >${seg.nombre}</option>
                    </c:forEach>

                </select>

            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-success">Guardar</button>
            </div>
        </div>
        </form:form>
    </div>
</div>


<!-- jQuery 2.2.0 -->
<script src="<c:url value='/resources/plugins/jQuery/jQuery-2.2.0.min.js'/>"></script>
<!-- Bootstrap 3.3.5 -->
<script src="<c:url value='/webjarslocator/bootstrap/js/bootstrap.min.js'/>"></script>
<!-- DataTables -->
<script src="<c:url value='/resources/plugins/datatables/jquery.dataTables.js'/>"></script>
<!-- AdminLTE App -->
<script src="<c:url value='/resources/dist/js/app.js'/>"></script>

<script type="application/javascript">

    $(document).ready(function(){
        $(".btn-notificacion-rubro").click(function(){
            var id = $(this).attr('id');
            $('#notificacion-id-rubro').val(id);
            $("#modal-rubros").modal();
        });

        $(".btn-notificacion-segmento").click(function(){
            var id = $(this).attr('id');
            $('#notificacion-id-segmento').val(id);
            $("#modal-segmentos").modal();
        });
    });

</script>

</body>
</html>
