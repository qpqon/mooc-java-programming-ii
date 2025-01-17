
package application;

import java.util.Random;

/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class TemperatureSensor implements Sensor {
    private boolean on = false;

    @Override
    public boolean isOn() {
        return this.on;
    }

    @Override
    public void setOn() {
        this.on = true;
    }

    @Override
    public void setOff() {
        this.on = false;
    }

    @Override
    public int read() {
        if (!this.isOn()) {
            throw new IllegalStateException("Temperature sonsor is switched off");
        }
        return new Random().nextInt(61) - 30;  
    }
    

}
