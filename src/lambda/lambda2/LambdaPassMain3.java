package lambda.lambda2;

import lambda.MyFunction;

public class LambdaPassMain3 {

    public static void main(String[] args) {
        MyFunction add = getOperation("add");
        System.out.println(add.apply(1, 2)); // 3

        MyFunction sub = getOperation("sub");
        System.out.println(sub.apply(1, 2)); // -1

        MyFunction xxx = getOperation("xxx");
        System.out.println(xxx.apply(1, 2)); // 0
    }

    static MyFunction getOperation(String operator) {
        switch (operator) {
            case "add":
                return (a, b) -> a + b;
            case "sub":
                return (a, b) -> a - b;
            default:
                return (a, b) -> 0;
        }
    }
}
