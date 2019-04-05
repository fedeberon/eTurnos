package com.bolivarSoftware.eTurnos.web.usuario;

import com.bolivarSoftware.eTurnos.domain.Actividad;
import com.bolivarSoftware.eTurnos.domain.ActividadUsuario;
import com.bolivarSoftware.eTurnos.domain.Usuario;
import com.bolivarSoftware.eTurnos.services.interfaces.IActividadUsuarioService;
import com.bolivarSoftware.eTurnos.services.interfaces.IRolService;
import com.bolivarSoftware.eTurnos.services.interfaces.IUsuarioService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;

@Controller
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IRolService rolService;

    @Autowired
    private IActividadUsuarioService actividadUsuarioService;

    @RequestMapping("list")
    public String findAll(@RequestParam(defaultValue = "1") Integer page, Model model){
        model.addAttribute("usuarios", usuarioService.findAllPageable(page));
        model.addAttribute("page", page);

        return "usuario/list";
    }

    @RequestMapping("get/{id}")
    public String get(@PathVariable String id, Model model){
        model.addAttribute("usuario", usuarioService.get(id));
        model.addAttribute("roles", rolService.findAll());

        return "usuario/show";
    }


    @RequestMapping("show")
    public String show(@RequestParam String id, Model model){
        model.addAttribute("usuario", usuarioService.get(id));
        model.addAttribute("roles", rolService.findAll());

        return "usuario/show";
    }

    @RequestMapping("editRol")
    public String editRol(@RequestParam String id, @RequestParam String rol){
        usuarioService.editarRolDeUsuario(id, rol);

        return "redirect:list";
    }

    @RequestMapping("save")
    public String save(@RequestParam String id, @RequestParam String dni){
        Usuario usuario = usuarioService.get(id);
        usuario.setDni(dni);
        usuarioService.save(usuario);

        return "redirect:list";
    }


    @RequestMapping(value = "{id}" , method = RequestMethod.GET)
    public String create(@PathVariable String id, Model model){
        model.addAttribute("usuario", usuarioService.get(id));

        return "usuario/edit";
    }

    @RequestMapping(value = "dejarDeAtender")
    public String dejarDeAtender(){
        Usuario usuario = usuarioService.obtenerDePrincipal();
        actividadUsuarioService.save(new ActividadUsuario(LocalDateTime.now(), Actividad.INACTIVO, usuario));

        return "redirect:/turno/panel";
    }

    @RequestMapping(value = "desktopDejarDeAtender")
    public String desktopDejarDeAtender(){
        Usuario usuario = usuarioService.obtenerDePrincipal();
        actividadUsuarioService.save(new ActividadUsuario(LocalDateTime.now(), Actividad.INACTIVO, usuario));

        return "redirect:/turno/windowDescktop";
    }

    @RequestMapping(value = "desktopAtender")
    public String desktopAtender(){
        Usuario usuario = usuarioService.obtenerDePrincipal();
        actividadUsuarioService.save(new ActividadUsuario(LocalDateTime.now(), Actividad.ATENDIENDO, usuario));

        return "redirect:/turno/windowDescktop";
    }

    @RequestMapping(value = "atender")
    public String atender(){
        Usuario usuario = usuarioService.obtenerDePrincipal();
        actividadUsuarioService.save(new ActividadUsuario(LocalDateTime.now(), Actividad.ATENDIENDO, usuario));

        return "redirect:/turno/panel";
    }

    @RequestMapping(value = "darDeBaja")
    public String darDeBaja(@RequestParam String id, RedirectAttributes redirectAttributes){
        usuarioService.darDeBaja(id);
        redirectAttributes.addAttribute("id", id);

        return "redirect:show";
    }

    @RequestMapping(value = "activar")
    public String activar(@RequestParam String id, RedirectAttributes redirectAttributes){
        usuarioService.activar(id);
        redirectAttributes.addAttribute("id", id);

        return "redirect:show";
    }

    @RequestMapping("exportarCredencial")
    public String exportarCredenciales(@RequestParam Long id, HttpServletResponse response) throws IOException, JRException {
        final OutputStream outStream = response.getOutputStream();
        usuarioService.exportarCredencial(id, outStream);

        return "redirect:list";
    }
}
