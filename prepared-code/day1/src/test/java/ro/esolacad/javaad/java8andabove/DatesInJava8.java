package ro.esolacad.javaad.java8andabove;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DatesInJava8 {

    @Test
    public void testOldDate() {
        Date date = new Date();

        System.out.println(date);

        date.setDate(30);

        System.out.println(date);
    }

    @Test
    public void testCreateLocalDate() {
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.of(2019, 5, 20));
        System.out.println(LocalDate.parse("2020-02-20"));
    }

    @Test
    public void testOperationsWithLocalDate() {
        LocalDate baseDate = LocalDate.parse("2020-02-02");

        assert baseDate.plusDays(2).compareTo(LocalDate.parse("2020-02-04")) == 0;
        assert baseDate.plusMonths(1).compareTo(LocalDate.parse("2020-03-02")) == 0;

        assert baseDate.getDayOfMonth() == 2;

        assert baseDate.isBefore(LocalDate.parse("2020-03-01"));
        assert baseDate.isAfter(LocalDate.parse("2020-01-01"));

        assert baseDate.equals(LocalDate.of(2020, 2, 2));
    }

    @Test
    public void testOperationsWithLocalTime() {
        LocalTime localTime = LocalTime.parse("12:00:00");

        assert localTime.getHour() == 12;

        assert localTime.plus(20, ChronoUnit.MINUTES).equals(LocalTime.parse("12:20:00"));
    }

    @Test
    public void testLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.of(
                LocalDate.of(2020, 1, 10),
                LocalTime.of(12, 30)
        );

        System.out.println(localDateTime);

        assert localDateTime.toLocalDate().equals(LocalDate.of(2020, 1, 10));
    }

    @Test
    public void testZoneIdTime() {
        ZoneId sourceTimeZone = ZoneId.of("UTC");
        ZoneId ourTimeZone = ZoneId.of("Europe/Bucharest");

        System.out.println(ourTimeZone);

        ZonedDateTime currentTime = LocalDateTime.parse("2020-01-01T12:00:00")
                .atZone(sourceTimeZone);

        assert currentTime.getHour() == 12;

        assert currentTime.withZoneSameInstant(ourTimeZone).getHour() == 14;
    }

    @Test
    public void testPeriod() {

        LocalDate today = LocalDate.now();
        LocalDate threeDaysInTheFuture = LocalDate.now().plusDays(3);

        Period between = Period.between(today, threeDaysInTheFuture);

        assert between.equals(Period.ofDays(3));

        long hours = ChronoUnit.DAYS.between(today, threeDaysInTheFuture);
        assert hours == 3;
    }

    @Test
    public void testDuration() {
        LocalTime now = LocalTime.now();
        LocalTime inTwoHours = now.plusHours(2);

        Duration twoHoursDuration = Duration.between(now, inTwoHours);

        assert Duration.ofHours(2).equals(twoHoursDuration);

        LocalDateTime now1 = LocalDateTime.now();
        Duration threeDaysDuration = Duration.between(now1, now1.plusDays(3));

        assert threeDaysDuration.equals(Duration.ofHours(72));
    }

    @Test
    public void dateFormatter() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDateTime of = LocalDateTime.of(2020, 2, 2, 12, 2);
        assert dateTimeFormatter.format(of).equals("2020-02-02");

        assert DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(of).equals("2020-02-02T12:02:00");
    }
}
