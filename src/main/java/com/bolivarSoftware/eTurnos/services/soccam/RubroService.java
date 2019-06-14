package com.bolivarSoftware.eTurnos.services.soccam;

import com.bolivarSoftware.eTurnos.dao.soccam.interfaces.IRubroRepository;
import com.bolivarSoftware.eTurnos.domainSoccam.Rubro;
import com.bolivarSoftware.eTurnos.services.soccam.interfaces.IRubroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Damian Gallego on 14/6/2019.
 */
@Service
@Transactional
public class RubroService implements IRubroService{

    @Autowired
    private IRubroRepository dao;


    @Override
    public List<Rubro> findAll(){
        return dao.findAll();
    }

}
