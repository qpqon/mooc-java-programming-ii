
import java.util.Scanner;



public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Checker check = new Checker();
        
        System.out.print("Enter a string: ");
        String day = scanner.nextLine();
        
        if (check.timeOfDay(day)) {
            System.out.println("The form is correct.");
        } else {
            System.out.println("The form is incorrect.");
        }
    }
}
