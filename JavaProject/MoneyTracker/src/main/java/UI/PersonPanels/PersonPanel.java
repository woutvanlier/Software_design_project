package UI.PersonPanels;

import javax.swing.*;
import java.awt.*;

public class PersonPanel extends JPanel
{
    public PersonPanel(JTextField personNameField)
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
        for(int i=0; i<5; i++)
        {
            UserPanel userPanel = new UserPanel("User" + i);
            c.gridy = 3+i;
            this.add(userPanel, c);
        }
    }
}
