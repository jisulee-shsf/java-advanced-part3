package stream.collectors;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collectors2Map {

    public static void main(String[] args) {
        Map<String, Integer> map1 = Stream.of("Apple", "Banana", "Tomato")
                .collect(Collectors.toMap(
                        name -> name,
                        name -> name.length()
                ));
        System.out.println(map1); // {Apple=5, Tomato=6, Banana=6}

//        Map<String, Integer> map2 = Stream.of("Apple", "Apple", "Banana", "Tomato") -> 키 중복
//                .collect(Collectors.toMap(
//                        name -> name,
//                        name -> name.length()
//                ));

        Map<String, Integer> map3 = Stream.of("Apple", "Apple", "Banana", "Tomato")
                .collect(Collectors.toMap(
                        name -> name,
                        name -> name.length(),
                        (oldValue, newValue) -> oldValue + newValue // 키 중복 -> 병합
                ));
        System.out.println(map3); // {Apple=10, Tomato=6, Banana=6}

        Map<String, Integer> map4 = Stream.of("Apple", "Apple", "Banana", "Tomato")
                .collect(Collectors.toMap(
                        name -> name,
                        name -> name.length(),
                        (oldValue, newValue) -> oldValue + newValue,
                        LinkedHashMap::new // 타입 지정
                ));
        System.out.println(map4); // {Apple=10, Banana=6, Tomato=6}
        System.out.println(map4.getClass()); // class java.util.LinkedHashMap
    }
}
