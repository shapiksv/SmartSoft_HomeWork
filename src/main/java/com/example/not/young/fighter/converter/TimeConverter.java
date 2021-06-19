package com.example.not.young.fighter.converter;

import org.springframework.stereotype.Service;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Service
public class TimeConverter {

    public String converter(Object date, String format) {
        if (date instanceof LocalDate localDate) {
            return converterLocalDate(localDate, format);
        }
        if (date instanceof LocalDateTime localDateTime) {
            return converterLocalDateTime(localDateTime, format);
        }
        if (date instanceof XMLGregorianCalendar gregorianCalendar) {
            return converterLocalDateTime(converterXMLGregorianCalendar(gregorianCalendar), format);
        }
        if (date instanceof OffsetDateTime offsetDateTime) {
            return converterOffsetDateTime(offsetDateTime, format);
        }
        if (date instanceof Instant instant) {
            return converterLocalDateTime(LocalDateTime.ofInstant(instant, ZoneOffset.UTC), format);
        }
        if (date instanceof Calendar calendar) {
            return converterLocalDateTime(convertDate(converterCalendar(calendar)), format);
        }
        if (date instanceof Date dateD ) {
            return converterLocalDateTime(convertDate(dateD), format);
        }
        if (date instanceof Calendar calendar) {
            return converterLocalDateTime(convertDate(converterCalendar(calendar)), format);
        }
        if (date instanceof GregorianCalendar gregorianCalendar) {
            return converterLocalDateTime(convertDate(convertGregorianCalendar(gregorianCalendar)),format);
        }
        if (date instanceof java.sql.Date dateSql) {
            return converterLocalDate(convertDateSql(dateSql), format);
        }
        return null;
    }

    private LocalDate convertDateSql(java.sql.Date dateSql) {
        return dateSql.toLocalDate();
    }

    private Date convertGregorianCalendar(GregorianCalendar gregorianCalendar) {
        return gregorianCalendar.getTime();
    }


    private String converterOffsetDateTime(OffsetDateTime offsetDateTime, String format) {
        return offsetDateTime.format(DateTimeFormatter.ofPattern(format)).toString();
    }

    private String converterLocalDateTime(LocalDateTime localDateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return formatter.format(localDateTime);
    }

    private String converterLocalDate(LocalDate localDate, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return formatter.format(localDate);
    }

    private LocalDateTime converterXMLGregorianCalendar(XMLGregorianCalendar gregorianCalendar) {
        ZonedDateTime utcZoned = gregorianCalendar.toGregorianCalendar().toZonedDateTime().withZoneSameInstant(ZoneId.of("UTC"));
        return utcZoned.toLocalDateTime();
    }
    public Date converterCalendar(Calendar calendar) {
        return calendar.getTime();
    }

    public LocalDateTime convertDate(Date date) {
        return Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

}
