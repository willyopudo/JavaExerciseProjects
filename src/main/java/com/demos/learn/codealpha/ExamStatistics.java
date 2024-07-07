package com.demos.learn.codealpha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ExamStatistics {
    //Function to perform statistical operations on arrayList of students' marks
    public static void calculateStats(ArrayList<int[]> studentMarksList){
        //Declare variables to be incremented/decremented in loop
        int subject1Sum = 0;
        int subject2Sum = 0;
        int subject1HighestMark = 0;
        int totalMarks = 0;
        int subject1LowestMark = Integer.MAX_VALUE;

        //Iterate over all arrays in the List
        for (int[] studentMarks : studentMarksList) {
            //Print for verification only
            System.out.println(Arrays.toString(studentMarks));

            //Increment sum for Subject 1
            subject1Sum += studentMarks[0];

            //Increment sum for Subject 2
            subject2Sum += studentMarks[1];

            //Increment Highest Mark for Subject 1
            if(studentMarks[0] >subject1HighestMark){
                subject1HighestMark = studentMarks[0];
            }
            //Decrement Highest Mark for Subject 1
            if(studentMarks[0] < subject1LowestMark){
                subject1LowestMark = studentMarks[0];

            }
            //Cumulate all entries to get total marks
            for (int studentMark : studentMarks) {
                totalMarks += studentMark;
            }

        }

        //Compute subject average. We need to convert operator to double by multiplying by 1.0
        double subject1Avg =  subject1Sum / (studentMarksList.size() * 1.0);
        double subject2Avg =  subject2Sum / (studentMarksList.size() * 1.0);

        //Compute mean score
        int numberOfEntries = studentMarksList.size() * studentMarksList.getFirst().length;
        double meanScore = totalMarks / (numberOfEntries * 1.0);

        //Print out stats to console
        System.out.println("The average the first subject is " + subject1Avg);
        System.out.println("The average the second subject is " + subject2Avg);
        System.out.println("The highest mark for subject 1 is " + subject1HighestMark);
        System.out.println("The lowest mark for subject 1 is " + subject1LowestMark);
        System.out.println("The mean score for all the subjects is " + meanScore);

    }


    public static void main(String[] args) {
        //Declare variables
        ArrayList<int[]> studentMarksList = new ArrayList<>();
        String studentsMarks;
        int numberOfSubjects = 3; //limit number of subjects
        int numberOfStudents = 3; //limit number of students
        int i = 1;

        //Prompt user for subject marks for each student until we exhaust number of students set above
        while (i <= numberOfStudents) {
            int[] studentMarksArray;

            Scanner scanner = new Scanner(System.in);
            System.out.println("Input student " + i + " marks in comma separated format e.g 21,45,23");
            studentsMarks = scanner.nextLine();

            //If entered marks is empty, prompt user to repeat (by decrementing i)
            if (studentsMarks.isEmpty()) {
                System.out.println("Please provide correct marks for student " + i);
                i--;
            }
            //proceed to parse entered data
            else {
                System.out.println("Marks for student " + i + " = " + studentsMarks);
                //Wrap String to integer mapping in try block to check for any number format exceptions
                try {
                    studentMarksArray = Arrays.stream(studentsMarks.split(",")).mapToInt(Integer::parseInt).toArray();
                    //Check whether user entered marks same as number of subjects, if not, repeat
                    if (studentMarksArray.length != numberOfSubjects) {
                        System.out.println("Please enter marks for " + numberOfSubjects + " subjects for student " + i);
                        i--;
                    }
                    else {
                        //Add marks for student to arrayList
                        studentMarksList.add(studentMarksArray);
                    }

                } catch (Exception e) { //Catch exception, notify user and prompt to reenter marks
                    System.out.println("An error occurred. " + e.toString());
                    i--;
                }

            }
            i++;

        }
        //Call function to perform operations of our arrayList and print stuff.
        calculateStats(studentMarksList);

    }

}
