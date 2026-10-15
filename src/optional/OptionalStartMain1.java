package optional;

import java.util.HashMap;
import java.util.Map;

public class OptionalStartMain1 {

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
        String name = findNameById(id);
        if (name != null) {
            System.out.println(id + ": " + name.toUpperCase());
        } else {
            System.out.println(id + ": UNKNOWN");
        }
    }

    private static String findNameById(Long id) {
        return map.get(id);
    }
    /*
    1: A
    3: UNKNOWN
    */
}
