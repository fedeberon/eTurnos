package com.bolivarSoftware.eTurnos.beans;

import com.bolivarSoftware.eTurnos.domain.NotificacionSocio;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damian Gallego on 10/5/2019.
 */
@Entity
public class NotificacionesSocios {

    public List<NotificacionSocio> notificaciones = new ArrayList();

    public List<NotificacionSocio> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<NotificacionSocio> notificaciones) {
        this.notificaciones = notificaciones;
    }
}
