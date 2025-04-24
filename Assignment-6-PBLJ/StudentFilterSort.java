
import java.util.*;
import java.util.stream.*;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() { return name; }
    public double getMarks() { return marks; }
}

public class StudentFilterSort {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("John", 85),
            new Student("Jane", 65),
            new Student("Tom", 78),
            new Student("Lucy", 90)
        );

        System.out.println("Students scoring above 75% sorted by marks:");
        students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted(Comparator.comparing(Student::getMarks))
                .forEach(s -> System.out.println(s.getName() + ": " + s.getMarks()));
    }
}
