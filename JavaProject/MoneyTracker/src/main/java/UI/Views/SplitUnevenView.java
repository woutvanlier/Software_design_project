package UI.Views;

import Ticket.Abstract_ticket;
import Ticket.TicketFactory;
import UI.FrameManager;
import UI.HomePanels.*;
import UI.Panels.SeparatorPanel;
import UI.Panels.TitlePanel;
import UI.TicketPanels.TicketPanel;
import database.Person_database;
import Person.Person;
import database.Ticket_database;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Objects;

public class SplitUnevenView extends JPanel {
    private HashMap<String, Double> PriceMap = new HashMap<>();
    private JTextField[] arrOfPrices = new JTextField[30];
    private JLabel[] arrOfNames = new JLabel[30];
    public SplitUnevenView(FrameManager frameManager, LoginView loginView, TicketPanel ticketPanel, LogPanel logPanel, TicketView ticketView, HomeView homeView) {
        this.setLayout(new GridLayout(20,10));
        this.setBackground(new Color(30,30,30));
        GridBagConstraints titleConstraints = new GridBagConstraints();
        TitlePanel SplitInfo = new TitlePanel("Fill in how much each person owes you");
        titleConstraints.fill = GridBagConstraints.HORIZONTAL;
        titleConstraints.gridy = 0;
        titleConstraints.gridwidth = 2;
        titleConstraints.anchor = GridBagConstraints.NORTH;
        SplitInfo.setOpaque(true);
        SplitInfo.setBackground(new Color(30,30,30));
        SplitInfo.setForeground(Color.white);
        this.add(SplitInfo,titleConstraints);
        //end

        //Fields to fill in
        GridBagConstraints c = new GridBagConstraints();
        int gridy = 2; int gridx = 0;
        int i = 0;
        for (
                Person p :frameManager.getPersonDatabase().getDb()){
            if(!Objects.equals(p.getFullName(),ticketPanel.getPersonNamePane().getSelectedItem().toString())){
                arrOfNames[i] = new JLabel(p.getFullName());
                arrOfNames[i].setBackground(new Color(30,30,30));
                arrOfNames[i].setForeground(Color.white);
                arrOfNames[i].setOpaque(false);
                c.gridx = gridx;
                c.gridy = gridy;
                this.add(arrOfNames[i],c);
                arrOfPrices[i] = new JTextField();
                gridx = 3;
                c.gridy = gridy;
                c.gridx = gridx;
                this.add(arrOfPrices[i]);
                gridx = 0;
                gridy+= 2;
                i+=1;
            }
        }
        JButton addPrices = new JButton("Add Prices");
        addPrices.addActionListener(e -> {
            double price;
            String name;
            System.out.println(arrOfPrices.length);
            for (int it = 0; it < arrOfPrices.length; it++){
                if(arrOfPrices[it]!=null){
                price = Double.parseDouble(arrOfPrices[it].getText());
                name = arrOfNames[it].getText();
                PriceMap.put(name,price);}
            }
            Abstract_ticket newTicket = TicketFactory.createTicket_unevenly_withMap(ticketView.getTicketName(), ticketView.getPersonPaid(), ticketView.getPricePaid(), ticketView.getDatePaid(), ticketView.getTicketCat(),PriceMap);
            Ticket_database.getInstance().addTicket(newTicket);
            if(!Objects.equals(loginView.getLoginName(),ticketView.getPersonPaid())){
                logPanel.addElement(newTicket, loginView.getLoginPerson(),frameManager);}
            frameManager.setContentPane(homeView);
            frameManager.revalidate();
        });
        this.add(addPrices);
    }
}
