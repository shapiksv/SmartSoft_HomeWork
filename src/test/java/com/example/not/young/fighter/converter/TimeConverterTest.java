package com.example.not.young.fighter.converter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;



import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TimeConverterTest {

    @Autowired
    private TimeConverter timeConverter;

    @Test
    void convertXMLGregorianCalendar() throws DatatypeConfigurationException {
        XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDateTime.of(2021, 6, 3, 14, 33, 48, 123456789).toString());
        assertEquals("2021.06.03", timeConverter.converter(date, "yyyy.MM.dd"));
    }

    @Test
    void convertLocalDate() {
        LocalDate localDate = LocalDate.of(2021, 6, 3);
        assertEquals("2021.06.03", timeConverter.converter(localDate, "yyyy.MM.dd"));
    }

    @Test
    void convertLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.of(2021, 6, 3, 14, 33, 48, 123456789);
        assertEquals("2021.06.03", timeConverter.converter(localDateTime, "yyyy.MM.dd"));
    }

    @Test
    void convertOffsetDateTime() {
        OffsetDateTime offsetDateTime = OffsetDateTime.of(2021, 6, 3, 12,22,22, 2222, ZoneOffset.UTC);
        assertEquals("2021.06.03", timeConverter.converter(offsetDateTime, "yyyy.MM.dd"));
    }

    @Test
    void convertInstant() {
        Instant instant = Instant.parse("2021-06-03T10:15:30.00Z");
        assertEquals("2021.06.03", timeConverter.converter(instant, "yyyy.MM.dd"));
    }

    @Test
    void convertCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Date.from(Instant.parse("2021-06-03T10:15:30.00Z")));
        assertEquals("2021.06.03", timeConverter.converter(calendar, "yyyy.MM.dd"));
    }

    @Test
    void convertDate() {
        Date date = Date.from(Instant.parse("2021-06-03T10:15:30.00Z"));
        assertEquals("2021.06.03", timeConverter.converter(date, "yyyy.MM.dd"));
    }

    @Test
    void convertGregorianCalendar() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(Date.from(Instant.parse("2021-06-03T10:15:30.00Z")));
        assertEquals("2021.06.03", timeConverter.converter(calendar, "yyyy.MM.dd"));
    }

    @Test
    void convertSqDate() {
        java.sql.Date date = java.sql.Date.valueOf("2021-06-03");;

        assertEquals("2021.06.03", timeConverter.converter(date, "yyyy.MM.dd"));
    }


}