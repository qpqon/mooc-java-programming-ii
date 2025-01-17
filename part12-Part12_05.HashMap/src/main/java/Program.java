
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        HashMap<String, String> map = new HashMap<>();
        
        map.add("eins", "zwei");
        map.add("drei", "4");
        map.add("fünf", "5");
        map.add("sieben", "6");
        map.add("neun", "56");
        map.add("elf", "765");
        map.add("dreizehn", "56");
        map.add("15", "34");
        map.add("17", "5");
        map.add("19", "9");
        map.add("21", "89");
        map.add("23", "ß0");
        map.add("25", "567");
        map.add("27", "56");
        map.add("29", "76");
        map.add("31", "45");
        map.add("33", "65");
        
        System.out.println(map.get("drei"));
        System.out.println(map.get("33"));
        System.out.println(map.get("dreizehn"));
        System.out.println(map.get("27"));
        map.remove("27");
        System.out.println(map.get("27"));
    }

}
