package optional;

import java.util.Optional;

public class OptionalRetrievalMain {

    public static void main(String[] args) {
        Optional<String> optValue = Optional.of("hello");
        Optional<String> optEmpty = Optional.empty();

        // isPresent()
        System.out.println(optValue.isPresent()); // true
        System.out.println(optEmpty.isPresent()); // false
        System.out.println(optEmpty.isEmpty()); // true

        // get()
        String getValue1 = optValue.get();
        System.out.println(getValue1); // hello
        // String getValue2 = optEmpty.get(); // NoSuchElementException: No value present

        // orElse()
        String value1 = optValue.orElse("default");
        String empty1 = optEmpty.orElse("default");
        System.out.println(value1); // hello
        System.out.println(empty1); // default

        // orElseGet()
        String value2 = optValue.orElseGet(() -> {
            System.out.println("람다 호출 - optValue");
            return "new value";
        });

        String empty2 = optEmpty.orElseGet(() -> {
            System.out.println("람다 호출 - optEmpty");
            return "new value";
        });
        System.out.println(value2);
        System.out.println(empty2);
        /*
        람다 호출 - optEmpty
        hello
        new value
        */

        // orElseThrow
        String value3 = optValue.orElseThrow(() -> new RuntimeException("값이 없습니다."));
        System.out.println(value3); // hello

        try {
            optEmpty.orElseThrow(() -> new RuntimeException("값이 없습니다."));
        } catch (Exception e) {
            System.out.println(e.getMessage()); // 값이 없습니다.
        }

        // or()
        Optional<String> result1 = optValue.or(() -> Optional.of("fallback"));
        Optional<String> result2 = optEmpty.or(() -> Optional.of("fallback"));
        System.out.println(result1); // Optional[hello]
        System.out.println(result2); // Optional[fallback]
    }
}
