package core.lang;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by yh on 2018/7/20.
 */
public class ArrayTest {

    @Test
    public void arrayToString() {
        String[] array = {"a", "b", "c"};
        System.out.println(Arrays.toString(array));
    }
}
