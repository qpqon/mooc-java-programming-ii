
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> myList = new List<>();
        
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.add(7);
        myList.add(8);
        myList.add(9);
        myList.add(10);
        myList.add(11);
        myList.add(12);

        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.value(i));
        }
        
        System.out.println("\n====\n");
        myList.remove(9);
        
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.value(i));
        }
    }

}
