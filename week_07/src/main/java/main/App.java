package main;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;


        System.out.println("Tervetuloa Gifu-järjestelmään");
        System.out.println("Mille yliopistolle haluat ottaa järjestelmän käyttöön?");

        String university = sc.nextLine();

        Gifu gifu = new Gifu(university);


        while (!exit) {
            System.out.println("1) Luo uusi kurssi, 2) Luo uusi opiskelija, 3) Listaa kurssit, 4) Listaa opiskelijat, 5) Lisää opiskelija kurssille" 
            + ", 6) Anna kurssiarvosanat, 7) Listaa kurssilla olevat opiskelijat, 8) Listaa opiskelijan arvosanat"
            + ", 9) Listaa kaikkien kurssien kaikkien opiskelijoiden arvosanat, 0) Lopeta ohjelma");

            if (sc.hasNext()) {
                int i = 0;
                String choice = sc.nextLine();
                i = Integer.parseInt(choice);

                switch(i) {
                    case 1:
                        System.out.println("Anna kurssin nimi:");
                        String courseName = sc.nextLine();
                        System.out.println("Anna kurssin ID:");
                        String courseId = sc.nextLine();
                        System.out.println("Anna kurssin maksimi opiskelijamäärä:");
                        String courseMaxStudents = sc.nextLine();
                        int intMaxStudents = Integer.parseInt(courseMaxStudents);

                        Course course = new Course(courseName, courseId, intMaxStudents);
                        gifu.addCourse(course);

                        break;
                    case 2:
                        System.out.println("Anna opiskelijan nimi:");
                        String studentName = sc.nextLine();
                        System.out.println("Anna opiskelijan opiskelijanumero:");
                        String studentId = sc.nextLine();

                        Student student = new Student(studentName, studentId);
                        gifu.addStudent(student);

                        break;
                    case 3:
                        gifu.listCourses();

                        break;
                    case 4:
                    
                        gifu.listStudents();

                        break;
                    case 5:
                        // lisää opiskelija kurssille
                        gifu.listCourses();

                        System.out.println("Mille kurssille haluat lisätä opiskelijan? Syötä kurssin numero:");
                        String courseNumber = sc.nextLine();
                        int intCourseNumber = Integer.parseInt(courseNumber);

                        gifu.listStudents();

                        System.out.println("Minkä opiskelijan haluat lisätä kurssille? Syötä opiskelijan numero:");
                        String studentNumber = sc.nextLine();
                        int intStudentNumber = Integer.parseInt(studentNumber);

                        gifu.enrollStudent(gifu.getStudent(intStudentNumber), gifu.getCourse(intCourseNumber));

                        break;
                    case 6:
                        // anna kurssiarvosanat
                        gifu.listCourses();

                        System.out.println("Minkä kurssin haluat arvostella? Syötä kurssin numero:");
                        String courseNumber2 = sc.nextLine();
                        int intCourseNumber2 = Integer.parseInt(courseNumber2);

                        ArrayList<Enrollment> enrollemnts = gifu.getEnrollments(gifu.getCourse(intCourseNumber2));

                        for (Enrollment e : enrollemnts) {
                            System.out.println("Anna arvosana opiskelijalle " + e.getStudent().getInformation());
                            String grade = sc.nextLine();
                            int intGrade = Integer.parseInt(grade);
                            e.gradeCourse(intGrade);
                        }

                        break;
                    case 7:
                        // listaa kurssilla olevat opiskelijat
                        gifu.listCourses();

                        System.out.println("Minkä kurssin opiskelijat haluat listata? Syötä kurssin numero:");
                        String courseNumber3 = sc.nextLine();
                        int intCourseNumber3 = Integer.parseInt(courseNumber3);

                        ArrayList<Enrollment> enrollemnts2 = gifu.getEnrollments(gifu.getCourse(intCourseNumber3));
                        int index2 = 0;

                        for (Enrollment e : enrollemnts2) {
                            System.out.println(index2 + ") " + e.getStudent().getInformation() + ", arvosana: " + e.getGrade());
                            index2++;
                        }

                        break;
                    case 8:
                        // listaa opiskelijan arvosanat
                        gifu.listStudents();

                        System.out.println("Minkä opiskelijan arvosanat haluat listata? Syötä opiskelijan numero:");
                        String studentNumber2 = sc.nextLine();
                        int intStudentNumber2 = Integer.parseInt(studentNumber2);

                        ArrayList<Enrollment> enrollemnts3 = gifu.getEnrollments(gifu.getStudent(intStudentNumber2));
                        
                        System.out.println("Opiskelijan " + gifu.getStudent(intStudentNumber2).getInformation() + " arvosanat:");

                        for (Enrollment e : enrollemnts3) {
                            System.out.println(e.getCourse().getInformation() + ", arvosana: " + e.getGrade());
                        }

                        break;
                    case 9:
                        // listaa kaikkien kurssien kaikkien opiskelijoiden arvosanat
                        ArrayList<Course> courses = gifu.getCourses();

                        for (Course c : courses) {
                            ArrayList<Enrollment> enrollemnts4 = gifu.getEnrollments(c);
                            System.out.println(c.getInformation());

                            for (Enrollment e : enrollemnts4) {
                                System.out.println(e.getStudent().getInformation() + ", arvosana: " + e.getGrade());
                            }
                        }

                        break;
                    case 0:
                        exit = true;
                        break;

                    default:
                        System.out.println("Syöte oli väärä");
                        break;
                }
            }
        }

        System.out.println("Kiitos ohjelman käytöstä.");
        sc.close();
    }
}