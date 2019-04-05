package com.bolivarSoftware.eTurnos.services.interfaces;

import com.bolivarSoftware.eTurnos.domain.parametro.Parametro;

/**
 * Created by Fede Beron on 17/7/2017.
 */
public interface IParametroService {
    Parametro save(Parametro parametro);

    Parametro get(Integer id);
}
