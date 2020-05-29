package multiThread.futureAndCompletableFuture.bestPriceFinder;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Created by yh on 10/25/18.
 */
public class Shop {

    private static final Random random = new Random();

    private String name;

    public Shop() {
    }

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 同步版本的getPrice
     *
     * @param product
     * @return
     */
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public String getPriceDiscount(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[
                random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    public String getPriceDiscountRandomDelay(String product) {
        double price = calculatePriceRandomDelay(product);
        Discount.Code code = Discount.Code.values()[
                random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    /**
     * 返回随机计算的价格
     * 它使用charAt，依据产品的名称，生成一个随机值作为价格
     *
     * @param product
     * @return
     */
    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    /**
     * 模拟一秒钟的延迟
     */
    private static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private double calculatePriceRandomDelay(String product) {
        randomDelay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }


    public static void randomDelay() {
        int delay = 500 + random.nextInt(2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 异步版本的getPrice
     * 创建了一个代表异步计算的CompletableFuture对象实例，它在计算完成时会包含计算的结果。
     * 接着，你调用fork创建了另一个线程去执行实际的价格计算工作，不等该耗时计算任务结束，直接返回一个Future实例。
     * 当请求的产品价格最终计算得出时，你可以使用它的complete方法，结束completableFuture对象的运行，并设置变量的值。
     * 很显然， 这个新版Future的名称也解释了它所具有的特性
     *
     * @param product
     * @return
     */
    public Future<Double> getPriceAsync(String product) {
//        创建CompletableFuture 对象，它会包含计算的结果
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//         在另一个线程中以异步方式执行计算
        new Thread(() -> {
            double price = calculatePrice(product);
//            需长时间计算的任务结束并得出结果时，设置Future的返回值
            futurePrice.complete(price);
        }).start();
//         无需等待还没结束的计算，直接返回Future对象
        return futurePrice;
    }

    public Future<Double> getPriceAsyncAndThrowException(String product) {
//        创建CompletableFuture 对象，它会包含计算的结果
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//         在另一个线程中以异步方式执行计算
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
//                如果价格计算正常结束，完成Future操作 并设置商品价格
                futurePrice.complete(price);
            } catch (Exception e) {
//                否则就抛出导致失 败的异常，完成这次Future操作
                futurePrice.completeExceptionally(e);
            }
        }).start();
//         无需等待还没结束的计算，直接返回Future对象
        return futurePrice;
    }

    public Future<Double> getPriceAsyncByFactory(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }


    private static void doSomethingElse() {

    }

    public static void main(String[] args) {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
//         查询商店，试图 取得商品的价格
        Future<Double> futurePrice = shop.getPriceAsync("my favorite name");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + " msecs");

//      执行更多任务，比如查询其他商店
//      在计算商品价格的同时
        doSomethingElse();
        try {
//            从Future对象中读取价格，如果价格未知，会发生阻塞
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }


}
