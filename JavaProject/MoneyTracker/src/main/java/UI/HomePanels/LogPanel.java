package UI.HomePanels;

import UI.FrameManager;
import UI.Views.HomeView;

import javax.swing.*;
import java.awt.*;

public class LogPanel extends JPanel
{
    HomeView homeView;
    GridBagLayout gridLayout;
    int layoutY = 0;

    public LogPanel(HomeView homeView)
    {
        this.homeView = homeView;

        gridLayout = new GridBagLayout();
        this.setLayout(gridLayout);

        JLabel label = new JLabel("No Tickets Available");
        label.setForeground(Color.white);
        this.add(label);
    }

    public void addElement(String ticketName, String price, String personPaying, String cat, FrameManager frameManager)
    {
        if(layoutY == 0)
        {
            this.removeAll();
            this.repaint();
        }

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.PAGE_START;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        this.add(new LogElementPanel(ticketName, price, personPaying, cat));

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

        JScrollBar vertical = homeView.getScrollPane().getVerticalScrollBar();
        vertical.setValue(vertical.getMaximum());
    }
}
