package lambda.lambda3;

public class GenericMain1 {

    public static void main(String[] args) {
        StringFunction upperCase = s -> s.toUpperCase();
        System.out.println(upperCase.apply("hello")); // HELLO

        NumberFunction square = n -> n * n;
        System.out.println(square.apply(3)); // 9
    }

    @FunctionalInterface
    interface StringFunction {
        String apply(String s);
    }

    @FunctionalInterface
    interface NumberFunction {
        Integer apply(Integer i);
    }
}
