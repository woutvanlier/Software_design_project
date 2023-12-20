import Person.Person;
import Person.PersonFactory;
import Ticket.Ticket;
import UI.FrameManager;
import database.Person_database;
import database.Ticket_database;
import Ticket.Split_evenly;
import Ticket.Split_unevenly;
import Ticket.TicketFactory;
import Ticket.Abstract_ticket;
import java.awt.*;

public class Main
{
    public static void main(String[] args)
    {
        Main main = new Main();
        main.run();
    }

    public void run()
    {
        Person_database personDB = Person_database.getInstance();
        //PersonFactory personFactory = new PersonFactory();

        // Because person is protected, we need to make persons via the factory!

        Person person1 = PersonFactory.createPerson("Eliott");
        Person person2 = PersonFactory.createPerson("Eliott");
        Person person3 = PersonFactory.createPerson("Wout");
        Person person4 = PersonFactory.createPerson("Tomas");

        System.out.println(personDB);

        Ticket_database ticketDB = Ticket_database.getInstance();

        ticketDB.changeNameOnTicket("Tomas","Thomas",personDB);

        System.out.println(ticketDB);

        Abstract_ticket ticket1 = TicketFactory.createTicket_even("Restaurant1","Eliott", 45.2,"10/02/2023", "Restaurant");
        Abstract_ticket ticket2 = TicketFactory.createTicket_unevenly("Restaurant2","Wout", 45.2,"11/02/2023", "Restaurant");
        Abstract_ticket ticket3 = TicketFactory.createTicket_even("Concert1","Thomas", 300.25,"18/02/2023", "Concert");
        Abstract_ticket ticket4 = TicketFactory.createTicket_even("Airplane1","Eliott", 845,"20/02/2023", "Airplane");


        //Split_evenly ticket_even = new Split_evenly(ticket1);
        //Split_unevenly ticket_uneven = new Split_unevenly(ticket3);

        System.out.println(Person_database.getInstance().getAmountOfPersons());

        //ticket_even.showOwed("Eliott");

        System.out.println(ticketDB);

        FrameManager frameManager = new FrameManager();
        frameManager.initialize(personDB, ticketDB);
    }
}
