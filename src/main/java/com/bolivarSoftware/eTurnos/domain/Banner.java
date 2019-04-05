package com.bolivarSoftware.eTurnos.domain;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "BANNERS")
public class Banner {

    @Id
    @Column(name = "BAN_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "BAN_NOMBRE")
    private String nombre;

    @Column(name = "BAN_PUBLICAR")
    private boolean publicar;

    @Column(name = "BAN_NOMBRE_IMAGEN")
    private String nombreDeLaImagen;

    @Transient
    private String url;

    @Transient
    private MultipartFile file;

    public static Boolean PUBLICAR = true;

    public static Boolean NO_PUBLICAR = false;

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

    public boolean isPublicar() {
        return publicar;
    }

    public void setPublicar(boolean publicar) {
        this.publicar = publicar;
    }

    public String getNombreDeLaImagen() {
        return nombreDeLaImagen;
    }

    public void setNombreDeLaImagen(String nombreDeLaImagen) {
        this.nombreDeLaImagen = nombreDeLaImagen;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
