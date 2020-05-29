package lambda;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

/**
 * Created by user on 16/11/21.
 */
public class LambdaTest {

    public static void main(String[] args) {
        //declareLambda();
        referFinalVariables();
    }

    public static void declareLambda() {
        // no params
        Runnable runnable = () -> System.out.println("hello world");
        // one param with no type ,omit brackets, single code
        ActionListener actionListener = event -> System.out.println("button clicked");
        // no params, block code
        Runnable multiStatement = () -> {
            System.out.println("hello");
            System.out.println("world");
        };
        // multi params
        BinaryOperator<Long> add = (x, y) -> x + y;
        // multi params where specific type
        BinaryOperator<Long> addExplict = (Long x, Long y) -> x + y;
        System.out.println(addExplict.apply(new Long(4), new Long(5)));

    }

    public static  void referFinalVariables() {
        String name = "yangheng";
        //name = "yangheng change";
        Runnable runnable = () -> System.out.println("hello world" + name);
        runnable.run();

    }
}
