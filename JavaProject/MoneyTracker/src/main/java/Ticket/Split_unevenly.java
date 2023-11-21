package Ticket;


//Everybody had something different: ticket is not split evenly
public class Split_unevenly extends Abstract_decorator {


    public Split_unevenly(Abstract_ticket ticket) {
        super(ticket);
    }

    @Override
    public void showOwed(String name) {

    }
}
