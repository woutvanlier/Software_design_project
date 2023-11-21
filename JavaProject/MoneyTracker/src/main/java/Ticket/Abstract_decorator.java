package Ticket;

public abstract class Abstract_decorator implements Abstract_ticket
{
    private Abstract_ticket ticket;

    public Abstract_decorator(Abstract_ticket ticket) {
        this.ticket = ticket;
    }
    public abstract void showOwed(String name);
    @Override
    public void SplitDecorate(){
        ticket.SplitDecorate();
    }
}