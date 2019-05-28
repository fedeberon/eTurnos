package com.bolivarSoftware.eTurnos.services.interfaces;

import com.bolivarSoftware.eTurnos.beans.TurnoView;
import com.bolivarSoftware.eTurnos.domain.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ITurnoService extends ICommonService<Turno, Long>{

    List<Turno> findAllPageable(Integer pageNumber);

    List<Turno> findByCreador(Usuario creador);

    List<Turno> findByPuestoDeAtencion(PuestoDeAtencion puestoDeAtencion);

    Turno obtenerProximoTurno();

    Turno rellamarTurno(Long id);

    List<TurnoOrdenado> getTurnosOrdenados();

    void turnoAtendido(Long idTurno);

    void ausentarTurno(Long idTurno);

    Long getCantidadTurnosPorAtender();

    List<TurnoOrdenado> getTurnosPendienteDePuesto();

    List<TurnoView> buscarEstadisticasPorFecha(String fechaInicio, String fechaFin) throws ParseException;

    List<Turno> buscar(String fechaDesde, String fechaHasta, String value);

    List<Turno> getTurnosCartel();
}
