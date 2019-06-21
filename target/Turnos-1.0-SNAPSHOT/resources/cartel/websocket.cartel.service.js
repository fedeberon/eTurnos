(function() {
    'use strict';

    angular
        .module('cartelApp')
        .factory('websocketService', websocketService);

    websocketService.$inject = ['$timeout'];

    function websocketService($timeout) {

        var Websocket = function(f, cac) {
            //this.listener = $q.defer();
            this.socket = {client: null, stomp: null};
            this.RECONNECT_TIMEOUT = 30000;
            this.SOCKET_URL = "/webSocket/cartel";
            this.CHAT_TOPIC = "/topic/cartel/" + cac;
            this.CHAT_BROKER = "/app";
            this.listenerSocket = f;
            this.initialize();
        }

        Websocket.prototype = {
            reconnect: function() {
               $timeout(function() {this.initialize().bind(this);}, this.RECONNECT_TIMEOUT);
            },
            getMessage: function(data) {
               var mensaje = JSON.parse(data.body);
               this.listenerSocket(mensaje.data, mensaje.topic);
               return mensaje;
            },
            startListener: function() {
                this.socket.stomp.subscribe(this.CHAT_TOPIC, this.getMessage.bind(this));
            },
            initialize: function() {
               this.socket.client = new SockJS(this.SOCKET_URL);
               this.socket.stomp = Stomp.over(this.socket.client);
//               this.socket.stomp.debug = null;
               this.socket.stomp.connect({}, this.startListener.bind(this));
               this.socket.stomp.onclose = this.reconnect.bind(this);
            }
        }

        return Websocket;

    }
})();