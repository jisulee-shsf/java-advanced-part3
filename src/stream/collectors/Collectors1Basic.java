package stream.collectors;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collectors1Basic {

    public static void main(String[] args) {
        // List
        List<Integer> list = Stream.of(1, 2, 3)
                .collect(Collectors.toList());
        System.out.println(list); // [1, 2, 3]

        List<Integer> unmodifiableList = Stream.of(1, 2, 3)
                .collect(Collectors.toUnmodifiableList());
        System.out.println(unmodifiableList); // [1, 2, 3]

        // Set
        Set<Integer> set = Stream.of(1, 1, 2, 2, 3, 3)
                .collect(Collectors.toSet());
        System.out.println(set); // [1, 2, 3]

        TreeSet<Integer> treeSet = Stream.of(3, 1, 2)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(treeSet); // [1, 2, 3]
    }
}
