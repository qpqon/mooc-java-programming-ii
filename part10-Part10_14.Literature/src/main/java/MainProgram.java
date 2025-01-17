
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        
        while (true) {
            System.out.print("Input the name of the book, empty stops: ");
            String bookName = scanner.nextLine();
            if (bookName.isEmpty()) {
                break;
            }
            
            System.out.print("Input the age recommendation: ");
            int age = Integer.parseInt(scanner.nextLine()); 
            System.out.println();
            
            books.add(new Book(bookName, age));
        }
        
        System.out.println(books.size() + " books in total\n");                
        System.out.println("Books:");
        books.stream()
                .sorted(Comparator
                        .comparingInt(Book::getAge)
                        .thenComparing(Book::getName))
                .forEach(book -> System.out.println(book.toString()));
    }

}
