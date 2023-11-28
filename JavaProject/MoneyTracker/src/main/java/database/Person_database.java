package database;

import Person.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person_database extends Database
{
    private static Person_database singletonDB;
    private final List<Person> db;

    private Person_database()
    {
        db = new ArrayList<Person>();
    }

    // Singleton Constructor
    public static Person_database getInstance()
    {
        if(singletonDB == null)
            singletonDB = new Person_database();

        return singletonDB;
    }
    public int getAmountOfPersons(){
        return db.size();
    }

    public List<Person> getDb() {
        return db;
    }

    public void addPerson(Person person)
    {
        if(Objects.equals(findInDatabase(person.getFullName()).getFullName(), person.getFullName()) & ) // Prevents doubles in the list
        {
            db.add(person);
        } else if (db.isEmpty()) {
            db.add(person);
        }
    }

    public Person getPerson(String name)
    {
        return findInDatabase(name);
    }

    // Searches for the person by name and returns null if not found
    private Person findInDatabase(String name)
    {
        for (Person person : db)
        {
            if (Objects.equals(name, person.getFullName()))
                return person;
        }
        return null;
    }
}
