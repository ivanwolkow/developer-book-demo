package com.example.demo.java.concurrency;

import org.apache.commons.lang3.time.FastDateFormat;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * SimpleDateFormat is not safe to use in multithreaded environment
 * Synchronize the SimpleDateFormat instance externally or use thread-safe formatters as shown below
 */
public class SimpleDateFormatProblemTest {

    @Test
    void threadSafeFormattersTest() {
        Instant instant = LocalDate.of(2015, 10, 21).atStartOfDay().toInstant(ZoneOffset.UTC);
        Date date = Date.from(instant);

        assertEquals("2015-10-21", new SimpleDateFormatterThreadLocal().formatDate(date));
        assertEquals("2015-10-21", new SimpleDateFormatterSynchronized().formatDate(date));
        assertEquals("2015-10-21", new DateTimeJava8Formatter().formatDate(date));
        assertEquals("2015-10-21", new CommonsFastDateParser().formatDate(date));
    }


    public static class SimpleDateFormatterSynchronized {

        private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        public synchronized String formatDate(Date date) {
            return simpleDateFormat.format(date);
        }

    }

    public static class SimpleDateFormatterThreadLocal {

        private final ThreadLocal<SimpleDateFormat> simpleDateFormat = ThreadLocal.withInitial(() ->
                new SimpleDateFormat("yyyy-MM-dd"));

        public String formatDate(Date date) {
            return simpleDateFormat.get().format(date);
        }
    }

    public static class DateTimeJava8Formatter {

        //joda-time's DateTimeFormatter. It is thread safe and faster than SimpleDateFormat
        private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        public String formatDate(Date date) {
            return ZonedDateTime.ofInstant(date.toInstant(), ZoneId.of("UTC")).format(formatter);
        }
    }

    public static class CommonsFastDateParser {

        //FastDateFormat is a fast and thread-safe version of java.text.SimpleDateFormat
        private final static FastDateFormat formatter = FastDateFormat.getInstance("yyyy-MM-dd");

        public String formatDate(Date date) {
            return formatter.format(date);
        }
    }

}
