
/**
 * This code is free to use, modify, and distribute under the MIT License.
 * See LICENSE file for details.
 * 
 * Course: https://java-programming.mooc.fi/
 *
 * @author Daniel Menke
 * 
 */
public class Person {
    private String name;
    private String adress;
    
    public Person(String name, String adress) {
        this.name   = name;
        this.adress = adress;
    }
    
    public String toString() {
        return this.name + "\n  " + this.adress;
    }
}
