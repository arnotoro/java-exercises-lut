package main;

import java.util.ArrayList;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;


public class University implements Serializable {
    private ArrayList<Student> students;
    final private String FILENAME;

    public University() {
        this.students = new ArrayList<Student>();
        this.FILENAME = "students.data";
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void listStudents() {
        System.out.println("Opiskelijat:");
        for (Student student : this.students) {
            System.out.println(student.getStudentNumber() + ": " + student.getName());
        }
    }

    public void chooseStudent() {
        int i = 0;

        for (Student student : this.students) {
            System.out.println(i + ": " + student.getName());
            i++;
        }
    }

    public Student getStudent(int id) {
        return this.students.get(id);
    }

    public void saveStudentstoFile() {
        try {
            ObjectOutputStream studentWriter = new ObjectOutputStream(new FileOutputStream(FILENAME));
            studentWriter.writeObject(this.students);
            studentWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadStudentsfromFile() {
        try {
            ObjectInputStream studentReader = new ObjectInputStream(new FileInputStream(FILENAME));
            this.students = (ArrayList<Student>) studentReader.readObject();
            studentReader.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
