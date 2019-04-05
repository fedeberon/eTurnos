package com.bolivarSoftware.eTurnos.websocket;

import com.bolivarSoftware.eTurnos.domain.Banner;
import com.bolivarSoftware.eTurnos.domain.TurnoCartel;
import com.bolivarSoftware.eTurnos.services.interfaces.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IWebSocketService {

    void llamarProximoTurno(TurnoCartel turno);

    void actualizarVideosCartel();

}
