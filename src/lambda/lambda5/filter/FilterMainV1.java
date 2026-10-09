package lambda.lambda5.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterMainV1 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> result1 = filterEvenNumbers(numbers);
        System.out.println(result1); // [2, 4, 6, 8, 10]

        List<Integer> result2 = filterOddNumbers(numbers);
        System.out.println(result2); // [1, 3, 5, 7, 9]
    }

    private static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            boolean testResult = number % 2 == 0;
            if (testResult) {
                result.add(number);
            }
        }
        return result;
    }

    private static List<Integer> filterOddNumbers(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            boolean testResult = number % 2 == 1;
            if (testResult) {
                result.add(number);
            }
        }
        return result;
    }
}
