
/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class CustomTacoBox implements TacoBox {
    private int tacos;
    
    public CustomTacoBox(int initialTacos) {
        this.tacos = initialTacos;
    }

    @Override
    public int tacosRemaining() {
        return this.tacos;
    }

    @Override
    public void eat() {
        if (this.tacos != 0) {
            this.tacos--;
        }
    }
    
    
}
