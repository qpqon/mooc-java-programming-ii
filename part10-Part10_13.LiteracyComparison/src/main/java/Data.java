


/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class Data {
    private String gender;
    private String country;
    private int    year;
    private double points;   
    
    public Data (String gender, String country, int year, double points) {
        this.gender  = gender;
        this.country = country;
        this.year    = year;
        this.points  = points;
    }

    public double getPoints() {
        return points;
    }
    
    @Override
    public String toString() {
        return this.country + " (" + this.year + "), " 
                + this.gender + ", " 
                + this.points;
    }
}
