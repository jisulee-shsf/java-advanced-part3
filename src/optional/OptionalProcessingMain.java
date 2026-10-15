package optional;

import java.util.Optional;

public class OptionalProcessingMain {

    public static void main(String[] args) {
        Optional<String> optValue = Optional.of("hello");
        Optional<String> optEmpty = Optional.empty();

        // ifPresent()
        optValue.ifPresent(v -> System.out.println("optValue: " + v)); // optValue: hello
        optEmpty.ifPresent(v -> System.out.println("optEmpty: " + v)); // 실행 안함

        // ifPresentOrElse()
        optValue.ifPresentOrElse(v -> System.out.println("optValue: " + v), () -> System.out.println("값이 없음")); // optValue: hello
        optEmpty.ifPresentOrElse(v -> System.out.println("optEmpty: " + v), () -> System.out.println("값이 없음")); // 값이 없음

        // map()
        Optional<Integer> lengthOpt1 = optValue.map(String::length);
        Optional<Integer> lengthOpt2 = optEmpty.map(String::length);
        System.out.println(lengthOpt1); // Optional[5]
        System.out.println(lengthOpt2); // Optional.empty

        // flatMap()
        Optional<Optional<String>> nestedOpt = optValue.map(s -> Optional.of(s));
        System.out.println(nestedOpt); // Optional[Optional[hello]]
        Optional<String> flattenedOpt = optValue.flatMap(s -> Optional.of(s));
        System.out.println(flattenedOpt); // Optional[hello]

        // filter()
        Optional<String> filtered1 = optValue.filter(s -> s.startsWith("h"));
        Optional<String> filtered2 = optEmpty.filter(s -> s.startsWith("x"));
        System.out.println(filtered1); // Optional[hello]
        System.out.println(filtered2); // Optional.empty

        // stream()
        optValue.stream()
                .forEach(s -> System.out.println("optValue: " + s)); // optValue: hello
        optEmpty.stream()
                .forEach(s -> System.out.println("optEmpty: " + s)); // 실행 안함
    }
}
