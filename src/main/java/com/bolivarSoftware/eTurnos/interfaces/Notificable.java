package com.bolivarSoftware.eTurnos.interfaces;

import com.bolivarSoftware.eTurnos.domain.Notificacion;
import com.bolivarSoftware.eTurnos.domain.NotificacionSocio;

import java.util.List;

/**
 * Created by Damian Gallego on 16/5/2019.
 */
public interface Notificable {

    List<NotificacionSocio> getNotificacionesDelSocio();

    void setNotificacionesDelSocio(List<NotificacionSocio> notificacionesDelSocio);

}
