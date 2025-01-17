
/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class Hideout<T> {
    private T hideThis;
    
    public void putIntoHideout(T toHide) {
        this.hideThis = toHide;
    }
    
    public T takeFromHideout() {
        T copy = this.hideThis;
        this.hideThis = null;
        
        return copy;
    }
    
    public boolean isInHideout() {
        return this.hideThis != null;
    }
}
