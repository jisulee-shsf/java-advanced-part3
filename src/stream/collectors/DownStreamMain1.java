package stream.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DownStreamMain1 {

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Kim", 1, 85),
                new Student("Park", 1, 70),
                new Student("Lee", 2, 70),
                new Student("Han", 2, 90),
                new Student("Hoon", 3, 90),
                new Student("Ha", 3, 89)
        );

        Map<Integer, List<Student>> collect1 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.toList() // 생략 가능
                ));
        System.out.println(collect1);
        /*
        {
        1=[Student{name='Kim', grade=1, score=85}, Student{name='Park', grade=1, score=70}],
        2=[Student{name='Lee', grade=2, score=70}, Student{name='Han', grade=2, score=90}],
        3=[Student{name='Hoon', grade=3, score=90}, Student{name='Ha', grade=3, score=89}]
        }
        */

        Map<Integer, List<String>> collect2 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.mapping(
                                Student::getName,
                                Collectors.toList())
                ));
        System.out.println(collect2); // {1=[Kim, Park], 2=[Lee, Han], 3=[Hoon, Ha]}

        Map<Integer, Long> collect3 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.counting()
                ));
        System.out.println(collect3); // {1=2, 2=2, 3=2}

        Map<Integer, Double> collect4 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.averagingInt(Student::getScore)
                ));
        System.out.println(collect4); // {1=77.5, 2=80.0, 3=89.5}
    }
}
