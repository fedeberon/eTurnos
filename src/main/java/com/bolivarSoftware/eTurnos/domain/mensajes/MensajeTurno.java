package com.bolivarSoftware.eTurnos.domain.mensajes;

import com.bolivarSoftware.eTurnos.domain.Turno;

import java.util.Map;
import java.util.UUID;

/**
 * Created by Diego on 05/10/2015.
 */
public class MensajeTurno implements IMensaje<Turno>{

    public final static String TOPIC_NUEVO_TURNO = "NUEVO_TURNO";
    public final static String TOPIC_LLAMANDO_TURNO = "LLAMANDO_TURNO";
    public final static String TOPIC_TURNO_AUSENTE = "TURNO_AUSENTE";
    public final static String TOPIC_TURNO_PRIORIZADO = "TURNO_PRIORIZADO";
    public final static String TOPIC_TURNO_CANCELADO = "TURNO_CANCELADO";
    public final static String TOPIC_TURNO_ASIGNADO = "TURNO_ASIGNADO";
    public final static String TOPIC_TURNO_DERIVADO = "TURNO_DERIVADO";
    public final static String TOPIC_TURNO_LIBERADO = "TURNO_LIBERADO";
    public final static String TOPIC_TURNO_ATENDIDO = "TURNO_ATENDIDO";
    private final static long OFFSET_MILLIS = 0 * 1000;

    private String topic;
    private Turno turno;
    private long timestamp;
    private UUID uuid;
    private Map<String, String> filterParams;
    private Integer timer;
    private String tipo;

    public MensajeTurno() {}

    public MensajeTurno(Turno turno, String topic) {
        this.turno = turno;
        this.uuid = UUID.randomUUID();
        this.topic = topic;
    }

    public static MensajeTurno crearMensajeTurno(Turno turno, String topic) {
        return new MensajeTurno(turno, topic);
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }
    @Override
    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String getTopic() {
        return topic;
    }

    @Override
    public Map<String, String> getFilterParameters() {
        return null;
    }

    @Override
    public Turno getData() {
        return turno;
    }

    @Override
    public Integer getTimer() {
        return timer;
    }


    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setTimer(Integer timer) {
        this.timer = timer;
    }
}
