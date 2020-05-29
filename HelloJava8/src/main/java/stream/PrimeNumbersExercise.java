package stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

/**
 * Created by yh on 9/6/18.
 */
public class PrimeNumbersExercise {
//    写一个方法，它接受参数int n，并将前n个自然数分为质数和非质数
//    为了把前n个数字分为质数和非质数，只要创建一个包含这n个数的流，用刚刚写的isPrime方法作为谓词，再给partitioningBy收集器归约就好了

    public static void main(String[] args) {
        PrimeNumbersExercise primeNumbersExercise = new PrimeNumbersExercise();
        long fastest = Long.MAX_VALUE;
//        运行测试10次
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
//            将前一百万个自然数按质数和非质数区分
//            primeNumbersExercise.partitionPrimes(1_000);
            primeNumbersExercise.partitionPrimesWithCustomCollector(1_000);
            long duration = (System.nanoTime() - start) / 1_000;
//            检查这个执行是不是最快的一个
            if (duration < fastest)
                fastest = duration;
        }
        System.out.println(
                "Fastest execution done in " + fastest + " msecs");

//        更为科学的测试方法是用一个诸如JMH的框架


    }

    public Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(new PrimeNumbersCollector());
    }

    //    通过把实现 PrimeNumbersCollector核心逻辑的三个函数传给collect方法的重载版本来获得同样的结果
    public Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector1(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(
//                        供应源
                        () -> new HashMap<Boolean, List<Integer>>() {{
                            put(true, new ArrayList<Integer>());
                            put(false, new ArrayList<Integer>());
                        }},
//        累加器
                        (acc, candidate) -> {
                            acc.get(isPrime3(acc.get(true), candidate))
                                    .add(candidate);
                        },
//       组合器
                        (map1, map2) -> {
                            map1.get(true).addAll(map2.get(true));
                            map1.get(false).addAll(map2.get(false));
                        });


    }

    public Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(
                        partitioningBy(candidate -> isPrime(candidate)));
    }

    //    测试某一个待测数字是否是质数的谓词
    public boolean isPrime(int candidate) {
//        产生一个自然数范围，从2开始， 直至但不包括待测数.如果待测数字不能被流中任何数字整除则返回true
        return IntStream.range(2, candidate).noneMatch(i -> candidate % i == 0);
    }

    //    简单的优化是仅测试小于等于待测数平方根的因子
    public boolean isPrime1(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    //  获得更好的性能，可能的优化是仅仅看看被测试数是不是能够被质数整除。要是除数本身都不是质数就用 不着测了。所以我们可以仅仅用被测试数之前的质数来测试
    public static boolean isPrime2(List<Integer> primes, int candidate) {
        return primes.stream().noneMatch(i -> candidate % i == 0);
    }

    // 应该应用先前的优化，仅仅用小于被测数平方根的质数来测试。因此，你需要想办法在下一个质数大于被测数平方根时立即停止测试
//    可以使用filter(p -> p <= candidateRoot)来筛选出小于被测数平方根的质数。但filter 要处理整个流才能返回恰当的结果。如果质数和非质数的列表都非常大，这就是个问题了
//你用 不着这样做;你只需在质数大于被测数平方根的时候停下来就可以了。
    public static boolean isPrime3(List<Integer> primes, int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return takeWhile(primes, i -> i <= candidateRoot)
                .stream()
                .noneMatch(p -> candidate % p == 0);
    }

    //    因此，我们会创建一个名 为takeWhile的方法，给定一个排序列表和一个谓词，它会返回元素满足谓词的最长前缀
    public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
        int i = 0;
        for (A item : list) {
            //检查列表中的当前 项目是否满足谓词 如果不满足，返回该 项目之前的前缀子 列表
            if (!p.test(item)) {
                return list.subList(0, i);
            }
            i++;
        }
        return list;

//        请注意，这个takeWhile实现是即时的。理想情况下，我们会想要一个延迟求值的
//takeWhile，这样就可以和noneMatch操作合并。不幸的是，这样的实现超出了本章的范围， 你需要了解Stream API的实现才行
    }


}
