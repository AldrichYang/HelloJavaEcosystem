package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static stream.PrimeNumbersExercise.isPrime3;

/**
 * Created by yh on 9/6/18.
 */
public class PrimeNumbersCollector implements Collector<Integer,
        Map<Boolean, List<Integer>>,
        Map<Boolean, List<Integer>>> {
    //    从一个有两个空 List的Map开始 收集过程
    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        return () -> new HashMap<Boolean, List<Integer>>() {{
            put(true, new ArrayList<Integer>());
            put(false, new ArrayList<Integer>());
        }};
    }

    //    将已经找到的 质数列表传递 给isPrime方法
    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
//        根据isPrime方法的返回值，从Map中取质 数或非质数列表，把当前的被测数加进去
        return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
            acc.get(isPrime3(acc.get(true), candidate)).add(candidate);
        };
    }

    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
//将第二个map合并到第一个
        return (Map<Boolean, List<Integer>> map1,
                Map<Boolean, List<Integer>> map2) -> {
            map1.get(true).addAll(map2.get(true));
            map1.get(false).addAll(map2.get(false));
            return map1;
        };
    }

    //  收集过程最后 无需转换，因此 用 identity 函 数收尾
    @Override
    public Function<Map<Boolean, List<Integer>>,
            Map<Boolean, List<Integer>>> finisher() {
        return Function.identity();
    }

    //这个收集器是IDENTITY_FINISH,但既不是UNORDERED,也不是CONCURRENT，因为质数是按顺序发现的
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH));
    }

}
