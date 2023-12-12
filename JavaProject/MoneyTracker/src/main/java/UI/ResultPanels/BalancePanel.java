package UI.ResultPanels;

import Person.Person;
import UI.FrameManager;
import UI.Views.LoginView;
import database.Person_database;

import javax.swing.*;
import java.awt.*;

public class BalancePanel extends JPanel
{
    LoginView loginView;
    int layoutY = 0;
    GridBagLayout gridLayout;

    public BalancePanel(FrameManager frameManager, LoginView loginView)
    {
        this.setLayout(new GridBagLayout());

        gridLayout = new GridBagLayout();
        this.setLayout(gridLayout);
        this.loginView = loginView;
        addElement(frameManager, loginView.getLoginPerson(), false);
        addElement(frameManager, loginView.getLoginPerson(), true);
    }

    public void addElement(FrameManager frameManager, Person person, boolean OwedToYou)
    {
        /*if(layoutY == 0)
        {
            this.removeAll();
            this.repaint();
        }*/

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.PAGE_START;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        this.add(new BalanceElementPanel(frameManager.getPersonDatabase(), person, OwedToYou));

        for(int i=0; i<this.getComponentCount()-1; i++)
        {
            c.insets.bottom = 5;
            c.gridy = i;
            gridLayout.setConstraints(this.getComponent(i), c);
        }

        c.gridy = layoutY; layoutY +=1;
        c.weighty = 1.0;
        c.insets.bottom = 0;
        gridLayout.setConstraints(this.getComponent(this.getComponentCount()-1), c);

        frameManager.revalidate();
    }
}
