package com.bolivarSoftware.eTurnos.config.interfaces;

import com.bolivarSoftware.eTurnos.domain.Usuario;
import org.springframework.security.core.Authentication;

/**
 * Created by Fede Beron on 23/6/2017.
 */
public interface IAuthenticationFacade {
    Authentication getAuthentication();

    Usuario getPrincipal();
}
