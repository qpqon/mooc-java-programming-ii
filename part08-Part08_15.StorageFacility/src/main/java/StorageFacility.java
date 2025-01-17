
import java.util.ArrayList;
import java.util.HashMap;


/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class StorageFacility {
    private HashMap<String, ArrayList<String>> storage;
    
    public StorageFacility() {
        this.storage = new HashMap<>();
    }
    
    public void add(String unit, String item) {
        this.storage.putIfAbsent(unit, new ArrayList<>());
        this.storage.get(unit).add(item);
    }
    
    public ArrayList<String> contents(String storageUnit) {
        return this.storage.getOrDefault(storageUnit, new ArrayList<>());
    }
    
    public void remove(String storageUnit, String item) {
        ArrayList<String> items = this.storage.get(storageUnit);
        
        if (items != null) {
            items.remove(item);
        }
        
        if (items.isEmpty()) {
            this.storage.remove(storageUnit);
        }
    }
    
    public ArrayList<String> storageUnits() {
        ArrayList<String> units = new ArrayList<>();
        
        for (String unit: this.storage.keySet()) {
            if (this.storage.get(unit) != null && !this.storage.get(unit).isEmpty()) {
                units.add(unit);
            }
        }
        return units;
    }
}
