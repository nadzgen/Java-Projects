package array;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];
        
        
        //input
        System.out.println("Enter 10 integer values:");
        for (int i = 0; i < 10; i++) 
        {
            System.out.print("Enter value for index " + i + ": ");
            numbers[i] = scanner.nextInt();
        }
        
        
        //sort
        int[] sortedArray = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sortedArray);
        System.out.print("\nSorted Array in Ascending Order:");
        System.out.println(Arrays.toString(sortedArray));
        

        //search
        System.out.print("\nEnter a value to search for: ");
        int searchValue = scanner.nextInt();
        int searchIndex = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == searchValue) {
                searchIndex = i;
                break;
            }
        }
        if (searchIndex != -1) {
            System.out.println("Value " + searchValue + " found at index " + searchIndex);
        } else {
            System.out.println("Value " + searchValue + " is not present in the array.");
        }
        
        
        //reverse
        int[] reversedArray = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) 
        {
            reversedArray[i] = numbers[numbers.length - 1 - i];
        }
        System.out.print("\nReversed Array:");
        System.out.println(Arrays.toString(reversedArray));
        
        

        //insert
        System.out.print("\nEnter a value to insert: ");
        int newValue = scanner.nextInt();
        System.out.print("Enter the index to insert the value at (0-9): ");
        int insertIndex = scanner.nextInt();

        if (insertIndex >= 0 && insertIndex < numbers.length) {
            int[] modifiedArray = new int[numbers.length + 1]; 
            for (int i = 0, j = 0; i < modifiedArray.length; i++) {
                if (i == insertIndex) {
                    modifiedArray[i] = newValue; 
                } else {
                    modifiedArray[i] = numbers[j];
                    j++;
                }
            }
            System.out.print("\nArray after insertion:");
            System.out.println(Arrays.toString(modifiedArray));
            numbers = Arrays.copyOf(modifiedArray, modifiedArray.length);
        } else {
            System.out.println("Invalid index for insertion.");
        }

        
        //remove
        System.out.print("\nEnter the index of the element to remove (0-10): ");
        int removeIndex = scanner.nextInt();

        if (removeIndex >= 0 && removeIndex < numbers.length) {
            int[] modifiedArray = new int[numbers.length - 1]; 
            for (int i = 0, j = 0; i < numbers.length; i++) {
                if (i != removeIndex) {
                    modifiedArray[j++] = numbers[i];
                }
            }
            System.out.print("\nArray after removal:");
            System.out.println(Arrays.toString(modifiedArray));
            numbers = Arrays.copyOf(modifiedArray, modifiedArray.length);
        } else {
            System.out.println("Invalid index for removal.");
        }

        scanner.close();
    }
}