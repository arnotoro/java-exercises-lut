package main;

import java.util.ArrayList;

public class Gifu {
    private String university;
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private ArrayList<Enrollment> enrollments;

    public Gifu(String university) {
        this.university = university;
        this.courses = new ArrayList<Course>();
        this.students = new ArrayList<Student>();
        this.enrollments = new ArrayList<Enrollment>();
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public Course getCourse(int id) {
        return this.courses.get(id);
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }
    
    public void listCourses() {
        int index = 0;
        for (Course course : this.courses) {
            System.out.println(index + ") " + course.getInformation());
            index++;
        }
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public Student getStudent(int id) {
        return this.students.get(id);
    }

    public void listStudents() {
        int index = 0;
        for (Student student : this.students) {
            System.out.println(index + ") " + student.getInformation());
            index++;
        }
    }

    public void enrollStudent(Student student, Course course) {
        Enrollment enrollment = new Enrollment(course, student);
        this.enrollments.add(enrollment);
    }

    public ArrayList<Enrollment> getEnrollments(Course course) {
        ArrayList<Enrollment> enrollmentList = new ArrayList<Enrollment>();
        for (Enrollment enrollment : this.enrollments) {
            if (enrollment.getCourse() == course) {
                enrollmentList.add(enrollment);
            }
        }
        return enrollmentList;
    }

    public ArrayList<Enrollment> getEnrollments(Student student) {
        ArrayList<Enrollment> enrollmentList = new ArrayList<Enrollment>();
        for (Enrollment enrollment : this.enrollments) {
            if (enrollment.getStudent() == student) {
                enrollmentList.add(enrollment);
            }
        }
        return enrollmentList;
    }

}