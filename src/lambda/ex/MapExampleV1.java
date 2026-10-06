package lambda.ex;

import java.util.ArrayList;
import java.util.List;

public class MapExampleV1 {

    public static List<String> map(List<String> list, StringFunction func) {
        List<String> result = new ArrayList<>();
        for (String str : list) {
            result.add(func.apply(str));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> words = List.of("hello", "java", "lambda");
        System.out.println("원본 리스트: " + words);

        List<String> upperList = map(words, new StringFunction() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        });
        System.out.println("대문자 변환 결과: " + upperList);

        List<String> decoratedList = map(words, new StringFunction() {
            @Override
            public String apply(String s) {
                return "***" + s + "***";
            }
        });
        System.out.println("특수문자 데코 결과: " + decoratedList);
    }
    /*
    원본 리스트: [hello, java, lambda]
    대문자 변환 결과: [HELLO, JAVA, LAMBDA]
    특수문자 데코 결과: [***hello***, ***java***, ***lambda***]
    */
}
