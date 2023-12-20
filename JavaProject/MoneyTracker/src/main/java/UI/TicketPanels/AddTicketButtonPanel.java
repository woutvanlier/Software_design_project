package UI.TicketPanels;

import Ticket.TicketFactory;
import Ticket.Ticket;
import Ticket.Abstract_ticket;
import UI.FrameManager;
import UI.HomePanels.LogPanel;
import UI.Views.HomeView;
import UI.Views.LoginView;
import UI.Views.SplitUnevenView;
import UI.Views.TicketView;
import database.Ticket_database;

import javax.swing.*;
import java.util.Objects;

public class AddTicketButtonPanel extends JPanel
{
    private Abstract_ticket newTicket;
    public AddTicketButtonPanel(TicketView ticketView, LogPanel logPanel, FrameManager frameManager, HomeView homeView, TicketPanel ticketPanel, LoginView loginview)
    {
        JButton button = new JButton("ADD TICKET");
        button.addActionListener(e ->
        {
            ticketPanel.SetErrorToFalse();
                if(ticketPanel.getTicketNameField().getText().equals("") || ticketPanel.getPriceNameField().getText().equals("")  || ticketPanel.getDatePicker().getModel().getValue() == null){
                    ticketPanel.SetErrorToTrue();
                    ticketPanel.getTicketNameField().setText("");
                    ticketPanel.getPriceNameField().setText("");
                }
                else{
                    switch (ticketPanel.Split){
                        case "even" :
                            newTicket = TicketFactory.createTicket_even(ticketView.getTicketName(), ticketView.getPersonPaid(), ticketView.getPricePaid(),ticketView.getDatePaid(),ticketView.getTicketCat());
                            logPanel.addElement(newTicket, loginview.getLoginPerson(),frameManager);
                            frameManager.setContentPane(homeView);
                            break;
                        case "uneven" :
                            frameManager.setContentPane(new SplitUnevenView(frameManager,loginview,ticketPanel,logPanel,ticketView, homeView));
                            break;
            }}
            frameManager.revalidate();
            //Ticket newTicket = new Ticket(ticketView.getTicketName(), Double.parseDouble(ticketView.getPricePaid()), ticketView.getPersonPaid(), ticketView.getTicketCat()); // via factory
        });
        this.add(button);
    }
}
