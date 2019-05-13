package com.bolivarSoftware.eTurnos.services.notificacionSocio;

import com.bolivarSoftware.eTurnos.dao.interfaces.INotificacionSocioRepository;
import com.bolivarSoftware.eTurnos.domain.NotificacionSocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Damian Gallego on 8/5/2019.
 */
@Service
public class NotificacionSocioService implements INotificacionSocioRepository{

    @Autowired
    private INotificacionSocioRepository dao;


    @Override
    public List<NotificacionSocio> findAllPageable(Integer page) {
        return dao.findAllPageable(page);
    }

    @Override
    public NotificacionSocio save(NotificacionSocio notificacionSocio) {
        return dao.save(notificacionSocio);
    }

    @Override
    public List<NotificacionSocio> save(List<NotificacionSocio> notificacionesSocios) {
        return dao.save(notificacionesSocios);
    }

    @Override
    public NotificacionSocio get(Integer id)
    {
        return dao.get(id);
    }
}
