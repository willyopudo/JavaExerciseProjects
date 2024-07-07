package com.demos.learn.codealpha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ExamStatistics {
    public static void calculateStats(ArrayList<int[]> studentMarksList){
        int subject1Sum = 0;
        int subject2Sum = 0;
        int subject1HighestMark = 0;
        int totalMarks = 0;
        int subject1LowestMark = Integer.MAX_VALUE;
        for (int[] studentMarks : studentMarksList) {
            System.out.println(Arrays.toString(studentMarks));
            subject1Sum += studentMarks[0];
            subject2Sum += studentMarks[1];

            if(studentMarks[0] >subject1HighestMark){
                subject1HighestMark = studentMarks[0];
            }
            if(studentMarks[0] < subject1LowestMark){
                subject1LowestMark = studentMarks[0];

            }
            for (int studentMark : studentMarks) {
                totalMarks += studentMark;
            }

        }
        int numberOfEntries = studentMarksList.size() * studentMarksList.getFirst().length;
        double subject1Avg =  subject1Sum / (studentMarksList.size() * 1.0);
        double subject2Avg =  subject2Sum / (studentMarksList.size() * 1.0);
        double meanScore = totalMarks / (numberOfEntries * 1.0);
        System.out.println("The average the first subject is " + subject1Avg);
        System.out.println("The average the second subject is " + subject2Avg);
        System.out.println("The highest mark for subject 1 is " + subject1HighestMark);
        System.out.println("The lowest mark for subject 1 is " + subject1LowestMark);
        System.out.println("The mean score for all the subjects is " + meanScore);

    }


    public static void main(String[] args) {
        ArrayList<int[]> studentMarksList = new ArrayList<>();
        String studentsMarks;
        int numberOfSubjects = 3;
        int numberOfStudents = 3;
        int i = 1;
        while (i <= numberOfStudents) {
            int[] studentMarksArray;

            Scanner scanner = new Scanner(System.in);
            System.out.println("Input student " + i + " marks in comma separated format e.g 21,45,23");
            studentsMarks = scanner.nextLine();
            if (studentsMarks.isEmpty()) {
                System.out.println("Please provide correct marks for student " + i);
                i--;
            }
            else {
                System.out.println("Marks for student " + i + " = " + studentsMarks);
                try {
                    studentMarksArray = Arrays.stream(studentsMarks.split(",")).mapToInt(Integer::parseInt).toArray();
                    if (studentMarksArray.length != numberOfSubjects) {
                        System.out.println("Please enter marks for " + numberOfSubjects + " subjects for student " + i);
                        i--;
                    }
                    else {
                        studentMarksList.add(studentMarksArray);
                    }

                } catch (Exception e) {
                    System.out.println("An error occurred. " + e.toString());
                    i--;
                }

            }
            i++;

        }
        calculateStats(studentMarksList);

    }

}
