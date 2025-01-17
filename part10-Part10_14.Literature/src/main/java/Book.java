
/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class Book {
    private String name;
    private int recomAge;
    
    public Book(String bookName, int recommandedAge) {
        this.name     = bookName;
        this.recomAge = recommandedAge;
    }

    public String getName() {
        return name;
    }
    
    public int getAge() {
        return recomAge;
    }

    @Override
    public String toString() {
        return this.name + " (recommended for " + this.recomAge + " year-olds or older)";
    }
    
    
}
