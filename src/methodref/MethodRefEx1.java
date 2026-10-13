package methodref;

import java.util.function.Supplier;

public class MethodRefEx1 {

    public static void main(String[] args) {
        // 정적 메서드 참조
        Supplier<String> staticMethod1 = () -> Person.greeting();
        Supplier<String> staticMethod2 = Person::greeting;
        System.out.println(staticMethod1.get());
        System.out.println(staticMethod2.get());

        // 특정 객체의 인스턴스 메서드 참조
        Person person = new Person("A");
        Supplier<String> instanceMethod1 = () -> person.introduce();
        Supplier<String> instanceMethod2 = person::introduce;
        System.out.println(instanceMethod1.get());
        System.out.println(instanceMethod2.get());

        // 생성자 참조
        Supplier<Person> newPerson1 = () -> new Person();
        Supplier<Person> newPerson2 = Person::new;
        System.out.println(newPerson1.get());
        System.out.println(newPerson2.get());
    }
    /*
    hello
    hello
    I am A
    I am A
    methodref.Person@6442b0a6
    methodref.Person@60f82f98
    */
}
