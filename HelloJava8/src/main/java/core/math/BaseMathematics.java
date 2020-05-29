package core.math;

import org.junit.Assert;
import org.junit.Test;

import java.nio.channels.SelectionKey;

import static java.lang.System.out;

/**
 * Created by yh on 17/3/10.
 */
public class BaseMathematics {
    @Test
    public void testMod() {
        Assert.assertEquals(19, 79 % 30);
        Assert.assertEquals(2, 79 / 30);
    }

    @Test
    public void bitOperatonResult() {
        out.println(SelectionKey.OP_READ);
        out.println(SelectionKey.OP_WRITE);
        out.println(SelectionKey.OP_CONNECT);
        out.println(SelectionKey.OP_ACCEPT);
    }

    @Test
    public void math(){
        System.out.println(Math.sqrt(16));
    }
}
