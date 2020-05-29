package basicUtilities.throwables;

import com.google.common.base.Throwables;

/**
 * Created by yh on 17/9/3.
 */

public class ThrowablesTest {

    public static void main(String[] args) {
        String nullStr = null;
        StringNull(nullStr);
    }

    private static void StringNull(String nullStr) {
        try {
            if (nullStr.equals("")) {
                System.out.println(true);
            }
        } catch (Throwable e) {
//            Throwables.propagate(e);
            Throwables.propagateIfInstanceOf(e, NullPointerException.class);
//            Throwables.propagateIfInstanceOf(e, SQLException.class);
//            Throwables.propagateIfPossible(e);
        }
    }

}
