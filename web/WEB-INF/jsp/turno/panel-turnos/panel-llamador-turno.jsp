<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="box">
    <div class="box-header">
        <h3 class="box-title">Administraci&oacute;n de Turnos</h3>
        <c:if test="${cantidadTurnosPorAtender == 0}">
            <hr>
            <div class="alert alert-success">
                <strong>Buen trabajo !</strong> No hay turnos en espera.
            </div>

            <script type="text/javascript">
                setTimeout(function () {
                    location.reload();
                }, 5000);
            </script>

        </c:if>
    </div>
    <div class="box-body">


        <p>Panel de control de llamado de turnos:</p>
        <c:choose>
            <c:when test="${ultimaActividad.actividad == 'ATENDIENDO'}">
                <a class="btn btn-app ${cantidadTurnosPorAtender == 0 ? 'disabled' : ''}" id="solicitarTurno" data-toggle="modal" data-target="#myModal">
                    <span class="badge bg-yellow">${cantidadTurnosPorAtender}</span>
                    <i class="fa fa-bullhorn"></i> Llamar
                </a>
                <a class="btn btn-app" href="../usuarios/dejarDeAtender">
                    <span class="badge bg-green"></span>
                    <i class="fa fa-coffee"></i> Dejar de Atender
                </a>
            </c:when>
            <c:otherwise>
                <a class="btn btn-app" href="../usuarios/atender">
                    <span class="badge bg-green"></span>
                    <i class="fa fa-desktop"></i> Atender
                </a>
            </c:otherwise>
        </c:choose>
    </div>
    <!-- /.box-body -->
</div>
<!-- /.box -->