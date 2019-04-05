package com.bolivarSoftware.eTurnos.beans;

import com.bolivarSoftware.eTurnos.domain.PuestoDeAtencion;
import com.bolivarSoftware.eTurnos.domain.Usuario;
import com.bolivarSoftware.eTurnos.services.interfaces.IPuestoDeAtencionService;
import com.bolivarSoftware.eTurnos.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Fede Beron on 15/8/2017.
 */
@Component
public class RequestInterceptor implements HandlerInterceptor {

    @Autowired
    private IPuestoDeAtencionService puestoDeAtencionService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HttpSession session = request.getSession(true);
        SecurityContextImpl context = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
        if(context != null) {
            Usuario usuarioLogueado = (Usuario) context.getAuthentication().getPrincipal();
            if(this.puestoDeAtencionService.tienePuestoAsignado(usuarioLogueado)){
                PuestoDeAtencion puestoDeAtencion = puestoDeAtencionService.getPorUsuarioAsignado(usuarioLogueado);
                request.setAttribute("puesto", puestoDeAtencion);
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
