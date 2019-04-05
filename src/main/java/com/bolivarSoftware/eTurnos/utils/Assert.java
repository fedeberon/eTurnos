package com.bolivarSoftware.eTurnos.utils;

/**
 * Created by Jose on 11/7/2017.
 */
public class Assert {

    private Assert() {}

    public static <T> T notNull(final T value, final String parameterName) {
        if (value == null)
            throw new IllegalArgumentException(parameterName + " no puede ser null.");
        return value;
    }
}