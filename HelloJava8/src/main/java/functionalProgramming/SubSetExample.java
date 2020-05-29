package functionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yh on 11/22/18.
 */
public class SubSetExample {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 4, 9);
        System.out.println(subset(integers));

    }

    static List<List<Integer>> subset(List<Integer> integers) {
        if (integers.isEmpty()) {
            List<List<Integer>> subsets = new ArrayList<>();
            subsets.add(integers);
            return subsets;
        }
//        第一个元素
        Integer first = integers.get(0);
//        非第一个元素之外的其他元素
        List<Integer> rest = integers.subList(1, integers.size());
//        除了第一个元素之外的，其它元素组成的子集
        List<List<Integer>> subans = subset(rest);
//        把第一个元素插入，所有其它元素组成的子集中
        List<List<Integer>> subans2 = insertAll(first, subans);
//        把两类子包含第一个元素，和不包含第1个元素子集加起来，就是所有的子集
        return concat(subans, subans2);

    }

    static List<List<Integer>> insertAll(Integer first, List<List<Integer>> lists) {
        List<List<Integer>> result = new ArrayList<>();
//        复制列表，从而使你有机会对其进行添加操作。即使底层是可变的，你也不应该复制底层的结构。不过Integer底层是不可变的
        for (List<Integer> list : lists) {
            List<Integer> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(list);
            result.add(copyList);
        }
        return result;
    }

    static List<List<Integer>> concat(List<List<Integer>> set1, List<List<Integer>> set2) {
        List<List<Integer>> sets = new ArrayList<>();
        sets.addAll(set1);
        sets.addAll(set2);
        return sets;
    }
}
