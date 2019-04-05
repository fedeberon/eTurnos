package com.bolivarSoftware.eTurnos.beans;

import com.bolivarSoftware.eTurnos.domain.Actividad;
import com.bolivarSoftware.eTurnos.domain.ActividadUsuario;
import com.bolivarSoftware.eTurnos.domain.PuestoDeAtencion;
import com.bolivarSoftware.eTurnos.domain.Usuario;
import com.bolivarSoftware.eTurnos.services.interfaces.IActividadUsuarioService;
import com.bolivarSoftware.eTurnos.services.interfaces.IPuestoDeAtencionService;
import com.bolivarSoftware.eTurnos.utils.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    private final IPuestoDeAtencionService puestoDeAtencionService;
    private final IActividadUsuarioService actividadUsuarioService;

    @Autowired
    public LogoutSuccessHandler(IPuestoDeAtencionService puestoDeAtencionService,
                                IActividadUsuarioService actividadUsuarioService) {
        this.puestoDeAtencionService = Assert.notNull(puestoDeAtencionService, "puestoDeAtencionService");
        this.actividadUsuarioService = Assert.notNull(actividadUsuarioService, "actividadUsuarioService");
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response,
                                Authentication authentication) throws IOException, ServletException {
        setDefaultTargetUrl("/login");
        if (authentication == null) {
            super.onLogoutSuccess(request, response, null);
            return;
        }

        Usuario usuario = (Usuario) authentication.getPrincipal();

        if(usuario.getRol().equals(Usuario.ROL_USER)) {
            PuestoDeAtencion puestoDeAtencion = puestoDeAtencionService.getPorUsuarioAsignado(usuario);
            puestoDeAtencionService.dejarDisponiblePuestoDeAtencion(puestoDeAtencion);
        }

        actividadUsuarioService.save(new ActividadUsuario(LocalDateTime.now(), Actividad.DESLOGUEADO, usuario));
        super.onLogoutSuccess(request, response, authentication);
    }
}