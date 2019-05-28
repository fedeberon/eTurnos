package com.bolivarSoftware.eTurnos.dao.interfaces;

import com.bolivarSoftware.eTurnos.domain.NotificacionSocio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damian Gallego on 8/5/2019.
 */

public interface INotificacionSocioRepository {

    List<NotificacionSocio> findAllPageable(Integer pageNumber);

    NotificacionSocio save(NotificacionSocio notificacionSocio);

    List<NotificacionSocio> save(List<NotificacionSocio> notificacionesSocios);

    NotificacionSocio get(Integer id);

    List<NotificacionSocio> getBySocio(Long idSocio);
}
