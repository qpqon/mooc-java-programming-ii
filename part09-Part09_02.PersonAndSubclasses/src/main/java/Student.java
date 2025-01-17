
/**
 * This code is free to use, modify, and distribute under the MIT License.
 * See LICENSE file for details.
 * 
 * Course: https://java-programming.mooc.fi/
 *
 * @author Daniel Menke
 * 
 */
public class Student extends Person {
    private int credits;
    
    public Student(String name, String adress) {
        super (name, adress);
        this.credits = 0;
    }
    
    public void study() {
        this.credits++;
    }
    
    public int credits() {
        return this.credits;
    }
    
    public String toString() {
        return super.toString() + "\n  Study credits " + this.credits; 
    }
}
