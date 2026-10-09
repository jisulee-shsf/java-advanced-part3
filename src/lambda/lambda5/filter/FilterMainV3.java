package lambda.lambda5.filter;

import java.util.List;

public class FilterMainV3 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> result1 = IntegerFilter.filter(numbers, n -> n % 2 == 0);
        System.out.println(result1); // [2, 4, 6, 8, 10]

        List<Integer> result2 = IntegerFilter.filter(numbers, n -> n % 2 == 1);
        System.out.println(result2); // [1, 3, 5, 7, 9]
    }
}
