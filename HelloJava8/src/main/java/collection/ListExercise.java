package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by yh on 2018/3/26.
 */
public class ListExercise {

    public static void main(String[] args) {
        listManipulate(args);
    }

    private static void listManipulate(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList(args));
        List<Integer> listInt = list.parallelStream().map(Integer::valueOf).collect(Collectors.toList());
        Collections.shuffle(listInt, new Random());
        Collections.sort(listInt);
        System.out.println(listInt);

    }

    @Test
     public void listInitSetGet() {
        int one_million = 1_000_000;
        System.out.println(one_million);
    }


}
