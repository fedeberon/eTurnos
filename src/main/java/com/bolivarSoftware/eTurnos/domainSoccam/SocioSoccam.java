package com.bolivarSoftware.eTurnos.domainSoccam;

import javax.persistence.*;

/**
 * Created by Damian Gallego on 14/6/2019.
 */

@Entity
@Table(name = "socio")
public class SocioSoccam {

    @Id
    @Column(name = "socio_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="socio_segmento", nullable=false)
    private Segmento segmentoDelSocio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Segmento getSegmentoDelSocio() {
        return segmentoDelSocio;
    }

    public void setSegmentoDelSocio(Segmento segmentoDelSocio) {
        this.segmentoDelSocio = segmentoDelSocio;
    }
}
