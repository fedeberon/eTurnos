package com.bolivarSoftware.eTurnos.web.notificacion;

import com.bolivarSoftware.eTurnos.beans.NotificacionesSocios;
import com.bolivarSoftware.eTurnos.domain.Notificacion;
import com.bolivarSoftware.eTurnos.domainSoccam.Rubro;
import com.bolivarSoftware.eTurnos.domainSoccam.Segmento;
import com.bolivarSoftware.eTurnos.services.notificacion.NotificacionService;
import com.bolivarSoftware.eTurnos.services.soccam.interfaces.IRubroService;
import com.bolivarSoftware.eTurnos.services.soccam.interfaces.ISegmentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Damian Gallego on 30/4/2019.
 */
@Controller
@RequestMapping("notificacion")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    @Autowired
    private ISegmentoService segmentoService;

    @Autowired
    private IRubroService rubroService;

    @RequestMapping("save")
    public String save(@ModelAttribute Notificacion notificacion) {
        notificacionService.save(notificacion);

        return "redirect:list";
    }

    @RequestMapping("list")
    public String findAll(@RequestParam(defaultValue = "1") Integer page, Model model) {
        model.addAttribute("notificacion", notificacionService.findAllPageable(page));
        model.addAttribute("page", page);

        return "notificacion/list";
    }

    @RequestMapping("create")
    public String create() {
        return "notificacion/create";
    }

    @ModelAttribute("notificacion")
    public Notificacion getNotificacion() {
        return new Notificacion();
    }

    @ModelAttribute("notificaciones")
    public NotificacionesSocios getNotificaciones() {
        return new NotificacionesSocios();
    }

    @RequestMapping(value={"update"})
    public String update(@RequestParam Integer id, Model model) {
        Notificacion notificacion = notificacionService.get(id);
        model.addAttribute("notificacion", notificacion);
        return "notificacion/update";
    }

    @ModelAttribute("segmentos")
    public List<Segmento> getSegmentos(){
        return segmentoService.findAll();
    }
    @ModelAttribute("rubros")
    public List<Rubro> getRubros(){
        return rubroService.findAll();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.format(new Date());
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
