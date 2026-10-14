package stream.operation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStreamMain {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3);
        Stream<Integer> stream1 = list.stream();
        stream1.forEach(System.out::print); // 123

        String[] arr = {"a", "b", "c"};
        Stream<String> stream2 = Arrays.stream(arr);
        stream2.forEach(System.out::print); // abc

        Stream<String> stream3 = Stream.of("a", "b", "c");
        stream3.forEach(System.out::print); // abc

        Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 2);
        infiniteStream.limit(3).forEach(System.out::print); // 024

        Stream<Double> randomStream = Stream.generate(Math::random);
        randomStream.limit(3).forEach(System.out::println);
        /*
        0.562281735234651
        0.43066590466138854
        0.9323250261558093
        */
    }
}
