package stream.parallel;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * Created by yh on 9/17/18.
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    private final long[] numbers;

    private final int start;
    private final int end;

    public static final long THRESHOLD = 10_000;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    /**
     * 私有构造函数用于以递归方式为主任务创建子任务
     *
     * @param numbers
     * @param start
     * @param end
     */
    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    /**
     * 该任务负责求和的部分的大小
     *
     * @return
     */
    @Override
    protected Long compute() {
        int length = end - start;
//        如果大小小于或等与阈值，顺序计算结果
        if (length <= THRESHOLD) {
            return computeSequentially();
        }
//        创建一个子任务为数组的前一半求和
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
//        利用另一个ForkJoinPool线程异步执行新创建的子任务
        leftTask.fork();
//        创建一个任务为数组的后一半求和
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
//        同步执行第二个子任务，有可能允许进一步递归划分
        long rightResult = rightTask.compute();
//        读取第一个子任务的结果，如果尚未完成就等待
        long leftResult = leftTask.join();
//        该任务的结果是两个子任务结果的组合
        return leftResult + rightResult;
    }

    private long computeSequentially() {
        return Arrays.stream(numbers).sum();
    }


    static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println("result:" + forkJoinSum(1_000_000) + ", 耗时:" + (System.nanoTime() - start) / 1_000_000 + " msec");


    }

}
