package core.lang;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.lang.System.out;

/**
 * Created by yh on 2018/3/26.
 */
public class StringTest {

    @Test
    public void testHashCode() {
        String str = "yh";
        System.out.println(str.hashCode());
    }

    @Test
    public void testStringDate() {
        String date1 = "2018-07-10 00:00:00";
        String date2 = "2018-07-10";
        out.println(LocalDate.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse(date1)).isEqual(LocalDate.parse(date2)));
    }

    @Test
    public void testReplace() {
        String id = "411323198909180539";
        out.println(id);
        out.println(id.replaceAll("(\\d{4})\\d{10}(\\w{4})",
                "$1*****$2"));
    }
}
