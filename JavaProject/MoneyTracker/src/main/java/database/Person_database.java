package database;

import Person.Person;

import java.util.ArrayList;
import java.util.List;

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

    public void addPerson(Person person)
    {
        if(findInDatabase(person.getFullName()) != null) // Prevents doubles in the list
        {
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
            if (name == person.getFullName())
                return person;
        }
        return null;
    }
}
