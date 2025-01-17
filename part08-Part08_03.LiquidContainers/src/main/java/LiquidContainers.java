
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first  = 0;
        int second = 0;
            
        while (true) {
            System.out.println("First: " + first + "/100");
            System.out.println("Second: " + second + "/100");

            String input = scanner.nextLine();
            if (input.equals("quit")) {
                break;
            }

            String[] parts = input.split(" ");
            String command = parts[0];
            int    amount  = Integer.parseInt(parts[1]);

            System.out.println();

            if (amount < 0) {
                continue;
            }

            switch (command) {
                case "add":
                    first = Math.min((first + amount), 100);
                    break;

                case "move":                       
                    int helper = Math.min(amount, first);
                    first -= helper;
                    second = Math.min((second + helper), 100);
                    break;

                case "remove":
                    second = Math.max((second - amount), 0);
            }
            
        }

        scanner.close();
    }
}
