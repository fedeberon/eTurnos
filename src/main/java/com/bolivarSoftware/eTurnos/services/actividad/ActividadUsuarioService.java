package com.bolivarSoftware.eTurnos.services.actividad;

import com.bolivarSoftware.eTurnos.dao.interfaces.IActividadUsuarioRepository;
import com.bolivarSoftware.eTurnos.domain.ActividadUsuario;
import com.bolivarSoftware.eTurnos.domain.Usuario;
import com.bolivarSoftware.eTurnos.services.interfaces.IActividadUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ActividadUsuarioService implements IActividadUsuarioService {

    @Autowired
    private IActividadUsuarioRepository dao;


    @Override
    public ActividadUsuario get(Long aLong) {
        return null;
    }

    @Override
    public ActividadUsuario save(ActividadUsuario actividadUsuario) {
        return dao.save(actividadUsuario);
    }

    @Override
    public List<ActividadUsuario> findAll() {
        return null;
    }

    @Override
    public List<ActividadUsuario> findByUsuario(Usuario usuario, Integer page) {
        return dao.findByUsuario(usuario, page);
    }

    @Override
    public ActividadUsuario getUltimaActividad(Usuario usuario) {
        return dao.getUltimaActividad(usuario);
    }

    @Override
    public List<ActividadUsuario> findByUsuarioByMomento(Usuario usuario, LocalDateTime momento) {
        return dao.findByUsuarioByMomento(usuario, momento);
    }
}
