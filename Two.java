package loops;
import java.util.Scanner;

public class Two {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a character: ");
        char input = scanner.next().charAt(0);
        
        // Check the type of character input
        if (Character.isAlphabetic(input)) {
            System.out.println("The character is an alphabet.");
        } else if (Character.isDigit(input)) {
            System.out.println("The character is a digit.");
        } else {
            System.out.println("The character is a special character.");
        }
        
        scanner.close();
    }
}
	 
	   

	