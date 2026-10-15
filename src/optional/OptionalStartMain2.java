package optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalStartMain2 {

    private static Map<Long, String> map = new HashMap<>();

    static {
        map.put(1L, "A");
        map.put(2L, "B");
    }

    public static void main(String[] args) {
        findAndPrint(1L);
        findAndPrint(3L);
    }

    private static void findAndPrint(Long id) {
        String name = findNameById(id).orElse("UNKNOWN");
        System.out.println(id + ": " + name.toUpperCase());
    }


    private static Optional<String> findNameById(Long id) {
        String name = map.get(id);
        return Optional.ofNullable(name);
    }
    /*
    1: A
    3: UNKNOWN
    */
}
