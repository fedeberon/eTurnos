package com.bolivarSoftware.eTurnos.web.estadistica;

import com.bolivarSoftware.eTurnos.services.interfaces.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Fede Beron on 1/7/2017.
 */
@Controller
@RequestMapping("estadistica")
public class EstadisticaController {


    @Autowired
    private ITurnoService turnoService;

    @RequestMapping("consultas")
    public String estadisiticas(){
        return "turno/estadisticas";
    }


    @RequestMapping("porFecha")
    public String buscarEstadisticasPorFecha(@RequestParam(required = false) String fechaInicio, @RequestParam(required = false)  String fechaFin, Model model){
        if(fechaInicio == null || fechaFin == null) {
            model.addAttribute("validacion", "Debe ingresar fecha de inicio y fecha de fin.");
        }
        else
            try {
                model.addAttribute("turnosView", turnoService.buscarEstadisticasPorFecha(fechaInicio, fechaFin));
            } catch (ParseException e) {
                model.addAttribute("validacion", "Hubo un problema con la fecha de busqueda.");
                e.printStackTrace();
            }

        model.addAttribute("fechaInicio", fechaInicio);
        model.addAttribute("fechaFin", fechaFin);

        return "turno/estadisticas";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
