package database;

import Ticket.Abstract_ticket;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

public class Ticket_database extends Database
{
    private static Ticket_database singletonDB;
    private final List<Abstract_ticket> db;

    private Ticket_database()
    {
        db = new ArrayList<Abstract_ticket>();
    }

    // Singleton Constructor
    public static Ticket_database getInstance()
    {
        if(singletonDB == null)
            singletonDB = new Ticket_database();

        return singletonDB;
    }

    public List<Abstract_ticket> getDb() {
        return db;
    }



    public void addTicket(Abstract_ticket ticket)
    {
        if (db.size() != 0) {
            PropertyChangeEvent event = new PropertyChangeEvent(this,"database",db.get(db.size() - 1), ticket);
            listenerManager.firePropertyChange(event);
        }
        db.add(ticket);
    }

    public void changeNameOnTicket(String oldname,String newname, Person_database personDatabase)
    {
        personDatabase.changeFullName(oldname,newname);

    }

    // Searches for the ticket by name and returns null if not found
    private Abstract_ticket findInDatabase(String name)
    {
        for (Abstract_ticket ticket : db)
        {
            if (name == ticket.getTicketName()) {
                ticket.setTicketName(name);
                return ticket;
            }
        }
        return null;
    }
}
