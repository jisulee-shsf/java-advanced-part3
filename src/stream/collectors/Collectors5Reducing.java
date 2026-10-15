package stream.collectors;

import java.util.List;
import java.util.stream.Collectors;

public class Collectors5Reducing {

    public static void main(String[] args) {
        List<String> names = List.of("a", "b", "c", "d");

        String joined1 = names.stream()
                .collect(Collectors.reducing((s1, s2) -> s1 + ", " + s2)).get();
        System.out.println(joined1); // a, b, c, d

        String joined2 = names.stream()
                .reduce((s1, s2) -> s1 + ", " + s2).get();
        System.out.println(joined2); // a, b, c, d

        String joined3 = names.stream()
                .collect(Collectors.joining(", "));
        System.out.println(joined3); // a, b, c, d

        String joined4 = String.join(", ", "a", "b", "c", "d");
        System.out.println(joined4); // a, b, c, d
    }
}
