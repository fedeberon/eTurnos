package com.bolivarSoftware.eTurnos.services.soccam;

import com.bolivarSoftware.eTurnos.dao.soccam.interfaces.ISocioSoccamRepository;
import com.bolivarSoftware.eTurnos.domainSoccam.Rubro;
import com.bolivarSoftware.eTurnos.domainSoccam.SocioSoccam;
import com.bolivarSoftware.eTurnos.services.soccam.interfaces.ISocioSoccamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by federicoberon on 17/06/2019.
 */
@Service
public class SocioSoccamService implements ISocioSoccamService {

    @Autowired
    private ISocioSoccamRepository dao;

    @Override
    public List<SocioSoccam> findByRubro(Rubro rubro){
        return dao.findByRubro(rubro);
    }


}
