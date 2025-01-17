
/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class List<Type> {
    private Type[] list;
    private int firstFreeIndex;
    
    public List() {
        this.list = (Type[]) new Object[10];
        this.firstFreeIndex = 0;
    }
    
    public List(int size) {
        this.list = (Type[]) new Object[size];
        this.firstFreeIndex = 0;
    }
    
    private void grow() {
        int newLength = this.list.length + this.list.length / 2;
        Type[] newList = (Type[]) new Object[newLength];
        for (int i = 0; i < list.length; i++) {
            newList[i] = this.list[i];
        }
        this.list = newList;
    }
    
    public void add(Type value) {
        if (this.firstFreeIndex == this.list.length) {
            grow();
        }
        this.list[this.firstFreeIndex] = value;
        this.firstFreeIndex++;
    }
    
    public void remove(Type value) {
        int index = indexOfValue(value);
        if (index < 0) {
            System.out.println("No such value in the list");
            return;
        }
        moveToTheLeft(index);
        this.firstFreeIndex--;        
    }
    
    public boolean contains(Type value) {
        return indexOfValue(value) >= 0;
    }
    
    public Type valueAt(int index) {
        if (index < 0 || index >= this.firstFreeIndex) {
            throw new IndexOutOfBoundsException("Index " + index + " outside of [0, " + this.firstFreeIndex + "]");
        }
        return this.list[index];
    }
    
    public int size() {
        return this.firstFreeIndex;
    }
    
    // helper for remove()
    private int indexOfValue(Type value) {
        for (int i = 0; i < this.firstFreeIndex; i++) {
            if (this.list[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }
    
    // helper for remove()
    private void moveToTheLeft(int fromIndex) {
        for (int i = fromIndex; i < this.firstFreeIndex - 1; i++) {
            this.list[i] = this.list[i + 1];
        }
    }
}
