package com.bolivarSoftware.eTurnos.dao.interfaces;

import com.bolivarSoftware.eTurnos.domain.PuestoDeAtencion;
import com.bolivarSoftware.eTurnos.domain.Turno;
import com.bolivarSoftware.eTurnos.domain.TurnoOrdenado;
import com.bolivarSoftware.eTurnos.domain.Usuario;

import java.util.Date;
import java.util.List;

public interface ITurnoRepository {

    List<Turno> findAll(Integer pageNumber);

    List<Turno> findAll();

    List<Turno> findByCreador(Usuario creador);

    List<Turno> findByPuestoDeAtencion(PuestoDeAtencion puestoDeAtencion);

    Turno get(Long id);

    TurnoOrdenado obtenerProximoTurno();

    TurnoOrdenado save(TurnoOrdenado turnoOrdenado);

    Turno save(Turno turno);

    void deleteTurnoOrdenado(Long id);

    List<TurnoOrdenado> getTurnosOrdenados();

    Long getCantidadTurnosPorAtender();

    TurnoOrdenado getTurnoOrdenado(Long id);

    List<TurnoOrdenado> getTurnosPendienteDePuesto(PuestoDeAtencion puestoDeAtencion);

    List<Turno> obtenerTurnoPorFecha(Date fechaInicio, Date fechaFin);

    List<Turno> buscar(String value, Date desde, Date hasta);

    List<Turno> getTurnosCartel();
}
