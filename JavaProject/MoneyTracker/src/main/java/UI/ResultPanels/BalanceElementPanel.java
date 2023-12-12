package UI.ResultPanels;

import Person.Person;
import UI.Views.LoginView;
import database.Person_database;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class BalanceElementPanel extends JPanel
{

    int yGrid = 1;
    public BalanceElementPanel(Person_database personDatabase, Person person, boolean OwedToYou)
    {
        if(!OwedToYou) {
            this.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();

            JLabel title = new JLabel(" You owe €" + person.calcTotalOwed() + " in total");
            c.anchor = GridBagConstraints.LINE_START;
            c.weightx = 1.0;
            c.gridy = 0;
            this.add(title, c);

            // for loop of all people normally
            c.fill = GridBagConstraints.HORIZONTAL;
            for (Person p : personDatabase.getDb()) {
                if (p.getFullName() != person.getFullName()) {
                    JLabel newPerson = new JLabel("You owe " + p.getFullName() + " €" + person.showOwedToPerson(p.getFullName()));
                    newPerson.setBackground(new Color(200, 200, 200));
                    newPerson.setOpaque(true);
                    c.gridy = yGrid;
                    yGrid++;
                    this.add(newPerson, c);
                }
            }
        }else{
            this.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();

            JLabel title = new JLabel("The group owes you: €"+person.showOwedToYou()+" in total");
            c.anchor = GridBagConstraints.LINE_START;
            c.weightx = 1.0;
            c.gridy = 0;
            this.add(title, c);

            // for loop of all people normally
            c.fill = GridBagConstraints.HORIZONTAL;
            for(Person p : personDatabase.getDb())
            {
                if(!Objects.equals(p.getFullName(), person.getFullName()))
                {
                    JLabel newPerson = new JLabel(p.getFullName() + " owes you €"+p.showOwedToPerson(person.getFullName()));
                    newPerson.setBackground(new Color(200,200,200));
                    newPerson.setOpaque(true);
                    c.gridy = yGrid; yGrid++;
                    this.add(newPerson, c);
                }
            }
        }
        }
    }
