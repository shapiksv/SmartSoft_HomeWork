package com.example.not.young.fighter.converter;

import com.example.not.young.fighter.enums.TimeFormat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.xml.datatype.XMLGregorianCalendar;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;



import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TimeConverterTest {

    @Autowired
    private TimeConverter timeConverter;

    @Test
    void convertXMLGregorianCalendar() throws Exception {
        assertTrue(timeConverter.converter("2021.06.15", TimeFormat.XML_GREGORIAN_CALENDAR) instanceof XMLGregorianCalendar);
    }

    @Test
    void convertLocalDate() throws Exception {
        assertTrue(timeConverter.converter("2021.06.15", TimeFormat.LOCAL_DATE) instanceof LocalDate);
    }

    @Test
    void convertLocalDateTime() throws Exception{
        assertTrue(timeConverter.converter("2021.06.15", TimeFormat.LOCAL_DATE_TIME) instanceof LocalDateTime);
    }

    @Test
    void convertOffsetDateTime() throws Exception {
        assertTrue(timeConverter.converter("2021.06.15", TimeFormat.OFFSET_DATE_TIME) instanceof OffsetDateTime);
    }

    @Test
    void convertInstant() throws Exception {
        assertTrue(timeConverter.converter("2021.06.15", TimeFormat.INSTANT) instanceof Instant);
    }

    @Test
    void convertCalendar() throws Exception {
        assertTrue(timeConverter.converter("2021.06.15", TimeFormat.CALENDAR) instanceof Calendar);
    }

    @Test
    void convertDate() throws Exception {
        assertTrue(timeConverter.converter("2021.06.15", TimeFormat.DATE) instanceof Date);
    }

    @Test
    void convertGregorianCalendar() throws Exception {
        assertTrue(timeConverter.converter("2021.06.15", TimeFormat.GREGORIAN_CALENDAR) instanceof GregorianCalendar);
    }

    @Test
    void convertSqDate() throws Exception {
        assertTrue(timeConverter.converter("2021.06.15", TimeFormat.SQ_DATE) instanceof java.sql.Date);
    }


    @Test
    void convertXMLGregorianCalendarWithSwitch() throws Exception {
        assertTrue(timeConverter.convertWithSwitch("2021.06.15", TimeFormat.XML_GREGORIAN_CALENDAR) instanceof XMLGregorianCalendar);
    }

    @Test
    void convertLocalDateWithSwitch() throws Exception {
        assertTrue(timeConverter.convertWithSwitch("2021.06.15", TimeFormat.LOCAL_DATE) instanceof LocalDate);
    }

    @Test
    void convertLocalDateTimeWithSwitch() throws Exception{
        assertTrue(timeConverter.convertWithSwitch("2021.06.15", TimeFormat.LOCAL_DATE_TIME) instanceof LocalDateTime);
    }

    @Test
    void convertOffsetDateTimeWithSwitch() throws Exception {
        assertTrue(timeConverter.convertWithSwitch("2021.06.15", TimeFormat.OFFSET_DATE_TIME) instanceof OffsetDateTime);
    }

    @Test
    void convertInstantWithSwitch() throws Exception {
        assertTrue(timeConverter.convertWithSwitch("2021.06.15", TimeFormat.INSTANT) instanceof Instant);
    }

    @Test
    void convertCalendarWithSwitch() throws Exception {
        assertTrue(timeConverter.convertWithSwitch("2021.06.15", TimeFormat.CALENDAR) instanceof Calendar);
    }

    @Test
    void convertDateWithSwitch() throws Exception {
        assertTrue(timeConverter.convertWithSwitch("2021.06.15", TimeFormat.DATE) instanceof Date);
    }

    @Test
    void convertGregorianCalendarWithSwitch() throws Exception {
        assertTrue(timeConverter.convertWithSwitch("2021.06.15", TimeFormat.GREGORIAN_CALENDAR) instanceof GregorianCalendar);
    }

    @Test
    void convertSqDateWithSwitch() throws Exception {
        assertTrue(timeConverter.convertWithSwitch("2021.06.15", TimeFormat.SQ_DATE) instanceof java.sql.Date);
    }

}