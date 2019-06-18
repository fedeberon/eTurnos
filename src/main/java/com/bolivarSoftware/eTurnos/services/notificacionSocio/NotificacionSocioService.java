package com.bolivarSoftware.eTurnos.services.notificacionSocio;

import com.bolivarSoftware.eTurnos.beans.NotificacionesSocios;
import com.bolivarSoftware.eTurnos.dao.interfaces.INotificacionSocioRepository;
import com.bolivarSoftware.eTurnos.domain.Notificacion;
import com.bolivarSoftware.eTurnos.domain.NotificacionSocio;
import com.bolivarSoftware.eTurnos.domain.socio.Socio;
import com.bolivarSoftware.eTurnos.domainSoccam.SocioSoccam;
import com.bolivarSoftware.eTurnos.services.interfaces.INotificacionSocioService;
import com.bolivarSoftware.eTurnos.services.soccam.interfaces.ISocioSoccamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by Damian Gallego on 8/5/2019.
 */
@Service
public class NotificacionSocioService implements INotificacionSocioService{

    @Autowired
    private INotificacionSocioRepository dao;

    @Autowired
    private ISocioSoccamService socioSoccamService;

    @Override
    public List<NotificacionSocio> findAllPageable(Integer page) {
        return dao.findAllPageable(page);
    }

    @Override
    public NotificacionSocio save(NotificacionSocio notificacionSocio) {
        return dao.save(notificacionSocio);
    }

    @Override
    public List<NotificacionSocio> save(List<NotificacionSocio> notificacionesSocios) {
        return dao.save(notificacionesSocios);
    }

    @Override
    public NotificacionSocio get(Integer id)
    {
        return dao.get(id);
    }

    @Override
    public List<NotificacionSocio> getBySocio(Long idSocio) {
        return dao.getBySocio(idSocio);
    }

    public List<NotificacionSocio> getByNotificacion(Notificacion notificacion) {
        return dao.getByNotificacion(notificacion);
    }



    public void save(NotificacionesSocios notificacionSocio) {
        List<NotificacionSocio> notificaciones = null;
        List<SocioSoccam> socios;
        switch (notificacionSocio.getGrupo()){
            case SOCIOS_ASIGNADOS:return;
            case SOCIOS_POR_SEGMENTO:
                socios = notificacionSocio.getSegmento().getSocioSoccams();
                notificaciones = createNotificacionesSocios(notificacionSocio.getNotificacion(), socios);
                break;
            case SOCIOS_POR_RUBRO:
                socios = socioSoccamService.findByRubro(notificacionSocio.getRubro());
                notificaciones = createNotificacionesSocios(notificacionSocio.getNotificacion(), socios);
                break;
        }

        if(Objects.nonNull(notificaciones) || !notificaciones.isEmpty()){
            this.save(notificaciones);
        }
    }


    private List<NotificacionSocio> createNotificacionesSocios(Notificacion notificacion, List<SocioSoccam> socios){
        if(Objects.isNull(socios)) return Collections.emptyList();
        List<NotificacionSocio> notificaciones = new ArrayList<>();
        socios.forEach(socioSoccam -> {
            Socio socio = new Socio();
            socio.setId(socioSoccam.getId().longValue());
            notificaciones.add(new NotificacionSocio(notificacion, socio));
        });

        return notificaciones;
    }
}
