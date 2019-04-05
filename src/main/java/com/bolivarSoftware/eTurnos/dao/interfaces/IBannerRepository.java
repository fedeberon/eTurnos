package com.bolivarSoftware.eTurnos.dao.interfaces;


import com.bolivarSoftware.eTurnos.domain.Banner;

import java.util.List;

public interface IBannerRepository {
    List<Banner> findAll(Integer pageNumber);

    Banner save(Banner banner);

    List<Banner> buscar(String valor);

    Banner get(Long id);

    List<Banner> obtenerBannerAPublicar();
}
