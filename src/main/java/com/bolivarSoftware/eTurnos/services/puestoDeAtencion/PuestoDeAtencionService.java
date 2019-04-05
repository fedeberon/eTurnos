package com.bolivarSoftware.eTurnos.services.puestoDeAtencion;


import com.bolivarSoftware.eTurnos.dao.interfaces.IPuestoDeAtencionRepository;
import com.bolivarSoftware.eTurnos.domain.EstadoPuestoDeAtencionEnum;
import com.bolivarSoftware.eTurnos.domain.PuestoDeAtencion;
import com.bolivarSoftware.eTurnos.domain.Usuario;
import com.bolivarSoftware.eTurnos.services.interfaces.IPuestoDeAtencionService;
import com.bolivarSoftware.eTurnos.utils.Assert;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuestoDeAtencionService implements IPuestoDeAtencionService {

    private final IPuestoDeAtencionRepository dao;

    @Autowired
    public PuestoDeAtencionService(IPuestoDeAtencionRepository dao) {
        this.dao = Assert.notNull(dao, "daoPuestoAtencion");
    }

    @Override
    public PuestoDeAtencion get(Long id) {
        return dao.get(id);
    }

    @Override
    public PuestoDeAtencion save(PuestoDeAtencion puestoDeAtencion) {
        throw new NotYetImplementedException("Metodo no implementado");
    }

    @Override
    public List<PuestoDeAtencion> findAll() {
        return dao.findAll();
    }

    @Override
    public List<PuestoDeAtencion> getPuestosDeAtencionDisponibles(){
        return dao.getPuestosDeAtencionDisponibles();
    }

    @Override
    public void dejarDisponiblePuestoDeAtencion(PuestoDeAtencion puestoDeAtencion) {
        System.out.println("liberando puesto de atencion");
        puestoDeAtencion.liberarPuestoDeAtencion();
        dao.actualizarPuestoDeAtencion(puestoDeAtencion);
    }

    @Override
    public void asignarPuestoDeAtencionAUsuario(Long idPuesto, Usuario usuario) {
        System.out.println("asignando puesto de atencion");
        PuestoDeAtencion puestoDeAtencion = get(idPuesto);
        puestoDeAtencion.asignarPuestoAUsuario(usuario);
        dao.actualizarPuestoDeAtencion(puestoDeAtencion);
    }

    @Override
    public PuestoDeAtencion getPorUsuarioAsignado(Usuario usuario) {
        return dao.getPorUsuarioAsignado(usuario);
    }

    @Override
    public boolean tienePuestoAsignado(Usuario usuarioLogueado){
        return dao.tienePuestoAsignado(usuarioLogueado);
    }

}