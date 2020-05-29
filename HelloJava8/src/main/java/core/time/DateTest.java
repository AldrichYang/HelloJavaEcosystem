package core.time;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by yh on 17/2/10.
 */
public class DateTest {


    @Test
    public void testLocalDateToDate() {
        LocalDate localDate = LocalDate.now();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println(date);
    }

    @Test
    public void testDateToLocalDate() {
        Date date = new Date();
        LocalDate localDate = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(localDate);
        LocalDateTime localDateTime = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(localDateTime);
    }


    @Test
    public void testAddDate() {
        LocalDate localDate = LocalDate.parse("2017-06-19");
        LocalDate endDate = localDate.plusDays(1);
        System.out.println(endDate);
        System.out.println(ChronoUnit.DAYS.between(localDate, endDate));
    }

    @Test
    public void testAddMonth() {
        LocalDate localDate = LocalDate.parse("2017-06-19");
        LocalDate endDate = localDate.plusMonths(1);
        System.out.println(endDate);
        System.out.println(ChronoUnit.DAYS.between(localDate, endDate));

    }


}
