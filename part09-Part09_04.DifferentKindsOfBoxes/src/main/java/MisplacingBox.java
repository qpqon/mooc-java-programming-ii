
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
public class MisplacingBox extends Box {
    private ArrayList<Item> items;
    
    public MisplacingBox() {
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public boolean isInBox(Item item) {
        return false;
    }
    
    
}
