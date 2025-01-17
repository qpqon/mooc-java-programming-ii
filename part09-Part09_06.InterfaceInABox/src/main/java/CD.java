
/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class CD implements Packable {
    private String artist;
    private String name;
    private int    pubYear;
    private double weight;

    public CD(String artist, String name, int pubYear) {
        this.artist  = artist;
        this.name    = name;
        this.pubYear = pubYear;
        this.weight  = 0.1;
    }

    @Override
    public double weight() {
        return this.weight;
    }
            
    @Override
    public String toString() {
        return this.artist + ": " + name + " (" + this.pubYear + ")";
    }
}
