package lambda;

/**
 * Created by yh on 9/20/18.
 */
public class AnonymousClassToLambda {
    public static void main(String[] args) {

//        匿名类
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        r1.run();
//        改造为Lambda
        Runnable r2 = () -> System.out.println("hello");
        r2.run();

        int a = 10;
//        匿名类可以屏蔽包含类的变量
        Runnable r3 = new Runnable() {
            @Override
            public void run() {
                int a = 2;
                System.out.println(a);
            }
        };
//        r3 = () -> {
//            int a = 2;
//            System.out.println(a);
//        };
        r3.run();


    }
}
