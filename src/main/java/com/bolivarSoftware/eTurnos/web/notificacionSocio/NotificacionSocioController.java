package com.bolivarSoftware.eTurnos.web.notificacionSocio;

import com.bolivarSoftware.eTurnos.beans.NotificacionesSocios;
import com.bolivarSoftware.eTurnos.domain.Notificacion;
import com.bolivarSoftware.eTurnos.domain.NotificacionSocio;
import com.bolivarSoftware.eTurnos.services.notificacion.NotificacionService;
import com.bolivarSoftware.eTurnos.services.notificacionSocio.NotificacionSocioService;
import com.bolivarSoftware.eTurnos.validator.NotificacionValidator;
import com.bolivarSoftware.eTurnos.web.notificacionSocio.enumerador.EstadoNotificacionSocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    private NotificacionValidator notificacionValidator;

    @RequestMapping("save")
    public String save(@ModelAttribute NotificacionesSocios notificacionSocio, BindingResult result, Model model) {
        this.notificacionValidator.validate(notificacionSocio, result);
        if (result.hasErrors()){
            return "notificacionSocio/create";
        }

        model.addAttribute("notificacion", notificacionSocio.notificaciones);
        notificacionSocioService.save(notificacionSocio.notificaciones);
         return "redirect:/notificacion/list";
    }

    @RequestMapping("list")
    public String findAll(@RequestParam Long idSocio, Model model) {
        List<NotificacionSocio> notificaciones = notificacionSocioService.getBySocio(idSocio);
        model.addAttribute("notificaciones", notificaciones);

        return "notificacionSocio/list";
    }

    @RequestMapping("activar")
    public String activarNotificacion(@RequestParam Integer id, RedirectAttributes redirectAttributes){
        NotificacionSocio notificacionSocio = notificacionSocioService.get(id);
        notificacionSocio.setEstado(EstadoNotificacionSocio.ACTIVO);
        redirectAttributes.addAttribute("idSocio", notificacionSocio.getSocio().getId());
        notificacionSocioService.save(notificacionSocio);

        return "redirect:list";
    }

    @RequestMapping("desactivar")
    public String desactivarNotificacion(@RequestParam Integer id, RedirectAttributes redirectAttributes){
        NotificacionSocio notificacionSocio = notificacionSocioService.get(id);
        notificacionSocio.setEstado(EstadoNotificacionSocio.INACTIVO);
        redirectAttributes.addAttribute("idSocio", notificacionSocio.getSocio().getId());
        notificacionSocioService.save(notificacionSocio);

        return "redirect:list";
    }

    @RequestMapping("create")
    public String create(@RequestParam Integer id, Model model) {
        model.addAttribute("id", id);
        Notificacion notificacion = notificacionService.get(id);

        List<NotificacionSocio> sociosNotificados = notificacionSocioService.getByNotificacion(notificacion);

        model.addAttribute("sociosNotificados", sociosNotificados);
        model.addAttribute("notificacion", notificacion);

        return "notificacionSocio/create";
    }

    @RequestMapping("show")
    public String show(@RequestParam Integer id,  Model model){
        model.addAttribute("notificacionSocio", notificacionSocioService.get(id));

        return "notificacionSocio/create";
    }

    @ModelAttribute("notificionesSocios")
    public NotificacionesSocios getNotificionesSocios(){
        return new NotificacionesSocios();
    }

}

