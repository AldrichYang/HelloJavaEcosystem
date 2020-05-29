package stream.parallel;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by yh on 9/18/18.
 */
public class SpliteratorExercise {

    final static String SENTENCE =
            " Nel   mezzo del cammin  di nostra  vita " +
                    "mi  ritrovai in una  selva oscura" +
                    " ché la  dritta via era   smarrita ";


    /**
     * 迭代方式的实现
     *
     * @param s
     * @return
     */
    static int countWordsIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;
//        遍历String中字符
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
//        上一个字符是空格，而当前遍历的字符不是空格时，将单词计数器+1
                if (lastSpace) counter++;
                lastSpace = false;
            }
        }
        return counter;
    }

    private static int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
        return wordCounter.getCounter();
    }

    static int countWordsFunctionally(String s) {
//  首先你需要把String转换成一个流,  原始类型的流仅限于int、long和double， 所以你只能用Stream<Character>
        Stream<Character> stream = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
//        这个流做归约来计算字数。在归约流时，你得保留由两个变量组成的状态:一个int用来计算到目前为止数过的字数，还有一个boolean用来记得上一个遇到的Character是不是空格
//        因为Java没有元组(tuple，用来表示由异类元素组成的有序列表的结构，不需要包装对象)， 所以你必须创建一个新类WordCounter来把这个状态封装起来
        return countWords(stream);
    }

    /**
     * 默认拆分下的并行执行，结果是错误的。
     * 因为原始的String在任意位置拆分，所以有时一个词会被分为两个词，然后数了两次。这就说明，拆分流会影响结果，而把顺序流换成并行流就可能使结果出错
     * 如何解决这个问题呢? 解决方案就是要确保String不是在随机位置拆开的，而只能在词尾拆开。要做到这一点，你必须为Character实现一个Spliterator，它只能在两个词之间拆开String，然后由此创建并行流
     *
     * @param s
     * @return
     */
    static int countWordsParallel(String s) {
        Stream<Character> stream = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
        return countWords(stream.parallel());
    }

    static int countWordParallelCorrect(String s) {
//        运用WordCounterSpliterator
        Spliterator<Character> spliterator = new WordCounterSpliterator(s);
//        传给StreamSupport.stream工厂方法的第二个布尔参数意味着你想创建一个并行流。把这个并行流传给countWords方法
        Stream<Character> stream = StreamSupport.stream(spliterator, true);
        return countWords(stream);
    }

    public static void main(String[] args) {
//        System.out.println("Found " + countWordsIteratively(SENTENCE) + " words");
//        System.out.println("Found " + countWordsFunctionally(SENTENCE) + " words");
//        System.out.println("Found " + countWordsParallel(SENTENCE) + " words");
        System.out.println("Found " + countWordParallelCorrect(SENTENCE) + " words");

    }

}
