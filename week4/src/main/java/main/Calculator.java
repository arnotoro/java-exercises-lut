package main;

import java.util.Arrays;

public class Calculator {
    
    public Calculator() {

    }

    public double getAverageGrade(Student s) {
        if (s.getGrade().size() == 0) {
            return 0;
        } else {
            double sum = 0;
            for (String course : s.getGrade().keySet()) {
                sum += s.getGrade().get(course);
            };
            return sum / s.getGrade().size();
        }
    }

    public double getMedianGrade(Student s) {
        if (s.getGrade().size() == 0) {
            return 0;
        } else if (s.getGrade().size() % 2 == 1) {
            int[] grades = new int[s.getGrade().size()];
            int i = 0;

            for (String course : s.getGrade().keySet()) {
                grades[i] = s.getGrade().get(course);
                i++;
            }

            Arrays.sort(grades);

            int medianIdx = grades.length / 2;
            return grades[medianIdx];
            

        } else {
            int[] grades = new int[s.getGrade().size()];
            int i = 0;

            for (String course : s.getGrade().keySet()) {
                grades[i] = s.getGrade().get(course);
                i++;
            }
            Arrays.sort(grades);

            int medianIdx = grades.length / 2;
            return (grades[medianIdx] + grades[medianIdx - 1]) / 2.0;

        }
    }
}
