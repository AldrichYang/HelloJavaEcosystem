package stream;

import com.google.common.base.Joiner;
import org.junit.Test;
import stream.pojo.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yh on 9/4/18.
 */
public class StreamIntro {

    static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));

    public static void main(String[] args) {
        List<String> threeHighCaloricDishNames =
                menu.stream().filter(d -> d.getCalories() > 300).map(Dish::getName).limit(3).collect(Collectors.toList());
        System.out.println(Joiner.on(",").join(threeHighCaloricDishNames));
    }

    /**
     * 中间操作是不处理数据的，在终结操作时才一次遍历完成中间处理和结果输出。
     */
    @Test
    public void midOperate() {
        List<String> threeHighCaloricDishNames =
                menu.stream().filter(d -> {
                    System.out.println("filtering: " + d.getName());
                    return d.getCalories() > 300;
                })
                        .map(d -> {
                                    System.out.println("mapping: " + d.getName());
                                    return d.getName();
                                }
                        ).limit(3).collect(Collectors.toList());
    }

    /**
     * 流只能被消费一次。除非重新从源获取
     */
    @Test
    public void consumeOnce() {
        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        s.forEach(System.out::println);
    }

    @Test
    public void map() {
        List<String> names = menu.stream().map(Dish::getName).collect(Collectors.toList());
    }


}
