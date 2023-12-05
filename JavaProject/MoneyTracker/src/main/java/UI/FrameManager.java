package UI;

import UI.Views.HomeView;
import database.Person_database;
import database.Ticket_database;

import javax.swing.*;
import java.awt.*;

public class FrameManager extends JFrame {
    public FrameManager() {
        super("Splitwise");
    }

    Person_database personDatabase;
    Ticket_database ticketDatabase;
    public Person_database getPersonDatabase() {
        return personDatabase;
    }
    public Ticket_database getTicketDatabase() {
        return ticketDatabase;
    }

    public void initialize(Person_database personDatabase, Ticket_database ticketDatabase)
    {
        this.personDatabase = personDatabase;
        this.ticketDatabase = ticketDatabase;

        HomeView homeView = new HomeView(this, personDatabase, ticketDatabase);

        this.setSize(350, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(30, 30, 30));

        this.setContentPane(homeView);

        this.setVisible(true);
    }
}
