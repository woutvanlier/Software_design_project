package database;

public class Ticket_database extends Database
{

    private static Ticket_database singletonDB;
    private final List<Ticket> db;
    
    private Ticket_database()
    {
        db = new List<Ticket>();
    }

    // Singleton Constructor
    public static Ticket_database getInstance()
    {
        if(singletonDB == null)
            singletonDB = new Ticket_database();

        return signletonDB;
    }


    public void addTicket(Ticket ticket)
    {
        db.add(ticket);
    }
    
    public void getTicket(String name)
    {
        return findInDatabase(name);
    }

    // Searches for the ticket by name and returns null if not found
    private Ticket findInDatabase(String name)
    {
        for(int i; i<db.size(); i++)
        {
            if(name == db(i).getName())
            {
                return db(i);
            }
        }
        return null;
    }
}
