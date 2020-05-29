package stream.parallel;

/**
 * Created by yh on 9/18/18.
 */
public class WordCounter {

    private final int counter;
    private final boolean lastSpace;

    public WordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    /**
     * accumulate方法定义了如何更改WordCounter的状态，或更确切地说是用 哪个状态来建立新的WordCounter
     * 因为这个类是不可变的。每次遍历到Stream中的一个新的Character时，就会调用accumulate方法
     *
     * @param c
     * @return
     */
    //  和迭代算法一样， accumulate 方法一个个遍历Character
    public WordCounter accumulate(Character c) {
        if (Character.isWhitespace(c)) {
            return lastSpace ?
                    this :
                    new WordCounter(counter, true);
        } else {
            //  上一个字符是空格，而当前遍历的字符不是空格时，将单词计数器加一
            return lastSpace ? new WordCounter(counter + 1, false) : this;
        }
    }

    /**
     * 调用第二个方法combine时，会对作用于Character流的两个不同子部分的两个 WordCounter的部分结果进行汇总，
     * 也就是把两个WordCounter内部的计数器加起来
     *
     * @param wordCounter
     * @return
     */
    //  合并两个Word- Counter，把其 计数器加起来
    public WordCounter combine(WordCounter wordCounter) {
//        仅需要计数器 的总和，无需关 心lastSpace
        return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
    }

    public int getCounter() {
        return counter;
    }

}
