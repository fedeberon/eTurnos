package com.bolivarSoftware.eTurnos.services.turno;

import com.bolivarSoftware.eTurnos.beans.TurnoView;
import com.bolivarSoftware.eTurnos.dao.interfaces.ITurnoRepository;
import com.bolivarSoftware.eTurnos.domain.*;
import com.bolivarSoftware.eTurnos.services.interfaces.INotificacionSocioService;
import com.bolivarSoftware.eTurnos.services.interfaces.IPuestoDeAtencionService;
import com.bolivarSoftware.eTurnos.services.interfaces.ITurnoService;
import com.bolivarSoftware.eTurnos.services.interfaces.IUsuarioService;
import com.bolivarSoftware.eTurnos.utils.UtilDate;
import com.bolivarSoftware.eTurnos.websocket.IWebSocketService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRepository dao;

    @Autowired
    private IWebSocketService webSocketService;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IPuestoDeAtencionService puestoDeAtencionService;


    @Autowired
    private INotificacionSocioService notificacionSocioService;

    @Override
    public Turno get(Long id) {
        return dao.get(id);
    }

    @Override
    public Turno save(Turno turno) {
        return dao.save(turno);
    }

    @Override
    public List<Turno> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Turno> findAllPageable(Integer pageNumber) {
        return dao.findAll(pageNumber);
    }

    @Override
    public List<Turno> findByCreador(Usuario creador) {
        return dao.findByCreador(creador);
    }

    @Override
    public List<Turno> findByPuestoDeAtencion(PuestoDeAtencion puestoDeAtencion) {
        return dao.findByPuestoDeAtencion(puestoDeAtencion);
    }

    @Override
    public Turno obtenerProximoTurno() {
        Usuario usuario = usuarioService.getUsuarioAutenticado();
        PuestoDeAtencion puestoDeAtencion = puestoDeAtencionService.getPorUsuarioAsignado(usuario);

        TurnoOrdenado proximoTurno = dao.obtenerProximoTurno();
        proximoTurno.setEstado(EstadoTurnoEnum.LLAMANDO);
        proximoTurno.setFecha(new Date());
        dao.save(proximoTurno);

        Turno turno = proximoTurno.getTurno();
        turno.setEstado(EstadoTurnoEnum.LLAMANDO);
        turno.setPuesto(puestoDeAtencion);
        turno.setFechaLlamado(new Date());
        this.save(turno);

        webSocketService.llamarProximoTurno(new TurnoCartel(turno));
        setNotificacionesBy(turno.getCliente());
        return turno;
    }

    public void setNotificacionesBy(Cliente cliente){
        if(Objects.isNull(cliente)) return;
        List<NotificacionSocio> notificacionSocios = notificacionSocioService.getBySocio(cliente.getId());
        cliente.setNotificacionesDelSocio(notificacionSocios);
    }


    @Override
    public Turno rellamarTurno(Long id) {
        Turno turno = this.get(id);
        Integer rellamadas = turno.getRellamados() != null  ? turno.getRellamados() + 1 : 1;
        turno.setRellamados(rellamadas);
        webSocketService.llamarProximoTurno(new TurnoCartel(turno));
        this.save(turno);

        return turno;
    }

    @Override
    public List<TurnoOrdenado> getTurnosOrdenados() {
        return dao.getTurnosOrdenados();
    }

    @Override
    public void turnoAtendido(Long idTurno) {
        Turno turno = this.get(idTurno);
        turno.setEstado(EstadoTurnoEnum.ATENDIDO);
        turno.setFechaCerrado(new Date());
        dao.deleteTurnoOrdenado(turno.getId());
        this.save(turno);
    }

    @Override
    public void ausentarTurno(Long idTurno) {
        Turno turno = this.get(idTurno);
        turno.setEstado(EstadoTurnoEnum.AUSENTE);
        turno.setFechaCerrado(new Date());
        dao.deleteTurnoOrdenado(turno.getId());
        this.save(turno);
    }

    @Override
    public Long getCantidadTurnosPorAtender() {
        return dao.getCantidadTurnosPorAtender();
    }

    @Override
    public List<TurnoOrdenado> getTurnosPendienteDePuesto(){
        Usuario usuario = usuarioService.obtenerDePrincipal();
        PuestoDeAtencion puestoDeAtencion = puestoDeAtencionService.getPorUsuarioAsignado(usuario);

        return dao.getTurnosPendienteDePuesto(puestoDeAtencion);

    }

    @Override
    public List<TurnoView> buscarEstadisticasPorFecha(String fechaInicio, String fechaFin) throws ParseException {
        Date fecha_0 = UtilDate.convertir(fechaInicio);
        Date fecha_1 = UtilDate.convertir(fechaFin);

        List<TurnoView> turnoViews = new ArrayList();
        List<Turno> obtenerTurnoPorFecha = dao.obtenerTurnoPorFecha(fecha_0, fecha_1);
        this.parsearFechasSinHoras(obtenerTurnoPorFecha);

        Map<Date, List<Turno>> map = obtenerTurnoPorFecha
                .stream()
                .collect(Collectors.groupingBy(Turno::getFechaSolicitado));


        map.forEach((k,v ) -> {
            Integer socios = v.stream().filter(turno -> turno.getCliente() != null).collect(Collectors.toList()).size();
            Integer noSocios = v.stream().filter(turno -> turno.getCliente() == null).collect(Collectors.toList()).size();
            turnoViews.add(new TurnoView(k , socios, noSocios));
        });

        return turnoViews;
    }

    @Override
    public List<Turno> buscar(String fechaDesde, String fechaHasta, String value) {
        Date desde = null;
        Date hasta = null;
        try {
            desde = UtilDate.convertir(fechaDesde);
            hasta = UtilDate.convertir(fechaHasta, "dd-MM-yyyy hh:mm:ss");

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dao.buscar(value, desde , hasta);
    }

    @Override
    public List<Turno> getTurnosCartel() {
        return dao.getTurnosCartel();
    }

    private void parsearFechasSinHoras(Collection<Turno> turnos){
        turnos.forEach(t -> t.setFechaSolicitado(UtilDate.obtenerFechaFormateada(t.getFechaSolicitado())));
    }


}
