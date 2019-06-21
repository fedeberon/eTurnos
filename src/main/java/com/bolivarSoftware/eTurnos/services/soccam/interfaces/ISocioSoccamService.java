package com.bolivarSoftware.eTurnos.services.soccam.interfaces;

import com.bolivarSoftware.eTurnos.domainSoccam.Rubro;
import com.bolivarSoftware.eTurnos.domainSoccam.Segmento;
import com.bolivarSoftware.eTurnos.domainSoccam.SocioSoccam;

import java.util.List;

/**
 * Created by federicoberon on 17/06/2019.
 */
public interface ISocioSoccamService {
    List<SocioSoccam> findByRubro(Rubro rubro);

    List<SocioSoccam>  findBySegmento(Segmento segmento);
}
