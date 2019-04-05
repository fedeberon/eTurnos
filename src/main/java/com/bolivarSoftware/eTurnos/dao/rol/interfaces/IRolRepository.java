package com.bolivarSoftware.eTurnos.dao.rol.interfaces;

import com.bolivarSoftware.eTurnos.domain.Rol;

import java.util.List;

/**
 * Created by Fede Beron on 4/7/2017.
 */
public interface IRolRepository {
    List<Rol> findAll();
}
