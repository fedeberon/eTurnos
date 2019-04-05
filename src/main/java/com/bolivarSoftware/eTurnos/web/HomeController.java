package com.bolivarSoftware.eTurnos.web;

import com.bolivarSoftware.eTurnos.domain.PuestoDeAtencion;
import com.bolivarSoftware.eTurnos.domain.Usuario;
import com.bolivarSoftware.eTurnos.services.interfaces.IPuestoDeAtencionService;
import com.bolivarSoftware.eTurnos.services.interfaces.IUsuarioService;
import com.bolivarSoftware.eTurnos.utils.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static javax.swing.text.StyleConstants.ModelAttribute;

@Controller
@RequestMapping("/")
public class HomeController {

    private final IPuestoDeAtencionService puestoDeAtencionService;
    private final IUsuarioService usuarioService;

    @Autowired
    public HomeController(IPuestoDeAtencionService puestoDeAtencionService,
                          IUsuarioService usuarioService) {
        this.puestoDeAtencionService = Assert.notNull(puestoDeAtencionService, "puestoDeAtencionService");
        this.usuarioService = Assert.notNull(usuarioService, "usuarioService");
    }

    @RequestMapping("/login")
    public String login() {
        if(usuarioService.obtenerDePrincipal() == null){
            return "login";
        }

        else return  "redirect:home";
    }

    @RequestMapping( { "/" , "/home"})
    public String index(Model model) {
        Usuario usuario = usuarioService.getUsuarioAutenticado();
        if(this.puestoDeAtencionService.tienePuestoAsignado(usuario)){
            PuestoDeAtencion puestoDeAtencion = puestoDeAtencionService.getPorUsuarioAsignado(usuario);
            model.addAttribute("puesto", puestoDeAtencion);
        }

        return "index";
    }

    @ModelAttribute("puestosDisponibles")
    private List<PuestoDeAtencion> getPuestosDeAtencionDisponibles(){
        return puestoDeAtencionService.findAll();
    }
}