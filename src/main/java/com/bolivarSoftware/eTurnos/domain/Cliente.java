package com.bolivarSoftware.eTurnos.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SOCIO")
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name = "TIPO")
public abstract class Cliente {

    @Id
    @Column(name = "SOCIO_ID")
    private Long id;
    @Column(name = "SOCIO_NOMBRE")
    private String nombre;
    @Column(name = "SOCIO_APELLIDO")
    private String apellido;
    @Column(name = "SOCIO_NACIONALIDAD")
    private String nacionalidad;
    @Column(name = "SOCIO_DNI")
    private String dni;
    @Column(name = "SOCIO_FECHANACIMIENTO")
    private String fechaNacimiento;
    @Column(name = "SOCIO_CUIT")
    private String cuit;
    @Column(name = "SOCIO_MAIL")
    private String eMail;
    @Column(name = "SOCIO_FIRMA")
    private String firma;
    @Column(name = "SOCIO_TIPOEMPRESA")
    private String tipoEmpresa;
    @Column(name = "SOCIO_DOMICILIO")
    private String domicilio;
    @Column(name = "SOCIO_NUMERO")
    private Integer numero;
    @Column(name = "SOCIO_FECHAAPROBACION")
    private Date fechaAprobacion;
    @Column(name = "SOCIO_ACTA")
    private String acta;

    public Cliente() { }

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public String getActa() {
        return acta;
    }

    public void setActa(String acta) {
        this.acta = acta;
    }


    @Override
    public String toString() {
        return apellido + " " + nombre;
    }
}
