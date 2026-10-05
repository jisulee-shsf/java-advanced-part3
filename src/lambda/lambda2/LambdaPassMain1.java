package lambda.lambda2;

import lambda.MyFunction;

public class LambdaPassMain1 {
    public static void main(String[] args) {
        MyFunction add = (a, b) -> a + b;
        System.out.println(add); // ...$$Lambda/0x00000008000c23f8@2acf57e3

        MyFunction sub = (a, b) -> a - b;
        System.out.println(sub); // ...$$Lambda/0x00000008000c2610@3796751b

        MyFunction cal = add;
        System.out.println(cal); // ...$$Lambda/0x00000008000c23f8@2acf57e3
        System.out.println(cal.apply(1, 2)); // 3

        cal = sub;
        System.out.println(cal); // ...$$Lambda/0x00000008000c2610@3796751b
        System.out.println(cal.apply(1, 2)); // -1
    }
}
