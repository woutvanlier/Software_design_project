import Person.Person;
import Person.PersonFactory;
import Ticket.Ticket;
import UI.FrameManager;
import database.Person_database;
import database.Ticket_database;
import Ticket.Split_evenly;
import Ticket.Split_unevenly;

import java.awt.*;

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
        PersonFactory personFactory = new PersonFactory();


        Person person1 = personFactory.createPerson("Eliott");
        Person person2 = personFactory.createPerson("Eliott");
        Person person3 = personFactory.createPerson("Wout");
        Person person4 = personFactory.createPerson("Tomas");


        personDB.addPerson(person1);
        personDB.addPerson(person2);
        personDB.addPerson(person3);
        personDB.addPerson(person4);

        System.out.println(personDB);

        Ticket_database ticketDB = Ticket_database.getInstance();

        ticketDB.changeNameOnTicket("Tomas","Thomas",personDB);

        System.out.println(ticketDB);

        Ticket ticket1 = new Ticket("Eliottt", 45.2,"10/02/2023", "Restaurant");
        Ticket ticket2 = new Ticket("Wout", 45.2,"11/02/2023", "Restaurant");
        Ticket ticket3 = new Ticket("Thomas", 300.25,"18/02/2023", "Concert");
        Ticket ticket4 = new Ticket("Eliottt", 845,"20/02/2023", "Airplane");


        Split_evenly ticket_even = new Split_evenly(ticket1);
        Split_unevenly ticket_uneven = new Split_unevenly(ticket3);

        System.out.println(Person_database.getInstance().getAmountOfPersons());

        ticket_even.showOwed("Eliott");


        ticketDB.addTicket(ticket1);
        ticketDB.addTicket(ticket2);
        ticketDB.addTicket(ticket3);
        ticketDB.addTicket(ticket4);

        System.out.println(ticketDB);


        FrameManager frameManager = new FrameManager();
        frameManager.initialize();
    }
}