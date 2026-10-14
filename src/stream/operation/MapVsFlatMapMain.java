package stream.operation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MapVsFlatMapMain {

    public static void main(String[] args) {
        List<List<Integer>> outerList = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6)
        );
        System.out.println(outerList); // [[1, 2], [3, 4], [5, 6]]

        // for
        List<Integer> result1 = new ArrayList<>();
        for (List<Integer> list : outerList) {
            for (Integer i : list) {
                result1.add(i);
            }
        }
        System.out.println(result1); // [1, 2, 3, 4, 5, 6]

        List<Stream<Integer>> result2 = outerList.stream()
                .map(list -> list.stream())
                .toList();
        System.out.println(result2);
        /*
        [
        java.util.stream.ReferencePipeline$Head@6aaa5eb0,
        java.util.stream.ReferencePipeline$Head@3498ed,
        java.util.stream.ReferencePipeline$Head@1a407d53
        ]
        */

        List<Integer> result3 = outerList.stream()
                .flatMap(list -> list.stream())
                .toList();
        System.out.println(result3); // [1, 2, 3, 4, 5, 6]
    }
}
