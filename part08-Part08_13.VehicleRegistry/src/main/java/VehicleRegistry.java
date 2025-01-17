
import java.util.HashMap;
import java.util.HashSet;

public class VehicleRegistry {
    private HashMap<LicensePlate, String> vehicles;
    
    public VehicleRegistry() {
        this.vehicles = new HashMap<>();
    }
    
    public boolean add(LicensePlate licensePlate, String owner) {
        if (!vehicles.containsKey(licensePlate)) {
            vehicles.put(licensePlate, owner);
            return true;
        }
        return false;
    }
    
    public String get(LicensePlate licensePlate) {
        return vehicles.get(licensePlate);
    }
    
    public boolean remove(LicensePlate licensePlate) {
        if (vehicles.containsKey(licensePlate)) {
            vehicles.remove(licensePlate);
            return true;
        }
        return false;
    }
    
    public void printLicensePlates() {
        if (!vehicles.isEmpty()) {
            for (LicensePlate key: vehicles.keySet()) {
                System.out.println(key);
            }
        }
    }
    
    public void printOwners() {
        if (!vehicles.isEmpty()) {
            HashSet<String> owners = new HashSet<>();
            
            for (String owner: vehicles.values()) {
                if (owners.add(owner)) {
                    System.out.println(owner);
                }
            }
        }
    }
}
