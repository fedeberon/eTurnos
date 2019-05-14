package com.bolivarSoftware.eTurnos.web.notificacionSocio;

import com.bolivarSoftware.eTurnos.beans.NotificacionesSocios;
import com.bolivarSoftware.eTurnos.beans.RedirectAuthentication;
import com.bolivarSoftware.eTurnos.domain.Notificacion;
import com.bolivarSoftware.eTurnos.domain.NotificacionSocio;
import com.bolivarSoftware.eTurnos.services.notificacion.NotificacionService;
import com.bolivarSoftware.eTurnos.services.notificacionSocio.NotificacionSocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by Damian Gallego on 8/5/2019.
 */
@Controller
@RequestMapping("notificacionSocio")
public class NotificacionSocioController {

    @Autowired
    private NotificacionSocioService notificacionSocioService;

    @Autowired
    private NotificacionService notificacionService;

    @RequestMapping("save")
    public String save(@ModelAttribute NotificacionesSocios notificacionSocio) {
        notificacionSocioService.save(notificacionSocio.notificaciones);

        return "redirect:list";
    }

    @RequestMapping("list")
    public String findAll(@RequestParam Integer idSocio, Model model) {
        List<NotificacionSocio> notificaciones = notificacionSocioService.getBySocio(idSocio);
        model.addAttribute("notificaciones", notificaciones);

        return "notificacionSocio/list";
    }

    @RequestMapping("create")
    public String create(@RequestParam Integer id, Model model) {
        model.addAttribute("id", id);
        Notificacion notificacion = notificacionService.get(id);
        model.addAttribute("notificacion", notificacion);

        return "notificacionSocio/create";
    }


    @ModelAttribute("notificionesSocios")
    public NotificacionesSocios getNotificionesSocios(){
        return new NotificacionesSocios();
    }

}

