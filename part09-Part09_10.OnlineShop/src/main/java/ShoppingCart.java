
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class ShoppingCart {
    private Map<String, Item> items;
    
    public ShoppingCart() {
        this.items = new HashMap<>();
    }
    
    public void add(String product, int price) {
        if (items.containsKey(product)) {
            items.get(product).increaseQuantity();
        } else {
            items.put(product, new Item(product, 1, price));
        }
    }
    
    public int price() {
        int total = 0;
        for (Item item: items.values()) {
            total += item.price();
        }
        return total;
    }
    
    public void print() {
        for (Item item: items.values()) {
            System.out.println(item);
        }
    }
}
