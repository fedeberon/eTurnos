package com.bolivarSoftware.eTurnos.services.notificacion;

import com.bolivarSoftware.eTurnos.dao.interfaces.INotificacionRepository;
import com.bolivarSoftware.eTurnos.domain.Notificacion;
import com.bolivarSoftware.eTurnos.services.interfaces.INotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Damian Gallego on 30/4/2019.
 */
@Service
public class NotificacionService implements INotificacionService{

    @Autowired
    private INotificacionRepository dao;


    @Override
    public List<Notificacion> findAllPageable(Integer page) {
        return dao.findAllPageable(page);
    }

    @Override
    public Notificacion get(String id) {
        return dao.get(id);
    }

    @Override
    public Notificacion save(Notificacion notificacion) {
        return dao.save(notificacion);
    }

    @Override
    public List<Notificacion> findAll() {
        return null;
    }

}
