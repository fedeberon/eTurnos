package com.bolivarSoftware.eTurnos.web.socio;

import com.bolivarSoftware.eTurnos.domain.socio.Socio;
import com.bolivarSoftware.eTurnos.services.interfaces.ISocioService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Controller
@RequestMapping("socio")
public class SocioController {

    @Autowired
    private ISocioService socioService;

    @RequestMapping("list")
    public String findAllPageable(@RequestParam(defaultValue = "1") Integer page, Model model){
        model.addAttribute("socios", socioService.findAllPageable(page));
        model.addAttribute("page", page);

        return "socio/list";
    }


    @RequestMapping("exportarCredenciales")
    public String exportarCredenciales(HttpServletResponse response) throws IOException, JRException {
        final OutputStream outStream = response.getOutputStream();
        socioService.exportarCredenciales(outStream);

        return "socio/list";
    }

    @RequestMapping("{id}")
    public String get(@PathVariable Long id, Model model){
        model.addAttribute("socio", socioService.get(id));

        return "socio/show";
    }

    @RequestMapping("exportarCredencial/{id}")
    public String exportarCredencial(@PathVariable Long id, HttpServletResponse response) throws IOException, JRException {
        final OutputStream outStream = response.getOutputStream();
        Socio socio = socioService.get(id);
        socioService.exportarCredencial(socio, outStream);

        return "socio/list";
    }

    @RequestMapping("buscar")
    public String get(@RequestParam String valor, Model model){
        model.addAttribute("socios", socioService.buscar(valor));
        model.addAttribute("valor", valor);

        return "socio/list";
    }

    @RequestMapping(value = "exportarQR")
    public String exportarQR(@RequestParam String valor, RedirectAttributes redirectAttributes){
        List<Socio> socios = socioService.buscar(valor);
        socioService.crearImagenQR(socios);
        redirectAttributes.addAttribute("valor", valor);

        return "redirect:list";
    }

}
