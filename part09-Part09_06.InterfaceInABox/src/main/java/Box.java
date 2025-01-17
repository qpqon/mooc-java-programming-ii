
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
public class Box implements Packable {
    private final double maxCapacity;
    private ArrayList<Packable> items;

    public Box(double maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.items       = new ArrayList<>();
    }
    
    public void add(Packable packable) {
        if (packable.weight() + this.weight() <= this.maxCapacity) {
            this.items.add(packable);
        }
    }
    
    @Override
    public double weight() {
        double weight = 0;
        for (Packable thing: items) {
            weight += thing.weight();
        }
        return weight;
    }

    @Override
    public String toString() {
        return "Box: "  + this.items.size() + " items, total weight " + this.weight() + " kg";
    }
    
    
}
