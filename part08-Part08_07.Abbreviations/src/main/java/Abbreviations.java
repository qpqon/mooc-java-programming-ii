
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
public class Abbreviations {
    private HashMap<String, String> abreviations;
    
    public Abbreviations() {
        this.abreviations = new HashMap<>();
    }
    
    public void addAbbreviation(String abbreviation, String explanation) {
        this.abreviations.put(abbreviation, explanation);
    }
    
    public boolean hasAbbreviation(String abbreviation) {
        return this.abreviations.containsKey(abbreviation);
    }
    
    public String findExplanationFor(String abbreviation) {
        if (!(hasAbbreviation(abbreviation))) {
            return null;
        }
        return this.abreviations.get(abbreviation);
    }
}
