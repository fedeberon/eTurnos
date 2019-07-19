package com.bolivarSoftware.eTurnos.validator;

import com.bolivarSoftware.eTurnos.beans.NotificacionesSocios;
import com.bolivarSoftware.eTurnos.web.notificacionSocio.enumerador.Grupo;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Damian Gallego on 22/5/2019.
 */
@Component
public class NotificacionValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return NotificacionesSocios.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NotificacionesSocios notificacionesSocios = (NotificacionesSocios) target;

        if(!notificacionesSocios.getGrupo().equals(Grupo.SOCIOS_POR_RUBRO) && !notificacionesSocios.getGrupo().equals(Grupo.SOCIOS_POR_SEGMENTO)){
            if (notificacionesSocios.getNotificaciones().isEmpty()){
                errors.rejectValue("notificaciones","NotificacionesSocios.Notificacion.listaVacia","Error");
            }
        }
    }
}

