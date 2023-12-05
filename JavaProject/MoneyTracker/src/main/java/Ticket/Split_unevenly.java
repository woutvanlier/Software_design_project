package Ticket;
import database.Person_database;
import Person.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//Everybody had something different: ticket is not split evenly
public class Split_unevenly extends Abstract_decorator {

    private List<Person> db = Person_database.getInstance().getDb();
    private HashMap<String,Double> prices = new HashMap<String,Double>();

    private Scanner scanner = new Scanner(System.in);

    public Split_unevenly(Abstract_ticket ticket) {
        super(ticket);
        setPrices();
    }
    public void setPrices(){
        System.out.println("The bill was: €"+super.getPrice());
        for(Person p : db){
            System.out.println("How much does "+p.getFullName()+" owe you: ");
            Double amount = scanner.nextDouble();
            prices.put(p.getFullName(),amount);
        }
    }
    @Override
    public void showOwed(String name) {
        System.out.println("You owe "+super.getName()+": €"+prices.get(name));
    }
}
