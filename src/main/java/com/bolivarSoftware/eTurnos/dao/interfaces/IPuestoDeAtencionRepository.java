package com.bolivarSoftware.eTurnos.dao.interfaces;


import com.bolivarSoftware.eTurnos.domain.EstadoPuestoDeAtencionEnum;
import com.bolivarSoftware.eTurnos.domain.PuestoDeAtencion;
import com.bolivarSoftware.eTurnos.domain.Usuario;

import java.util.List;

public interface IPuestoDeAtencionRepository {
    List<PuestoDeAtencion> getPuestosDeAtencionDisponibles();

    List<PuestoDeAtencion> findAll();

    PuestoDeAtencion getPorUsuarioAsignado(Usuario usuario);

    boolean tienePuestoAsignado(Usuario usuarioLogueado);

    PuestoDeAtencion get(Long id);

    void actualizarPuestoDeAtencion(PuestoDeAtencion puestoDeAtencion);
}
