package com.bolivarSoftware.eTurnos.web.turno;

import com.bolivarSoftware.eTurnos.domain.Turno;
import com.bolivarSoftware.eTurnos.services.interfaces.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("proximoTurno")
public class TurnoRestController {

    @Autowired
    private ITurnoService turnoService;

    @RequestMapping
    public @ResponseBody Turno getProximoTurno() {
         return turnoService.obtenerProximoTurno();
    }

    @RequestMapping("rellamar/{id}")
    public Turno rellamar(@PathVariable Long id, Model model){
        return turnoService.rellamarTurno(id);
    }

}