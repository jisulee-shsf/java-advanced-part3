package stream.operation;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperationsMain {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10);

        // filter
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " ")); // 2 2 4 6 8 10
        System.out.println();

        // map
        numbers.stream()
                .map(n -> n * n)
                .forEach(n -> System.out.print(n + " ")); // 1 4 4 9 16 25 25 36 49 64 81 100
        System.out.println();

        // distinct
        numbers.stream()
                .distinct()
                .forEach(n -> System.out.print(n + " ")); // 1 2 3 4 5 6 7 8 9 10
        System.out.println();

        // sorted
        Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .sorted()
                .forEach(n -> System.out.print(n + " ")); // 1 1 2 3 4 5 5 6 9
        System.out.println();

        Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .sorted(Comparator.reverseOrder())
                .forEach(n -> System.out.print(n + " ")); // 9 6 5 5 4 3 2 1 1
        System.out.println();

        // peek
        numbers.stream()
                .peek(n -> System.out.print("before: " + n + ", "))
                .map(n -> n * n)
                .peek(n -> System.out.print("after: " + n + ", "))
                .limit(3)
                .forEach(n -> System.out.println("final: " + n));
        /*
        before: 1, after: 1, final: 1
        before: 2, after: 4, final: 4
        before: 2, after: 4, final: 4
        */

        // limit
        numbers.stream()
                .limit(5)
                .forEach(n -> System.out.print(n + " ")); // 1 2 2 3 4
        System.out.println();

        // skip
        numbers.stream()
                .skip(5)
                .forEach(n -> System.out.print(n + " ")); // 5 5 6 7 8 9 10
        System.out.println();

        // takeWhile
        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5, 1, 2, 3);
        numbers2.stream()
                .takeWhile(n -> n < 5)
                .forEach(n -> System.out.print(n + " ")); // 1 2 3 4
        System.out.println();

        // dropWhile
        numbers2.stream()
                .dropWhile(n -> n < 5)
                .forEach(n -> System.out.print(n + " ")); // 5 1 2 3
        System.out.println();
    }
}
