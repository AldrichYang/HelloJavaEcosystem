import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;

/**
 * Created by yh on 17/2/25.
 */
public class StringTest {

    @Test
    public void stringExplodeTest(){
        String rates = "7.7,8.0,8.3,8.6,8.9,9.2,9.5,9.8,10.1,10.4,10.7,11.0";
        String[] rateArray = rates.split(",");
        System.out.println(rateArray.length);
        List a = Arrays.asList(rateArray);
        Arrays.asList(rateArray).forEach(x->System.out.println(x));
    }

    @Test
    public void splitterTest(){
        String rates = "7.7,8.0,8.3,8.6,8.9,9.2,9.5,9.8,10.1,10.4,10.7,11.0";
        double[] rateArray = Splitter.on(',').splitToList(rates).stream().mapToDouble(Double::valueOf).toArray();
        Arrays.asList(rateArray).forEach(x->System.out.println(x));
        DoubleStream.of(rateArray).forEach(x->System.out.println(x));


    }

    @Test
    public void joinerTest(){
        Joiner joiner = Joiner.on(",");
        List<Long> arrayList = new ArrayList<>();
        arrayList.add(1l);
        arrayList.add(1l);
        arrayList.add(1l);
        arrayList.add(1l);
        String res = joiner.join(arrayList);
        System.out.println(res);
    }
}
