package database;

import Person.Person;
import Ticket.Ticket;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person_database extends Database
{
    private static Person_database singletonDB;
    private List<Person> db;


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
        if(findInDatabase(person.getFullName()) == null)  // Prevents doubles in the list
        {

            if (db.size() != 0) {
                PropertyChangeEvent event = new PropertyChangeEvent(this,"database",db.get(db.size() - 1), person);
                listenerManager.firePropertyChange(event);
            }
            db.add(person);
        }
        else
        {
            System.out.println("Person already exists");
        }
    }

    public void removePerson(String personName)
    {
        Person personToBeRemoved = null;
        for(Person person : db)
        {
            if(Objects.equals(personName, person.getFullName()))
            {
                personToBeRemoved = person;
            }
        }
        
        if(personToBeRemoved != null)
            db.remove(personToBeRemoved);
    }
    public String[] getDbArray(){
        List<String> names = new ArrayList<>();
        for(Person p : this.db){
            names.add(p.getFullName());
        }
        return names.toArray(new String[0]);
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
            assert person != null;
            person.changeFullName(newName);

        }
    }

    // Searches for the person by name and returns null if not found
    private Person findInDatabase(String name)
    {
        for(Person person : db)
        {
            if(Objects.equals(name, person.getFullName()))
            {
                return person;
            }
        }
        return null;
    }
    public List<String> getdbNames(){
        List<String> dbNames = new ArrayList<>();
        for (Person p: db){
            dbNames.add(p.getFullName());
        }
        return dbNames;
    }
}
