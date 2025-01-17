
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
public class Warehouse {
    private Map<String, Integer> prices;
    private Map<String, Integer> inventory;

    public Warehouse() {
        this.prices    = new HashMap<>();
        this.inventory = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock) {
        this.prices.put(product, price);
        this.inventory.put(product, stock);
    }
    
    public int price(String product) {
        return this.prices.getOrDefault(product, -99);
    }
    
    public int stock(String product) {
        return this.inventory.getOrDefault(product, 0);
    }
    
    public boolean take(String product) {
        if (inventory.containsKey(product) && inventory.get(product) > 0) {
            inventory.put(product, inventory.get(product) - 1);
            return true;
        }
        return false;
    }
    
    public Set<String> products() {
        return prices.keySet();
    }
}
