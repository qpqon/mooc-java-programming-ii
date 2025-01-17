
/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class Dog extends Animal implements NoiseCapable {
    
    public Dog() {
        this("Dog");
    }
    
    public Dog(String name) {
        super(name);
    }
    
    public void bark() {
        System.out.println(super.getName() + " barks");
    }

    @Override
    public void makeNoise() {
        this.bark();
    }
    
    
}   