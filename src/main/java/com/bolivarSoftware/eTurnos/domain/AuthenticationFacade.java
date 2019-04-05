package com.bolivarSoftware.eTurnos.domain;

import com.bolivarSoftware.eTurnos.config.interfaces.IAuthenticationFacade;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade implements IAuthenticationFacade {

    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public Usuario getPrincipal() {
        return "anonymousUser".equals(getAuthentication().getPrincipal()) ?
                null : (Usuario) getAuthentication().getPrincipal();
    }
}