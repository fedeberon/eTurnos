package com.bolivarSoftware.eTurnos.dao.interfaces;

import com.bolivarSoftware.eTurnos.domain.Banner;
import com.bolivarSoftware.eTurnos.domain.parametro.Parametro;

/**
 * Created by Fede Beron on 17/7/2017.
 */
public interface IParametroRepository {
    Parametro save(Parametro parametro);

    Parametro get(Integer id);
}
