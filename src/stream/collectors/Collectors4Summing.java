package stream.collectors;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collectors4Summing {

    public static void main(String[] args) {
        Long count1 = Stream.of(1, 2, 3)
                .collect(Collectors.counting());
        System.out.println(count1); // 3

        long count2 = Stream.of(1, 2, 3)
                .count();
        System.out.println(count2); // 3

        Double average1 = Stream.of(1, 2, 3)
                .collect(Collectors.averagingInt(i -> i));
        System.out.println(average1); // 2.0

        double average2 = Stream.of(1, 2, 3)
                .mapToInt(i -> i)
                .average().getAsDouble();
        System.out.println(average2); // 2.0

        double average3 = IntStream.of(1, 2, 3)
                .average()
                .getAsDouble();
        System.out.println(average3); // 2.0

        IntSummaryStatistics stats = Stream.of("Apple", "Banana", "Tomato")
                .collect(Collectors.summarizingInt(String::length));
        System.out.println(stats.getSum());
        System.out.println(stats.getMin());
        System.out.println(stats.getMax());
        System.out.println(stats.getAverage());
        System.out.println(stats.getCount());
        /*
        17
        5
        6
        5.666666666666667
        3
        */
    }
}
