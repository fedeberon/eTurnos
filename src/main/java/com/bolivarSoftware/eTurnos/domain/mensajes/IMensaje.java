package com.bolivarSoftware.eTurnos.domain.mensajes;

import java.util.Map;
import java.util.UUID;

/**
 * Created by Diego on 05/10/2015.
 */
public interface IMensaje<T> {

    /**
     * Represents the UUID of the message (for replacation checking)
     * @return the UUID of the message
     */
    UUID getUUID();

    /**
     * Represents the creation time of the message
     * @return the timestamp associated w/ the creation time of the message
     */
    long getTimestamp();

    /**
     * The immutable topic of the message
     * @return the topic of the message
     */
    String getTopic();

    /**
     * The immutable map of filter params
     * @return the map with the filters and their values
     */
    Map<String, String> getFilterParameters();

    /**
     * @return The data associated with the message
     */
    T getData();

    Integer getTimer();

    /**
     * @return the replace topic of the message
     */
    default String getTitle() {
        return getTopic().replaceAll("_", " ");
    }
}
