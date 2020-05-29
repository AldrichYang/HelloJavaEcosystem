package lambda;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by yh on 9/20/18.
 */
public class Debugging {

    public static void main(String[] args) {
//        viewStack();
//        viewLog();
        viewLogWithPeek();

    }

    static void viewStack() {
        List<Point> points = Arrays.asList(new Point(12, 2), null);
        points.stream().map(p -> p.getX()).forEach(System.out::println);
    }

    static void viewLog() {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);
        numbers.stream()
                .map(x -> x + 17)
                .filter(x -> x % 2 == 0)
                .limit(3)
                .forEach(System.out::println);
    }

    static void viewLogWithPeek() {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);
        List<Integer> result =
                numbers.stream()
//                        输出来自数 据源的当前 元素值
                        .peek(x -> System.out.println("from stream: " + x))
                        .map(x -> x + 17)
//                        输出map操作的结果
                        .peek(x -> System.out.println("after map: " + x))
                        .filter(x -> x % 2 == 0)
//                        输出经过filter 操作之后，剩下的 元素个数
                        .peek(x -> System.out.println("after filter: " + x))
                        .limit(3)
//                        输出经过limit操作之 后，剩下的元素个数
                        .peek(x -> System.out.println("after limit: " + x))
                        .collect(toList());
    }
}
