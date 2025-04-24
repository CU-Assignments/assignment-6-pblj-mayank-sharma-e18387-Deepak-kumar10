
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

    @Override
    public String toString() {
        return "Student{name='" + name + "', marks=" + marks + "}";
    }
}

public class StudentFilter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Ravi", 72),
            new Student("Sneha", 85),
            new Student("Amit", 90),
            new Student("Pooja", 65)
        );

        students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted(Comparator.comparingDouble(Student::getMarks).reversed())
                .map(Student::getName)
                .forEach(System.out::println);
    }
}
