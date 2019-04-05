package com.bolivarSoftware.eTurnos.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class UtilDate {

    private static final Logger LOGGER = LoggerFactory.getLogger(UtilDate.class);

    public static Date obtenerFechaFormateada(Date fecha) {
        Instant instant = fecha.toInstant();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
        DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("dd/LL/yyyy");
        fechaFormateada.format(localDate);

        return Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
    }

    public static String parseToString(Date fecha) {
        return fecha.toInstant()  // Convert `java.util.Date` to `Instant`.
                .atOffset( ZoneOffset.UTC )  // Transform `Instant` to `OffsetDateTime`.
                .format( DateTimeFormatter.ISO_LOCAL_DATE_TIME )  // Generate a String.
                .replace( "T" , " " );  // Put a SPACE in the middle.

    }

    public static Date setTime( final Date date, final int hourOfDay, final int minute, final int second, final int ms ) {
        final GregorianCalendar gc = new GregorianCalendar();
        gc.setTime( date );
        gc.set( Calendar.HOUR_OF_DAY, hourOfDay );
        gc.set( Calendar.MINUTE, minute );
        gc.set( Calendar.SECOND, second );
        gc.set( Calendar.MILLISECOND, ms );
        return gc.getTime();
    }

    public static Date convertir(String fecha) throws ParseException {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return formatoDelTexto.parse(fecha);
        } catch (ParseException e) {
            LOGGER.error("No se pudo parsear la fecha.", e);
            throw e;
        }
    }

    public static Date convertir(String fecha, String format) throws ParseException {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat(format);
        try {
            return setTime(formatoDelTexto.parse(fecha + " 00:00:00"), 23, 59, 59, 0);
        } catch (ParseException e) {
            LOGGER.error("No se pudo parsear la fecha y hora.", e);
            throw e;
        }
    }

    public static String formatDuration(Duration duration) {
        long seconds = duration.getSeconds();
        long absSeconds = Math.abs(seconds);
        String positive = String.format(
                "%d:%02d:%02d",
                absSeconds / 3600,
                (absSeconds % 3600) / 60,
                absSeconds % 60);
        return seconds < 0 ? "-" + positive : positive;
    }
}