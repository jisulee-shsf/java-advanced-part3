package lambda.lambda5.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterMainV2 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> result1 = filter(numbers, n -> n % 2 == 0);
        System.out.println(result1); // [2, 4, 6, 8, 10]

        List<Integer> result2 = filter(numbers, n -> n % 2 == 1);
        System.out.println(result2); // [1, 3, 5, 7, 9]
    }

    private static List<Integer> filter(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : list) {
            if (predicate.test(num)) {
                result.add(num);
            }
        }
        return result;
    }
}
