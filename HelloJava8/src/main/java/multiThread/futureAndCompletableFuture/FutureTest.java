package multiThread.futureAndCompletableFuture;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by yh on 10/25/18.
 */
public class FutureTest {

    public static void main(String[] args) {
//        创建ExecutorService，通过它你可以向线程池提交任务
        ExecutorService executorService = Executors.newCachedThreadPool();
//        向Executor- Service提交一个 Callable对象
//        以异步方式在新的线程中执行耗时的操作
        Future<Double> future = executorService.submit(FutureTest::doSomeLongComputation);
//        异步操作进行的同时可以做其他的事情
        doSomethingElse();
        try {
//        获取异步操作的结果，如果最终被阻塞，无法得到结果，那么在最多等待1秒钟之后退出
            Double result = future.get(1, TimeUnit.SECONDS);
            System.out.println(result);
        } catch (ExecutionException ee) {
//            计算抛出一个异常
            ee.printStackTrace();
        } catch (InterruptedException ie) {
//            当前线程在等待过程中被中断
            ie.printStackTrace();
        } catch (TimeoutException te) {
//            在Future对象完成之前超过已过期
            te.printStackTrace();
        }

    }

    private static Double doSomeLongComputation() throws InterruptedException {
        Thread.sleep(1000);
        return new Random().nextDouble();
    }

    private static void doSomethingElse() {

    }
}
