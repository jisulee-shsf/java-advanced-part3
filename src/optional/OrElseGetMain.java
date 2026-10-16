package optional;

import java.util.Optional;
import java.util.Random;

public class OrElseGetMain {

    public static void main(String[] args) {
        Optional<Integer> optValue = Optional.of(100);
        Optional<Integer> optEmpty = Optional.empty();

        // 단순 계산
        Integer value1 = optValue.orElse(10 + 20);
        System.out.println(value1); // 100

        Integer empty1 = optEmpty.orElse(10 + 20);
        System.out.println(empty1); // 30

        // 문제 발생 - orElse()
        System.out.println("1-1. optValue - 값이 있는 경우");
        Integer value2 = optValue.orElse(createData());
        System.out.println("value2 = " + value2);

        System.out.println("1-2. optEmpty - 값이 없는 경우");
        Integer empty2 = optEmpty.orElse(createData());
        System.out.println("empty2 = " + empty2);
        /*
        1-1. optValue - 값이 있는 경우
        값 생성 시작
        값 생성 완료: 77 -> 값 버림
        value2 = 100

        1-2. optEmpty - 값이 없는 경우
        값 생성 시작
        값 생성 완료: 44
        empty2 = 44
         */

        // 문제 해결 - orElseGet()
        System.out.println("2-1. optValue - 값이 있는 경우");
        Integer value3 = optValue.orElseGet(() -> createData());
        System.out.println("value3 = " + value3);

        System.out.println("2-2. optEmpty - 값이 없는 경우");
        Integer empty3 = optEmpty.orElseGet(() -> createData());
        System.out.println("empty3 = " + empty3);
        /*
        2-1. optValue - 값이 있는 경우
        value3 = 100

        2-2. optEmpty - 값이 없는 경우
        값 생성 시작
        값 생성 완료: 62
        empty3 = 62
        */
    }

    private static int createData() {
        System.out.println("값 생성 시작");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int createValue = new Random().nextInt(100);
        System.out.println("값 생성 완료: " + createValue);
        return createValue;
    }
}
