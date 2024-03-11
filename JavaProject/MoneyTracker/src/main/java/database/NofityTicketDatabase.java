package database;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class NofityTicketDatabase implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Ticket added to the database: " + evt.getNewValue());

    }
}
