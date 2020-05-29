package multiThread.futureAndCompletableFuture.bestPriceFinder;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.join;

/**
 * Created by yh on 10/29/18.
 */
public class BestPriceFinder {

    List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"), new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"), new Shop("CheapestShop"));


    public List<String> findPricesSync(String product) {
        return shops.stream().map(shop -> String.format("%s prices is %.2f", shop.getName(), shop.getPrice(product))).collect(Collectors.toList());
    }

    public List<String> findPricesParalls(String product) {
        return shops.parallelStream().map(shop -> String.format("%s prices is %.2f", shop.getName(), shop.getPrice(product))).collect(Collectors.toList());
    }

    public List<String> findPricesAsync(String product) {
        List<CompletableFuture<String>> futureList =
                shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s prices is %.2f", shop.getName(), shop.getPrice(product)))).collect(Collectors.toList());
        return futureList.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    //  创建一个线程池，线程池中线程的数目为100和商店数目二者中较小的一个值
    private final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100),
            (Runnable runnable) -> {
                Thread t = new Thread(runnable);
//        使用守护线程—这种方式不会阻止程序的关停
                t.setDaemon(true);
                return t;
            });

    public List<String> findPricesAsyncAndCustomizeExecutions(String product) {
        List<CompletableFuture<String>> futureList =
                shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s prices is %.2f", shop.getName(), shop.getPrice(product)), executor)).collect(Collectors.toList());
        return futureList.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    public List<String> findDiscountPricesSync(String product) {
        return shops.stream().map(shop -> shop.getPriceDiscount(product)).map(Quote::parse).map(Discount::applyDiscount).collect(Collectors.toList());
    }

    public List<String> findDiscountPricesAsync(String product) {
        List<CompletableFuture<String>> priceFutures =
                shops.stream()
//                         以异步方式取得 每个shop中指定 产品的原始价格
                        .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPriceDiscount(product), executor))
//                     上一步同样的线程执行Quote对象存在时，对其返回的值进行转换
                        .map(future -> future.thenApply(Quote::parse))
//                      使用另一个异步任务构造期望的Future， 申请折扣
                        .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)))
                        .collect(Collectors.toList());
//        等待流中的所有Future执行完毕，并提取各自的返回值
        return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    private Stream<CompletableFuture<String>> findDiscountPriceStream(String product) {
        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPriceDiscountRandomDelay(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)));
    }

    public List<String> findDiscountPriceBest(String product) {
        CompletableFuture[] futures = findDiscountPriceStream(product)
                .map(f -> f.thenAccept(System.out::println))
                .toArray(size -> new CompletableFuture[size]);
        CompletableFuture.allOf(futures).join();
        return Arrays.asList(new String[futures.length]);

    }


    public static void invocationTime(Supplier<List<String>> supplier) {
        long start = System.nanoTime();
        List<String> results = supplier.get();
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + " msecs");
        System.out.println(join(",", results));
    }

    public static void main(String[] args) {
        String product = "iphone8s";
        BestPriceFinder bestPriceFinder = new BestPriceFinder();
        invocationTime(() -> bestPriceFinder.findPricesSync(product));
        invocationTime(() -> bestPriceFinder.findPricesParalls(product));
        invocationTime(() -> bestPriceFinder.findPricesAsync(product));
        invocationTime(() -> bestPriceFinder.findPricesAsyncAndCustomizeExecutions(product));
        invocationTime(() -> bestPriceFinder.findDiscountPricesSync(product));
        invocationTime(() -> bestPriceFinder.findDiscountPricesAsync(product));
        invocationTime(() -> bestPriceFinder.findDiscountPriceBest(product));
    }



}
