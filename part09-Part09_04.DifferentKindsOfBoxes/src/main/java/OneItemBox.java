
/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class OneItemBox extends Box {
    private Item item;
    
    public OneItemBox() {
        this.item = new Item(null, 0);
    }

    @Override
    public void add(Item item) {
        if (this.item.getName() == null) {
            this.item = item;
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return this.item.equals(item);
    }
     
}
