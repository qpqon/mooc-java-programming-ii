
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
public class IOU {
    private HashMap<String, Double> iou;
    
    public IOU () {
        this.iou = new HashMap<>();
    }
    
    public void setSum(String toWhom, double amount) {
        this.iou.put(toWhom, amount);
    }
    
    public double howMuchDoIOweTo(String toWhom) {
        return this.iou.getOrDefault(toWhom, 0.0);
    }
}
