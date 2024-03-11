package UI.Views;

import UI.FrameManager;
import UI.HomePanels.*;
import UI.Panels.SeparatorPanel;
import UI.Panels.TitlePanel;
import database.Person_database;
import database.Ticket_database;

import javax.swing.*;
import java.awt.*;

public class HomeView extends JPanel
{
    TitlePanel titlePanel;
    LogPanel logPanel;
    PersonButtonPanel addPersonPanel;
    ResultButtonPanel calcResultPanel;
    TicketButtonPanel addTicketPanel;
    SeparatorPanel separatorPanel;
    JScrollPane scrollPane;


    public HomeView(FrameManager frameManager, Person_database personDatabase, Ticket_database ticketDatabase, LoginView loginview)
    {
        this.setBackground(new Color(30,30,30));

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Title
        titlePanel = new TitlePanel("M O N E Y   T R A C K E R");
        titlePanel.setLayout(new GridLayout(1,1));
        //region >> Constraints
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.gridwidth = 3;
        c.anchor = GridBagConstraints.PAGE_START;
        //endregion
        this.add(titlePanel, c);

        // Line 1
        separatorPanel = new SeparatorPanel(SwingConstants.HORIZONTAL);
        separatorPanel.setLayout(new GridLayout(1,1));
        //region >> Constraints
        c.gridy = 1;
        //endregion
        this.add(separatorPanel,c);

        // Log
        logPanel = new LogPanel(loginview,this, frameManager);
        logPanel.setOpaque(false);
        //region >> Constraints
        c.gridy = 2;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(20,20,20,20);
        //endregion
        scrollPane = new JScrollPane(logPanel);
        //region >> Constraints
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(200,475));
        scrollPane.setAlignmentY(JScrollPane.TOP_ALIGNMENT);
        scrollPane.getViewport().setBackground(new Color(30,30,30));

        logPanel.updateTickets(); //update already made tickets at main
        //endregion
        this.add(scrollPane, c);

        AllButtons allButtons = new AllButtons(logPanel, frameManager, this, loginview);
        allButtons.setLayout(new GridLayout(1,1));
        allButtons.setOpaque(false);
        allButtons.setBackground(new Color(30,30,30));
        c.gridy = 3;
        c.gridx = 0;
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.0;
        c.weightx = 1.0;
        c.insets = new Insets(0,0,20,0);
        this.add(allButtons, c);
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }
}
