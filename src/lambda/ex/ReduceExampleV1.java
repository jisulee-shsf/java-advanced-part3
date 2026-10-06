package lambda.ex;

import java.util.List;

public class ReduceExampleV1 {

    public static int reduce(List<Integer> list, int initial, MyReducer reducer) {
        int result = initial;
        for (int val : list) {
            result = reducer.reduce(result, val);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        System.out.println("리스트: " + numbers);

        int sum = reduce(numbers, 0, new MyReducer() {
            @Override
            public int reduce(int a, int b) {
                return a + b;
            }
        });
        System.out.println("합(누적 +): " + sum);

        int product = reduce(numbers, 1, new MyReducer() {
            @Override
            public int reduce(int a, int b) {
                return a * b;
            }
        });
        System.out.println("곱(누적 *): " + product);
    }
    /*
    리스트: [1, 2, 3, 4]
    합(누적 +): 10
    곱(누적 *): 24
    */
}
