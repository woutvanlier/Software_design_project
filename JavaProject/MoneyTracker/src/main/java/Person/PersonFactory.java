package Person;

public class PersonFactory {
    public static Person createPerson(String name) {
        return new Person(name);
    }
}

