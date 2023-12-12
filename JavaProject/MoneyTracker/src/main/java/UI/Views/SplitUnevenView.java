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
    private FrameManager frameManager;
    private TicketPanel ticketPanel;
    private TicketView ticketView;
    public SplitUnevenView(FrameManager frameManager, LoginView loginView, TicketPanel ticketPanel, LogPanel logPanel, TicketView ticketView, HomeView homeView) {
        this.ticketView = ticketView;
        this.frameManager = frameManager;
        this.ticketPanel = ticketPanel;
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
        JLabel Error = new JLabel("Amount exceeded ticket value!");
        Error.setForeground(new Color(120,30,30));
        Error.setBackground(new Color(30,30,30));
        Error.setOpaque(false);
        Error.setVisible(false);
        c.gridx = 0;
        c.gridy = gridy+1;
        this.add(Error,c);
        JButton addPrices = new JButton("Add Prices");
        addPrices.addActionListener(e -> {
            boolean completed = fillPriceMap();
            if(!completed){
                for (JTextField arrOfPrice : arrOfPrices) {
                    if(arrOfPrice!=null){
                        arrOfPrice.setText("");
                    }
                }
                Error.setVisible(true);
            }else{
            Error.setVisible(false);
            Abstract_ticket newTicket = TicketFactory.createTicket_unevenly_withMap(ticketView.getTicketName(), ticketView.getPersonPaid(), ticketView.getPricePaid(), ticketView.getDatePaid(), ticketView.getTicketCat(),PriceMap);
            Ticket_database.getInstance().addTicket(newTicket);
            logPanel.addElement(newTicket, loginView.getLoginPerson(),frameManager);
            frameManager.setContentPane(homeView);
            frameManager.revalidate();}
        });
        this.add(addPrices);
    }
    public boolean fillPriceMap(){
        boolean completed = true;
        double totalprice = 0;
        double price;
        String name;
        System.out.println(arrOfPrices.length);
        for (int it = 0; it < arrOfPrices.length; it++){
            if(arrOfPrices[it]!=null){
                price = Double.parseDouble(arrOfPrices[it].getText());
                totalprice += price;
                name = arrOfNames[it].getText();
                if(totalprice > ticketView.getPricePaid()){
                    completed = false;
                    break;
                }else{
                    PriceMap.put(name,price);
                }}
        }
        return completed;
    }
}
