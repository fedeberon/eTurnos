package com.bolivarSoftware.eTurnos.services.interfaces;

import com.bolivarSoftware.eTurnos.domain.Banner;

import java.util.List;

/**
 * Created by Fede Beron on 20/6/2017.
 */
public interface IBannerService {
    List<Banner> findAll(Integer pageNumber);

    Banner save(Banner banner);

    List<Banner> buscar(String valor);

    void publicar(Long id);

    void noPublicar(Long id);

    Banner get(Long id);

    List<Banner> obtenerBannerAPublicar();
}
