package lambda.ex;

public class BuildGreeterExampleV1 {

    public static StringFunction buildGreeter(String greeting) {
        return new StringFunction() {
            @Override
            public String apply(String name) {
                return greeting + ", " + name;
            }
        };
    }

    public static void main(String[] args) {
        StringFunction helloGreeter = buildGreeter("Hello");
        StringFunction hiGreeter = buildGreeter("Hi");

        System.out.println(helloGreeter.apply("Java")); // Hello, Java
        System.out.println(hiGreeter.apply("Lambda")); // Hi, Lambda
    }
}
