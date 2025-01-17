
package application;

import java.util.ArrayList;
import java.util.List;

/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class AverageSensor implements Sensor {
    private ArrayList<Sensor> sensors = new ArrayList<>();
    private List<Integer> allReadings = new ArrayList<>();
    
    @Override
    public boolean isOn() {
        for (Sensor s: sensors) {
            if (!s.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setOn() {
        for (Sensor s: sensors) {
            s.setOn();
        }
    }

    @Override
    public void setOff() {
        for (Sensor s: sensors) {
            s.setOff();
        }
    }

    @Override
    public int read() {
        if (!(this.isOn())) {
            throw new IllegalStateException("Average sensor is switched off");
        }
        if (this.sensors.isEmpty()) {
            throw new IllegalStateException("No sensors in Average sensor list");
        }
        int reading = (int) this.sensors.stream()
                .mapToInt(s -> s.read())
                .average()
                .orElse(0);
        
        this.allReadings.add(reading);
        
        return reading;
    }
    
    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }
    
    public List<Integer> readings() {
        return this.allReadings;
    }
}
