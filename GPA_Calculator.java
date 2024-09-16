/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gpa_calculator;

import java.util.Scanner;

public class GPA_Calculator {
        public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int totalPoints = 0;
        int totalCredits = 0;
        boolean moreClasses;

        do {
            int credits = 0;
            boolean validCredits;

            // Input validation for credits
            do {
                System.out.print("Enter number of credits: ");
                String creditsString = scanner.nextLine();
                try {
                    credits = Integer.parseInt(creditsString);
                    validCredits = true;
                } catch (NumberFormatException nfe) {
                    System.out.println("Please enter a valid integer for credits!");
                    validCredits = false;
                }
            } while (!validCredits);

            int gradeValue = 0;
            boolean validGrade;

            // Input validation for grade
            do {
                System.out.print("Enter Grade (A, B, C, D, F): ");
                String grade = scanner.nextLine();
                validGrade = true;

                switch (grade.toUpperCase()) {
                    case "A":
                        gradeValue = 4;
                        break;
                    case "B":
                        gradeValue = 3;
                        break;
                    case "C":
                        gradeValue = 2;
                        break;
                    case "D":
                        gradeValue = 1;
                        break;
                    case "F":
                        gradeValue = 0;
                        break;
                    default:
                        System.out.println("Please enter a valid grade (A, B, C, D, F)!");
                        validGrade = false;
                        break;
                }
            } while (!validGrade);

            // Calculate total points and credits
            int points = gradeValue * credits;
            totalPoints += points;
            totalCredits += credits;

            // Check if the user wants to enter another class
            System.out.print("Would you like to enter another class? (y/n): ");
            moreClasses = scanner.nextLine().equalsIgnoreCase("y");

        } while (moreClasses);

        // Calculate GPA
        double gpa = (double) totalPoints / totalCredits;

        // Display results
        System.out.println("Total Credits: " + totalCredits);
        System.out.println("Total Points: " + totalPoints);
        System.out.println("GPA: " + String.format("%.2f", gpa));

        scanner.close();
    }
}