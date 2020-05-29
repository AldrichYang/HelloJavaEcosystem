package lambda;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Created by yh on 17/1/3.
 */
public class Java8BuiltinFiTest {

    public static void main(String[] args) {
        boolean trueOrFalse = usePredicate().test(4);
        System.out.print(trueOrFalse);

    }

    public static Predicate usePredicate() {
        Predicate<Integer> atLeast5 = x -> x > 5;
        return atLeast5;
    }

    public static void validate() {
        Predicate<String> predicate = Objects::isNull;
        Optional result = predicate.test("yh") ? Optional.of("1") : Optional.empty();
    }
}
