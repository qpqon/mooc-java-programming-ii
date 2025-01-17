


/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class HashMap<K, V> {
    private List<Pair<K, V>>[] outerArray; // Array of Lists, each containing Pairs of key-value (K, V) generics
    private int firstFreeIndex;
    
    public HashMap() {
        this.outerArray = new List[32];
        this.firstFreeIndex = 0;
    }
    
    public V get(K key) {
        int hashValue = Math.abs(key.hashCode() % this.outerArray.length);
        if (this.outerArray[hashValue] == null) {
            return null;
        }
        
        List<Pair<K, V>> innerArray = this.outerArray[hashValue];
        
        for (int i = 0; i < innerArray.size(); i++) {
            if (innerArray.valueAt(i).getKey().equals(key)) {
                return innerArray.valueAt(i).getValue();
            }
        }
        return null;
    }
    
    public void add(K key, V value) {        
        List<Pair<K, V>> innerArray = getListBasedOnKey(key);
        int index = getIndexOfKey(innerArray, key);
        
        if (index < 0) {
            innerArray.add(new Pair(key, value));
            this.firstFreeIndex++;
        } else {
            innerArray.valueAt(index).setValue(value);
        }
        
        if (1.0 * this.firstFreeIndex / this.outerArray.length > 0.75) {
            grow();
        }
    }
    
    public V remove(K key) {
        List<Pair<K, V>> innerArray = getListBasedOnKey(key);
        if (innerArray.size() == 0) {
            return null;
        }
        
        int index = getIndexOfKey(innerArray, key);
        if (index < 0) {
            return null;
        }
        
        Pair<K, V> pair = innerArray.valueAt(index);
        innerArray.remove(pair);
        return pair.getValue();
    }
    
    // helper for add()
    private void grow() {
        List<Pair<K, V>>[] newArray = new List[this.outerArray.length * 2];
        
        for (int i = 0; i < newArray.length; i++) {
            copy(newArray, i);
        }
        this.outerArray = newArray;
    }
    
    // helper for add() & remove()
    private List<Pair<K, V>> getListBasedOnKey(K key) { 
        int hashValue = Math.abs(key.hashCode() % this.outerArray.length);
        if (this.outerArray[hashValue] == null) {
            this.outerArray[hashValue] = new List<>();  
        }
        
        return this.outerArray[hashValue]; // = innerArray
    }
    
    // helper for add() & remove()
    private int getIndexOfKey(List<Pair<K, V>> innerArray, K key) { // 2. part of add()
        for (int i = 0; i < innerArray.size(); i++) {
            if (innerArray.valueAt(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }
    
    // helper for grow()
    private void copy(List<Pair<K, V>>[] newArray, int index) {
        for (int i = 0; i < this.outerArray[index].size(); i++) {
            Pair<K, V> value = this.outerArray[index].valueAt(i);
            
            int hashCode = Math.abs(value.getKey().hashCode() % newArray.length);
            if (newArray[hashCode] == null) {
                newArray[hashCode] = new List<>();
            }
            newArray[hashCode].add(value);
        }
    }
}
