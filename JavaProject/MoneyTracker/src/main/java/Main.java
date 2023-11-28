import Person.Person;
import Ticket.Ticket;
import database.Person_database;
import database.Ticket_database;
import Ticket.Split_evenly;
import Ticket.Split_unevenly;

public class Main
{
    public static void main(String[] args)
    {
        Main main = new Main();
        main.run();
    }

    public Main()
    {

    }

    public void run()
    {
        Person_database personDB = Person_database.getInstance();

        Person person1 = new Person("Eliott");
        Person person2 = new Person("Eliott");
        Person person3 = new Person("Wout");
        Person person4 = new Person("Thomas");

        personDB.addPerson(person1);
        personDB.addPerson(person2);
        personDB.addPerson(person3);
        personDB.addPerson(person4);

        System.out.println(personDB);

        Ticket_database ticketDB = Ticket_database.getInstance();

        Ticket ticket1 = new Ticket("Eliott", 45.2,"10/02/2023", "Restaurant");
        Ticket ticket2 = new Ticket("Wout", 45.2,"11/02/2023", "Restaurant");
        Ticket ticket3 = new Ticket("Jan", 300.25,"18/02/2023", "Concert");
        Ticket ticket4 = new Ticket("Eliott", 845,"20/02/2023", "Airplane");

        personDB.changeFullName("Jan","Thomas");

        Split_evenly ticket_even = new Split_evenly(ticket1);
        Split_unevenly ticket_uneven = new Split_unevenly(ticket3);

        System.out.println(Person_database.getInstance().getAmountOfPersons());

        ticket_even.showOwed("Eliott");


        ticketDB.addTicket(ticket1);
        ticketDB.addTicket(ticket2);
        ticketDB.addTicket(ticket3);
        ticketDB.addTicket(ticket4);

        System.out.println(ticketDB);


    }
}