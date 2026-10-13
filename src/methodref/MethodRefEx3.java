package methodref;

import java.util.function.Function;

public class MethodRefEx3 {

    public static void main(String[] args) {
        // 특정 타입의 임의 객체의 인스턴스 메서드 참조
        Person person1 = new Person("A");
        Person person2 = new Person("B");
        Person person3 = new Person("C");

        Function<Person, String> fun1 = (Person person) -> person.introduce();
        System.out.println(fun1.apply(person1));
        System.out.println(fun1.apply(person2));
        System.out.println(fun1.apply(person3));

        Function<Person, String> fun2 = Person::introduce;
        System.out.println(fun2.apply(person1));
        System.out.println(fun2.apply(person2));
        System.out.println(fun2.apply(person3));
    }
    /*
    I am A
    I am B
    I am C
    I am A
    I am B
    I am C
    */
}
