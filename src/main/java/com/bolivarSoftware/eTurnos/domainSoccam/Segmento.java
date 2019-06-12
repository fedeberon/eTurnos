package com.bolivarSoftware.eTurnos.domainSoccam;

import javax.persistence.*;
import java.util.List;

/**
 * Created by federicoberon on 12/06/2019.
 */
@Entity
@Table(name = "sociosSegmento")
public class Segmento {

    @Id
    @Column(name = "sociosSegmento_id")
    private Long id;

    @Column(name = "sociosSegmentos_nombre")
    private String nombre;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "sociosSegmento_rubro")
    private List<Rubro> rubros;

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

    public List<Rubro> getRubros() {
        return rubros;
    }

    public void setRubros(List<Rubro> rubros) {
        this.rubros = rubros;
    }
}
