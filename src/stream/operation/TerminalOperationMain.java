package stream.operation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperationMain {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10);

        // collect
        List<Integer> result1 = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(result1); // [2, 2, 4, 6, 8, 10]

        // toList
        List<Integer> result2 = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println(result2); // [2, 2, 4, 6, 8, 10]

        // toArray
        Integer[] result3 = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toArray(Integer[]::new);
        System.out.println(Arrays.toString(result3));

        // forEach
        numbers.stream()
                .limit(5)
                .forEach(n -> System.out.print(n + " ")); // 1 2 2 3 4
        System.out.println();

        // count
        long result4 = numbers.stream()
                .filter(n -> n > 5)
                .count();
        System.out.println(result4); // 5

        // reduce - 초기값이 없는 경우
        Optional<Integer> result5 = numbers.stream()
                .reduce((a, b) -> a + b);
        System.out.println(result5.get()); // 62

        // reduce - 초기값이 있는 경우
        Integer result6 = numbers.stream()
                .reduce(100, (a, b) -> a + b);
        System.out.println(result6); // 162

        // min
        Optional<Integer> result7 = numbers.stream()
                .min(Integer::compareTo);
        System.out.println(result7.get()); // 1

        // max
        Optional<Integer> result8 = numbers.stream()
                .max(Integer::compareTo);
        System.out.println(result8.get()); // 10

        // findFirst
        Optional<Integer> result9 = numbers.stream()
                .filter(n -> n > 5)
                .findFirst();
        System.out.println(result9.get()); // 6

        // findAny
        Optional<Integer> result10 = numbers.stream()
                .filter(n -> n > 5)
                .findAny();
        System.out.println(result10.get()); // 6

        // anyMatch
        boolean result11 = numbers.stream()
                .anyMatch(n -> n % 2 == 0);
        System.out.println(result11); // true

        // allMatch
        boolean result12 = numbers.stream()
                .allMatch(n -> n > 0);
        System.out.println(result12); // true

        // noneMatch
        boolean result13 = numbers.stream()
                .noneMatch(n -> n < 0);
        System.out.println(result13); // true
    }
}
