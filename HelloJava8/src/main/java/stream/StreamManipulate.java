package stream;

import org.junit.Test;
import stream.pojo.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static stream.StreamIntro.menu;

/**
 * Created by yh on 9/5/18.
 */
public class StreamManipulate {

    @Test
    public void filterWithPredicate() {
        menu.stream().filter(Dish::isVegetarian).forEach(System.out::println);
    }

    @Test
    public void filterWithDistinct() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().filter(integer -> integer % 2 == 0).distinct().forEach(System.out::println);
    }

    @Test
    public void filterWithLimit() {
        menu.stream().filter(dish -> dish.getCalories() > 300).limit(3).forEach(System.out::println);
    }

    @Test
    public void filterWithSkip() {
        menu.stream().skip(6).forEach(System.out::println);
    }

    @Test
    public void mapOperation() {
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        dishNames.forEach(System.out::println);

        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        wordLengths.forEach(System.out::println);

    }

    //    对于一张单 词表，如何返回一张列表，列出里面各不相同的字符
    @Test
    public void flatMapOperation() {
        String[] words = {"Hello", "World"};
// 这个方法的问题在于，传递给map方法的Lambda为每个单词返回了一个String[](String 列表)。因此，map返回的流实际上是Stream<String[]>类型的。
// 你真正想要的是用 Stream<String>来表示一个字符流
        Arrays.stream(words).map(word -> word.split("")).distinct().collect(Collectors.toList());

//        改进1
        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
        Arrays.stream(arrayOfWords)
                .map(word -> word.split("")).map(Arrays::stream)
                .distinct()
                .collect(toList());
//        当前的解决方案仍然搞不定!这是因为，你现在得到的是一个流的列表(更准确地说是 Stream<String>)!

//        改进2
        List<String> uniqueCharacters =
                Arrays.stream(arrayOfWords)
                        .map(w -> w.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(Collectors.toList());
        uniqueCharacters.forEach(System.out::println);
    }

    @Test
    public void anyMatchOperation() {
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }
    }

    @Test
    public void allMatchOperation() {
        boolean isHealthy = menu.stream().allMatch(d -> d.getCalories() < 1000);
        isHealthy = menu.stream()
                .noneMatch(d -> d.getCalories() >= 1000);
    }

    @Test
    public void findAnyOperation() {
        Optional<Dish> dish =
                menu.stream()
                        .filter(Dish::isVegetarian)
                        .findAny();
    }

    @Test
    public void findFirstOperation() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map(x -> x * x)
                        .filter(x -> x % 3 == 0)
                        .findFirst(); // 9
    }

    @Test
    public void reduceOperation() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 19);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);

        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
    }

}
