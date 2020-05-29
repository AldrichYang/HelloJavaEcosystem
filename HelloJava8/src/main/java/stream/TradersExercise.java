package stream;

import stream.pojo.Currency;
import stream.pojo.Trader;
import stream.pojo.Transaction;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by yh on 9/5/18.
 */
public class TradersExercise {


    public static void main(String[] args) {
        getTransactions().stream().collect(groupingBy(Transaction::getTrader)).forEach((x, y) -> System.out.println(x.toString()));
    }

    static List<Transaction> getTransactions() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        Currency usd = new Currency("USD");
        Currency cny = new Currency("CNY");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300, usd),
                new Transaction(raoul, 2012, 1000, cny),
                new Transaction(raoul, 2011, 400, cny),
                new Transaction(mario, 2012, 710, usd),
                new Transaction(mario, 2012, 700, usd),
                new Transaction(alan, 2012, 950, usd)
        );
        return transactions;
    }


}
