package UI.TicketPanels;

import UI.FrameManager;
import UI.HomePanels.LogPanel;
import UI.Views.HomeView;
import UI.Views.TicketView;

import javax.swing.*;

public class AddTicketButtonPanel extends JPanel
{
    public AddTicketButtonPanel(TicketView ticketView, LogPanel logPanel, FrameManager frameManager, HomeView homeView)
    {
        JButton button = new JButton("ADD TICKET");
        button.addActionListener(e ->
        {
            frameManager.setContentPane(homeView);
            logPanel.addElement(ticketView.getTicketName(), ticketView.getPricePaid(), ticketView.getPersonPaid(), ticketView.getTicketCat(), frameManager);
            frameManager.revalidate();
        });
        this.add(button);
    }
}
