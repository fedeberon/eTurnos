package com.bolivarSoftware.eTurnos.domainSoccam;

import javax.persistence.*;

/**
 * Created by federicoberon on 12/06/2019.
 */

@Entity
@Table(name = "sociosRubro")
public class Rubro {

    @Id
    @Column(name = "sociosRubro_id")
    private Long id;

    @Column(name = "sociosRubro_nombre")
    private String nombre;

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
