<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="box box-solid">
    <div class="box-header with-border">
        <h3 class="box-title">Turnos Pendientes</h3>
    </div>
    <!-- /.box-header -->
    <div id="turnos-content" class="box-body">

        <c:forEach items="${turnosPendientesDePuesto}" var="turnoPendiente">
            <div id="turno-box-template" class="col-md-12">
                <div class="info-box">
                    <span id="box-nro-turno" class="info-box-icon bg-yellow">
                        ${turnoPendiente.turno.numeroTicket}
                    </span>

                    <div class="box-body">

                        <a class="btn btn-app" href="#">
                            <i class="fa">${turnoPendiente.turno.rellamados != null ? turnoPendiente.turno.rellamados : "Sin"}</i> Rellamadas
                        </a>

                        <a class="btn btn-app" href="<c:url value='/turno/atendido?idTurno=${turnoPendiente.turno.id}'/>">
                            <i class="fa fa-play"></i>Atendido.
                        </a>

                        <a class="btn btn-app" href="<c:url value='/turno/ausentar?idTurno=${turnoPendiente.turno.id}'/>">
                            <i class="fa fa-hourglass-end"></i> Ausentar
                        </a>

                        <a class="btn btn-app" href="<c:url value='/turno/rellamar?idTurno=${turnoPendiente.turno.id}'/>">
                            <i class="fa fa-repeat"></i> Rellamar
                        </a>

                    </div>

                </div>
            </div>
        </c:forEach>
        <!-- fix for small devices only -->
        <div class="clearfix visible-sm-block"></div>

    </div>
</div>