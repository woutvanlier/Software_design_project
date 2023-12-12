package Ticket;
import database.Person_database;
import Person.Person;

import java.util.*;

//Everybody had something different: ticket is not split evenly
public class Split_unevenly extends Abstract_decorator {

    private final List<Person> db = Person_database.getInstance().getDb();
    private HashMap<String,Double> prices = new HashMap<String,Double>();

    private double SumOfPrices;

    private final Scanner scanner = new Scanner(System.in);

    protected Split_unevenly(Abstract_ticket ticket) {
        super(ticket);
        setPrices();
    }

    public Split_unevenly(Abstract_ticket ticket, HashMap<String, Double> prices) {
        super(ticket);
        this.prices = prices;
    }

    public void setPrices() {
        boolean completed = false;
        while(!completed)
        {
            System.out.println("The bill was: €" + super.getPrice() + " , paid on "+super.getDate());
            if(!db.isEmpty()){
            for (Person p : db)
            {
                if (!Objects.equals(super.getTicketHolder(), p.getFullName())) {
                    System.out.println("How much does " + p.getFullName() + " owe you: ");
                    double amount = scanner.nextDouble();
                    SumOfPrices += amount;
                    if (SumOfPrices <= super.getPrice()) {
                        prices.put(p.getFullName(), amount);
                    }
                    else{
                        System.out.println("Amount exceeded ticket value!");
                        prices.clear();
                        SumOfPrices = 0;
                        break;
                    }
                }
            }
            if(!prices.isEmpty()){
                completed = true;
            }
        }
        else{
            System.out.println("The person database is empty!");
            completed = true;
        }}
    }
    @Override
    public double showOwed(String name) {
        if(prices.get(name)!=null){
        return prices.get(name);}
        else{
            return 0;
        }
    }

    @Override
    public double calcOwedToHolder() {
        double owed = 0;
        for(Map.Entry<String, Double> e : prices.entrySet()){
            owed += e.getValue();
        }
        return owed;
    }
    public void setPricePerson(String name, double price){
            prices.put(name,price);
    }

    public void setPrices(HashMap<String, Double> prices) {
        this.prices = prices;
    }

}
