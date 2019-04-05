package com.bolivarSoftware.eTurnos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPOS_CLIENTE")
public class TipoCliente {

    public final static TipoCliente TIPO_NO_SOCIO = new TipoCliente(1L, "No Socio");
    public final static TipoCliente TIPO_SOCIO = new TipoCliente(2L, "Socio");

    @Id
    @Column(name = "TCL_ID")
    private Long id;
    @Column(name = "TCL_NOMBRE")
    private String nombre;

    public TipoCliente() { }

    public TipoCliente(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
