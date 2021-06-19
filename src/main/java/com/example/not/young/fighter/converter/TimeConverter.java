package com.example.not.young.fighter.converter;

import com.example.not.young.fighter.enums.TimeFormat;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeFactory;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class TimeConverter {


    public Object converter(String time, TimeFormat timeFormat) throws Exception {
        return timeFormat.convert(time);
    }

    Object convertWithSwitch(String time, TimeFormat timeFormat) throws Exception {
        var date = switch (timeFormat) {
            case XML_GREGORIAN_CALENDAR -> {
                yield DatatypeFactory.newInstance().newXMLGregorianCalendar(getGregorianCalendar(getDate(time)));
            }
            case LOCAL_DATE -> {
                yield getLocalDate(time);
            }
            case LOCAL_DATE_TIME -> {
                yield getLocalDate(time).atStartOfDay();
            }
            case OFFSET_DATE_TIME -> {
                yield getLocalDate(time).atStartOfDay(ZoneId.of("Europe/Madrid")).toOffsetDateTime();
            }
            case INSTANT -> {
                yield getLocalDate(time).atStartOfDay(ZoneId.of("Europe/Madrid")).toInstant();
            }
            case CALENDAR -> {
                Calendar cal = Calendar.getInstance();
                cal.setTime(getDate(time));
                yield cal;
            }
            case DATE -> {
                yield getDate(time);
            }
            case GREGORIAN_CALENDAR -> {
                yield getGregorianCalendar(getDate(time));
            }
            case SQ_DATE -> {
                yield java.sql.Date.valueOf(getLocalDate(time));
            }
        };
        return date;
    }

    private Date getDate(String time) throws Exception {
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        return format.parse(time);
    }

    private GregorianCalendar getGregorianCalendar(Date date) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal;
    }

    private LocalDate getLocalDate(String time) {
        return LocalDate.parse(time, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
    }
}
