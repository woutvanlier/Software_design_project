package database;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NotifyPersonDatabase implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Person added to the database: " + evt.getNewValue());

    }
}
