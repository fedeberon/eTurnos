package com.bolivarSoftware.eTurnos.domain;

import com.bolivarSoftware.eTurnos.domain.socio.Socio;
import com.bolivarSoftware.eTurnos.web.notificacionSocio.enumerador.EstadoNotificacionSocio;
import com.bolivarSoftware.eTurnos.web.notificacionSocio.enumerador.Grupo;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Damian Gallego on 2/5/2019.
 */
@Entity
@Table(name = "NOTIFICACIONES_SOCIOS")
public class NotificacionSocio {

    @Id
    @Column(name = "ID_NOT_SOC")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @OneToOne
    @JoinColumn(name = "ID_NOT")
    private Notificacion notificacion;

    @OneToOne
    @JoinColumn(name = "SOCIO_ID")
    private Socio socio;

    @Enumerated(EnumType.STRING)
    @Column(name = "NOT_SOC_ESTADO")
    private EstadoNotificacionSocio estado = EstadoNotificacionSocio.ACTIVO;

    public NotificacionSocio() {
    }

    public NotificacionSocio(Notificacion notificacion, Socio socio) {
        this.notificacion = notificacion;
        this.socio = socio;
    }

    private Grupo grupo = Grupo.SOCIOS_ASIGNADOS;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Notificacion getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(Notificacion notificacion) {
        this.notificacion = notificacion;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public EstadoNotificacionSocio getEstado() {
        return estado;
    }

    public void setEstado(EstadoNotificacionSocio estado) {
        this.estado = estado;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}
