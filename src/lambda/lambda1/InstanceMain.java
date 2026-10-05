package lambda.lambda1;

import lambda.Procedure;

public class InstanceMain {

    public static void main(String[] args) {
        Procedure procedure1 = new Procedure() {
            @Override
            public void run() {
                System.out.println("hello lambda");
            }
        };

        System.out.println(procedure1.getClass());
        System.out.println(procedure1);
        /*
        class lambda.lambda1.InstanceMain$1
        lambda.lambda1.InstanceMain$1@2acf57e3
        */

        Procedure procedure2 = () -> {
            System.out.println("hello lambda");
        };

        System.out.println(procedure2.getClass());
        System.out.println(procedure2);
        /*
        class lambda.lambda1.InstanceMain$$Lambda/0x00000008000c2618
        lambda.lambda1.InstanceMain$$Lambda/0x00000008000c2618@96532d6
        */
    }
}
