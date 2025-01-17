
/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class Organism implements Movable {
    private int x;
    private int y;
    
    public Organism(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "x: " + this.x + "; y: " + this.y;
    }
    
    @Override
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
}
