package com.bolivarSoftware.eTurnos.domain;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PUESTOS_DE_ATENCION")
public class PuestoDeAtencion {

    @Id
    @Column(name = "PTO_ID")
    private Long id;
    @Column(name = "PTO_NUMERO")
    private Integer numero;
    @Column(name = "PTO_HOST")
    private String hostname;
    @Enumerated(EnumType.STRING)
    @Column(name = "PTO_ESTADO")
    private EstadoPuestoDeAtencionEnum estado = EstadoPuestoDeAtencionEnum.DISPONIBLE;
    @OneToOne
    @JoinColumn(name = "USERS_ID")
    private Usuario usuarioAsiganado;

    @Column(name = "PTO_ULTIMO_LOGUEO")
    private Date ultimoLogueo;

    @Formula("(select count(*) from TURNOS t where t.PUE_ID = PTO_ID and t.TUR_ESTADO = 'atendido' and t.TUR_FECHA_CERRADO <> sysdate())")
    private Integer turnosAtendidos;

    @Formula("(select count(*) from TURNOS t where t.PUE_ID  = PTO_ID and t.TUR_ESTADO = 'ausente' and t.TUR_FECHA_CERRADO <> sysdate())")
    private Integer turnosAusentes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public EstadoPuestoDeAtencionEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoPuestoDeAtencionEnum estado) {
        this.estado = estado;
    }

    public Usuario getUsuarioAsiganado() {
        return usuarioAsiganado;
    }

    public void setUsuarioAsiganado(Usuario usuarioAsiganado) {
        this.usuarioAsiganado = usuarioAsiganado;
    }

    public Integer getTurnosAtendidos() {
        return turnosAtendidos;
    }

    public void setTurnosAtendidos(Integer turnosAtendidos) {
        this.turnosAtendidos = turnosAtendidos;
    }

    public Integer getTurnosAusentes() {
        return turnosAusentes;
    }

    public void setTurnosAusentes(Integer turnosAusentes) {
        this.turnosAusentes = turnosAusentes;
    }

    public Date getUltimoLogueo() {
        return ultimoLogueo;
    }

    public void setUltimoLogueo(Date ultimoLogueo) {
        this.ultimoLogueo = ultimoLogueo;
    }

    public void asignarPuestoAUsuario(Usuario usuarioAsiganado) {
        this.usuarioAsiganado = usuarioAsiganado;
        this.estado = EstadoPuestoDeAtencionEnum.NO_DISPONIBLE;
        this.ultimoLogueo = new Date();
    }
    public void liberarPuestoDeAtencion() {
        this.usuarioAsiganado = null;
        this.estado = EstadoPuestoDeAtencionEnum.DISPONIBLE;
        this.ultimoLogueo = new Date();
    }

    @Override
    public String toString() {
        return "Nro: " + id + ". " + usuarioAsiganado;
    }
}
