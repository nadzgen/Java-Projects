package testScoreComparison;
import java.util.Scanner;

public class TestScoreComparison {
    public static void main(String[] args) {
        // Create a scanner object to get input from the user
        Scanner scanner = new Scanner(System.in);
        
        // Define the passing score
        int passingScore = 60;
        
        // Ask for the student's test score
        System.out.print("Enter the student's test score (out of 100): ");
        int score = scanner.nextInt();
        
        // Compare the student's score with the passing score
        if (score >= passingScore) {
            System.out.println("The student passed the test.");
        } else {
            System.out.println("The student did not pass the test.");
        }
        
        // Close the scanner
        scanner.close();
    }
}

