package com.bolivarSoftware.eTurnos.services.interfaces;

import com.bolivarSoftware.eTurnos.domain.Notificacion;
import com.bolivarSoftware.eTurnos.domain.Usuario;
import com.bolivarSoftware.eTurnos.domain.parametro.Parametro;

import java.util.List;

/**
 * Created by Damian Gallego on 30/4/2019.
 */
public interface INotificacionService extends ICommonService<Notificacion, String> {
    List<Notificacion> findAllPageable(Integer page);
    void darDeBaja(String id);
    void activar(String id);
    Notificacion save(Notificacion notificacion);
}
