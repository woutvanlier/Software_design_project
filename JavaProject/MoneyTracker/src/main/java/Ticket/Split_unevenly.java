package Ticket;
import database.Person_database;
import Person.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//Everybody had something different: ticket is not split evenly
public class Split_unevenly extends Abstract_decorator {

    private List<Person> db = Person_database.getInstance().getDb();
    private HashMap<String,Double> prices = new HashMap<String,Double>();

    private double SumOfPrices;

    private Scanner scanner = new Scanner(System.in);

    public Split_unevenly(Abstract_ticket ticket) {
        super(ticket);
        setPrices();
    }
    public void setPrices() {
        boolean completed = false;
        while(!completed)
        {
            System.out.println("The bill was: €" + super.getPrice() + " , paid on "+super.getDate());
            for (Person p : db)
            {
                if (!Objects.equals(super.getName(), p.getFullName())) {
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
    }
    @Override
    public void showOwed(String name) {
        System.out.println("You owe "+super.getName()+": €"+prices.get(name)+" , paid on "+super.getDate());
    }
}
