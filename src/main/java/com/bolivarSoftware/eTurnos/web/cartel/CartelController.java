package com.bolivarSoftware.eTurnos.web.cartel;

import com.bolivarSoftware.eTurnos.domain.*;
import com.bolivarSoftware.eTurnos.domain.socio.Socio;
import com.bolivarSoftware.eTurnos.services.interfaces.ITurnoService;
import com.bolivarSoftware.eTurnos.websocket.IWebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cartel")
public class CartelController {

    @Autowired
    private IWebSocketService webSocketService;

    @Autowired
    private ITurnoService turnoService;

    @RequestMapping("")
    public String getCartel(){
        return "_cartel";
    }

    @RequestMapping("/turnosLlamados")
    public @ResponseBody List<Turno> getTurnosCartel(){
        return turnoService.getTurnosCartel();
    }

    @RequestMapping("/msg/{message}")
    public void enviarMensaje(@PathVariable final String message) {

        Cliente usuario = new Socio();
        usuario.setNombre("Cliente");
        usuario.setApellido("Test");

        PuestoDeAtencion puesto = new PuestoDeAtencion();
        puesto.setNumero(2);
        Turno turno = new Turno();
        turno.setCliente(usuario);
        turno.setPuesto(puesto);
        turno.setNumeroTicket(message);
        TurnoCartel turnoCartel = new TurnoCartel(turno);
        webSocketService.llamarProximoTurno(turnoCartel);
    }

}
