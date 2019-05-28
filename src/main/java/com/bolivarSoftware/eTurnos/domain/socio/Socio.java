package com.bolivarSoftware.eTurnos.domain.socio;

import com.bolivarSoftware.eTurnos.domain.Cliente;
import com.bolivarSoftware.eTurnos.domain.NotificacionSocio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.List;

@Entity
@DiscriminatorValue( value = "SOCIO" )
public class Socio extends Cliente{
    @Transient
    private List<NotificacionSocio> notificacionesDelSocio;

    @Override
    public List<NotificacionSocio> getNotificacionesDelSocio() {
        return notificacionesDelSocio;
    }

    public void setNotificacionesDelSocio(List<NotificacionSocio> notificacionesDelSocio) {
        this.notificacionesDelSocio = notificacionesDelSocio;
    }
}
