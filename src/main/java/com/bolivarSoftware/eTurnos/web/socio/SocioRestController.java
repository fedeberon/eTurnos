package com.bolivarSoftware.eTurnos.web.socio;

import com.bolivarSoftware.eTurnos.domain.socio.Socio;
import com.bolivarSoftware.eTurnos.services.cliente.SocioService;
import com.bolivarSoftware.eTurnos.services.interfaces.ISocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Damian Saez on 3/5/2019.
 */

@RestController
@RequestMapping("restSocio")
public class SocioRestController {

    @Autowired
    ISocioService socioService;

    @RequestMapping("list")
    public @ResponseBody List<Socio> getSocios(){

        return socioService.findAll();
    }
}
