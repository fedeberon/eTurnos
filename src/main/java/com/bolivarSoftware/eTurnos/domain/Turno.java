package com.bolivarSoftware.eTurnos.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TURNOS")
public class Turno {

    @Id
    @Column(name = "TUR_ID")
    private Long id;
    @Column(name = "TUR_NRO_TICKET")
    private String numeroTicket;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "TUR_FECHA_SOLICITADO")
    private Date fechaSolicitado;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "TUR_FECHA_LLAMADO")
    private Date fechaLlamado;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "TUR_FECHA_CERRADO")
    private Date fechaCerrado;
    @Column(name = "TUR_MOTIVO_PRIORIZADO")
    private String motivoPriorizado;
    @Column(name = "TUR_RELLAMADOS")
    private Integer rellamados = 0;
    @Enumerated(EnumType.STRING)
    @Column(name = "TUR_ESTADO")
    private EstadoTurnoEnum estado;
    @OneToOne
    @JoinColumn(name = "CLI_ID")
    private Cliente cliente;
    @OneToOne
    @JoinColumn(name = "USU_LOGIN")
    private Usuario creador;
    @OneToOne
    @JoinColumn(name = "PUE_ID")
    private PuestoDeAtencion puesto;

    public Turno() { }

    public Turno(String numeroTicket, Usuario usuario) {
        this.numeroTicket = numeroTicket;
        this.creador = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroTicket() {
        return numeroTicket;
    }

    public void setNumeroTicket(String numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    public Date getFechaSolicitado() {
        return fechaSolicitado;
    }

    public void setFechaSolicitado(Date fechaSolicitado) {
        this.fechaSolicitado = fechaSolicitado;
    }

    public Date getFechaLlamado() {
        return fechaLlamado;
    }

    public void setFechaLlamado(Date fechaLlamado) {
        this.fechaLlamado = fechaLlamado;
    }

    public Date getFechaCerrado() {
        return fechaCerrado;
    }

    public void setFechaCerrado(Date fechaCerrado) {
        this.fechaCerrado = fechaCerrado;
    }

    public String getMotivoPriorizado() {
        return motivoPriorizado;
    }

    public void setMotivoPriorizado(String motivoPriorizado) {
        this.motivoPriorizado = motivoPriorizado;
    }

    public Integer getRellamados() {
        return rellamados;
    }

    public void setRellamados(Integer rellamados) {
        this.rellamados = rellamados;
    }

    public EstadoTurnoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoTurnoEnum estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public PuestoDeAtencion getPuesto() {
        return puesto;
    }

    public void setPuesto(PuestoDeAtencion puesto) {
        this.puesto = puesto;
    }




}
