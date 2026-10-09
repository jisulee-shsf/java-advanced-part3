package lambda.lambda5.map;

import java.util.List;

public class MapMainV3 {

    public static void main(String[] args) {
        List<String> list = List.of("1", "12", "123", "1234");

        List<Integer> result1 = StringToIntegerMapper.map(list, s -> Integer.valueOf(s));
        System.out.println(result1); // [1, 12, 123, 1234]

        List<Integer> result2 = StringToIntegerMapper.map(list, s -> s.length());
        System.out.println(result2); // [1, 2, 3, 4]
    }
}
