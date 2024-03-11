import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import Person.PersonFactory;
import javax.xml.crypto.Data;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import Ticket.Ticket;
import database.Ticket_database;

// Run with PowerMock, an extended version of Mockito
@RunWith(PowerMockRunner.class)
// Prepare class RegistrationController for testing by injecting mocks
@PrepareForTest({ Ticket.class, Ticket_database.class })
public class UnitTest {
    public UnitTest() {
    }
    @Before
    public void initialize()
    {

    }

    @Test
    public void TestaddPerson() throws Exception {
        Field field = Ticket_database.class.getDeclaredField("db");
        field.setAccessible(true);

        Ticket_database mock_tdb = Ticket_database.getInstance();
        List<Ticket> mock_l = Mockito.mock(ArrayList.class);
        field.set(mock_tdb, mock_l);
        Ticket mock_t = Mockito.mock(Ticket.class);
        mock_tdb.addTicket(mock_t);
        Mockito.verify(mock_l, Mockito.times(1)).add(mock_t);
    }
}
