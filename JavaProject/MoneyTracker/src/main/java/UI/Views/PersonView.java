package UI.Views;

import UI.FrameManager;
import UI.Panels.BackButtonPanel;
import UI.Panels.SeparatorPanel;
import UI.Panels.TitlePanel;
import UI.PersonPanels.AddPersonButtonPanel;
import UI.PersonPanels.PersonPanel;
import database.Person_database;

import javax.swing.*;
import java.awt.*;

public class PersonView extends JPanel
{
    JLabel errorLabel;
    public PersonView(HomeView homeview, FrameManager frameManager, Person_database personDatabase)
    {
        this.setBackground(new Color(30,30,30));

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Title
        TitlePanel titlePanel = new TitlePanel("A D D   U S E R");
        titlePanel.setLayout(new GridLayout(1,1));
        //region >> Constraints
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.PAGE_START;
        //endregion
        this.add(titlePanel, c);

        // Line 1
        SeparatorPanel separatorPanel = new SeparatorPanel(SwingConstants.HORIZONTAL);
        separatorPanel.setLayout(new GridLayout(1,1));
        //region >> Constraints
        c.gridy = 1;
        //endregion
        this.add(separatorPanel,c);

        // PersonPane
        JTextField personName = new JTextField();
        PersonPanel personPanel = new PersonPanel(personName, frameManager);
        personPanel.setLayout(new GridLayout(0,1));
        //region >> Constraints
        c.gridy = 2;
        c.weighty = 1.0;
        c.insets = new Insets(20,20,20,20);
        //endregion
        this.add(personPanel, c);

        //Error
        errorLabel = new JLabel("ERROR : Type a valid name!", SwingConstants.CENTER);
        errorLabel.setForeground(Color.red);
        errorLabel.setVisible(false);
        c.gridy = 3;
        c.insets.bottom = 0;
        c.anchor = GridBagConstraints.PAGE_END;
        c.weighty = 0.0;
        this.add(errorLabel, c);

        //Button
        AddPersonButtonPanel addPerson = new AddPersonButtonPanel(personPanel, personName, personDatabase, this);
        addPerson.setLayout(new GridLayout(1,1));
        //region >> Constraints
        c.weighty = 0.0;
        c.gridy = 4;
        c.insets.bottom = 0;
        c.anchor = GridBagConstraints.PAGE_END;
        //endregion
        this.add(addPerson, c);

        //Button
        BackButtonPanel backButton = new BackButtonPanel(frameManager, homeview);
        backButton.setLayout(new GridLayout(1,1));
        //region >> Constraints
        c.gridy = 5;
        c.insets.bottom = 20;
        c.insets.top = 5;
        //endregion
        this.add(backButton, c);
    }

    public void setError(boolean isOn)
    {
        errorLabel.setVisible(isOn);
    }
}
