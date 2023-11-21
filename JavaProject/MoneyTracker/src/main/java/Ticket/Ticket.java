package Ticket;

public class Ticket implements Asbtract_ticket{
    enum TicketType
    {
        Airplane,
        Restaurant,
        Taxi,
        Concert
    }
    private TicketType typeOfTicket;
    private String name;
    private double price;
    public Ticket(String name, double price, String typeOfTicket) {
        this.name = name;
        this.price = price;
        switch(typeOfTicket){
            case "Airplane":
                this.typeOfTicket = TicketType.Airplane;
            case "Restaurant":
                this.typeOfTicket = TicketType.Restaurant;
            case "Taxi":
                this.typeOfTicket = TicketType.Taxi;
            case "Concert":
                this.typeOfTicket = TicketType.Concert;
            default:
               System.out.println("Invalid type of ticket!");
        }
    }

    public Ticket() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract void showOwed(String name);
}
