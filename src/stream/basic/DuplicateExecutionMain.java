package stream.basic;

import java.util.List;
import java.util.stream.Stream;

public class DuplicateExecutionMain {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        stream.forEach(System.out::print); // 12345
//        stream.forEach(System.out::print); -> IllegalStateException: stream has already been operated upon or closed

        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Stream.of(list).forEach(System.out::print); // [1, 2, 3, 4, 5]
        Stream.of(list).forEach(System.out::print); // [1, 2, 3, 4, 5]
    }
}
