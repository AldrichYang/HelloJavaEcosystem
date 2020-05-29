package collection;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by yh on 9/4/18.
 */
public class PrintList {

    private List<String> programmingLanguages = Lists.newArrayList("java", "python", "ruby", "groovy");
    private String languagesSeperatedByComma = "java,python,ruby,groovy";

    private static String join(String separator, String... strings) {
        if (strings == null || strings.length == 0) {
            return "";
        } else if (strings.length == 1) {
            return strings[0];
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(strings[0]);
            for (int i = 1; i < strings.length; i++) {
                sb.append(separator).append(strings[i]);
            }
            return sb.toString();
        }
    }

    //Straight up Java
    @Test
    public void join_elements_in_list_java() {
        String elementsJoined = join(",", programmingLanguages.toArray(new String[programmingLanguages.size()]));
        assertEquals(languagesSeperatedByComma, elementsJoined);
    }

    //    java 8 string joiner
    @Test
    public void join_elements_in_list_java8() {
        String elementsJoined = programmingLanguages
                .stream()
                .collect(Collectors.joining(","));

        assertEquals(languagesSeperatedByComma, elementsJoined);
    }

    //    Google Guava
    @Test
    public void join_elements_in_list_guava() {

        String elementsJoined = Joiner.on(",").join(programmingLanguages);
        assertEquals(languagesSeperatedByComma, elementsJoined);
    }

    //    Apache Commons
    @Test
    public void join_elements_in_list_apache_commons() {

        String elementsJoined = StringUtils.join(programmingLanguages, ",");
        assertEquals(languagesSeperatedByComma, elementsJoined);
    }

    // Spring Framework
    @Test
    public void join_elements_in_list_spring() {

//        String elementsJoined = org.springframework.util
//                .StringUtils.collectionToDelimitedString(programmingLanguages, ",");
//
//        assertEquals(languagesSeperatedByComma, elementsJoined);
    }
}
