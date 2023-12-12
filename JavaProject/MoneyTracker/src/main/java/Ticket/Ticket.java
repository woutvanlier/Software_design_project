package Ticket;

import Person.Person;
import database.Ticket_database;

public class Ticket implements Abstract_ticket {

    private String TicketHolder;

    private String typeOfTicket;

    private String TicketName;
    private double price;
    private String date;

    protected Ticket(String TicketName, String TicketHolder, double price, String date, String typeOfTicket) {
        this.TicketName = TicketName;
        this.price = price;
        this.date = date;
        this.TicketHolder = TicketHolder;
        switch (typeOfTicket) {
            case "Food & Drinks", "Transportation","Accommodation", "Entertainment" -> this.typeOfTicket = typeOfTicket;
            default -> this.typeOfTicket = "Other";
        }
    }

    public String getTicketHolder() {
        return TicketHolder;
    }

    public void setTicketHolder(String ticketHolder) {
        TicketHolder = ticketHolder;
    }

    @Override
    public void setPayed(String person) {}
    @Override
    public double calcOwedToHolder() {
        return 0;
    }

    public String getTypeOfTicket() {
        return typeOfTicket;
    }

    public void setTypeOfTicket(String typeOfTicket) {
        switch (typeOfTicket) {
            case "Food & Drinks", "Transportation","Accommodation", "Entertainment" -> this.typeOfTicket = typeOfTicket;
            default -> this.typeOfTicket = "Other";
        }
    }
    @Override
    public double showOwed(String name) {return 0;}

    public String getTicketName() {
        return TicketName;
    }

    public void setTicketName(String name) {
        this.TicketName = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {return date;}

    public void setDate(String date) {this.date = date;}

}
