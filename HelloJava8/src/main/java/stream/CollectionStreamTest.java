package stream;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by user on 16/11/21.
 */
public class CollectionStreamTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        Stream<Integer> stream = numbers.stream();
        stream.filter((x) -> (x % 2 == 0)).forEach(System.out::println);
        /*main.java.stream.filter((x)->( x%2 == 0))
                .map((x)->( x * x))
                .forEach(System.out::println);*/

    }

    @Test
    public void testReduce() {
        List<BigDecimal> bdList = new ArrayList<>();
        bdList.add(new BigDecimal(0.1));
        bdList.add(new BigDecimal(2.04));
        bdList.add(new BigDecimal(300042.356));
        BigDecimal sum = new BigDecimal(0);
//populate list
        //BigDecimal result = bdList.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        //BigDecimal result = bdList.stream().reduce(BigDecimal.ZERO,(each,x)->each.add(BigDecimal.ZERO));
        BigDecimal result = bdList.stream().reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
        System.out.print(result);
    }

    @Test
    public void testReduceTwo() {
        List<BigDecimal> bdList = new ArrayList<>();
        bdList.add(new BigDecimal(1000));
        bdList.add(new BigDecimal(2500));
        bdList.add(new BigDecimal(3000));
        BigDecimal amount = BigDecimal.ZERO;
        BigDecimal[] result = bdList.stream().map(x -> new BigDecimal[]{x, x.add(new BigDecimal(500))})
                .reduce(new BigDecimal[]{BigDecimal.ZERO, BigDecimal.ZERO}, (x, y) -> new BigDecimal[]{x[0].add(y[0]), x[1].add(y[1])});
        System.out.print(result[0].toString()+":"+result[1].toString());
    }


}
