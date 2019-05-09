package com.bolivarSoftware.eTurnos.web.notificacionSocio;

import com.bolivarSoftware.eTurnos.domain.Notificacion;
import com.bolivarSoftware.eTurnos.domain.NotificacionSocio;
import com.bolivarSoftware.eTurnos.services.notificacionSocio.NotificacionSocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Damian Gallego on 8/5/2019.
 */
@Controller
public class NotificacionSocioController {

    @Autowired
    private NotificacionSocioService notificacionSocioService;

    @RequestMapping("save")
    public String save(@ModelAttribute NotificacionSocio notificacionSocio) {
        notificacionSocioService.save(notificacionSocio);

        return "redirect:list";
    }

    @RequestMapping("list")
    public String findAll(@RequestParam(defaultValue = "1") Integer page, Model model) {
        model.addAttribute("notificacionSocio", notificacionSocioService.findAllPageable(page));
        model.addAttribute("page", page);

        return "notificacionSocio/create";
    }

}
