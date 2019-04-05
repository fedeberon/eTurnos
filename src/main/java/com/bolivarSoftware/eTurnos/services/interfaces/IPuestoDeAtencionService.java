package com.bolivarSoftware.eTurnos.services.interfaces;

import com.bolivarSoftware.eTurnos.domain.EstadoPuestoDeAtencionEnum;
import com.bolivarSoftware.eTurnos.domain.PuestoDeAtencion;
import com.bolivarSoftware.eTurnos.domain.Usuario;

import java.util.List;

public interface IPuestoDeAtencionService extends ICommonService<PuestoDeAtencion,Long> {
    List<PuestoDeAtencion> getPuestosDeAtencionDisponibles();

    void dejarDisponiblePuestoDeAtencion(PuestoDeAtencion puestoDeAtencion);

    void asignarPuestoDeAtencionAUsuario(Long idPuesto, Usuario usuario);

    PuestoDeAtencion getPorUsuarioAsignado(Usuario usuario);

    boolean tienePuestoAsignado(Usuario usuarioLogueado);
}
