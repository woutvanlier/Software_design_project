package UI.ResultPanels;

import Person.Person;
import database.Person_database;

import javax.swing.*;
import java.awt.*;

public class BalanceElementPanel extends JPanel
{

    int yGrid = 1;
    public BalanceElementPanel(Person_database personDatabase, Person person)
    {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel title = new JLabel(person.getFullName()+" owes €??? in total");
        c.anchor = GridBagConstraints.LINE_START;
        c.weightx = 1.0;
        c.gridy = 0;
        this.add(title, c);

        // for loop of all people normally
        c.fill = GridBagConstraints.HORIZONTAL;
        for(Person p : personDatabase.getDb())
        {
            if(p.getFullName() != person.getFullName())
            {
                JLabel newPerson = new JLabel(person.getFullName() + " owes " + p.getFullName() + " €???");
                newPerson.setBackground(new Color(200,200,200));
                newPerson.setOpaque(true);
                c.gridy = yGrid; yGrid++;
                this.add(newPerson, c);
            }
        }
    }
}
