var stompClient = null;
var cantTurnos = 0;
var turnosllamados = [];


function cargarTurnosLlamados() {

    turnosllamados.forEach(function (t) {
        t.puesto = t.puesto.numero;
        var div = createTurnoContainer(t);
        $("#turnos-content").append(div);
    })

}

$(function () {
    $.ajax({
        url: ctx + "/cartel/turnosLlamados",
        success: function(response){
            turnosllamados = response;
            cantTurnos = turnosllamados.length;
            cargarTurnosLlamados();
        }});
});

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS( ctx + '/webSocket/cartel');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/turnos', function (greeting) {
            showGreeting(greeting.body);
        });
        stompClient.subscribe('/topic/videos', function (videos) {
            updateVideoList(JSON.parse(videos.body));
        });
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function showGreeting(message) {
    playAudio();
    addTurno(message);
}

function addTurno(message) {

    var turno = JSON.parse(message);
    buscarTurnoDuplicado(turno);

    turnosllamados.unshift(turno);

    if(turnosllamados.length > 5) {
        $('.col1 .turno:last-child').remove();
        turnosllamados.splice(-1, 1);
    }

    var div = createTurnoContainer(turno);
    $("#turnos-content").prepend(div);
    animarNuevoTurno(div);
}

function createTurnoContainer(turno) {
    var div = $("#turno-box-template").clone();
    $(div).attr('style', '');
    $(div).find("#box-nro-turno").html(turno.numeroTicket);
    $(div).find("#box-nro-caja").html(turno.puesto);
    $(div).find("#box-cliente").html(turno.cliente);
    $(div).attr('id', 'turno-box-template-' + turno.numeroTicket);
    return div;
}

function playAudio() {
    var x = document.getElementById("sonidoCartel");
    try {
        x.play();
    } catch (e) {
        console.log(e);
    }
}

function buscarTurnoDuplicado(turno) {
    turnosllamados.forEach(function (t, index, object) {
        if (turno.numeroTicket == t.numeroTicket) {
            removerTurnoDuplicado(turno);
            object.splice(index, 1);
        }
    })
}

function removerTurnoDuplicado(turno) {
    $('#turno-box-template-' + turno.numeroTicket).remove();
}

function animarNuevoTurno(div) {

    $(div).fadeIn("slow");
    setTimeout(function()
        {$(div).css('transform','scale(1.1)');}
        ,500);
    setTimeout(function()
        {$(div).css('transform','scale(0.9)');}
        ,500);
    setTimeout(function()
        {$(div).css('transform','scale(1.1)');}
        ,1000);
    setTimeout(function()
        {$(div).css('transform','scale(1)');}
        ,1500);
}

$(function () {
    connect();
    $( "#solicitarTurno" ).click(function() {
        $('.btn-panel').prop('disabled','disabled');
        $.ajax({url: ctx + "/proximoTurno", success: function(result){
        
            if(result != null){
                $("#informacionSobreTurno").html("Llamando a " + result.numeroTicket);
                $("input[name=idTurno]").val(result.id);
                agregarDatosDeSocio(result);
                $('.btn-panel').prop('disabled', false);
            }
            else {
                var table = $("#datosDelTurno");
                $('#datosDelTurno').append('<tr><th>No hay turnos en espera:</th>/tr>');
            }
            
        }});

    });

    $( "#rellamarTurno" ).click(function() {
        var idTurno = $("input[name=idTurno]").val();
        $.ajax({url: ctx + "/proximoTurno/rellamar/" + idTurno, success: function(result){
            $("#informacionSobreTurno").html("Rellamando por " + result.rellamados + " vez a Turno: " + result.numeroTicket);
        }});
    });

    $('#myModal').modal({
        keyboard: false,
        backdrop: false,
        show:false
    });
 
});


function agregarDatosDeSocio(turno, notificacionSocio){

    var table = $("#datosDelTurno");
    table.empty();
    if(turno.cliente != null) {

        var cliente = turno.cliente;
        $('#datosDelTurno').append('<tr><th>N&uacute;mero:</th><td> ' + turno.numeroTicket + ' </td></tr>');

        $('#datosDelTurno tr:last').after('<tr><th>Socio</th><td>' + cliente.nombre + ' ' + cliente.apellido + ' </td></tr>');

            if(turno.cliente.notificacionesDelSocio.length > 0) {
                $('#datosDelTurno tr:last').after('<tr><th colspan="2"><a href="../notificacionSocio/list?idSocio=' + cliente.id + '" target="_blank" type="button" class="btn btn-danger" style="display: block">Mostrar notificaciones</a></th></tr>');

            }else{
                $('#datosDelTurno tr:last').after('<tr><th>No tiene notificaciones</th><td></td></tr>');
            }
        }

    else
        {
            $('#datosDelTurno').append('<tr><th>N&uacute;mero:</th><td> ' + turno.numeroTicket + ' </td></tr>');
            $('#datosDelTurno tr:last').after('<tr><th>Solicitado:</th><td> ' + turno.fechaSolicitado + ' </td></tr>');
        }
    }

