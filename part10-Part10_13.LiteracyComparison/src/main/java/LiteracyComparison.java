
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        ArrayList<Data> listedData = new ArrayList<>();
        
        try {
            Files.lines(Paths.get("literacy.csv"))
            .map(row -> row.split(","))
            .map(parts -> new Data(parts[2].trim().replace(" (%)", ""), parts[3], Integer.parseInt(parts[4]), Double.parseDouble(parts[5])))
            .forEach(dataElement -> listedData.add(dataElement));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        listedData.stream()
                .sorted((a, b) -> Double.compare(a.getPoints(), b.getPoints()) )
                .forEach(row -> System.out.println(row.toString()));
    }
}
