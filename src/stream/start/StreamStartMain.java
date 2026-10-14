package stream.start;

import java.util.List;

public class StreamStartMain {

    public static void main(String[] args) {
        List<String> names = List.of("Apple", "Banana", "Berry", "Tomato");

        // 스트림 API 사용
        List<String> result = names.stream()
                .filter(name -> name.startsWith("B"))
                .map(s -> s.toUpperCase())
                .toList();

        for (String s : result) {
            System.out.println(s);
        }

        // 내부 반복
        names.stream()
                .filter(name -> name.startsWith("B"))
                .map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

        // 메서드 참조
        names.stream()
                .filter(name -> name.startsWith("B"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
