package chapter5.review;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Properties;

public class Dates {

    public static void main(String[] args) {
        final LocalDate date = LocalDate.of(2014, 6, 21);
        System.out.println(date);

        final LocalDate date1 = LocalDate.of(2014, Month.JUNE, 21);
        System.out.println(date1);

        // private accessor new LocalDate();

        final LocalDate date2 = LocalDate.parse("2018-04-30", DateTimeFormatter.ISO_LOCAL_DATE);
        date2.plusDays(2);
        // date2.plusHours(3);


        final LocalDate localDate = LocalDate.of(2018, Month.APRIL, 30); // valid values 1 - 28/31)
        System.out.println(localDate);

        // 9
        final LocalDate date3 = LocalDate.of(2018, Month.APRIL, 30);
        date3.plusDays(2); // must be assigned result is returned
        System.out.println(date3);

        // 10
        LocalDateTime d = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
        final Period p = Period.of(1, 2, 3);
        d = d.minus(p);
        final DateTimeFormatter f = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        System.out.println(d.format(f));

        // 11
        LocalDateTime dt = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
        final Period p1 = Period.ofDays(1).ofYears(2); // only year applys
        dt = dt.minus(p1);
        final DateTimeFormatter fs = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(fs.format(dt));

        // 12

        // 13
        Dates.review13();

        // 14
        // LocalDate.of(2017, 2, 29); // is not a leap year

        // 15
        review15();

        // 17
        review17();
    }

    static void review13() {
        final LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
        final LocalTime time = LocalTime.of(1, 30);
        final ZoneId zone = ZoneId.of("US/Eastern");
        final ZonedDateTime zonedDateTime1 = ZonedDateTime.of(date, time, zone);
        final ZonedDateTime zonedDateTime2 = zonedDateTime1.plus(1, ChronoUnit.HOURS);

        System.out.println("**" + zonedDateTime2.toString());
        final long hours = ChronoUnit.HOURS.between(zonedDateTime1, zonedDateTime2);
        final int clock1 = zonedDateTime1.getHour();
        final int clock2 = zonedDateTime2.getHour();
        System.out.println(hours + "," + clock1 + "," + clock2); // 1,1,3
    }

    static void review15() {
        final String m1 = Duration.of(1, ChronoUnit.MINUTES).toString();
        final String m2 = Duration.ofMinutes(1).toString();
        System.out.println(m1);
        System.out.println(m1.equals(m2));
        final Duration s = Duration.of(60, ChronoUnit.SECONDS);
        System.out.println(s);

        System.out.println(Duration.ofDays(1).toString());// PT24H
        System.out.println(Period.ofDays(1).toString());// P1D
    }

    static void review17() {
        final Properties properties = new Properties();
        properties.put("key", "value");
        properties.put("key2", "value2");
        properties.get("key");
        properties.getProperty("key", "default");

        properties.keySet().stream().map(k -> properties.get(k)).forEach(System.out::println);

    }
}
