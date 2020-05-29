package stream.parallel;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by yh on 9/18/18.
 * 这个Spliterator由要解析的String创建，并遍历了其中的Character，同时保存了当前 正 在 遍 历 的 字 符 位 置
 * Spliterator如何让你控制拆分数据结构的策略
 */
public class WordCounterSpliterator implements Spliterator<Character> {


    private final String string;
    private int currentChar = 0;

    public WordCounterSpliterator(String string) {
        this.string = string;
    }

    /**
     * tryAdvance方法把String中当前位置的Character传给了Consumer，并让位置加一。 作为参数传递的Consumer是一个Java内部类，在遍历流时将要处理的Character传给了一系列要对其执行的函数。
     * 这里只有一个归约函数，即WordCounter类的accumulate 方法。如果新的指针位置小于String的总长，且还有要遍历的Character，则 tryAdvance返回true
     *
     * @param action
     * @return
     */
    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
//        处理当前字符
        action.accept(string.charAt(currentChar++));
//        如果还有字符要处理，则返回true
        return currentChar < string.length();
    }

    /**
     * trySplit方法是Spliterator中最重要的一个方法，因为它定义了拆分要遍历的数据结构的逻辑。就像在ForkJoinSumCalculator中实现的RecursiveTask的compute方法一样(分支 /合并框架的使用方式)，首先要设定不再进一步拆分的下限。
     * 这里用了一个非常低的下限——10个Character，仅仅是为了保证程序会对那个比较短的String做几次拆分。
     * 在实际应用中，就像分支/合并的例子那样，你肯定要用更高的下限来避免生成太多的任务。如果剩余的Character数量低于下限，你就返回null表示无需进一步拆分。相反，如果你需要执行拆分，就把试探的拆分位置设在要解析的String块的中间。
     * 但我们没有直接使用这个拆分位置，因为要避免把词在中间断开，于是就往前找，直到找到一个空格。一旦找到了适当的拆分位置，就可以创建一个新的Spliterator来遍历从当前位置到拆分位置的子串;把当前位置this设为拆分位置，因为之前的部分将由新Spliterator来处理，最后返回
     *
     * @return
     */
    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currentChar;
        if (currentSize < 10) {
//            返回null表示要解析的String已经足够小，可以顺序处理
            return null;
        }
//        将试探拆分位置设定为要解析的String的中间
        for (int splitPos = currentSize / 2 + currentChar; splitPos < string.length(); splitPos++) {
//            让拆分位置前进直到下一个空格
            if (Character.isWhitespace(string.charAt(splitPos))) {
//                创建一个新的WordCounterSpliterator来解析String从开始到拆分位置的部分
                Spliterator<Character> spliterator =
                        new WordCounterSpliterator(string.substring(currentChar, splitPos));
//                将这个WordCounterSpliterator的起始位置设为拆分位置
                currentChar = splitPos;
                return spliterator;
            }
        }
        return null;
    }

    /**
     * 还需要遍历的元素的estimatedSize就是这个Spliterator解析的String的总长度和 当前遍历的位置的差
     *
     * @return
     */
    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    /**
     * characteristic方法告诉框架这个Spliterator是ORDERED(顺序就是String 中各个Character的次序)、SIZED(estimatedSize方法的返回值是精确的)、 SUBSIZED(trySplit方法创建的其他Spliterator也有确切大小)、NONNULL(String 中 不 能 有 为null的Character) 和IMMUTABLE( 在 解 析String时 不 能 再 添 加 Character，因为String本身是一个不可变类)的
     *
     * @return
     */
    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }
}
