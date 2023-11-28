package Ticket;
import database.Person_database;

// Everybody should pay the same: ticket is split evenly
public class Split_evenly extends Abstract_decorator {
    private double PricePerPerson;

    public Split_evenly(Abstract_ticket ticket) {
        super(ticket);
        this.PricePerPerson = calculatePricePerPerson();
    }

    @Override
    public void showOwed(String name) {
        System.out.println("You owe "+super.getName()+": €"+PricePerPerson);
    }
    public double calculatePricePerPerson(){
        PricePerPerson = (super.getPrice()/Person_database.getInstance().getAmountOfPersons());
        return PricePerPerson;
    }

}
