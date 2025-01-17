
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        
        while (true) {
            int number = scanner.nextInt();
            if (number == -1) {
                break;
            }
            
            list.add(number);
        }
        
        list.stream()
                .filter(i -> i > 0 && i <= 5)
                .forEach(i -> System.out.println(i));
    }
}
