package com.bolivarSoftware.eTurnos.dao.interfaces;

import com.bolivarSoftware.eTurnos.domain.ActividadUsuario;
import com.bolivarSoftware.eTurnos.domain.Usuario;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Fede Beron on 4/7/2017.
 */
public interface IActividadUsuarioRepository {

    ActividadUsuario save(ActividadUsuario actividadUsuario);

    List<ActividadUsuario> findByUsuario(Usuario usuario, Integer pageNumber);

    ActividadUsuario getUltimaActividad(Usuario usuario);

    List<ActividadUsuario> findByUsuarioByMomento(Usuario usuario, LocalDateTime momento);
}
