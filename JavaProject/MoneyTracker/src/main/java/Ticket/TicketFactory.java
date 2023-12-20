package Ticket;

import database.Ticket_database;

import java.util.HashMap;

public class TicketFactory {
    public static Split_evenly createTicket_even(String ticketName, String ticketHolder, double price, String date, String typeOfTicket){
        Split_evenly ticket = new Split_evenly(new Ticket(ticketName,ticketHolder,price,date,typeOfTicket));
        Ticket_database.getInstance().addTicket(ticket);
        return ticket;
    }
    public static Split_unevenly createTicket_unevenly(String ticketName, String ticketHolder, double price, String date, String typeOfTicket){
        Split_unevenly ticket = new Split_unevenly(new Ticket(ticketName,ticketHolder,price,date,typeOfTicket));
        Ticket_database.getInstance().addTicket(ticket);
        return ticket;
    }
    public static Split_unevenly createTicket_unevenly_withMap(String ticketName, String ticketHolder, double price, String date, String typeOfTicket, HashMap<String,Double> map){
        Split_unevenly ticket = new Split_unevenly(new Ticket(ticketName,ticketHolder,price,date,typeOfTicket),map);
        Ticket_database.getInstance().addTicket(ticket);
        return ticket;
    }
}
