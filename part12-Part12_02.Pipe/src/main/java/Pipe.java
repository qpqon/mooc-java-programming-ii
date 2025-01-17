
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
public class Pipe<T> {
    ArrayList<T> pipe;
    
    public Pipe() {
        this.pipe = new ArrayList<>();
    }
    
    public void putIntoPipe(T value) {
        this.pipe.add(value);
    }
    
    public T takeFromPipe() {
        if (this.pipe.isEmpty()) {
            return null;
        }       
        T copy = this.pipe.get(0);
        this.pipe.remove(0);
        return copy;
    }
    
    public boolean isInPipe() {
        return !this.pipe.isEmpty();
    }
}
