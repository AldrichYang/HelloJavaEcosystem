package stream.parallel;

/**
 * Created by yh on 9/17/18.
 */
public class Accumulator {
    public long total = 0;

    public void add(long value) {
        total += value;
    }
}
