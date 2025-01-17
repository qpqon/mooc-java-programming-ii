
/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class Item {
    private String name;
    private int qty;
    private int price;
    
    public Item(String product, int qty, int unitPrice) {
        this.name  = product;
        this.qty   = qty;
        this.price = unitPrice;
    }
    
    public int price() {
        return qty * price;
    }
    
    public void increaseQuantity() {
        this.qty++;
    }
    
    @Override
    public String toString() {
        return this.name + ": " + this.qty;
    }
}
