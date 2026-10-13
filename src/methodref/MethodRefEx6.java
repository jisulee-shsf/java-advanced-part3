package methodref;

import lambda.lambda5.mystream.MyStreamV3;

import java.util.List;

public class MethodRefEx6 {

    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("A"),
                new Person("B"),
                new Person("C")
        );

        List<String> result1 = MyStreamV3.of(personList)
                .map(person -> person.introduce())
                .map(str -> str.toUpperCase())
                .toList();
        System.out.println(result1); // [I AM A, I AM B, I AM C]

        List<String> result2 = MyStreamV3.of(personList)
                .map(Person::introduce)
                .map(String::toUpperCase)
                .toList();
        System.out.println(result2); // [I AM A, I AM B, I AM C]
    }
}
