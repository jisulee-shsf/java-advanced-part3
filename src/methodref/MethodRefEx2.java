package methodref;

import java.util.function.Function;

public class MethodRefEx2 {

    public static void main(String[] args) {
        // 정적 메서드 참조
        Function<String, String> staticMethod1 = name -> Person.greetingWithName(name);
        Function<String, String> staticMethod2 = Person::greetingWithName;
        System.out.println(staticMethod1.apply("A"));
        System.out.println(staticMethod2.apply("A"));

        // 특정 객체의 인스턴스 메서드 참조
        Person person = new Person("A");
        Function<Integer, String> instanceMethod1 = num -> person.introduceWithNumber(num);
        Function<Integer, String> instanceMethod2 = person::introduceWithNumber;
        System.out.println(instanceMethod1.apply(1));
        System.out.println(instanceMethod2.apply(1));

        // 생성자 참조
        Function<String, Person> newPerson1 = name -> new Person(name);
        Function<String, Person> newPerson2 = Person::new;
        System.out.println(newPerson1.apply("A").getName());
        System.out.println(newPerson2.apply("A").getName());
    }
    /*
    hello A
    hello A
    I am A my number is 1
    I am A my number is 1
    A
    A
    */
}
