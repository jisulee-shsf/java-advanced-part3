package lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;

public class MapMainV1 {

    public static void main(String[] args) {
        List<String> list = List.of("1", "12", "123", "1234");

        List<Integer> result1 = mapStringToInteger(list);
        System.out.println(result1); // [1, 12, 123, 1234]

        List<Integer> result2 = mapStringToLength(list);
        System.out.println(result2); // [1, 2, 3, 4]
    }

    private static List<Integer> mapStringToInteger(List<String> list) {
        List<Integer> result = new ArrayList<>();
        for (String s : list) {
            Integer value = Integer.valueOf(s);
            result.add(value);
        }
        return result;
    }

    private static List<Integer> mapStringToLength(List<String> list) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : list) {
            int value = s.length();
            numbers.add(value);
        }
        return numbers;
    }
}
