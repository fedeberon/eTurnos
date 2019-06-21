package com.bolivarSoftware.eTurnos.services.soccam.interfaces;

import com.bolivarSoftware.eTurnos.domainSoccam.Segmento;

import java.util.List;

/**
 * Created by federicoberon on 13/06/2019.
 */
public interface ISegmentoService {
    List<Segmento> findAll();
}
