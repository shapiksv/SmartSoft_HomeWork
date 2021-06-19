package com.example.not.young.fighter.enums;

import javax.xml.datatype.DatatypeFactory;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public enum TimeFormat {
    XML_GREGORIAN_CALENDAR {
        @Override
        public Object convert(String time) throws Exception{
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(getGregorianCalendar(getDate(time)));
        }
    },
    LOCAL_DATE {
        @Override
        public Object convert(String time) {
            return getLocalDate(time);
        }
    },
    LOCAL_DATE_TIME {
        @Override
        public Object convert(String time) {
            return getLocalDate(time).atStartOfDay();
        }
    },
    OFFSET_DATE_TIME {
        @Override
        public Object convert(String time) throws Exception {
            return getLocalDate(time).atStartOfDay(ZoneId.of("Europe/Madrid")).toOffsetDateTime();
        }
    },
    INSTANT {
        @Override
        public Object convert(String time) {
            return getLocalDate(time).atStartOfDay(ZoneId.of("Europe/Madrid")).toInstant();
        }
    },
    CALENDAR {
        @Override
        public Object convert(String time) throws Exception {
            Calendar cal = Calendar.getInstance();
            cal.setTime(getDate(time));
            return cal;
        }
    },
    DATE {
        @Override
        public Object convert(String time) throws Exception{
            return getDate(time);
        }
    },
    GREGORIAN_CALENDAR {
        @Override
        public Object convert(String time) throws Exception{
            return getGregorianCalendar(getDate(time));
        }
    },
    SQ_DATE {
        @Override
        public Object convert(String time) {
            return java.sql.Date.valueOf(getLocalDate(time));
        }
    };

    public Object convert(String time) throws Exception {
        return null;
    }

    Date getDate(String time) throws Exception {
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        return format.parse(time);
    }

    GregorianCalendar getGregorianCalendar(Date date) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal;
    }

    LocalDate getLocalDate(String time) {
        return LocalDate.parse(time, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
    }
}
