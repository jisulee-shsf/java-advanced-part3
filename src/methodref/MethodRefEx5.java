package methodref;

import java.util.function.BiFunction;

public class MethodRefEx5 {

    public static void main(String[] args) {
        Person person = new Person("A");

        BiFunction<Person, Integer, String> fun1 = (Person p, Integer num) -> p.introduceWithNumber(num);
        System.out.println(fun1.apply(person, 1)); // I am A, my number is 1

        BiFunction<Person, Integer, String> fun2 = Person::introduceWithNumber;
        System.out.println(fun2.apply(person, 2)); // I am A, my number is 2
    }
}
