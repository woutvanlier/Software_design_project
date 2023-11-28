package Ticket;

public abstract class Abstract_decorator implements Abstract_ticket
{
    private Abstract_ticket ticket;

    public Abstract_decorator(Abstract_ticket ticket) {
        this.ticket = ticket;
    }
    public abstract void showOwed(String name);

    public String getName(){
        return this.ticket.getName();
    }
    public void setName(String name){
        this.ticket.setName(name);
    }
    public double getPrice(){
        return this.ticket.getPrice();
    }
    public void setPrice(double price){
         this.ticket.setPrice(price);
    }
}