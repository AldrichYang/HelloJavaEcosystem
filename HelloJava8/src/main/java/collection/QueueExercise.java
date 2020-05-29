package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by yh on 2018/3/28.
 */
public class QueueExercise {
    public static void main(String[] args) throws InterruptedException {
        countDown(args);
        System.out.println(heapSort(Arrays.asList(args)));

    }


    private static void countDown(String[] args) throws InterruptedException {
        //a queue is used to implement a countdown timer
        int time = Integer.parseInt(args[0]);
        Queue<Integer> queue = new LinkedList<>();

        for (int i = time; i >= 0; i--)
            queue.add(i);

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
            Thread.sleep(1000);
        }

    }

    static <E> List<E> heapSort(Collection<E> c) {
//        a priority queue is used to sort a collection of elements
        Queue<E> queue = new PriorityQueue<E>(c);
        List<E> result = new ArrayList<E>();

        while (!queue.isEmpty())
            result.add(queue.remove());

        return result;
    }
}
