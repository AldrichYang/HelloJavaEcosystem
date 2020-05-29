package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created by yh on 9/6/18.
 */
public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {
    //    创建集合操作的起始点
    @Override
    public Supplier<List<T>> supplier() {
//        return () -> new ArrayList<>();
        return ArrayList::new;
    }

    //累积遍历过的项目，原位修改累加器
    @Override
    public BiConsumer<List<T>, T> accumulator() {
//        return (list, item) -> list.add(item);
        return List::add;
    }

    //恒等函数
    @Override
    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }

    //修改第一个累加器，将其与第二个累加器的内容合并
    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    //未收集器添加IDENTITY_FINISH和CONCURRENT标志
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT));
    }
}
