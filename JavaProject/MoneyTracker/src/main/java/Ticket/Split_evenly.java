package Ticket;


// Everybody should pay the same: ticket is split evenly
public class Split_evenly extends Abstract_decorator {

    public Split_evenly(Abstract_ticket ticket) {
        super(ticket);
    }

    @Override
    public void showOwed(String name) {

    }
}
