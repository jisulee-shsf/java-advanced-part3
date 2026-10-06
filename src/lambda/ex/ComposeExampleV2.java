package lambda.ex;

public class ComposeExampleV2 {

    public static MyTransformer compose(MyTransformer f1, MyTransformer f2) {
        return s -> f2.transform(f1.transform(s));
    }

    public static void main(String[] args) {
        MyTransformer toUpper = s -> s.toUpperCase();
        MyTransformer addDeco = s -> "**" + s + "**";

        MyTransformer composeFunc = compose(toUpper, addDeco);
        System.out.println(composeFunc.transform("hello")); // **HELLO**
    }
}
