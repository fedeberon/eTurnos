package com.bolivarSoftware.eTurnos.dao.interfaces;

import com.bolivarSoftware.eTurnos.domain.Notificacion;
import com.bolivarSoftware.eTurnos.domain.Usuario;

import java.util.List;

/**
 * Created by Damian Gallego on 30/4/2019.
 */
public interface INotificacionRepository {

    List<Notificacion> findAllPageable(Integer pageNumber);
    Notificacion save(Notificacion notificacion);
    Notificacion delete(Notificacion id);
    Notificacion update(Notificacion notificacion);
}
