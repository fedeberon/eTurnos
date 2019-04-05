package com.bolivarSoftware.eTurnos.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TURNOS_ORDENADOS")
public class TurnoOrdenado{

    @Id
    @Column(name = "IdTurno")
    private Long IdTurno;

    @Column(name = "orden")
    private Integer orden;

    @Enumerated(EnumType.STRING)
    @Column(name = "TOR_ESTADO")
    private EstadoTurnoEnum estado;

    @Column(name = "TOR_FECHA")
    private Date fecha;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "IdTurno")
    private Turno turno;

    public Long getIdTurno() {
        return IdTurno;
    }

    public void setIdTurno(Long idTurno) {
        IdTurno = idTurno;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public EstadoTurnoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoTurnoEnum estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
}
