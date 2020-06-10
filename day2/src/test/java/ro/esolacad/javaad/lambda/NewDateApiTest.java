package ro.esolacad.javaad.lambda;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class NewDateApiTest {

    @Test
    public void testDate() {
        Date date = new Date();

        System.out.println(date);
    }

    @Test
    public void testLocalDate() {
        LocalDate now = LocalDate.now();

        System.out.println(now);

        LocalDate inTheFuture2Months = now.plusMonths(2);

        System.out.println(inTheFuture2Months);

        assert now.isBefore(inTheFuture2Months);

        LocalDate parse = LocalDate.parse("2020-05-05");

        assert parse.isEqual(LocalDate.of(2020, 5, 5));
    }

    @Test
    public void testLocalTime() {
        LocalTime now = LocalTime.now();

        System.out.println(now);
    }

    @Test
    public void testLocalDateTime() {
        LocalDateTime now = LocalDateTime.now();

        System.out.println(now);

        LocalDate localDate = now.toLocalDate();
        LocalTime localTime = now.toLocalTime();
    }

    @Test
    public void testZoneTime() {
        LocalDateTime localDateTime = LocalDateTime.parse("2020-01-01T12:00:00");

        // Always put your times in UTC in DB
        ZonedDateTime utc = localDateTime.atZone(ZoneId.of("UTC"));
        System.out.println(utc);
        ZonedDateTime zonedDateTime = utc.withZoneSameInstant(ZoneId.of("Europe/Bucharest"));
        System.out.println(zonedDateTime);
    }

    @Test
    public void testPeriod() {
        LocalDate today = LocalDate.now();
        LocalDate inTenDays = today.plusDays(10);

        Period between = Period.between(today, inTenDays);

        System.out.println(between);
        assert between.getDays() == 10;
    }

    @Test
    public void testDuration() {
        LocalTime now = LocalTime.now();
        LocalTime inTwoHours = now.plusHours(2);

        Duration between = Duration.between(now, inTwoHours);

        assert Duration.ofHours(2).equals(between);

        LocalDateTime now2 = LocalDateTime.now();
        LocalDateTime future = now2.plusDays(3);

        assert Duration.between(now2,future).equals(Duration.ofDays(3));
        assert Duration.between(now2,future).equals(Duration.ofHours(72));
    }

    @Test
    public void dateFormatter() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDateTime of = LocalDateTime.of(2020, 2, 2, 12, 2);

        assert dateTimeFormatter.format(of).equals("2020-02-02");
    }
}
