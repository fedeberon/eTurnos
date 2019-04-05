package com.bolivarSoftware.eTurnos.beans;


import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TurnoView {

    public Date fecha;
    public Integer cantidadDeTurnoSocio;
    public Integer cantidadDeTurnoNoSocio;

    public TurnoView() { }

    public TurnoView(Date fecha, Integer cantidadDeTurnoSocio, Integer cantidadDeTurnoNoSocio) {
        this.fecha = fecha;
        this.cantidadDeTurnoSocio = cantidadDeTurnoSocio;
        this.cantidadDeTurnoNoSocio = cantidadDeTurnoNoSocio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidadDeTurnoSocio() {
        return cantidadDeTurnoSocio;
    }

    public void setCantidadDeTurnoSocio(Integer cantidadDeTurnoSocio) {
        this.cantidadDeTurnoSocio = cantidadDeTurnoSocio;
    }

    public Integer getCantidadDeTurnoNoSocio() {
        return cantidadDeTurnoNoSocio;
    }

    public void setCantidadDeTurnoNoSocio(Integer cantidadDeTurnoNoSocio) {
        this.cantidadDeTurnoNoSocio = cantidadDeTurnoNoSocio;
    }
}
