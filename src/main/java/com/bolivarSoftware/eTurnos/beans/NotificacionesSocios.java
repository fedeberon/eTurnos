package com.bolivarSoftware.eTurnos.beans;

import com.bolivarSoftware.eTurnos.domain.Notificacion;
import com.bolivarSoftware.eTurnos.domain.NotificacionSocio;
import com.bolivarSoftware.eTurnos.domainSoccam.Rubro;
import com.bolivarSoftware.eTurnos.domainSoccam.Segmento;
import com.bolivarSoftware.eTurnos.web.notificacionSocio.enumerador.Grupo;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damian Gallego on 10/5/2019.
 */
@Entity
public class NotificacionesSocios {

    public List<NotificacionSocio> notificaciones = new ArrayList();

    private Segmento segmento;

    private Rubro rubro;

    private Grupo grupo;

    private Notificacion notificacion;

    public List<NotificacionSocio> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<NotificacionSocio> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public Segmento getSegmento() {
        return segmento;
    }

    public void setSegmento(Segmento segmento) {
        this.segmento = segmento;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Notificacion getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(Notificacion notificacion) {
        this.notificacion = notificacion;
    }

}


