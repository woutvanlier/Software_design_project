package UI.PersonPanels;

import Person.Person;
import database.Person_database;

import javax.swing.*;
import java.awt.*;

public class PersonPanel extends JPanel
{
    int yLayer = 0;
    public PersonPanel(JTextField personNameField, Person_database personDatabase)
    {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel personName = new JLabel("Name User");
        personName.setOpaque(true);
        personName.setBackground(new Color(30,30,30));
        personName.setForeground(Color.white);

        c.gridy = 0;

        this.add(personName, c);
        c.gridy = 1;

        this.add(personNameField, c);

        JLabel listPeople = new JLabel("All Users");
        listPeople.setOpaque(true);
        listPeople.setBackground(new Color(30,30,30));
        listPeople.setForeground(Color.white);
        c.gridy = 2;
        this.add(listPeople, c);

        // list of all users
        for(Person person : personDatabase.getDb())
        {
            UserPanel userPanel = new UserPanel(person.getFullName());
            c.gridy = 3+yLayer; yLayer++;
            this.add(userPanel, c);
        }
    }

    public void addPersonXtra(Person person)
    {
        GridBagConstraints c = new GridBagConstraints();
        UserPanel userPanel = new UserPanel(person.getFullName());
        c.gridy = 3+yLayer; yLayer++;
        this.add(userPanel, c);
    }
}
