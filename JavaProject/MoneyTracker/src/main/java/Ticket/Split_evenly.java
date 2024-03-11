package Ticket;
import database.Person_database;

// Everybody should pay the same: ticket is split evenly
public class Split_evenly extends Abstract_decorator {
    private double PricePerPerson;

    protected Split_evenly(Abstract_ticket ticket) {
        super(ticket);
        this.PricePerPerson = calculatePricePerPerson();
    }

    @Override
    public double showOwed(String name) {
        return PricePerPerson;
    }

    @Override
    public double calcOwedToHolder() {
        double owed = 0;
        owed = this.getPrice() - this.PricePerPerson;
        return owed;
    }

    @Override
    public double showOwedToHolder() {
        return this.getPrice() - PricePerPerson;
    }

    public double calculatePricePerPerson(){
        PricePerPerson = (super.getPrice()/Person_database.getInstance().getAmountOfPersons());
        return PricePerPerson;
    }
}
