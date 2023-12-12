package Ticket;

import java.util.HashMap;

public class TicketFactory {
    public static Split_evenly createTicket_even(String ticketName, String ticketHolder, double price, String date, String typeOfTicket){
        return new Split_evenly(new Ticket(ticketName,ticketHolder,price,date,typeOfTicket));
    }
    public static Split_unevenly createTicket_unevenly(String ticketName, String ticketHolder, double price, String date, String typeOfTicket){
        return new Split_unevenly(new Ticket(ticketName,ticketHolder,price,date,typeOfTicket));
    }
    public static Split_unevenly createTicket_unevenly_withMap(String ticketName, String ticketHolder, double price, String date, String typeOfTicket, HashMap<String,Double> map){
        return new Split_unevenly(new Ticket(ticketName,ticketHolder,price,date,typeOfTicket),map);
    }
}
