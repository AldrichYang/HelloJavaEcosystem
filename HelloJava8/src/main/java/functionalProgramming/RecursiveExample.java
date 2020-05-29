package functionalProgramming;

import java.util.stream.LongStream;

/**
 * Created by yh on 11/22/18.
 */
public class RecursiveExample {

    public static void main(String[] args) {
        int n = 10;
        System.out.println("迭代式阶乘运算:" + factorialIterative(n));
        System.out.println("递归式阶乘运算:" + factorialRecursive(n));
        System.out.println("Stream阶乘运算:" + factorialStreams(n));
        System.out.println("尾递迭代阶乘运算:" + factorialTailRecursive(n));

    }

    /**
     * 迭代式的阶乘运算
     *
     * @param n
     * @return
     */
    static long factorialIterative(int n) {
        int r = 1;
        for (int i = 1; i <= n; i++) {
            r *= i;
        }
        return r;
    }

    /**
     * 递归式的阶乘运算
     *
     * @param n
     * @return
     */
    static long factorialRecursive(long n) {
        return n == 1 ? 1 : n * factorialRecursive(n - 1);
    }

    /**
     * 基于Stream的阶乘
     *
     * @param n
     * @return
     */
    static long factorialStreams(long n) {
        return LongStream.rangeClosed(1, n).reduce(1, (long a, long b) -> a * b);
    }

    /**
     * 基于“尾-递”的阶乘
     *
     * @param n
     * @return
     */
    static long factorialTailRecursive(long n) {
        return factorialHelper(1, n);
    }

    private static long factorialHelper(long acc, long n) {
        return n == 1 ? acc : factorialHelper(acc * n, n - 1);
    }


}
