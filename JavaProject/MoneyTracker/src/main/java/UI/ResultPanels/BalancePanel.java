package UI.ResultPanels;

import UI.FrameManager;

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

        /*BalanceElementPanel balanceElementPanel = new BalanceElementPanel();
        //balanceElementPanel.setOpaque(false);
        c.weightx = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);
        this.add(balanceElementPanel);*/

        addElement(frameManager);
        addElement(frameManager);
        addElement(frameManager);
    }

    public void addElement(FrameManager frameManager)
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
        this.add(new BalanceElementPanel());

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
