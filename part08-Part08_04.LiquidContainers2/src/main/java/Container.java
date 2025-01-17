
/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class Container {
    private int liquid;
    
    public Container() {
        this.liquid = 0;
    }
    
    public void add(int amount) {
        if (amount > 0) {
        this.liquid = Math.min((this.liquid + amount), 100);
        }
    }
    
    public void remove(int amount) {
        if (amount > 0) {
        this.liquid = Math.max((this.liquid - amount), 0);
        }
    }
    
    public int contains() {
        return this.liquid;
    }
    
    @Override
    public String toString() {
        return this.liquid + "/100";
    }
}
