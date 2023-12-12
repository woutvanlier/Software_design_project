package Ticket;
import Person.Person;

public interface Abstract_ticket {
    
     double showOwed(String name);
     String getTicketName();
     void setTicketName(String name);
     double getPrice();
     void setPrice(double price);

     String getDate();

     void setDate(String date);
     void setTypeOfTicket(String typeOfTicket);

     String getTypeOfTicket();
     String getTicketHolder();
     void setTicketHolder(String ticketHolder);

     void setPayed(String name);

     double calcOwedToHolder();
}
