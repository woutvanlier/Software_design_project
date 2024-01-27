import Person.Person;
import database.Person_database;
import org.junit.Assert;
import org.junit.Test;
import Ticket.Ticket;
import Ticket.Abstract_ticket;
import database.Ticket_database;
import Ticket.TicketFactory;
import database.Person_database;
public class IntegrationTest {
    public IntegrationTest() {
    }

    @Test
    public void CreateAndAddTicket() {
        Abstract_ticket ticket = TicketFactory.createTicket_even("ticket","Name",8,"27/01/24","Food & Drinks");
        Ticket_database t_db = Ticket_database.getInstance();
        t_db.addTicket(ticket);
        int index = t_db.getDb().indexOf(ticket);
        Assert.assertEquals("Test if ticket is correctly added to database: ",ticket,t_db.getDb().get(index));
        Assert.assertEquals("Test if the ticket has the correct name: ", "ticket", t_db.getDb().get(index).getTicketName());
    }
}
