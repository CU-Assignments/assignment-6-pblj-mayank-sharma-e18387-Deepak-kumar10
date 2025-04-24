
import java.util.*;

class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}

public class EmployeeSorting {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, 70000),
            new Employee("Bob", 25, 50000),
            new Employee("Charlie", 35, 60000)
        );

        System.out.println("Sorted by Name:");
        employees.stream()
                 .sorted(Comparator.comparing(Employee::getName))
                 .forEach(System.out::println);

        System.out.println("\nSorted by Age:");
        employees.stream()
                 .sorted(Comparator.comparing(Employee::getAge))
                 .forEach(System.out::println);

        System.out.println("\nSorted by Salary:");
        employees.stream()
                 .sorted(Comparator.comparing(Employee::getSalary))
                 .forEach(System.out::println);
    }
}
