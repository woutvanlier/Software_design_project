package database;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class Database
{
    protected PropertyChangeSupport listenerManager = new PropertyChangeSupport(this);
    public void addListener(PropertyChangeListener listener) {listenerManager.addPropertyChangeListener(listener);}
    public void removeListener(PropertyChangeListener listener){listenerManager.removePropertyChangeListener(listener);}
}
