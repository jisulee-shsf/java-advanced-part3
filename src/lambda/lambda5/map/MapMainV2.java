package lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MapMainV2 {

    public static void main(String[] args) {
        List<String> list = List.of("1", "12", "123", "1234");

        List<Integer> result1 = map(list, s -> Integer.valueOf(s));
        System.out.println(result1); // [1, 12, 123, 1234]

        List<Integer> result2 = map(list, s -> s.length());
        System.out.println(result2); // [1, 2, 3, 4]
    }

    private static List<Integer> map(List<String> list, Function<String, Integer> mapper) {
        List<Integer> result = new ArrayList<>();
        for (String s : list) {
            result.add(mapper.apply(s));
        }
        return result;
    }
}
