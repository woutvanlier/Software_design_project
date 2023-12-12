package Ticket;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import Person.Person;
import database.Person_database;

public abstract class Abstract_decorator implements Abstract_ticket
{
    private final List<Person> db = Person_database.getInstance().getDb();
    private HashMap<String, Boolean> HavePayed = new HashMap<String, Boolean>();
    private final Abstract_ticket ticket;

    public Abstract_decorator(Abstract_ticket ticket) {
        this.ticket = ticket;
        for(Person p : db){
            if(!Objects.equals(p.getFullName(), getTicketHolder())){
                HavePayed.put(p.getFullName(),false);
            }
        }
    }
    public abstract double showOwed(String name);

    public String getTicketHolder(){
        return this.ticket.getTicketHolder();
    }
    public void setTicketHolder(String name){
        this.ticket.setTicketHolder(name);
    }
    public double getPrice(){
        return this.ticket.getPrice();
    }
    public void setPrice(double price){
         this.ticket.setPrice(price);
    }
    public String getDate() {
        return this.ticket.getDate();}

    public void setDate(String date) {
        this.ticket.setDate(date);}

    public String getTicketName(){
        return this.ticket.getTicketName();
    }
    public void setTicketName(String name){
        this.ticket.setTicketName(name);
    }
    public void setTypeOfTicket(String typeOfTicket){
        this.ticket.setTypeOfTicket(typeOfTicket);
    }

    public String getTypeOfTicket(){
        return this.ticket.getTypeOfTicket();
    }

    @Override
    public void setPayed(String name) {
        HavePayed.replace(name,true);
    }

    public HashMap<String, Boolean> getHavePayed() {
        return HavePayed;
    }
    public void printHavePayed(){
        System.out.println(HavePayed.toString());
    }
    public abstract double calcOwedToHolder();

}