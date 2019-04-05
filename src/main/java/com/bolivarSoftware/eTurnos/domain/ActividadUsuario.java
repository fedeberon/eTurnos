package com.bolivarSoftware.eTurnos.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Fede Beron on 4/7/2017.
 */
@Entity
@Table(name = "ACTIVIDAD_USUARIO")
public class ActividadUsuario {

    @Id
    @Column(name="ACT_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="ACT_MOMENTO")
    private LocalDateTime momento;

    @Enumerated(EnumType.STRING)
    @Column(name="ACT_ACTIVIDAD")
    private Actividad actividad;

    @OneToOne
    @JoinColumn(name = "USU_ID")
    private Usuario usuario;

    public ActividadUsuario() {}

    public ActividadUsuario(LocalDateTime momento, Actividad actividad, Usuario usuario) {
        this.momento = momento;
        this.actividad = actividad;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getMomento() {
        return momento;
    }

    public void setMomento(LocalDateTime momento) {
        this.momento = momento;
    }
}
