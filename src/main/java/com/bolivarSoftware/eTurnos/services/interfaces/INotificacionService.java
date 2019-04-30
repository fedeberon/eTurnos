package com.bolivarSoftware.eTurnos.services.interfaces;

import com.bolivarSoftware.eTurnos.domain.Notificacion;
import com.bolivarSoftware.eTurnos.domain.Usuario;
import com.bolivarSoftware.eTurnos.domain.parametro.Parametro;

import java.util.List;

/**
 * Created by Damian Gallego on 30/4/2019.
 */
public interface INotificacionService {
    List<Notificacion> findAll (Integer id);
    Notificacion save (Notificacion notificacion);
    Notificacion delete (Notificacion id);

}
