package main;

public class Course implements PrintInfo {
    private int maxNumberOfStudents;
    private String name;
    private String id;


    public Course(String name, String id, int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.name = name;
        this.id = id;
    }

    public String getInformation() {
        return this.id + " " + this.name;
    }
}