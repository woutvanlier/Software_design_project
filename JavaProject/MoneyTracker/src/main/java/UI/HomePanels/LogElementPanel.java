package UI.HomePanels;

import javax.swing.*;
import java.awt.*;
import java.io.File;

import Person.Person;
import Ticket.Abstract_ticket;

import java.text.DecimalFormat;
import java.util.Objects;
public class LogElementPanel extends JPanel
{
    public LogElementPanel(Abstract_ticket ticket, Person person)
    {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        ImageIcon icon = new ImageIcon(getCategory(ticket.getTypeOfTicket()));
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance( 25, 25,  Image.SCALE_SMOOTH );
        icon = new ImageIcon(newImg);
        JLabel label = new JLabel(icon);
        //region >> Constraints
        c.insets = new Insets(5, 5, 5, 20);
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 2;
        //endregion
        this.add(label, c);

        JLabel nameTicket = new JLabel(ticket.getTicketName());
        Font font = new Font(nameTicket.getFont().toString(), Font.BOLD,12);
        nameTicket.setFont(font);
        //region >> Constraints
        c.insets = new Insets(0,0,0,0);
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.insets.top = 3;
        c.anchor = GridBagConstraints.LINE_START;
        //endregion
        this.add(nameTicket, c);
        String ticketholder;
        String owedOrborrowed;
        Color borrowedOrPaidC;
        double price;
        if(Objects.equals(ticket.getTicketHolder(),person.getFullName())){
            ticketholder = "You";
            owedOrborrowed = "You lent";
            price = ticket.showOwedToHolder();
            borrowedOrPaidC = new Color(120,30,30);
        }else {
            ticketholder = ticket.getTicketHolder();
            owedOrborrowed = "You owe";
            price = ticket.showOwed(person.getFullName());
            borrowedOrPaidC = new Color(30,120,30);
        }
        JLabel personPaid = new JLabel(ticketholder + " paid €" + ticket.getPrice());
        personPaid.setForeground(new Color(80, 80, 80));
        font = new Font(personPaid.getFont().toString(), Font.PLAIN, 8);
        personPaid.setFont(font);
        //region >> Constraints
        c.gridx = 1;
        c.gridy = 1;
        c.insets.top = 0;
        c.insets.bottom = 3;
        //endregion
        this.add(personPaid, c);

        JLabel borrowedOrPaid = new JLabel(owedOrborrowed);
        borrowedOrPaid.setForeground(borrowedOrPaidC);
        font = new Font(borrowedOrPaid.getFont().toString(), Font.BOLD, 10);
        borrowedOrPaid.setFont(font);
        //region >> Constraints
        c.gridx = 2;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets.top = 3;
        c.insets.right = 5;
        c.insets.bottom = 0;
        //endregion
        this.add(borrowedOrPaid, c);
        DecimalFormat df = new DecimalFormat("0.00");
        JLabel priceLabel = new JLabel(df.format(price));
        font = new Font(priceLabel.getFont().toString(), Font.BOLD,12);
        priceLabel.setFont(font);
        //region >> Constraints
        c.gridx = 2;
        c.gridy = 1;
        c.insets.top = 0;
        c.insets.bottom = 3;
        //endregion
        this.add(priceLabel,c);
    }

    public String getCategory(String cat)
    {
        String pathName = "src/main/java/UI/Resources/";

        switch (cat)
        {
            case "Food & Drinks" -> pathName += "food.png";
            case "Transportation" -> pathName += "transportation.png";
            case "Accommodation" -> pathName += "hotel.png";
            case "Entertainment" -> pathName += "game-center.png";
            default -> pathName += "application.png";
        }

        return new File(pathName).getAbsolutePath();
    }
}
