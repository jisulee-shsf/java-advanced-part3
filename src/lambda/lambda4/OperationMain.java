package lambda.lambda4;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class OperationMain {

    public static void main(String[] args) {
        Function<Integer, Integer> square1 = x -> x * x;
        UnaryOperator<Integer> square2 = x -> x * x;
        System.out.println(square1.apply(3));
        System.out.println(square2.apply(3));

        BiFunction<Integer, Integer, Integer> addition1 = (a, b) -> a + b;
        BinaryOperator<Integer> addition2 = (a, b) -> a + b;
        System.out.println(addition1.apply(1, 2));
        System.out.println(addition2.apply(1, 2));
    }
}
