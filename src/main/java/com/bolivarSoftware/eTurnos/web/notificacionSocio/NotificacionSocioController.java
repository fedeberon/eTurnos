package com.bolivarSoftware.eTurnos.web.notificacionSocio;

import com.bolivarSoftware.eTurnos.beans.NotificacionesSocios;
import com.bolivarSoftware.eTurnos.domain.Notificacion;
import com.bolivarSoftware.eTurnos.domain.NotificacionSocio;
import com.bolivarSoftware.eTurnos.domainSoccam.Rubro;
import com.bolivarSoftware.eTurnos.domainSoccam.Segmento;
import com.bolivarSoftware.eTurnos.services.notificacion.NotificacionService;
import com.bolivarSoftware.eTurnos.services.notificacionSocio.NotificacionSocioService;
import com.bolivarSoftware.eTurnos.services.soccam.interfaces.IRubroService;
import com.bolivarSoftware.eTurnos.services.soccam.interfaces.ISegmentoService;
import com.bolivarSoftware.eTurnos.validator.NotificacionValidator;
import com.bolivarSoftware.eTurnos.web.notificacionSocio.enumerador.EstadoNotificacionSocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;

/**
 * Created by Damian Gallego on 8/5/2019.
 */
@Controller
@RequestMapping("notificacionSocio")
public class NotificacionSocioController {

    private NotificacionSocioService notificacionSocioService;

    private NotificacionService notificacionService;

    private NotificacionValidator notificacionValidator;

    private ISegmentoService segmentoService;

    private IRubroService rubroService;

    @Autowired
    public NotificacionSocioController(NotificacionSocioService notificacionSocioService, NotificacionService notificacionService, NotificacionValidator notificacionValidator, ISegmentoService segmentoService, IRubroService rubroService) {
        this.notificacionSocioService = notificacionSocioService;
        this.notificacionService = notificacionService;
        this.notificacionValidator = notificacionValidator;
        this.segmentoService = segmentoService;
        this.rubroService = rubroService;
    }

    @RequestMapping("save")
    public String save(@ModelAttribute NotificacionesSocios notificacionSocio, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        this.notificacionValidator.validate(notificacionSocio, result);
        if (result.hasErrors()) {
            model.addAttribute("socioError", "Socio no encontrado");
        }

        notificacionSocioService.save(notificacionSocio);

        Integer id = notificacionSocio.getNotificacion().getId();
        if(Objects.isNull(id)) id = notificacionSocio.getNotificaciones().get(0).getNotificacion().getId();

        redirectAttributes.addAttribute("id", id);

        return "redirect:listSocio";
    }

    @RequestMapping("list")
    public String findAll(@RequestParam Long idSocio, Model model) {
        List<NotificacionSocio> notificaciones = notificacionSocioService.getBySocio(idSocio);
        model.addAttribute("notificaciones", notificaciones);

        return "notificacionSocio/list";
    }

    @RequestMapping("activar")
    public String activarNotificacion(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        NotificacionSocio notificacionSocio = notificacionSocioService.get(id);
        notificacionSocio.setEstado(EstadoNotificacionSocio.ACTIVO);
        redirectAttributes.addAttribute("idSocio", notificacionSocio.getSocio().getId());
        notificacionSocioService.save(notificacionSocio);

        return "redirect:list";
    }

    @RequestMapping("desactivar")
    public String desactivarNotificacion(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        NotificacionSocio notificacionSocio = notificacionSocioService.get(id);
        notificacionSocio.setEstado(EstadoNotificacionSocio.INACTIVO);
        redirectAttributes.addAttribute("idSocio", notificacionSocio.getSocio().getId());
        notificacionSocioService.save(notificacionSocio);

        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        NotificacionSocio notificacionSocio = notificacionSocioService.get(id);
        redirectAttributes.addAttribute("id", notificacionSocio.getNotificacion().getId());
        notificacionSocioService.delete(id);

        return "redirect:listSocio";
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

    @RequestMapping("listSocio")
    public String listSocio(@RequestParam Integer id, Model model) {
        Notificacion notificacion = notificacionService.get(id);
        List<NotificacionSocio> sociosNotificados = notificacionSocioService.getByNotificacion(notificacion);
        model.addAttribute("sociosNotificados", sociosNotificados);
        model.addAttribute("notificacion", notificacion);


        return "notificacionSocio/listSocio";
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

    @ModelAttribute("segmentos")
    public List<Segmento> getSegmentos(){
        return segmentoService.findAll();
    }

    @ModelAttribute("rubros")
    public List<Rubro> getRubros(){
        return rubroService.findAll();
    }




}

