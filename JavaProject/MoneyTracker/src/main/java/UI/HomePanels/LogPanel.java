package UI.HomePanels;

import Person.Person;
import Ticket.Ticket;
import UI.FrameManager;
import UI.Views.HomeView;
import UI.Views.LoginView;
import database.Ticket_database;
import Ticket.Abstract_ticket;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class LogPanel extends JPanel
{
    HomeView homeView;
    GridBagLayout gridLayout;
    FrameManager frameManager;
    int layoutY = 0;

    Person loginPerson;
;

    public LogPanel(LoginView loginview, HomeView homeView, FrameManager frameManager)
    {
        this.homeView = homeView;
        this.frameManager = frameManager;

        gridLayout = new GridBagLayout();
        this.setLayout(gridLayout);

        JLabel label = new JLabel("No Tickets Available");
        label.setForeground(Color.white);
        this.add(label);

        loginPerson = loginview.getLoginPerson();

    }

    public void updateTickets()
    {
        this.removeAll();
        this.repaint();

        for (Abstract_ticket t : frameManager.getTicketDatabase().getDb())
        {
            if(!Objects.equals(loginPerson.getFullName(), t.getTicketHolder())){
                addElement(t,loginPerson, frameManager);}
        }
    }

    public void addElement(Abstract_ticket ticket, Person person, FrameManager frameManager)
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
        this.add(new LogElementPanel(ticket,person));

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
