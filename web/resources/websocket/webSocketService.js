app.service("webSocketService", function($q, $timeout) {

    var service = {}, listener = $q.defer(), socket = {
      client: null,
      stomp: null
    };

    service.RECONNECT_TIMEOUT = 30000;
    service.SOCKET_URL = "/webSocket/message";
    service.CHAT_TOPIC = "/user/topic/turnoAsignado";
    service.CHAT_BROKER = "/app";

    var reconnect = function() {
      $timeout(function() {
        initialize();
      }, this.RECONNECT_TIMEOUT);
    };

    var getMessage = function(data) {
      var mensaje = JSON.parse(data.body);
      console.log(mensaje);
      return mensaje;
    };

    var startListener  = function() {
      socket.stomp.subscribe(service.CHAT_TOPIC, function(data) {
            listener.notify(getMessage(data));
      });
    };

    var initialize = function() {
      socket.client = new SockJS(service.SOCKET_URL);
      socket.stomp = Stomp.over(socket.client);
      socket.stomp.connect({}, startListener);
      socket.stomp.onclose = reconnect;
    };

    initialize();
    return service;
  });