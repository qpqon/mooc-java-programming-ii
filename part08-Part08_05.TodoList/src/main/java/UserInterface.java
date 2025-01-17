
import java.util.Scanner;


/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class UserInterface {
    private TodoList todo;
    private Scanner scanner;
    
    public UserInterface(TodoList todo, Scanner scanner) {
        this.todo = todo;
        this.scanner = scanner;
    }
    
    public void start() {
        while (true) {
            System.out.print("Command: ");
            String command = this.scanner.nextLine();
            if (command.equals("stop")) {
                break;
            }
            
            switch (command) {
                case "add":
                    System.out.print("To add: ");
                    String task = this.scanner.nextLine();
                    
                    this.todo.add(task);
                    break;
                    
                case "list":
                    this.todo.print();
                    break;
                    
                case "remove":
                    System.out.print("Which one is removed? ");
                    int number = this.scanner.nextInt();
                    
                    this.todo.remove(number);
                    break;
            }
        }
    }
}
