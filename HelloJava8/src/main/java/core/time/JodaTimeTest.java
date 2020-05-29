package core.time;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.stream.IntStream;

/**
 * Created by yh on 17/2/10.
 */
public class JodaTimeTest {

    @Test
    public void testDateToDateWithYmd() {
        Date today = new Date();
        LocalDate localDate = LocalDate.fromDateFields(today);
        Date todayWithYmd = localDate.toDate();
        System.out.print(todayWithYmd);

    }

    @Test
    public void testDateToLocaDate() {
        Date today = new Date();
        LocalDate todayLocal = LocalDate.fromDateFields(today);
        LocalDate localDate = new LocalDate();
        Assert.assertEquals(localDate, todayLocal);
    }

    @Test
    public void testDays() {
        LocalDate startDate = LocalDate.parse("2017-03-26");
        LocalDate endDate = LocalDate.parse("2017-5-23");
        long holdDays = Days.daysBetween(startDate, endDate).getDays();
        System.out.println(holdDays);
    }

    @Test
    public void testYearMonthDay() {
        LocalDate endDate = LocalDate.parse("2017-05-23");
        System.out.println(endDate.getYear());
        System.out.println(endDate.getMonthOfYear());
        System.out.println(endDate.getDayOfMonth());

    }

    @Test
    public void testDuration() {
        LocalDate publishDate = LocalDate.parse("2017-04-02");
        LocalDate dueDate = publishDate.plusMonths(12);
        LocalDate quitDate = LocalDate.parse("2017-6-21");
        Integer month = IntStream.rangeClosed(1, 12).boxed()
                .filter(x -> (quitDate.compareTo(publishDate.plusMonths(x)) >= 0 && quitDate.compareTo(publishDate.plusMonths(1 + x))<0)
                        || (x==12 && quitDate.compareTo(publishDate.plusMonths(x+1))>=0)
                        )
                .findAny().get();
        System.out.println(month);
    }


}
