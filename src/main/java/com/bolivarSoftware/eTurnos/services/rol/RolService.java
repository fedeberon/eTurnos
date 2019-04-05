package com.bolivarSoftware.eTurnos.services.rol;

import com.bolivarSoftware.eTurnos.dao.rol.interfaces.IRolRepository;
import com.bolivarSoftware.eTurnos.domain.Rol;
import com.bolivarSoftware.eTurnos.services.interfaces.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Fede Beron on 4/7/2017.
 */
@Service
public class RolService implements IRolService {

    @Autowired
    private IRolRepository dao;

    @Override
    public Rol get(String s) {
        return null;
    }

    @Override
    public Rol save(Rol rol) {
        return null;
    }

    @Override
    public List<Rol> findAll() {
        return dao.findAll();
    }
}
