import dto.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamApi {
    public static void main(String[] args) {
        List<Student> students = Stream.of(new Student(1, "Leo", 23, "Mechanical", "Aranthangi",
                        List.of("+919169790781", "+917373089461"), 1),
                new Student(2, "Alice", 22, "Mechanical", "Trichy",
                        List.of("+919876543210"), 2),
                new Student(3, "Bob", 24, "Mechanical", "Salem",
                        List.of("+918765432109"), 34),
                new Student(4, "Carol", 21, "Mechanical", "Namakkal",
                        List.of("+917654321098"), 54),
                new Student(5, "Eve", 25, "Electrical", "Salem",
                        List.of("+919999999999"), 11),
                new Student(6, "Frank", 23, "Electrical", "Trinelveli",
                        List.of("+918888888888"), 24),
                new Student(7, "Grace", 22, "Computer Science", "thoothukudi",
                        List.of("+917777777777"), 13),
                new Student(8, "Harry", 21, "Computer Science", "aranthangi",
                        List.of("+916666666666"), 21),
                new Student(9, "Dhurga", 24, "Civil", "Aranthangi",
                        List.of("+915555555555"), 92)).toList();


        //1.List out the student whose rank is 50 to 100
        List<Student> rankedList = students.stream()
                .filter(student -> student.getRank() > 50 && student.getRank() < 100)
                .toList();
//        System.out.println("student between given rank range========================="+rankedList);

        //2.find the students who is stayed in Aranthangi and sort them by their name.
        List<Student> arnthangiStudents=students.stream()
                .filter(student -> "Aranthangi".equalsIgnoreCase(student.getCity()))
                .sorted(Comparator.comparing(Student::getName))
                .toList();

        List<Student> reversedAranthangiStudents = students.stream()
                .filter(student -> "aranthangi".equalsIgnoreCase(student.getCity()))
                .sorted(Comparator.comparing(Student::getName, Comparator.reverseOrder()))
                .toList();
        System.out.println("Aranthangi students====================="+arnthangiStudents);
        System.out.println("reversed aranthangi students======================="+reversedAranthangiStudents);


        //3.find out the all the studens contacts numbers
        List<List<String>> contatctsOfStudents = students.stream()
                .map(student -> student.getContacts()).toList();
        System.out.println("contatct number for the all the sudents=============="+contatctsOfStudents);

        List<String> singletonresultOfContatcts = students.stream()
                .flatMap(student -> student.getContacts().stream())
                .distinct().toList();
        System.out.println("singleton numbers for the all the students==========="+singletonresultOfContatcts);


        //4.find out the all the department names
        List<String> departmentNames = students.stream()
                .map(Student::getDept)
                        .distinct().toList();
        System.out.println("the all the department names======================="+departmentNames);

        //5.Group the student by Department names
        Map<String, List<Student>> studentMap = students.stream()
                .collect(Collectors
                        .groupingBy(Student::getDept));
        System.out.println("students map======================================"+studentMap);

        //key as departments and count
        Map<String, Long> studentMapWithCounts = students.stream()
                .collect(Collectors.groupingBy(Student::getDept, Collectors.counting()));
        System.out.println("students maps with count==========================="+studentMapWithCounts);



        //6.find the departments which is having maximum number of students
        Map.Entry<String, Long> results = students.stream().collect(Collectors
                        .groupingBy(Student::getDept, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()).get();

        System.out.println("the results=========================="+results);


   //7 find the highest rank in each department.
        Map<String, Optional<Student>> highestRanks = students.stream()
                .collect(Collectors
                        .groupingBy(Student::getDept, Collectors.minBy(Comparator.comparing(Student::getRank))));

        System.out.println("highest rank in each department"+highestRanks);

        //8 findout the second highest rank from the all the college.

        Student secondHighestRankStudent = students.stream()
                .sorted(Comparator
                        .comparing(Student::getRank))
                    .distinct()
                     .skip(1)
                         .findFirst()
                            .get();

        System.out.println("second highest rank in the college============="+secondHighestRankStudent);

    }
}