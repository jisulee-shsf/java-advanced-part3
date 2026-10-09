package lambda.lambda5.map;

import java.util.List;

public class MapMainV4 {

    public static void main(String[] args) {
        List<String> list = List.of("a", "aa", "aaa");

        List<String> result1 = GenericMapper.map(list, s -> s.toUpperCase());
        System.out.println(result1); // [A, AA, AAA]

        List<Integer> result2 = GenericMapper.map(list, s -> s.length());
        System.out.println(result2); // [1, 2, 3]

        List<Integer> integers = List.of(1, 2, 3);
        List<String> result3 = GenericMapper.map(integers, n -> "*".repeat(n));
        System.out.println(result3); // [*, **, ***]
    }
}
