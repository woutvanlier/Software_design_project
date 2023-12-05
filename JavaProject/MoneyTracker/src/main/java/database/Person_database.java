package database;

import Person.Person;
import Ticket.Ticket;

import java.beans.PropertyChangeEvent;
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
        if(findInDatabase(person.getFullName()) == null && db.size() != 0)  // Prevents doubles in the list
        {
            PropertyChangeEvent event = new PropertyChangeEvent(this,"database",db.get(db.size() - 1), person);
            listenerManager.firePropertyChange(event);
            db.add(person);
        }         
    }

    public int getAmountOfPersons(){
        return db.size();
    }

    public List<Person> getDb(){
        return  db;
    }


    public Person getPerson(String name) { return findInDatabase(name); }

    public void changeFullName(String oldName, String newName)
    {

        if(findInDatabase(oldName) != null)
        {
            Person person = findInDatabase(oldName);
            person.changeFullName(newName);

        }
    }

    // Searches for the person by name and returns null if not found
    private Person findInDatabase(String name)
    {
        for(Person person : db)
        {
            if(name == person.getFullName())
            {
                return person;
            }
        }
        return null;
    }
}
