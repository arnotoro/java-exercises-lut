package main;

import java.io.Serializable;
import java.util.LinkedHashMap;

public class Student implements Serializable {
    private LinkedHashMap<String, Integer> studentCourses;
    private String name;
    private int studentNumber;

    public Student(String name, int number) {
        this.name = name;
        this.studentNumber = number;
        this.studentCourses = new LinkedHashMap<String, Integer>();
    }

    public void addGrade(String course, int grade) {
        this.studentCourses.put(course, grade);
    }

    public void listGrades() {
        for (String course : this.studentCourses.keySet()) {
            System.out.println(course + ": " + this.studentCourses.get(course));
        }
    }

    public int getStudentNumber() {
        return this.studentNumber;
    }

    public String getName() {
        return this.name;
    }

    public LinkedHashMap<String, Integer> getGrade() {
        return this.studentCourses;
    }
}
