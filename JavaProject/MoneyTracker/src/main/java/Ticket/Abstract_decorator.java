package Ticket;

public class Abstract_decorator extends Abstract_ticket

{
    private Abstract_Ticket abstractTicket;
    
    // standard constructors
    @Override
    void showOwed(String name);
}