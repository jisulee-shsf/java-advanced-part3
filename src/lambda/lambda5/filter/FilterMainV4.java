package lambda.lambda5.filter;

import java.util.List;

public class FilterMainV4 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result1 = GenericFilter.filter(numbers, n -> n % 2 == 0);
        System.out.println(result1); // [2, 4, 6, 8, 10]

        List<String> strings = List.of("A", "AA", "AAA");
        List<String> result2 = GenericFilter.filter(strings, s -> s.length() >= 2);
        System.out.println(result2); // [AA, AAA]
    }
}
