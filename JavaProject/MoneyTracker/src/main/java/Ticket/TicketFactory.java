package Ticket;

public class TicketFactory {
    public Ticket createTicket(String name, double price, String date, String typeOfTicket){
        return new Ticket(name,price,date,typeOfTicket);
    }
}
