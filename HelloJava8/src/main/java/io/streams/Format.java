package io.streams;

/**
 * Created by yh on 2018/4/9.
 */
public class Format {
    public static void main(String[] args) {
        int i = 2;
        double r = Math.sqrt(i);

        System.out.print("The square root of ");
        System.out.print(i);
        System.out.print(" is ");
        System.out.print(r);
        System.out.println(".");

        i = 5;
        r = Math.sqrt(i);
        System.err.println("The square root of " + i + " is " + r + ".");


        int i1 = 2;
        double r1 = Math.sqrt(i1);

        System.out.format("The square root of %d is %f.%n", i1, r1);

        System.out.format("%f, %1$+020.10f %n", Math.PI);

    }
}
