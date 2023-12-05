package UI.PersonPanels;

import Person.Person;
import Person.PersonFactory;
import UI.FrameManager;
import UI.Views.HomeView;
import UI.Views.PersonView;
import UI.Views.ResultView;
import database.Person_database;

import javax.swing.*;
import javax.xml.transform.Result;

public class AddPersonButtonPanel extends JPanel
{
    public AddPersonButtonPanel(PersonPanel personPanel, JTextField personNameField, Person_database personDatabase)
    {
        JButton button = new JButton("ADD USER");
        button.addActionListener(e ->
        {
            Person newPerson =  PersonFactory.createPerson(personNameField.getText());
            personDatabase.addPerson(newPerson); // MOET FACTORY WORDEN
            personPanel.addPersonXtra(newPerson);

            personNameField.setText("");

            personPanel.revalidate();
        });
        this.add(button);
    }
}
