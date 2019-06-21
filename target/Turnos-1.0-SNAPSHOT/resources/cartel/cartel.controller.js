(function() {
    'use strict';

    angular
        .module('cartelApp')
        .controller('CartelController', CartelController);

    CartelController.$inject = [
        'websocketService',
        'cartelService',
        'displayService',
        '$scope',
        '$log'];

    function CartelController(
            websocketService,
            cartelService,
            displayService,
            $scope,
            $log) {

        var vm = this;

        vm.websocket = null;
        vm.filas = [];
        vm.cac = {};
        vm.turnoLlamado = {};
        vm.cartel = null;

        vm.iniciar = iniciar;
        vm.llamarTurno = llamarTurno;
        vm.setTurno = setTurno;
        vm.listenerSocket = listenerSocket;

        function iniciar() {
            configurarCartel();
        }

        function listenerSocket(turno, topic) {
            if (topic == 'LLAMANDO_TURNO') {
                llamarTurno(turno);
            }
            if (topic == 'TURNO_AUSENTE') {
                quitarTurnoDeFila(turno);
            }
        }

        function llamarTurno(turno) {
            vm.setTurno(turno);
            $scope.$apply();
            agregarTurnoAFila(turno);

            displayService.ejecutarLlamada('#box' +vm.turnoLlamado.letraDeTicket,
                vm.cartel.tiempoLlamado);
        }

        function agregarTurnoAFila(turno) {
            for (var i = 0; i < vm.filas.length; i++) {
                if (turno.rellamados == 0 &&
                    vm.filas[i].fila.fila.letra == turno.letraDeTicket) {
                    vm.filas[i].turnos.push(turno);
                    $scope.$apply();

                    actualizarCarrousel(turno);
                }
            }
        }

        function actualizarCarrousel(turno) {
            var element = $('#box' + turno.letraDeTicket);
            var slides = $(element).find('.slide');
            if (slides.length > 1) {
                var c = $(element).data('carousel');
                if (c != undefined) {
                    c.options._slides = $(element).find('.slide');
                } else {
                    $(element).carousel();
                    c = $(element).data('carousel');
                }
            }
        }

        function setTurno(turno) {
            vm.turnoLlamado = turno;
        }

        function configurarCartel() {
            mostrarLoaderWin(25);
            cartelService.getConfiguracionCartel(codigoCAC)
                .then(function(data) {
                    vm.cartel = data.configuracionCartel;
                    vm.websocket = new websocketService(listenerSocket, data.centro.codigo);
                    vm.filas = data.filas;
                    if (vm.cartel != null) {
                        $('#sonidoCartel').attr('src','/resources/sonidos/' + vm.cartel.sonidoLlamado);
                    } else {

                    }
                    ocultarLoaderWin();
                });
        }

        function quitarTurnoDeFila(turno) {

            for (var i = 0; i < vm.filas.length; i++) {
                if (vm.filas[i].fila.fila.letra == turno.letraDeTicket) {
                    for (var e = 0; e < vm.filas[i].turnos.length; e++) {
                        if (vm.filas[i].turnos[e].numeroTicket == turno.numeroTicket) {
                            vm.filas[i].turnos.splice(e, 1);
                            $scope.$apply();
                        }
                    }
                }
            }
            actualizarCarrousel(turno);
        }
    }
})();