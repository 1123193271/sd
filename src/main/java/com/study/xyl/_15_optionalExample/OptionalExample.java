package com.study.xyl._15_optionalExample;

import lombok.Data;
import lombok.Getter;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Student student = new Student(12);
//        Student student = new Student();
//        Student student = null;
        Optional<Student> optionalStudent = Optional.ofNullable(student);
        optionalStudent.ifPresent(o -> o.setAge(5));
        Integer i = optionalStudent.map(Student::getAge).orElseGet(() -> Integer.MAX_VALUE);
        Integer i1 = optionalStudent.filter(f -> f.getAge() < 13).map(Student::getAge).orElseGet(() -> 2);
        Optional<Student> empty = Optional.empty();
//        empty.get();//报错
//        empty.orElseThrow(() -> new RuntimeException("dsdsdsdss"));


        Integer i2 = empty.map(Student::getAge).orElseGet(() -> 1);
        System.out.println(i1);
        System.out.println(i2);

        Person person = new Person();
        Optional<Person> optionalPerson = Optional.ofNullable(person);

        Optional<String> s = optionalPerson.map(Person::getStudent).map(Student::getCar).map(Student.Car::getName);
        optionalPerson.flatMap(value -> Optional.ofNullable(value.getStudent()));
        System.out.println(s.get());
    }
}

@Data
class Person {
    private Student student = new Student(2);
}

@Getter
class Student {
    private int age;

    private Car car = new Car("dsds");

    public Student(int age) {
        this.age = age;
    }

    public Student() {
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Data
    class Car {
        String name;

        public Car(String name) {
            this.name = name;
        }
    }
}

