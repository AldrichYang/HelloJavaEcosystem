package stream;

import stream.pojo.Currency;
import stream.pojo.Dish;
import stream.pojo.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static stream.StreamIntro.menu;
import static stream.TradersExercise.getTransactions;

/**
 * Created by yh on 9/6/18.
 */
public class StreamCollect {

    public static void main(String[] args) {
        Map<Currency, List<Transaction>> transactionsByCurrencies =
                getTransactions().stream().collect(groupingBy(Transaction::getCurrency));

        List<Transaction> transactionList = getTransactions().stream().collect(Collectors.toList());
    }

    static void reduct() {
        long howManyDishes = menu.stream().collect(Collectors.counting());
        howManyDishes = menu.stream().count();
    }

    static void maxOrMin() {
        Comparator<Dish> dishCaloriesComparator =
                Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish =
                menu.stream()
                        .collect(maxBy(dishCaloriesComparator));

    }

    static void reduceReplaceToListCollector() {
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
        List<Integer> numbers = stream.reduce(
                new ArrayList<Integer>(),
                (List<Integer> l, Integer e) ->
                {
                    l.add(e);
                    return l;
                },
                (List<Integer> l1, List<Integer> l2) ->
                {
                    l1.addAll(l2);
                    return l1;
                });
    }




}
