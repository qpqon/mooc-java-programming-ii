
/**
 *
 * @author ABK
 */
public class Person {
    private String name;
    private Education edu;
    
    public Person(String name, Education edu) {
        this.name = name;
        this.edu  = edu;
    }
    
    public Education getEducation() {
        return this.edu;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.edu;
    }

    public Education getEdu() {
        return edu;
    }
    
    
}
