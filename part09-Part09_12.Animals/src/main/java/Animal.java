
/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public abstract class Animal {
    private String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    public void eat(){
        System.out.println(this.name + " eats");
    }
    
    public void sleep(){
        System.out.println(this.name + " sleeps");
    }
    
    public String getName() {
        return this.name;
    }
}
