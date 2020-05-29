package basicUtilities.precondition;

import org.junit.Test;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkElementIndex;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkPositionIndex;
import static com.google.common.base.Preconditions.checkPositionIndexes;
import static com.google.common.base.Preconditions.checkState;

/**
 * Created by yh on 17/5/20.
 */
public class CheckProcess {

//    Each method has three variants:
//
//    No extra arguments. Any exceptions are thrown without error messages.
//    An extra Object argument. Any exception is thrown with the error message object.toString().
//    An extra String argument, with an arbitrary number of additional Object arguments. This behaves something like printf, but for GWT compatibility and efficiency, it only allows %s indicators

    @Test
    public void testNullCheck() {
        String param = checkNotNull("test");
        System.out.println(param);
    }

    @Test
    public void testAgrumentCheck() {
        checkArgument(3 * 4 == 12);
    }

    @Test
    public void testObjectState(){
        checkState(false);
    }

    @Test
    public void testIndexCheck(){
        checkElementIndex(2,3);
        int index = checkPositionIndex(2,5);
        checkPositionIndexes(1,2,1);
        System.out.println(index);

    }
}
