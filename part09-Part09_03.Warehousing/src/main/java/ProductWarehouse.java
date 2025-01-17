
/**
 * This code is free to use, modify, and distribute under the MIT License.
 * See LICENSE file for details.
 * 
 * Course: https://java-programming.mooc.fi/
 *
 * @author Daniel Menke
 * 
 */
public class ProductWarehouse extends Warehouse {
    private String productName;
    
    public ProductWarehouse(String productName,double capacity) {
        super (capacity);
        this.productName = productName;
    }
    
    public String getName() {
        return this.productName;
    }
    
    public void setName(String newName) {
        this.productName = newName;
    }
    
    @Override
    public String toString() {
        return this.productName + ": " + super.toString();
    }
}
