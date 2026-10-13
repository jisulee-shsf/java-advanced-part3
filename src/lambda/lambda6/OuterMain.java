package lambda.lambda6;

public class OuterMain {

    private String message = "외부 클래스";

    public void execute() {
        Runnable anonymous = new Runnable() {

            private String message = "익명 클래스";

            @Override
            public void run() {
                System.out.println("[익명 클래스] this: " + this);
                System.out.println("[익명 클래스] this.class: " + this.getClass());
                System.out.println("[익명 클래스] this.message: " + this.message);
            }
        };

        Runnable lambda = () -> {
            System.out.println("[람다] this: " + this);
            System.out.println("[람다] this.class: " + this.getClass());
            System.out.println("[람다] this.message: " + this.message);
        };

        anonymous.run();
        System.out.println("==========");
        lambda.run();
    }

    public static void main(String[] args) {
        OuterMain outer = new OuterMain();
        System.out.println("[외부 클래스] this: " + outer);
        System.out.println("==========");

        outer.execute();
    }
    /*
    [외부 클래스] this: lambda.lambda6.OuterMain@2d6e8792
    ==========
    [익명 클래스] this: lambda.lambda6.OuterMain$1@96532d6
    [익명 클래스] this.class: class lambda.lambda6.OuterMain$1
    [익명 클래스] this.message: 익명 클래스
    ==========
    [람다] this: lambda.lambda6.OuterMain@2d6e8792
    [람다] this.class: class lambda.lambda6.OuterMain
    [람다] this.message: 외부 클래스
    */
}
