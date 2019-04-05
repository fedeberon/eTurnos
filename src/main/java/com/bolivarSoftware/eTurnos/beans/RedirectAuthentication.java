package com.bolivarSoftware.eTurnos.beans;

import com.bolivarSoftware.eTurnos.domain.Actividad;
import com.bolivarSoftware.eTurnos.domain.ActividadUsuario;
import com.bolivarSoftware.eTurnos.domain.PuestoDeAtencion;
import com.bolivarSoftware.eTurnos.domain.Usuario;
import com.bolivarSoftware.eTurnos.services.interfaces.IActividadUsuarioService;
import com.bolivarSoftware.eTurnos.services.interfaces.IPuestoDeAtencionService;
import com.bolivarSoftware.eTurnos.services.interfaces.IUsuarioService;
import com.bolivarSoftware.eTurnos.utils.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class RedirectAuthentication extends SavedRequestAwareAuthenticationSuccessHandler {

    private final IPuestoDeAtencionService puestoDeAtencionService;
    private final IUsuarioService usuarioService;
    private final IActividadUsuarioService actividadUsuarioService;

    @Autowired
    public RedirectAuthentication(IPuestoDeAtencionService puestoDeAtencionService,
                                  IUsuarioService usuarioService,
                                  IActividadUsuarioService actividadUsuarioService) {
        this.puestoDeAtencionService = Assert.notNull(puestoDeAtencionService, "puestoDeAtencionService");
        this.usuarioService = Assert.notNull(usuarioService, "usuarioService");
        this.actividadUsuarioService = Assert.notNull(actividadUsuarioService, "actividadUsuarioService");
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        Usuario usuario = usuarioService.obtenerDePrincipal();
        if(usuario.getRol().equals(Usuario.ROL_USER)){
            PuestoDeAtencion puestoDeAtencion = puestoDeAtencionService.getPorUsuarioAsignado(usuario);
            if(puestoDeAtencion != null){
                puestoDeAtencionService.dejarDisponiblePuestoDeAtencion(puestoDeAtencion);
            }
            puestoDeAtencionService
                    .asignarPuestoDeAtencionAUsuario(Long.parseLong(request.getParameter("puestoDeAtencion")), usuario);
        }

        actividadUsuarioService.save(new ActividadUsuario(LocalDateTime.now(), Actividad.LOGUEADO, usuario));
        super.onAuthenticationSuccess(request, response, authentication);
    }
}