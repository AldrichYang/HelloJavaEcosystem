package collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by yh on 2018/3/28.
 */
public class MapExercise {
    public static void main(String[] args) {
        freq(args);
    }

    private static void freq(String[] args) {
        //generates a frequency table of the words found in its argument list
//        Map<String, Integer> m = new HashMap<String, Integer>();
//        Map<String, Integer> m = new TreeMap<String, Integer>();
        Map<String, Integer> m = new LinkedHashMap<>();

        // Initialize frequency table from command line
        for (String a : args) {
            Integer freq = m.get(a);
            m.put(a, (freq == null) ? 1 : freq + 1);
        }

        System.out.println(m.size() + " distinct words:");
        System.out.println(m);
    }
}
