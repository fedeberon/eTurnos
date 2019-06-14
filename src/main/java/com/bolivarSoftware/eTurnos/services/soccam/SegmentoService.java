package com.bolivarSoftware.eTurnos.services.soccam;

import com.bolivarSoftware.eTurnos.dao.soccam.interfaces.ISegmentoRepository;
import com.bolivarSoftware.eTurnos.domainSoccam.Segmento;
import com.bolivarSoftware.eTurnos.services.soccam.interfaces.ISegmentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by federicoberon on 13/06/2019.
 */

@Service
@Transactional("txnManagerSoccam")
public class SegmentoService implements ISegmentoService {

    @Autowired
    private ISegmentoRepository dao;


    @Override
    public List<Segmento> findAll(){
        return dao.findAll();
    }

}
