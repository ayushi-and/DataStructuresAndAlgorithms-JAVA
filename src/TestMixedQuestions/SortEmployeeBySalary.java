package TestMixedQuestions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortEmployeeBySalary {

    public static void main(String[] args) {
        Employee emp1 = new Employee("Employee1", 7000D, "code1");
        Employee emp2 = new Employee("Employee2", 3000D, "code2");
        Employee emp3 = new Employee("Employee3", 10000D, "code3");


        List<Employee> list = new ArrayList<>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);

        List<String> list1 = new ArrayList<>();
        list1.add("AA");
        list1.add("BB");
        list1.add("AB");
        list1.add("BA");
        list1.add("CC");

        list1.stream().filter(str -> !str.startsWith("B")).map(s -> s.toLowerCase()).forEach(System.out::println);

        list1.stream().filter(str -> !str.startsWith("B")).map(String::toLowerCase).forEach(System.out::println);

        List<Employee> res = list.stream().sorted(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.getSalary().compareTo(o1.getSalary());
            }
        }).collect(Collectors.toList());

        /*List<Employee> res = list.stream().sorted(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary().compareTo(o2.getSalary());
            }
        }).collect(Collectors.toList());*/

        List<Employee> result = list.stream().sorted((o1, o2) -> o1.getSalary().compareTo(o2.getSalary())).collect(Collectors.toList());

        System.out.println(result);

        List<Employee> resOptimized = list.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());

        System.out.println(resOptimized);

    }
}
