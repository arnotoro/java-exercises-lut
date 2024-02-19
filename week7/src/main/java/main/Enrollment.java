package main;

public class Enrollment {
    int grade;
    Course course;
    Student student;

    public Enrollment(Course course, Student student) {
        this.grade = -1;
        this.course = course;
        this.student = student;
    }

    public void gradeCourse(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return this.grade;
    }

    public Student getStudent() {
        return this.student;
    }

    public Course getCourse() {
        return this.course;
    }
}