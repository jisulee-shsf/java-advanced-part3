package lambda.lambda1;

public class LambdaSimple4 {

    public static void main(String[] args) {
        MyCall myCall1 = (int value) -> value * 2;
        System.out.println(myCall1.call(10));

        MyCall myCall2 = (value) -> value * 2;
        System.out.println(myCall2.call(10));

        MyCall myCall3 = value -> value * 2;
        System.out.println(myCall3.call(10));
    }

    interface MyCall {
        int call(int value);
    }
}
