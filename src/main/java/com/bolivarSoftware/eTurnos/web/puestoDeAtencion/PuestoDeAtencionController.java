package com.bolivarSoftware.eTurnos.web.puestoDeAtencion;

import com.bolivarSoftware.eTurnos.services.interfaces.IPuestoDeAtencionService;
import com.bolivarSoftware.eTurnos.services.interfaces.IUsuarioService;
import com.bolivarSoftware.eTurnos.utils.UtilDate;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Duration;

@Controller
@RequestMapping("puestoDeAtencion")
public class PuestoDeAtencionController {

    @Autowired
    private IPuestoDeAtencionService puestoDeAtencionService;

    @Autowired
    private IUsuarioService usuarioService;


    @RequestMapping("list")
    public String list(Model model){
        model.addAttribute("puestos", puestoDeAtencionService.findAll());
        Duration duration = usuarioService.getTiempoActivoDeUsuarioDeHoy();
        model.addAttribute("tiempoActivoDeUsuario", UtilDate.formatDuration(duration));
//        String date = DurationFormatUtils.formatDuration(duration.toMillis(), "**H:mm:ss**", true);

        return "puestoDeAtencion/list";
    }

}
