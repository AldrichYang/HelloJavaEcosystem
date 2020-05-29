package basicUtilities.objectMethods;

import com.google.common.base.MoreObjects;

import java.util.Objects;

/**
 * Created by yh on 17/9/4.
 */
public class ObjectsTest {
    public static void main(String[] args) {
        System.out.println(Objects.hash(1, 2, 3, "test"));
        System.out.println(com.google.common.base.Objects.hashCode("test", 1, 2));
        System.out.println(MoreObjects.toStringHelper("this").add("ls", "ls").add("pwd", "pwd").toString());
    }


}
