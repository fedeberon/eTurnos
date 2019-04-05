package com.bolivarSoftware.eTurnos.domain.parametro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Fede Beron on 17/7/2017.
 */
@Entity
@Table(name = "PARAMETROS")
public class Parametro {

    @Id
    @Column(name = "PAR_ID")
    private Integer id;

    @Column(name = "PAR_NOMBRE")
    private String nombre;

    @Column(name = "PAR_VALOR")
    private String valor;

    public static Integer  ALTERNANCIA_TURNOS = 1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }


}
