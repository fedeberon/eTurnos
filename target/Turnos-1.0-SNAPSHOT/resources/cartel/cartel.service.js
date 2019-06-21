(function() {
    'use strict';

    angular
        .module('cartelApp')
        .factory('cartelService', cartelService);

    cartelService.$inject = ['$http', '$log'];

    function cartelService($http, $log) {

       return {
            getConfiguracionCartel: getConfiguracionCartel,
            getTurnosActuales : getTurnosActuales
       }

       function getConfiguracionCartel (codigoCac) {
         return $http.get('/webapp/cartel/' + codigoCac)
                        .then(successConfigCartel)
                        .catch(errorConfigCartel);
                    function errorConfigCartel(error) {
                        $log.error(error);
                    }
       }
       function successConfigCartel(response) {
            $log.debug('obteniendo configuracion cartel ');
            return response.data;
       }

       function getTurnosActuales(codigoCac) {

       }
    }
})();