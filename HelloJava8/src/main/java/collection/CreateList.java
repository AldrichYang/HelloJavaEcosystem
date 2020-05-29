package collection;

import com.google.common.collect.Lists;

import java.util.Arrays;

/**
 * Created by yh on 2019-04-26.
 */
public class CreateList {
    public static void main(String[] args) {
        // 可行代码一：
        Lists.charactersOf(new String(new char[100]));
        // 可行代码二：
        java.util.Collections.nCopies(100, 0);
        // 错误代码:这种是把数组当成list的第一个元素了,因为入参是一个数组，这样只是给了一个元素而已
        Arrays.asList(new int[6]);
    }
}
