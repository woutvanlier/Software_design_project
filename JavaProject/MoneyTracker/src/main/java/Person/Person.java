package Person;

import Ticket.Ticket;
import database.Ticket_database;
import Ticket.Abstract_ticket;
import java.util.Objects;
public class Person
{
    private String fullName;

    protected Person(String fullName)
    {
        this.fullName = fullName;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void changeFullName(String newfullName) {this.fullName = newfullName;}

    public void setPayed(Ticket ticket){
        ticket.setPayed(this.getFullName());
    }

    public double calcTotalOwed(){
        double totalOwed = 0;
        Ticket_database t_db = Ticket_database.getInstance();
        for (Abstract_ticket t : t_db.getDb()){
            totalOwed += t.showOwed(this.getFullName());
        }
        return totalOwed;
    }

    public double showOwedToPerson(String name){
        double owed = 0;
        Ticket_database t_db = Ticket_database.getInstance();
        for (Abstract_ticket t : t_db.getDb()){
            if(Objects.equals(name,t.getTicketHolder())){
                owed += t.showOwed(this.getFullName());
            }
        }
        return owed;
    }
    public double showOwedToYou(){
        double owed = 0;
        Ticket_database t_db = Ticket_database.getInstance();
        for (Abstract_ticket t : t_db.getDb()){
            if(Objects.equals(this.getFullName(),t.getTicketHolder())){
                owed += t.calcOwedToHolder();
            }
        }
        return owed;
    }
}