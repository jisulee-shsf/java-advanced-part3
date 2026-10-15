package optional;

import java.util.Optional;

public class OptionalCreationMain {

    public static void main(String[] args) {
        Optional<String> opt1 = Optional.of("hello");
        System.out.println(opt1); // Optional[hello]

        Optional<String> opt2 = Optional.ofNullable("hello");
        Optional<String> opt3 = Optional.ofNullable(null);
        System.out.println(opt2); // Optional[hello]
        System.out.println(opt3); // Optional.empty

        Optional<Object> opt4 = Optional.empty();
        System.out.println(opt4); // Optional.empty
    }
}
