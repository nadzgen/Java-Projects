package array;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];

        
        System.out.println("Enter 10 integers: ");
        for (int i = 0; i < 10; i++) {
            numbers[i] = scanner.nextInt(); 
        }

        // Display the original array
        System.out.print("Original Array: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        int max = numbers[0];
        int min = numbers[0];
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 1; i < 10; i++) { 
            if (numbers[i] > max) {
                max = numbers[i];
                maxIndex = i;
            }
            if (numbers[i] < min) {
                min = numbers[i];
                minIndex = i;
            }
        }

        System.out.println("Maximum: " + max + "found at Index: " + maxIndex);
        System.out.println("Minimum: " + min + "found at Index: " + minIndex);

        
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += numbers[i];
        }
        double average = sum / 10.0;
        System.out.println("Average: " + average);

        
        int aboveAverage = 0;
        int belowAverage = 0;
        for (int i = 0; i < 10; i++) {
            if (numbers[i] > average) {
                aboveAverage++;
            } else if (numbers[i] < average) {
                belowAverage++;
            }
        }
        System.out.println("Numbers above average: " + aboveAverage);
        System.out.println("Numbers below average: " + belowAverage);

        scanner.close();
    }
}
