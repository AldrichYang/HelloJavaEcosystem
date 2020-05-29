package core.util.optional;

/**
 * Created by yh on 10/9/18.
 */
public class PersonInsuranceService {
    public static void main(String[] args) {
        Person person = new Person();
        new PersonInsuranceService().getCarInsuranceName(person);
    }

    String getCarInsuranceName(Person person) {
        return person.getCar().getInsurance().getName();
    }

    /**
     * null-安全的第一种尝试:深层质疑
     * 深层质疑，原因是它不断重复着一种模式:每次你不确定一个变量是否为null时，都需要添加一个进一步嵌套的if块，也增加了代码缩进的层数。
     * 很明显， 这种方式不具备扩展性，同时还牺牲了代码的可读性
     *
     * @param person
     * @return
     */
    String getCarInsuranceName1(Person person) {
        if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }
        return "UnKnown";
    }

    /**
     * null-安全的第二种尝试:过多的退出语句
     * 第二种尝试中，你试图避免深层递归的if语句块，采用了一种不同的策略:每次你遭遇null变量，都返回一个字符串常量“Unknown”。
     * 然而，这种方案远非理想，现在这个方法有了四个截然不同的退出点，使得代码的维护异常艰难。更糟的是，发生null时返回的默认值，即字符串“Unknown”在三个不同的地方重复出现——出现拼写错误的概率不小
     *
     * @param person
     * @return
     */
    public String getCarInsuranceName2(Person person) {
        if (person == null) {
            return "Unknown";
        }
        Car car = person.getCar();
        if (car == null) {
            return "Unknown";
        }
        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return "Unknown";
        }
        return insurance.getName();
    }
}
