package core.math;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yh on 17/2/16.
 */
public class BigDecimalTest {

    @Test
    public void testListAdd() {
        List<BigDecimal> decimals = new ArrayList<>();
        decimals.add(new BigDecimal(0.1));
        decimals.add(new BigDecimal(2.04));
        decimals.add(new BigDecimal(300042.356));
        BigDecimal sum = new BigDecimal(0);
        decimals.forEach(each -> sum.add(each));
        // System.out.print(sum.doubleValue());
        BigDecimal t1 = new BigDecimal(0.345);
        System.out.print(t1.round(new MathContext(2, RoundingMode.HALF_UP)));

    }

    @Test
    public void testRoundDown() {
        Double[] amount = {17.48,
                17.53,
                39.17,
                48.81,
                48.81,
                48.81,
                44.59,
                48.81,
                48.81,
                48.81,
                48.81,
                48.81,
                48.81,
                48.81,
                48.81,
                48.78,
                48.79,
                52.95,
                48.77,
                48.75,
                48.83,
        };
        List<Double> amountList = Arrays.asList(amount);
        List<BigDecimal> newList = amountList.stream().map(x -> new BigDecimal(x).multiply(new BigDecimal(0.39)).divide(new BigDecimal(1245.19), 2, BigDecimal.ROUND_DOWN)).collect(Collectors.toList());
        newList.forEach(x -> System.out.println(x.doubleValue()));
        //System.out.println(newList.stream().reduce(BigDecimal::add).get().doubleValue());
    }

    @Test
    public void testRoundZeroDigit() {
        BigDecimal value = new BigDecimal(3.55);
        System.out.println(value.longValue());
        System.out.println(value.setScale(0,RoundingMode.HALF_UP));
    }
}
