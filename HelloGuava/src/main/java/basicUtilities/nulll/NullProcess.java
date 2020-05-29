package basicUtilities.nulll;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import org.junit.Test;


/**
 * Created by yh on 17/4/1.
 */
public class NullProcess {

    @Test
    public void testMakeOptional(){
        //都是静态方法
        //1:参数不能为空，and fail fast on null
        Optional<String> so = Optional.of("yh");
        System.out.println(so.isPresent());

        //2:参数可为空和非空
        Optional o1 = Optional.fromNullable(null);
        System.out.println(o1.isPresent());

        //3:空的optional
        Optional o2 = Optional.absent();
        System.out.println(o2.isPresent());

    }

    @Test
    public void testQueryOptional(){
        Optional<String> os = Optional.of("test");
        if(os.isPresent())
            //Returns the contained T instance, which must be present; otherwise, throws an IllegalStateException
            System.out.println(os.get());

        Optional<String> o1 = Optional.fromNullable(null);
        if(os.isPresent()) {
            System.out.println(o1.or("replace null"));
            System.out.println(o1.orNull());
        }

        System.out.println(os.asSet());
        System.out.println(o1.asSet());
    }

    @Test
    public void testNullString(){
        System.out.println(Strings.emptyToNull(null));
        System.out.println(Strings.emptyToNull("tess"));
        System.out.println(Strings.nullToEmpty(null));
        System.out.println(Strings.isNullOrEmpty(null));

    }



}
