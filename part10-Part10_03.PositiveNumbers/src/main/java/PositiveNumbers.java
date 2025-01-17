
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        while (true) {
            String row = scanner.nextLine();
            if (row.equals("end")) {
                break;
            }

            list.add(Integer.valueOf(row));          
        }
        List<Integer> listOfPositives = positive(list);
            
        for (Integer positive: listOfPositives) {
            System.out.println(positive);
        }
    }
    
    public static List<Integer> positive(List<Integer> numbers) {
        List<Integer> positives = numbers.stream()
                .filter(i -> i > 0)
                .collect(Collectors.toList());
                
        return positives;
    }

}
