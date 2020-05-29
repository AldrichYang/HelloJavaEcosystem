package lambda;


/**
 * Created by yh on 2018/5/11.
 */
public class MethodRef {

    @FunctionalInterface
    interface Converter<F, T> {
        T convert(F from);
    }

    interface DoSome {
        String doSomething(Object s);
    }

    class Person {
        String firstName;
        String lastName;

        Person() {

        }

        Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    interface PersonFactory<T extends Person> {
        T create(String firstName, String lastName);
    }

    public static void main(String[] args) {
        // 静态方法引用
//        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);

        // 对象方法引用
        DoSome doSome = Object::toString;
        Converter<Object, String> converter1 = doSome::doSomething;
        System.out.println(converter1.convert("hello"));


    }

    private static void constructMethodReference() {
        // 构造函数引用
        // 这种写法在这里是不行，因为Person是一个内部类，只有在其外部类某个实例中才可以构造
        // 而MethodRef我们并没有实例化
//        PersonFactory<Person> personFactory = Person::new;
//        Person person = personFactory.create("first", "last");

    }
}
