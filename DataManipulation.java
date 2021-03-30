import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataManipulation {

  protected static class Employee {

    public final String name;
    public final Integer age;
    public final String jobTitle;
    public final Float salary;

    public Employee(String name, Integer age, String jobTitle, Float salary) {
      this.name = name;
      this.age = age;
      this.jobTitle = jobTitle;
      this.salary = salary;
    }

    @Override
    public String toString() {
      return (
        "Employee{" +
        "name='" +
        name +
        '\'' +
        ", age=" +
        age +
        ", jobTitle='" +
        jobTitle +
        '\'' +
        ", salary=" +
        salary +
        '}'
      );
    }
  }

  public static void main(String[] args) {
    Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    List<Integer> numbers = new ArrayList<>(Arrays.asList(intArray));

    String[] wordsArr = { "hello", "data", "science", "is", "cool" };
    List<String> words = new ArrayList<>(Arrays.asList(wordsArr));

    Employee[] employeesArr = {
      new Employee("John", 34, "developer", 80000f),
      new Employee("Hannah", 24, "developer", 95000f),
      new Employee("Bart", 50, "sales executive", 100000f),
      new Employee("Sophie", 49, "construction worker", 40000f),
      new Employee("Darren", 38, "writer", 50000f),
      new Employee("Nancy", 29, "developer", 75000f),
    };
    List<Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));

    List<Integer> doubledNumbers = numbers
      .stream()
      .map(x -> x * 2)
      .collect(Collectors.toList());
    System.out.println(doubledNumbers);

    List<String> uppercasedWords = words
      .stream()
      .map(word -> word.toUpperCase())
      .collect(Collectors.toList());
    System.out.println(uppercasedWords);

    // Use map/filter/collect/sort to get a list of all the employees names who are over 30, sorted by salary
    List<String> employeeNames = employees
      .stream()
      .filter(employee -> employee.age > 30)
      .sorted((e1, e2) -> e1.salary.compareTo(e2.salary))
      .map(employee -> employee.name)
      .collect(Collectors.toList());
  }
}
