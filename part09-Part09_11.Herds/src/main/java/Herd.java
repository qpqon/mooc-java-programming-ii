
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
public class Herd implements Movable {
    private ArrayList<Movable> herd;
    
    public Herd() {
        this.herd = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Movable organism: herd) {
            builder.append(organism.toString() + "\n");
        }
        return builder.toString();
    }
    
    public void addToHerd(Movable movable) {
        herd.add(movable);
    }
    
    @Override
    public void move(int dx, int dy) {
        for (Movable organism: herd) {
            organism.move(dx, dy);
        }
    }
}
