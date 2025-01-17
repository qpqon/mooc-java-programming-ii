package validating;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        if (name == null || name.isEmpty() || name.length() > 40 || age > 120 || age < 0) {
            throw new IllegalArgumentException("String name may not be null, empty, or over 40 characters in length. int age may not be under 0 or higher than 120");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
