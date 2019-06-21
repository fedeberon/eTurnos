(function() {
    'use strict';

    angular
        .module('cartelApp')
        .factory('displayService', displayService);

    function displayService() {
       var displayBox;
       return {
            ejecutarLlamada: ejecutarLlamada
       };

       function ejecutarLlamada(element, time) {
            document.getElementById('sonidoCartel').play();
            displayBox = element;
            $('#dialogCartelLlamador')
               .fadeIn( "slow", function(){
                   setTimeout(ocultarLlamada, time);
               });
       }

       function ocultarLlamada() {
           $("#dialogCartelLlamador").fadeOut( 500, function() {
               animarBox();
           });
       }

       function animarBox() {
           var box = $(displayBox);
           $(box).css('transform','scale(1.1)');
           setTimeout(function()
               {$(box).css('transform','scale(0.9)');}
               ,500);
           setTimeout(function()
               {$(box).css('transform','scale(1.1)');}
               ,1000);
           setTimeout(function()
               {$(box).css('transform','scale(1)');}
               ,1500);
       }

    }
})();