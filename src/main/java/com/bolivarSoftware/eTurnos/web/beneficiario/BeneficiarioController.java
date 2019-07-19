package com.bolivarSoftware.eTurnos.web.beneficiario;

import com.bolivarSoftware.eTurnos.domain.Beneficiario;
import com.bolivarSoftware.eTurnos.domain.socio.Socio;
import com.bolivarSoftware.eTurnos.services.interfaces.IBeneficiarioService;
import com.bolivarSoftware.eTurnos.services.interfaces.ISocioService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Damian Gallego on 10/7/2019.
 */
@Controller
@RequestMapping("beneficiario")
public class BeneficiarioController {

    private IBeneficiarioService beneficiarioService;

    private ISocioService socioService;

    @Autowired
    public BeneficiarioController(IBeneficiarioService beneficiarioService, ISocioService socioService) {
        this.beneficiarioService = beneficiarioService;
        this.socioService = socioService;
    }

    @RequestMapping("save")
    public String save(@ModelAttribute Beneficiario beneficiario) {
        beneficiarioService.save(beneficiario);

        return "redirect:list";
    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        Beneficiario beneficiario = beneficiarioService.get(id);
        model.addAttribute("beneficiario", beneficiario);

        return "beneficiario/update";
    }

    @RequestMapping("delete")
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        Beneficiario beneficiario = beneficiarioService.get(id);
        redirectAttributes.addAttribute("id", beneficiario.getId());
        beneficiarioService.delete(id);

        return "redirect:list";
    }

    @RequestMapping("list")
    public String findAllPageable(@RequestParam(defaultValue = "1") Integer page, Model model){
        model.addAttribute("beneficiario", beneficiarioService.findAllPageable(page));
        model.addAttribute("page", page);

        return "beneficiario/list";
    }

    @RequestMapping("buscar")
    public String get(@RequestParam String valor, Model model){
        model.addAttribute("beneficiario", beneficiarioService.buscar(valor));
        model.addAttribute("valor", valor);

        return "beneficiario/list";
    }

    @RequestMapping("create")
    public String create(@RequestParam Long id,Model model) {
        Socio socio = socioService.get(id);
        model.addAttribute("socio", socio);

        return "beneficiario/create";
    }

    @ModelAttribute("beneficiario")
    public Beneficiario getBeneficiario(){
        return new Beneficiario();
    }

    @RequestMapping("exportarCredencial")
    public String exportarCredencial(@RequestParam Long id, HttpServletResponse response) throws IOException, JRException {
        final OutputStream outStream = response.getOutputStream();
        Beneficiario beneficiario = beneficiarioService.get(id);
        beneficiarioService.exportarCredencial(beneficiario, outStream);

        return "beneficiario/listBySocio";
    }

    @RequestMapping("listBeneficiario")
    public String listSocio(@RequestParam Long id, Model model) {
        Socio socio = socioService.get(id);
        List<Beneficiario> beneficiarios = beneficiarioService.getBySocio(socio);
        model.addAttribute("beneficiariosBySocio", beneficiarios);
        model.addAttribute("socio", socio);


        return "beneficiario/listBySocio";
    }
}
