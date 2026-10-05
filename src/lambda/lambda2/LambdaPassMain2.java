package lambda.lambda2;

import lambda.MyFunction;

public class LambdaPassMain2 {

    public static void main(String[] args) {
        MyFunction add = (a, b) -> a + b;
        MyFunction sub = (a, b) -> a - b;

        calculate(add); // 3
        calculate(sub); // -1

        calculate((a, b) -> a + b); // 3
        calculate((a, b) -> a - b); // -1
    }

    static void calculate(MyFunction myFunction) {
        int a = 1;
        int b = 2;

        int result = myFunction.apply(a, b);
        System.out.println(result);
    }
}
