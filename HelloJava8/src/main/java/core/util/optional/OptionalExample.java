package core.util.optional;

import java.util.Optional;
import java.util.Properties;

/**
 * Created by yh on 10/10/18.
 */
public class OptionalExample {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");
    }

    public int readDuration_1(Properties props, String name) {
        return Integer.parseInt(props.getProperty(name));
    }

    public int readDuration_2(Properties props, String name) {
        String value = props.getProperty(name);
        //    确保名称对应的属性存在
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                    //检查返回的数字是否为正数
                }
            } catch (NumberFormatException nfe) {

            }
        }
//        如果不满足先前的条件，返回0
        return 0;
    }

    public int readDuration_3(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(OptionalUtility::stringToInt)
                .filter(i -> i > 0)
                .orElse(0);
    }

}

