package com.bolivarSoftware.eTurnos.dao.soccam.interfaces;

import com.bolivarSoftware.eTurnos.domainSoccam.Rubro;

import java.util.List;

/**
 * Created by Damian Gallego on 14/6/2019.
 */
public interface IRubroRepository {
    List<Rubro> findAll();
}
