package com.bolivarSoftware.eTurnos.domain;

import javax.persistence.*;

@Entity
@Table(name = "ROLES")
public class Rol {

    @Id
    @Column(name = "ROL_ID")
    private String id;

    @Column(name = "ROL_FUNCTION")
    private String function;

    @Column(name = "ROL_ENABLED")
    private Integer enabled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Rol) {
            Rol rol = (Rol) obj;
            if (this.equals(rol) && this.id.equals(rol.id) ) {
                return true;
            }  else { return false; }
        }  else { return false; }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "function='" + function + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
