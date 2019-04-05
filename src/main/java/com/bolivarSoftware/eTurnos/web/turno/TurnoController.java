package com.bolivarSoftware.eTurnos.web.turno;

import com.bolivarSoftware.eTurnos.beans.ContentExcelView;
import com.bolivarSoftware.eTurnos.domain.PuestoDeAtencion;
import com.bolivarSoftware.eTurnos.domain.Usuario;
import com.bolivarSoftware.eTurnos.services.interfaces.IActividadUsuarioService;
import com.bolivarSoftware.eTurnos.services.interfaces.IPuestoDeAtencionService;
import com.bolivarSoftware.eTurnos.services.interfaces.ITurnoService;
import com.bolivarSoftware.eTurnos.services.interfaces.IUsuarioService;
import com.bolivarSoftware.eTurnos.utils.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("turno")
public class TurnoController {

    private final ITurnoService turnoService;
    private final IUsuarioService usuarioService;
    private final IPuestoDeAtencionService puestoDeAtencionService;
    private final IActividadUsuarioService actividadUsuarioService;

    @Autowired
    public TurnoController(ITurnoService turnoService, IUsuarioService usuarioService,
                           IPuestoDeAtencionService puestoDeAtencionService,
                           IActividadUsuarioService actividadUsuarioService) {
        this.turnoService = Assert.notNull(turnoService, "turnoService");
        this.usuarioService = Assert.notNull(usuarioService, "usuarioService");
        this.puestoDeAtencionService = Assert.notNull(puestoDeAtencionService, "puestoDeAtencionService");
        this.actividadUsuarioService = Assert.notNull(actividadUsuarioService, "actividadUsuarioService");
    }

    @RequestMapping("list")
    public String list(@RequestParam(defaultValue = "1") Integer page, Model model) {
        model.addAttribute("turnos", turnoService.findAllPageable(page));
        model.addAttribute("page", page);

        return "turno/list";
    }

    @RequestMapping("buscar")
    public String buscar(@RequestParam String fechaDesde, @RequestParam String fechaHasta, @RequestParam String value, Model model) {
        model.addAttribute("turnos", turnoService.buscar(fechaDesde, fechaHasta, value));
        model.addAttribute("fechaDesde", fechaDesde);
        model.addAttribute("fechaHasta", fechaHasta);
        model.addAttribute("value", value);

        return "turno/list";
    }

    @RequestMapping("turnosPorUsuario")
    public String turnosPorUsuario(@RequestParam String idUsuario, Model model) {
        Usuario usuario = usuarioService.get(idUsuario);
        model.addAttribute("usuario", usuario);
        model.addAttribute("turnos", turnoService.findByCreador(usuario));

        return "turno/list";
    }

    @RequestMapping("turnosPorPuestoDeAtencion")
    public String turnosPorPuestoDeAtencion(@RequestParam Long idPuestoDeAtencion, Model model) {
        PuestoDeAtencion puestoDeAtencion = puestoDeAtencionService.get(idPuestoDeAtencion);
        model.addAttribute("turnos", turnoService.findByPuestoDeAtencion(puestoDeAtencion));

        return "turno/list";
    }

    @RequestMapping("panel")
    public String panel(Model model) {
        model.addAttribute("cantidadTurnosPorAtender", turnoService.getCantidadTurnosPorAtender());
        model.addAttribute("turnosPendientesDePuesto", turnoService.getTurnosPendienteDePuesto());
        Usuario usuario = usuarioService.obtenerDePrincipal();
        model.addAttribute("ultimaActividad", actividadUsuarioService.getUltimaActividad(usuario));

        return "turno/panel";
    }

    @RequestMapping("show")
    public String show(@RequestParam Long id, Model model) {
        model.addAttribute("turno", turnoService.get(id));

        return "turno/show";
    }

    @RequestMapping("turnosOrdenados")
    public String turnosOrdenados(Model model) {
        model.addAttribute("turnosOrdenados", turnoService.getTurnosOrdenados());

        return "turno/listOrdenados";
    }

    @RequestMapping(value = "atendido", method = {RequestMethod.POST, RequestMethod.GET})
    public String atendido(@RequestParam Long idTurno) {
        turnoService.turnoAtendido(idTurno);

        return "redirect:panel";
    }

    @RequestMapping(value = "ausentar", method = {RequestMethod.POST, RequestMethod.GET})
    public String ausentar(@RequestParam Long idTurno) {
        turnoService.ausentarTurno(idTurno);

        return "redirect:panel";
    }

    @RequestMapping(value = "rellamar", method = RequestMethod.GET)
    public String rellamar(@RequestParam Long idTurno) {
        turnoService.rellamarTurno(idTurno);

        return "redirect:panel";
    }

    @RequestMapping(value = "desktopAtendido", method = {RequestMethod.POST, RequestMethod.GET})
    public String desktopAtendido(@RequestParam Long idTurno) {
        turnoService.turnoAtendido(idTurno);

        return "redirect:windowDescktop";
    }

    @RequestMapping(value = "desktopAusentar", method = {RequestMethod.POST, RequestMethod.GET})
    public String desktopAusentar(@RequestParam Long idTurno) {
        turnoService.ausentarTurno(idTurno);

        return "redirect:windowDescktop";
    }

    @RequestMapping(value = "desktopRellamar", method = RequestMethod.GET)
    public String desktopRellamar(@RequestParam Long idTurno) {
        turnoService.rellamarTurno(idTurno);

        return "redirect:windowDescktop";
    }

    @RequestMapping(value = "solicitar", method = RequestMethod.GET)
    public String solicitar() {
        turnoService.obtenerProximoTurno();

        return "redirect:windowDescktop";
    }

    @RequestMapping("windowDescktop")
    public String windowDescktop(Model model){
        model.addAttribute("cantidadTurnosPorAtender", turnoService.getCantidadTurnosPorAtender());
        model.addAttribute("turnosPendientesDePuesto", turnoService.getTurnosPendienteDePuesto());
        Usuario usuario = usuarioService.obtenerDePrincipal();
        model.addAttribute("ultimaActividad", actividadUsuarioService.getUltimaActividad(usuario));
        return "turno/windowDescktop";
    }

    @RequestMapping(value = "/report", method = RequestMethod.GET,produces = "application/xlsx")
    public ModelAndView exportToXlsx() {
        return new ModelAndView(new ContentExcelView(),"turnos", turnoService.findAll());
    }
}
