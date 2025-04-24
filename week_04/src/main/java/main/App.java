package main;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        boolean exit = false;
        Scanner sc = new Scanner(System.in);

        University uni = new University();
        Calculator calculator = new Calculator();


        while (!exit) {
            System.out.println("1) Lisää opiskelija, 2) Listaa opiskelijat,"
            + " 3) Lisää opiskelijalle suorite, 4) Listaa opiskelijan suoritteet, "
            + " 5) Laske opiskelijan suoritusten keskiarvo, 6) Laske opiskelijan suoritusten mediaani,"
            + " 7) Tallenna opiskelijat tiedostoon, 8) Lataa opiskelijat tiedostosta, 0) Lopeta ohjelma");

            if (sc.hasNext()) {
                int selection = 0;

                selection = Integer.parseInt(sc.nextLine());

                switch(selection) {
                    case 1:
                        System.out.println("Anna opiskelijan nimi?");
                        String studentName = sc.nextLine();

                        System.out.println("Anna opiskelijan opiskelijanumero:");
                        String studentNumberString = sc.nextLine();
                        int studentNumber = Integer.parseInt(studentNumberString);

                        Student student = new Student(studentName, studentNumber);
                        uni.addStudent(student);
                        break;
                    case 2:
                        uni.listStudents();
                        break;
                    case 3:
                        uni.chooseStudent();
                        System.out.println("Mille opiskelijalle suorite lisätään?");
                        int studentID = Integer.parseInt(sc.nextLine());

                        System.out.println("Mille kurssille suorite lisätään?");
                        String course = sc.nextLine();

                        System.out.println("Mikä arvosana kurssille lisätään?");
                        int grade = Integer.parseInt(sc.nextLine());

                        uni.getStudent(studentID).addGrade(course, grade);
                        break;
                    case 4:
                        uni.chooseStudent();
                        System.out.println("Minkä opiskelijan suoritteet listataan?");
                        int studentID2 = Integer.parseInt(sc.nextLine());
                        uni.getStudent(studentID2).listGrades();
                        break;
                    case 5:
                        uni.chooseStudent();
                        System.out.println("Minkä opiskelijan suoritteiden keskiarvo lasketaan?");
                        int studentID3 = Integer.parseInt(sc.nextLine());

                        double average = calculator.getAverageGrade(uni.getStudent(studentID3));

                        System.out.println("Keskiarvo on " + average);
                        break;
                    case 6:
                        uni.chooseStudent();
                        System.out.println("Minkä opiskelijan suoritteiden mediaani lasketaan?");
                        int studentID4 = Integer.parseInt(sc.nextLine());

                        double median = calculator.getMedianGrade(uni.getStudent(studentID4));

                        System.out.println("Mediaani on " + median);
                        break;
                    case 7:
                        uni.saveStudentstoFile();
                        break;
                    case 8:
                        uni.loadStudentsfromFile();
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("Syöte oli väärä");
                }
            }
        }
        System.out.println("Kiitos ohjelman käytöstä.");
        sc.close();
    }
}
