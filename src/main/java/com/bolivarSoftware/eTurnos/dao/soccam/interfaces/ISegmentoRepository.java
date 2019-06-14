package com.bolivarSoftware.eTurnos.dao.soccam.interfaces;

import com.bolivarSoftware.eTurnos.domainSoccam.Segmento;

import java.util.List;

/**
 * Created by federicoberon on 13/06/2019.
 */
public interface ISegmentoRepository {
    List<Segmento> findAll();
}
