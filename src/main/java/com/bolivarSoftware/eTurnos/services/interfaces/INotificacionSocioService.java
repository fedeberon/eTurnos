package com.bolivarSoftware.eTurnos.services.interfaces;

import com.bolivarSoftware.eTurnos.domain.NotificacionSocio;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Damian Gallego on 8/5/2019.
 */
@Service
public interface INotificacionSocioService {
    List<NotificacionSocio> findAllPageable(Integer page);
    NotificacionSocio save(NotificacionSocio notificacionSocio);
    NotificacionSocio get(Integer id);
    List<NotificacionSocio> save(List<NotificacionSocio> notificacionesSocios);
    List<NotificacionSocio> getBySocio(Long idSocio);

    void delete(Integer id);
}
