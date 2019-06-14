package com.bolivarSoftware.eTurnos.validator;

import com.bolivarSoftware.eTurnos.beans.NotificacionesSocios;
import com.bolivarSoftware.eTurnos.domain.NotificacionSocio;
import com.bolivarSoftware.eTurnos.services.notificacionSocio.NotificacionSocioService;
import com.bolivarSoftware.eTurnos.web.notificacionSocio.enumerador.Grupo;
import org.springframework.beans.factory.annotation.Autowired;
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

        if(notificacionesSocios.getNotificaciones().get(0).getGrupo().equals(Grupo.SOCIOS_ASIGNADOS)){

            if (notificacionesSocios.getNotificaciones().isEmpty()){
                errors.rejectValue("notificaciones","NotificacionesSocios.Notificacion.listaVacia","Error");
            }
        }

    }
}
