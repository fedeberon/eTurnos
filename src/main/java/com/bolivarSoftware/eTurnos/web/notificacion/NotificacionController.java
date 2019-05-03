package com.bolivarSoftware.eTurnos.web.notificacion;

import com.bolivarSoftware.eTurnos.domain.Notificacion;
import com.bolivarSoftware.eTurnos.domain.Usuario;
import com.bolivarSoftware.eTurnos.services.notificacion.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by Damian Gallego on 30/4/2019.
 */
@Controller
@RequestMapping("notificacion")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    @RequestMapping("save")
    public String save(@ModelAttribute Notificacion notificacion, @RequestParam String message){
        notificacion.setMessage(message);
        notificacionService.save(notificacion);

        return "redirect:list";
    }

    @RequestMapping("list")
    public String findAll(@RequestParam(defaultValue = "1") Integer page, Model model){
        model.addAttribute("usuarios", notificacionService.findAllPageable(page));
        model.addAttribute("page", page);

        return "notificacion/list";
    }

    @RequestMapping(value = "darDeBaja")
    public String darDeBaja(@RequestParam String id, RedirectAttributes redirectAttributes){
        notificacionService.darDeBaja(id);
        redirectAttributes.addAttribute("id", id);

        return "redirect:show";
    }

    @RequestMapping(value = "activar")
    public String activar(@RequestParam String id, RedirectAttributes redirectAttributes){
        notificacionService.activar(id);
        redirectAttributes.addAttribute("id", id);

        return "redirect:show";
    }
}
