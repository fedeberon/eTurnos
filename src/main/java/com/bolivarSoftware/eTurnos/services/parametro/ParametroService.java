package com.bolivarSoftware.eTurnos.services.parametro;

import com.bolivarSoftware.eTurnos.dao.interfaces.IParametroRepository;
import com.bolivarSoftware.eTurnos.domain.parametro.Parametro;
import com.bolivarSoftware.eTurnos.services.interfaces.IParametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Fede Beron on 17/7/2017.
 */
@Service
public class ParametroService implements IParametroService {

    @Autowired
    private IParametroRepository dao;

    @Override
    public Parametro save(Parametro parametro) {
        return dao.save(parametro);
    }

    @Override
    public Parametro get(Integer id) {
        return dao.get(id);
    }

}
