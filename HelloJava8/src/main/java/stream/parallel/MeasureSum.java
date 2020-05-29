package stream.parallel;

import java.util.function.Function;

/**
 * Created by yh on 9/17/18.
 */
public class MeasureSum {
    public static void main(String[] args) {

//        System.out.println("Sequential sum done in:" + measureSumPerf(ParallelStreams::sequentialSum, 10_000_000) + " msecs");
//        用传统for循环的迭代版本执行起来应该会快很多，因为它更为底层，更重要的是不需要对原始类型做任何装箱或拆箱操作
//        System.out.println("Sequential sum done in:" + measureSumPerf(ParallelStreams::iterativeSum, 10_000_000) + " msecs");
//        函数的并行版本做测试
//        System.out.println("Sequential sum done in:" + measureSumPerf(ParallelStreams::parallelSum, 10_000_000) + " msecs");
//        System.out.println("Sequential sum done in:" + measureSumPerf(ParallelStreams::rangedSum, 10_000_000) + " msecs");
//        System.out.println("Sequential sum done in:" + measureSumPerf(ParallelStreams::parallelRangedSum, 10_000_000) + " msecs");
        System.out.println("Sequential sum done in:" + measureSumPerf(ParallelStreams::sideEffectSum, 10_000_000) + " msecs");

    }

    /**
     * 接受一个函数和一个long作为参数。它会对传给方法的long应用函数10次，记录 每次执行的时间(以毫秒为单位)，并返回最短的一次执行时间
     *
     * @param adder
     * @param n
     * @return
     */
    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }
}
