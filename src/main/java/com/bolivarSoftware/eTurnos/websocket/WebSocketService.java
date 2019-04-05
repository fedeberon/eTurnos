package com.bolivarSoftware.eTurnos.websocket;

import com.bolivarSoftware.eTurnos.domain.Banner;
import com.bolivarSoftware.eTurnos.domain.TurnoCartel;
import com.bolivarSoftware.eTurnos.services.interfaces.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

@Service
public class WebSocketService implements IWebSocketService{

    @Autowired
    private IBannerService bannerService;

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

//    @Async("threadPoolTaskExecutor")
    @Override
    public void llamarProximoTurno(TurnoCartel turno) {
        messagingTemplate.convertAndSend("/topic/turnos", turno);
    }

//    @Async("threadPoolTaskExecutor")
    @Override
    public void actualizarVideosCartel() {
        List<Banner> videos = bannerService.obtenerBannerAPublicar();
        messagingTemplate.convertAndSend("/topic/videos", videos);
    }

}
