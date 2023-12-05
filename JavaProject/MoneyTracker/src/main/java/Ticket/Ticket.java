package Ticket;

public class Ticket implements Abstract_ticket {

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
    private String date;

    public Ticket(String name, double price, String date, String typeOfTicket) {
        this.name = name;
        this.price = price;
        this.date = date;

        switch(typeOfTicket){
            case "Airplane":
                this.typeOfTicket = TicketType.Airplane;
                break;
            case "Restaurant":
                this.typeOfTicket = TicketType.Restaurant;
                break;
            case "Taxi":
                this.typeOfTicket = TicketType.Taxi;
                break;
            case "Concert":
                this.typeOfTicket = TicketType.Concert;
                break;
            default:
               System.out.println("Invalid type of ticket!");
        }
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

    public String getDate() {return date;}

    public void setDate(String date) {this.date = date;}

    @Override
    public void showOwed(String name) {}

}
