package database;

import java.beans.PropertyChangeListener;

// This is the observer
public interface Observable
{
    void addListener(PropertyChangeListener listener);
    void removeListener(PropertyChangeListener listener);
}