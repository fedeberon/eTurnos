package com.bolivarSoftware.eTurnos.web.actividad;


import com.bolivarSoftware.eTurnos.domain.Usuario;
import com.bolivarSoftware.eTurnos.services.interfaces.IActividadUsuarioService;
import com.bolivarSoftware.eTurnos.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("actividad")
public class ActividadUsuarioController {

    @Autowired
    private IActividadUsuarioService actividadUsuarioService;

    @Autowired
    private IUsuarioService usuarioService;

    @RequestMapping("porUsuario")
    public String findByUsuario(@RequestParam(defaultValue = "1") Integer page, @RequestParam String id, Model model){
        Usuario usuario = usuarioService.get(id);
        model.addAttribute("actividades", actividadUsuarioService.findByUsuario(usuario, page));

        return "actividad/list";
    }


}
