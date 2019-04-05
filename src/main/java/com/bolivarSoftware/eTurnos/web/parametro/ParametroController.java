package com.bolivarSoftware.eTurnos.web.parametro;

import com.bolivarSoftware.eTurnos.domain.parametro.Parametro;
import com.bolivarSoftware.eTurnos.services.interfaces.IParametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by Fede Beron on 17/7/2017.
 */
@Controller
@RequestMapping("parametros")
public class ParametroController {

    @Autowired
    private IParametroService parametroService;

    @RequestMapping("show")
    private String show(@RequestParam Integer id, Model model){
        model.addAttribute("parametro", parametroService.get(id));

        return "parametro/show";
    }

    @RequestMapping("save")
    private String save(@ModelAttribute Parametro parametro, RedirectAttributes redirectAttributes){
        parametroService.save(parametro);
        redirectAttributes.addAttribute("id", parametro.getId());
        return "parametro/show";
    }
}
