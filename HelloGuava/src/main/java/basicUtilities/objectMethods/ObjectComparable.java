package basicUtilities.objectMethods;

import com.google.common.collect.ComparisonChain;

/**
 * Created by yh on 17/9/5.
 */
public class ObjectComparable implements Comparable<Object> {
    @Override
    public int compareTo(Object o) {
        return ComparisonChain.start().compare(this.toString(), o.toString()).result();
    }
}
