package com.bolivarSoftware.eTurnos.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Damian Gallego on 30/4/2019.
 */
@Entity
@Table(name = "NOTIFICACIONES")
public class Notificacion {

    @Id
    @Column(name = "ID_NOT")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "MENSAJE_NOT")
    private String message;

    @Column(name = "DESDE_NOT")
    private Date desde;

    @Column(name = "HASTA_NOT")
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
