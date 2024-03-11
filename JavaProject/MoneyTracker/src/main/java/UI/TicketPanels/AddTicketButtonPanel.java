package UI.TicketPanels;

import Ticket.TicketFactory;
import Ticket.Abstract_ticket;
import UI.ButtonSound;
import UI.FrameManager;
import UI.HomePanels.LogPanel;
import UI.Views.HomeView;
import UI.Views.LoginView;
import UI.Views.SplitUnevenView;
import UI.Views.TicketView;

import javax.swing.*;


public class AddTicketButtonPanel extends JPanel
{
    private Abstract_ticket newTicket;
    ButtonSound buttonSound = new ButtonSound();
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
                    buttonSound.playSound("src/main/java/UI/Resources/error.wav");
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
