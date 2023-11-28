package UI.TicketPanels;

import javax.swing.*;
import java.awt.*;

public class TicketPanel extends JPanel
{
    JTextField ticketNameField;
    JComboBox<String> catNamePane;
    JComboBox<String> personNamePane;
    JTextField priceNameField;
    public TicketPanel()
    {
        JLabel ticketName = new JLabel("Ticket Name");
        ticketName.setOpaque(true);
        ticketName.setBackground(new Color(30,30,30));
        ticketName.setForeground(Color.white);
        this.add(ticketName);

        ticketNameField = new JTextField();
        this.add(ticketNameField);

        JLabel catName = new JLabel("Category");
        catName.setOpaque(true);
        catName.setBackground(new Color(30,30,30));
        catName.setForeground(Color.white);
        this.add(catName);

        String[] catChoices ={"Food & Drinks","Transportation","Accommodation", "Entertainment", "Other"};
        catNamePane = new JComboBox<>(catChoices);
        this.add(catNamePane);

        JLabel personName = new JLabel("Person Paid");
        personName.setOpaque(true);
        personName.setBackground(new Color(30,30,30));
        personName.setForeground(Color.white);
        this.add(personName);

        String[] personChoises={"Eliott","Thomas","Wout"};
        personNamePane = new JComboBox<>(personChoises);
        this.add(personNamePane);

        JLabel priceName = new JLabel("Price");
        priceName.setOpaque(true);
        priceName.setBackground(new Color(30,30,30));
        priceName.setForeground(Color.white);
        this.add(priceName);

        priceNameField = new JTextField();
        this.add(priceNameField);

        JRadioButton even = new JRadioButton("Split even");
        even.setOpaque(true);
        even.setBackground(new Color(30,30,30));
        even.setForeground(Color.white);
        JRadioButton uneven = new JRadioButton("Split uneven");
        uneven.setOpaque(true);
        uneven.setBackground(new Color(30,30,30));
        uneven.setForeground(Color.white);

        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(even);
        radioGroup.add(uneven);

        this.add(even);
        this.add(uneven);
    }

    public JTextField getTicketNameField() {
        return ticketNameField;
    }

    public JComboBox<String> getCatNamePane() {
        return catNamePane;
    }

    public JComboBox<String> getPersonNamePane() {
        return personNamePane;
    }

    public JTextField getPriceNameField() {
        return priceNameField;
    }
}
