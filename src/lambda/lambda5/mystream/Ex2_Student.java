package lambda.lambda5.mystream;

import lambda.lambda5.filter.GenericFilter;
import lambda.lambda5.map.GenericMapper;

import java.util.ArrayList;
import java.util.List;

public class Ex2_Student {

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("A", 100),
                new Student("B", 80),
                new Student("C", 50),
                new Student("D", 40)
        );

        List<String> result1 = direct(students);
        System.out.println(result1); // [A, B]

        List<String> result2 = lambda(students);
        System.out.println(result2); // [A, B]
    }

    private static List<String> direct(List<Student> students) {
        List<String> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getScore() >= 80) {
                result.add(student.getName());
            }
        }
        return result;
    }

    private static List<String> lambda(List<Student> students) {
        List<Student> result = GenericFilter.filter(students, s -> s.getScore() >= 80);
        return GenericMapper.map(result, s -> s.getName());
    }
}
