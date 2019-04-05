package com.bolivarSoftware.eTurnos.services.banner;

import com.bolivarSoftware.eTurnos.dao.interfaces.IBannerRepository;
import com.bolivarSoftware.eTurnos.domain.Banner;
import com.bolivarSoftware.eTurnos.services.interfaces.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@Service
public class BannerService implements IBannerService {

    @Autowired
    private IBannerRepository dao;

//    @Value("${folderBanners}")
    private String folderBanners = "C:\\Program Files (x86)\\Apache Software Foundation\\Apache2.2\\htdocs\\banners";

//    @Value("${urlServerImagenes}" )
    private String urlServerImagenes = "http://192.168.0.34:8888/banners/";

    @Override
    public List<Banner> findAll(Integer pageNumber) {
        return dao.findAll(pageNumber);
    }

    @Override
    public Banner save(Banner banner) {
        return dao.save(banner);
    }

    @Override
    public List<Banner> buscar(String valor) {
        return dao.buscar(valor);
    }

    @Override
    public void publicar(Long id) {
        this.cambiarEstadoDePublicacion(id, Banner.PUBLICAR);
    }

    @Override
    public void noPublicar(Long id) {
        this.cambiarEstadoDePublicacion(id, Banner.NO_PUBLICAR);
    }

    private void cambiarEstadoDePublicacion(Long id, boolean estadoDePublicacion) {
        Banner bannerAPublicar = this.get(id);
        bannerAPublicar.setPublicar(estadoDePublicacion);
        this.save(bannerAPublicar);
    }

    @Override
    public Banner get(Long id) {
        return dao.get(id);
    }

    @Override
    public List<Banner> obtenerBannerAPublicar() {
        List<Banner> bannersAPublicarEnCartel = dao.obtenerBannerAPublicar();
        bannersAPublicarEnCartel.forEach(banner -> banner.setUrl(urlServerImagenes + banner.getNombreDeLaImagen()));

        return bannersAPublicarEnCartel;
    }
}
