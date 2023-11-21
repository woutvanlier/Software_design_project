package database;

public class Person_database extends database
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

        return signletonDB;
    }

    public void addPerson(Person person)
    {
        if(findInDatabase(person.getFullName() != null)) // Prevents doubles in the list   
        {
            db.add(person);
        }         
    }

    public void getPerson(String name)
    {
        return finInDatabase(name);
    }

    // Searches for the person by name and returns null if not found
    private Person findInDatabase(String name)
    {
        for(int i; i<db.size(); i++)
        {
            if(name == db(i).getFullName())
            {
                return db(i);
            }
        }
        return null;
    }
}
