
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner   scanner   = new Scanner(System.in);
        Container first  = new Container();
        Container second = new Container();

        while (true) {
            System.out.println("First: " + first);
            System.out.println("Second: " + second);

            String input = scanner.nextLine();
            if (input.equals("quit")) {
                break;
            }

            String[] parts = input.split(" ");
            String command = parts[0];
            int    amount  = Integer.parseInt(parts[1]);

            System.out.println();

            switch (command) {
                case "add":
                    first.add(amount);
                    break;

                case "move":   
                    if (amount > 0) {
                        int moveAmount = Math.min(amount, first.contains());
                        first.remove(moveAmount);
                        second.add(moveAmount);
                        break;
                    }
                    
                case "remove":
                    second.remove(amount);
            }            
        }

        scanner.close();
    }

}
