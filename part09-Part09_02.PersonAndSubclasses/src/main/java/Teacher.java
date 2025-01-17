
/**
 * This code is free to use, modify, and distribute under the MIT License.
 * See LICENSE file for details.
 * 
 * Course: https://java-programming.mooc.fi/
 *
 * @author Daniel Menke
 * 
 */
public class Teacher extends Person {
    private int salary;
    
    public Teacher(String name, String adress, int salary) {
        super (name, adress);
        this.salary = salary;
    }
    
    public String toString() {
        return super.toString() + "\n  salary " + this.salary + " euro/month";
    }
}
