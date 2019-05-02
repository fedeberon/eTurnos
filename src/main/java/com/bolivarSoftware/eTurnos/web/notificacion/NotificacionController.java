package com.bolivarSoftware.eTurnos.web.notificacion;

import com.bolivarSoftware.eTurnos.domain.Notificacion;
import com.bolivarSoftware.eTurnos.domain.Usuario;
import com.bolivarSoftware.eTurnos.services.notificacion.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Damian Gallego on 30/4/2019.
 */
@Controller
@RequestMapping("notificacion")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    @RequestMapping("save")
    public String save(@RequestParam Integer id, @RequestParam String message){
        Notificacion notificacion = new Notificacion();
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



}
