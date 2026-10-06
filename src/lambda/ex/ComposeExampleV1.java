package lambda.ex;

public class ComposeExampleV1 {

    public static MyTransformer compose(MyTransformer f1, MyTransformer f2) {
        return new MyTransformer() {
            @Override
            public String transform(String s) {
                return f2.transform(f1.transform(s));
            }
        };
    }

    public static void main(String[] args) {
        MyTransformer toUpper = new MyTransformer() {
            @Override
            public String transform(String s) {
                return s.toUpperCase();
            }
        };

        MyTransformer addDeco = new MyTransformer() {
            @Override
            public String transform(String s) {
                return "**" + s + "**";
            }
        };

        MyTransformer composeFunc = compose(toUpper, addDeco);
        System.out.println(composeFunc.transform("hello")); // **HELLO**
    }
}
