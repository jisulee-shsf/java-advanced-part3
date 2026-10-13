package methodref;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MethodRefEx4 {

    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("A"),
                new Person("B"),
                new Person("C")
        );

        List<String> result1 = mapPersonToString(personList, (Person person) -> person.introduce());
        List<String> result2 = mapPersonToString(personList, Person::introduce);
        System.out.println(result1); // [I am A, I am B, I am C]
        System.out.println(result2); // [I am A, I am B, I am C]

        List<String> result3 = mapStringToString(result1, s -> s.toUpperCase());
        List<String> result4 = mapStringToString(result1, String::toUpperCase);
        System.out.println(result3); // [I AM A, I AM B, I AM C]
        System.out.println(result4); // [I AM A, I AM B, I AM C]
    }

    private static List<String> mapPersonToString(List<Person> personList, Function<Person, String> fun) {
        List<String> result = new ArrayList<>();
        for (Person p : personList) {
            result.add(fun.apply(p));
        }
        return result;
    }

    private static List<String> mapStringToString(List<String> strings, Function<String, String> fun) {
        List<String> result = new ArrayList<>();
        for (String s : strings) {
            result.add(fun.apply(s));
        }
        return result;
    }
}
