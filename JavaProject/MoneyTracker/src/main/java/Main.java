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
        Person_database personDB = new Person_database();

        Person person1 = new Person("Eliott");
        Person person2 = new Person("Eliott");
        Person person3 = new Person("Wout");
        Person person4 = new Person("Thomas");

        personDB.addPerson(person1);
        personDB.addPerson(person2);
        personDB.addPerson(person3);
        personDB.addPerson(person4);

        Ticket_database ticketDB = new Ticket_database();

        Ticket ticket1 = new Ticket("McDonalds", 45.2, "Food & Drinks");
        Ticket ticket2 = new Ticket("McDonalds", 45.2, "Food & Drinks");
        Ticket ticket3 = new Ticket("Hotel", 300.25, "Accommodation");
        Ticket ticket4 = new Ticket("Flight", 845, "Transportation");

        ticketDB.addTicket(ticket1);
        ticketDB.addTicket(ticket2);
        ticketDB.addTicket(ticket3);
        ticketDB.addTicket(ticket4);
    }
}