package database;

import Ticket.Ticket;

import java.util.ArrayList;
import java.util.List;

public class Ticket_database extends Database
{

    private static Ticket_database singletonDB;
    private final List<Ticket> db;
    
    private Ticket_database()
    {
        db = new ArrayList<Ticket>();
    }

    // Singleton Constructor
    public static Ticket_database getInstance()
    {
        if(singletonDB == null)
            singletonDB = new Ticket_database();

        return singletonDB;
    }


    public void addTicket(Ticket ticket)
    {
        db.add(ticket);
    }
    
    public Ticket getTicket(String name)
    {
        return findInDatabase(name);
    }

    // Searches for the ticket by name and returns null if not found
    private Ticket findInDatabase(String name)
    {
        for(int i=0; i<db.size(); i++)
        {
            if(name == db.get(i).getName())
            {
                return db.get(i);
            }
        }
        return null;
    }
}
