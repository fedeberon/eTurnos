package com.bolivarSoftware.eTurnos.domain;

import com.bolivarSoftware.eTurnos.domain.socio.Socio;

import javax.persistence.*;

/**
 * Created by Damian Gallego on 5/7/2019.
 */
@Entity
@Table(name = "BENEFICIARIOS")
public class Beneficiario{

    @Id
    @Column(name = "BEN_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "BEN_NOMBRE")
    private String nombre;

    @OneToOne
    @JoinColumn(name = "SOCIO_ID")
    private Socio socioExtension;

    @Column(name = "BEN_APELLIDO")
    private String apellido;

    @Column(name = "BEN_DNI")
    private String dni;

    public Beneficiario() { }

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

    public Socio getSocioExtension() {
        return socioExtension;
    }

    public void setSocioExtension(Socio socioExtension) {
        this.socioExtension = socioExtension;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Beneficiario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", socioExtension=" + socioExtension +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
