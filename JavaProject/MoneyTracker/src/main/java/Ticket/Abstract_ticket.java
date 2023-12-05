package Ticket;

public interface Abstract_ticket {
    
     void showOwed(String name);
     String getName();
     void setName(String name);
     double getPrice();
     void setPrice(double price);

     String getDate();

     void setDate(String date);
}
