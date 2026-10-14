package stream.operation;

import java.util.IntSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreamMain {

    public static void main(String[] args) {
        IntStream stream = IntStream.of(1, 2, 3, 4, 5);
        stream.forEach(i -> System.out.print(i + " ")); // 1 2 3 4 5
        System.out.println();

        IntStream range1 = IntStream.range(1, 6);
        range1.forEach(i -> System.out.print(i + " ")); // 1 2 3 4 5
        System.out.println();

        IntStream range2 = IntStream.rangeClosed(1, 5);
        range2.forEach(i -> System.out.print(i + " ")); // 1 2 3 4 5
        System.out.println();

        int sum = IntStream.range(1, 6)
                .sum();
        System.out.println(sum); // 15

        double avg = IntStream.range(1, 6)
                .average()
                .getAsDouble();
        System.out.println(avg); // 3.0

        IntSummaryStatistics stats = IntStream.range(1, 6).summaryStatistics();
        System.out.println(stats.getSum());
        System.out.println(stats.getAverage());
        System.out.println(stats.getMax());
        System.out.println(stats.getMin());
        System.out.println(stats.getCount());
        /*
        15
        3.0
        5
        1
        5
        */

        LongStream longStream = IntStream.range(1, 6).asLongStream();
        DoubleStream doubleStream = IntStream.range(1, 6).asDoubleStream();
        Stream<Integer> boxedStream = IntStream.range(1, 6).boxed();

        LongStream mappedLong = IntStream.range(1, 6)
                .mapToLong(i -> i * 10L);

        DoubleStream mappedDouble = IntStream.range(1, 6)
                .mapToDouble(i -> i * 1.5);

        Stream<String> mappedObj = IntStream.range(1, 6)
                .mapToObj(i -> "Number: " + i);

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        IntStream intStream = integerStream.mapToInt(i -> i);

        int result = Stream.of(1, 2, 3, 4, 5)
                .mapToInt(i -> i)
                .sum();
        System.out.println(result); // 15
    }
}
