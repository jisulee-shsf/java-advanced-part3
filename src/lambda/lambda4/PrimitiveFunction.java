package lambda.lambda4;

import java.util.function.IntFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ToIntFunction;

public class PrimitiveFunction {

    public static void main(String[] args) {
        IntFunction<String> intFunction = x -> "숫자: " + x;
        System.out.println(intFunction.apply(3));

        ToIntFunction<String> toIntFunction = s -> s.length();
        System.out.println(toIntFunction.applyAsInt("hello"));

        IntToLongFunction intToLongFunction = x -> x * 100L;
        System.out.println(intToLongFunction.applyAsLong(3));

        IntUnaryOperator intUnaryOperator = x -> x * 100;
        System.out.println(intUnaryOperator.applyAsInt(3));
    }
}
