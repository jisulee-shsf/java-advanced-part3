package lambda.lambda6;

public class CaptureMain {

    public static void main(String[] args) {

        final int final1 = 10;
        int final2 = 20;
        int final3 = 30;

        Runnable anonymous = new Runnable() {
            @Override
            public void run() {
                System.out.println("[익명 클래스] final1: " + final1);
                System.out.println("[익명 클래스] final2: " + final2);
//                System.out.println("[익명 클래스] final3: " + final3);
            }
        };

        Runnable lambda = () -> {
            System.out.println("[람다] final1: " + final1);
            System.out.println("[람다] final2: " + final2);
//            System.out.println("[람다] final3: " + final3);
        };

        final3++; // 사실상 final X

        anonymous.run();
        lambda.run();
    }
}
