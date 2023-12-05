package Ticket;
import database.Person_database;

// Everybody should pay the same: ticket is split evenly
public class   Split_evenly extends Abstract_decorator {

    private double pricePerPerson;

    public Split_evenly(Abstract_ticket ticket) {
        super(ticket);
        this.pricePerPerson = calculatePricePerPerson();
    }


    public double calculatePricePerPerson(){
        pricePerPerson = (super.getPrice()/Person_database.getInstance().getAmountOfPersons());
        return pricePerPerson;
    }

    @Override
    public void showOwed(String name) {
        System.out.println("You owe "+super.getName()+": €"+pricePerPerson);
    }

}
