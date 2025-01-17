
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
public class BoxWithMaxWeight extends Box {
    private final int maxCapacity;
    private int boxWeight;
    private ArrayList<Item> items;
    
    public BoxWithMaxWeight(int capacity) {
        this.maxCapacity = capacity;
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        if ((this.boxWeight + item.getWeight()) <= this.maxCapacity) {
            this.items.add(item);
            this.boxWeight += item.getWeight();
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return this.items.contains(item);
    }
    
    
}
