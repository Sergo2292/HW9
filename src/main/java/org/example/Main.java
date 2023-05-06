package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Sergey", Arrays.asList(new Course("Java"), new Course("Java Core"),
                new Course("Excel"), new Course("Russian"))));
        students.add(new Student("Igor", Arrays.asList(new Course("Engineer"), new Course("Russian"),
                new Course("Excel"))));
        students.add(new Student("Alena", Arrays.asList(new Course("Economical"), new Course("SMM"),
                new Course("Mokshans"), new Course("Editor"))));
        System.out.println();
        // 1. Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты:
        System.out.println(students.stream()
                .map(s -> s.getAllCourses())
                .flatMap(c -> c.stream())
                .collect(Collectors.toSet()));
        System.out.println();
        // 2. Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных:
        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getAllCourses().size() - s1.getAllCourses().size())
                .limit(2)
                .collect(Collectors.toList()));
        System.out.println();
        // 3. Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов, которые посещают этот курс:
        Course course = new Course("Excel");
        System.out.println(students.stream()
                .filter(s -> s.getAllCourses().contains(course))
                .collect(Collectors.toList()));
    }
}