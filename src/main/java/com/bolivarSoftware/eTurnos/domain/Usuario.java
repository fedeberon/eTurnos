package com.bolivarSoftware.eTurnos.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name = "USERS")
public class Usuario implements UserDetails {

    @Id
    @Column(name = "USERS_ID")
    private Integer id;

    @Column(name = "USERS_USERNAME")
    private String username;

    @Column(name = "USERS_NOMBRE")
    private String nombre;

    @Column(name = "USERS_APELLIDO")
    private String apellido;

    @Column(name = "USERS_MAIL")
    private String mail;

    @Column(name = "USERS_LASTLOGIN")
    private Date lastLoguin;

    @Column(name = "USERS_PASSWORD")
    private String password;

    @Column(name = "USU_ROL")
    private String rol;

    @Column(name = "USU_ACTIVO")
    private Boolean activo;

    @Column(name = "USU_DNI")
    private String dni;

    /** Rol de administrador de la aplicaci&oacute;n. */
    public final static String ROL_ADMIN = "ROLE_ADMIN";

    /** Rol de cliente que utiliza la aplicaci&oacute;n. */
    public final static String ROL_USER = "ROLE_USER";

    /** Rol de cliente que utiliza la aplicaci&oacute;n. */
    public final static String ROL_CONFIG = "ROLE_CONFIG";

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return activo;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> setAuths = new HashSet();
        setAuths.add(new SimpleGrantedAuthority(this.rol));
        List<GrantedAuthority> Result = new ArrayList(setAuths);

        return Result;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getLastLoguin() {
        return lastLoguin;
    }

    public void setLastLoguin(Date lastLoguin) {
        this.lastLoguin = lastLoguin;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return nombre + " - " + apellido;
    }

}
