
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {
    private ArrayList<Integer> numbers;

    public LotteryRow() {
        // Draw the numbers when the LotteryRow is created
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        // Initialize the list for numbers
        this.numbers  = new ArrayList<>();
        Random random = new Random();
        
        while (numbers.size() != 7) {
            int number = random.nextInt(40) + 1;
            if (!containsNumber(number)) {
                this.numbers.add(number);
            }
        }
    }

    public boolean containsNumber(int number) {
        return this.numbers.contains(number);
    }
}

