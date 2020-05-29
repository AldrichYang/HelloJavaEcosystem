package stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yh on 17/1/4.
 */
public class CommonOpStreamTest {
    public static void main(String[] args) {
        List<String> collected = Stream.of("a", "b", "c").collect(Collectors.toList());
        List<String> collected1 = Stream.of("a", "b", "c").map(string -> string.toUpperCase()).collect(Collectors.toList());
    }
}
