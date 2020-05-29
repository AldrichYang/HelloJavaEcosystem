package stream.parallel;

import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by yh on 9/17/18.
 */
class ParallelStreams {

    //    顺序归纳
    static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
    }

    //    迭代式
    static long iterativeSum(long n) {
        long result = 0;
        for (long i = 1l; i <= n; i++) {
            result += i;
        }
        return result;
    }

    //    并行归纳
    static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    //    顺序，生成流方式调整,无拆箱和装箱操作
    static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n).reduce(0L, Long::sum);
    }


    // 并行，生成流方式调整,无拆箱和装箱操作
    static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }


}
