package UI.PersonPanels;

import Person.Person;
import UI.FrameManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PersonPanel extends JPanel
{
    int yLayer = 0;
    FrameManager frameManager;
    ArrayList<UserPanel> userPanelList;
    public PersonPanel(JTextField personNameField, FrameManager frameManager)
    {
        this.frameManager = frameManager;
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
        userPanelList = new ArrayList<>();
        for(Person person : frameManager.getPersonDatabase().getDb())
        {
            UserPanel userPanel = new UserPanel(person.getFullName(), this);
            userPanelList.add(userPanel);
            c.gridy = 3+yLayer; yLayer++;
            this.add(userPanel, c);
        }
    }

    public void addPersonXtra(Person person)
    {
        GridBagConstraints c = new GridBagConstraints();
        UserPanel userPanel = new UserPanel(person.getFullName(), this);
        userPanelList.add(userPanel);
        c.gridy = 3+yLayer; yLayer++;
        this.add(userPanel, c);
    }

    public void removePerson(String name)
    {
        frameManager.getPersonDatabase().removePerson(name);

        for(UserPanel u : userPanelList)
        {
            if(u.getName() == name)
            {
                this.remove(u);
            }
        }

        frameManager.revalidate();
    }
}
