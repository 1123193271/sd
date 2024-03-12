package com.study.xyl._16_streamExample;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "Sales", 6000),
                new Employee("Bob", "Sales", 5000),
                new Employee("Charlie", "HR", 5500),
                new Employee("David", "HR", 6500),
                new Employee("Ella", "IT", 7500),
                new Employee("Frank", "IT", 7000),
                new Employee("Grace", "HR", 4500)
        );

        List<Employee> highPaidEmployees = employees.stream()
                .filter(e -> e.getSalary() > 5000).collect(Collectors.toList());
        System.out.println("高薪员工：");
        highPaidEmployees.forEach(System.out::println);

        Map<String, DoubleSummaryStatistics> statsByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summarizingDouble(Employee::getSalary)));

        System.out.println("按部门统计：");
        statsByDepartment.forEach((department, stats) -> {
            System.out.printf("%s：平均薪水 %.2f，员工数量 %d\n",
                    department, stats.getAverage(), stats.getCount());
        });


        List<Employee> sortedEmployees = employees.stream()
                .filter(e -> e.getSalary() > 5000)
                .sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()))
                .collect(Collectors.toList());

        System.out.println("按薪水从高到低排序：");
        sortedEmployees.forEach(System.out::println);
    }
}

@Data
class Employee {
    private String name;
    private String department;
    private int salary;

    public Employee(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}
