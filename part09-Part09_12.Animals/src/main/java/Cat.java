
/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class Cat extends Animal implements NoiseCapable {
    
    public Cat() {
        this("Cat");
    }
    
    public Cat(String name) {
        super(name);
    }
    
    public void purr() {
        System.out.println(super.getName() + " purrs");
    }

    @Override
    public void makeNoise() {
        this.purr();
    }
}
