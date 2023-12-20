package Person;

import database.Person_database;

public class PersonFactory {
    public static Person createPerson(String name) {
        Person person = new Person(name);
        Person_database.getInstance().addPerson(person);
        return person;
    }
}

