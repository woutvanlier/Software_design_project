package database;

import Ticket.Ticket;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

public class Ticket_database extends Database
{
    private static Ticket_database singletonDB;

    public List<Ticket> getDb() {
        return db;
    }

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
        PropertyChangeEvent event = new PropertyChangeEvent(this,"database",db.get(db.size() - 1), ticket);
        listenerManager.firePropertyChange(event);
        db.add(ticket);
    }
    
    public Ticket getTicket(String name)
    {
        return findInDatabase(name);
    }
    
    public void changeNameOnTicket(String oldname,String newname, Person_database personDatabase)
    {
        personDatabase.changeFullName(oldname,newname);

    }

    // Searches for the ticket by name and returns null if not found
    private Ticket findInDatabase(String name)
    {
        for (Ticket ticket : db)
        {
            if (name == ticket.getName()) {
                ticket.setName(name);
                return ticket;
            }
        }
        return null;
    }
}
