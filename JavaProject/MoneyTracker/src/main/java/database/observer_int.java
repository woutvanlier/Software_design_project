package database;

import java.beans.PropertyChangeListener;

// This is the observer
public interface observer_int 
{
    void addListener(PropertyChangeListener listener);
    void removeListener(PropertyChangeListener listener);
}