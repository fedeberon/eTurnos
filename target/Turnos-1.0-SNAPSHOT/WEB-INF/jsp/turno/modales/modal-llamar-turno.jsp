<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Modal llamar turno -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">

            <div class="modal-header">
                <h4 class="modal-title" id="informacionSobreTurno">Buscando Atenci&oacute;n</h4>
            </div>

            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-6">
                        <table id="datosDelTurno" class="table table-bordered"></table>
                    </div>
                    <div class="col-xs-6">

                    </div>
                </div>
            </div>

            <div class="modal-footer">
                <div class="row">
                    <div class="col-xs-3">
                        <form action="<c:url value='/turno/atendido'/>">
                            <input type="hidden" name="idTurno">
                            <button class="btn btn-primary btn-panel" type="submit">
                                <i class="fa fa-play"></i>&nbsp;&nbsp;Atendido
                            </button>
                        </form>
                    </div>
                    <div class="col-xs-4">
                        <form action="<c:url value='/turno/ausentar'/>">
                            <input type="hidden" name="idTurno">
                            <button class="btn btn-danger btn-panel" type="submit">
                                <i class="fa fa-hourglass-end"></i>&nbsp;&nbsp;Ausentar
                            </button>
                        </form>
                    </div>
                    <div class="col-xs-5">
                        <button class="btn btn-warning btn-panel" id="rellamarTurno">
                            <i class="fa fa-repeat"></i>&nbsp;&nbsp;Rellamar
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>