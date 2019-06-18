package com.bolivarSoftware.eTurnos.dao.soccam.interfaces;

import com.bolivarSoftware.eTurnos.domainSoccam.Rubro;
import com.bolivarSoftware.eTurnos.domainSoccam.SocioSoccam;

import java.util.List;

/**
 * Created by federicoberon on 17/06/2019.
 */
public interface ISocioSoccamRepository {
    List<SocioSoccam> findByRubro(Rubro rubro);
}
