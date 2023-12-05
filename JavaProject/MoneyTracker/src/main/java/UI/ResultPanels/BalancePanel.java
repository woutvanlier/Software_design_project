package UI.ResultPanels;

import Person.Person;
import UI.FrameManager;
import database.Person_database;

import javax.swing.*;
import java.awt.*;

public class BalancePanel extends JPanel
{
    int layoutY = 0;
    GridBagLayout gridLayout;
    public BalancePanel(FrameManager frameManager)
    {
        this.setLayout(new GridBagLayout());

        gridLayout = new GridBagLayout();
        this.setLayout(gridLayout);

        for(Person person : frameManager.getPersonDatabase().getDb())
            addElement(frameManager, person);
    }

    public void addElement(FrameManager frameManager, Person person)
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
        this.add(new BalanceElementPanel(frameManager.getPersonDatabase(), person));

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
