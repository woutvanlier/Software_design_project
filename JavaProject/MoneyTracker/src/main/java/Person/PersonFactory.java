
package Person;

public class PersonFactory {

    public Person createPerson(String name) {
        return new Person(name);
    }
}
