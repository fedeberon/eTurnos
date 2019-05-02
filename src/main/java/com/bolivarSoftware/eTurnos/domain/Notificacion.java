package com.bolivarSoftware.eTurnos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Damian Gallego on 30/4/2019.
 */
@Entity
@Table(name = "notificacion")
public class Notificacion {

    @Id
    @Column(name = "NOTIFICACIONES_ID")
    private Integer id;

    @Column(name = "NOTIFICACIONES_MENSAJE")
    private String message;

    @Column(name = "NOTIFICACIONES_DESDE")
    private Date desde;

    @Column(name = "NOTIFICACIONES_HASTA")
    private Date hasta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }


}
