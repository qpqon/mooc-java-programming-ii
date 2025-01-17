
import java.util.ArrayList;

/**
 * This code is free to use, modify, and distribute under the MIT License.
 * See LICENSE file for details.
 * 
 * Course: https://java-programming.mooc.fi/
 *
 * @author Daniel Menke
 * 
 */
public class ChangeHistory {
    private ArrayList<Double> history;
    
    public ChangeHistory() {
        this.history = new ArrayList<>();
    }
    
    public void add(double status) {
        this.history.add(status);
    }
    
    public void clear() {
        this.history.clear();
    }
    
    @Override
    public String toString() {
        return this.history.toString();
    }
    
    public double maxValue() {
        if (this.history.isEmpty()) {
            return 0;
        }
        
        double maxValue = this.history.get(0);
        for (Double d: this.history) {
            maxValue = Math.max(d, maxValue);
        }
        return maxValue;
    }
    
    public double minValue() {
        if (this.history.isEmpty()) {
            return 0;
        }
        
        double minValue = this.history.get(0);
        for (Double d: this.history) {
            minValue = Math.min(d, minValue);
        }
        return minValue;
    }
    
    public double average() {
        if (this.history.isEmpty()) {
            return 0;
        }
        
        double sum = 0;
        for (Double d: this.history) {
            sum += d;
        }
        return sum / this.history.size();
    }
}
