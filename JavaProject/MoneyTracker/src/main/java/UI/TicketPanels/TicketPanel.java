package UI.TicketPanels;

import Person.Person;
import UI.Panels.TitlePanel;
import database.Person_database;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;

public class TicketPanel extends JPanel
{
    JTextField ticketNameField;
    JComboBox<String> catNamePane;
    JComboBox<String> personNamePane;
    JTextField priceNameField;

    JDatePickerImpl datePicker;

    JLabel Error;

    String Split;
    public TicketPanel(Person_database p_db)
    {
        this.setBackground(new Color(30,30,30));
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        JLabel ticketName = new JLabel("Ticket Name");
        ticketName.setOpaque(true);
        ticketName.setBackground(new Color(30,30,30));
        ticketName.setForeground(Color.white);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.insets.bottom = 10;
        c.gridx = 0;
        c.gridy = 0;
        this.add(ticketName, c);

        ticketNameField = new JTextField();
        c.gridx = 1;
        c.gridy = 0;
        this.add(ticketNameField, c);

        JLabel catName = new JLabel("Category");
        catName.setOpaque(true);
        catName.setBackground(new Color(30,30,30));
        catName.setForeground(Color.white);
        c.insets.top = 10;
        c.gridx = 0;
        c.gridy = 1;
        this.add(catName, c);

        String[] catChoices ={"Food & Drinks","Transportation","Accommodation", "Entertainment", "Other"};
        catNamePane = new JComboBox<>(catChoices);
        c.gridx = 1;
        c.gridy = 1;
        this.add(catNamePane, c);

        JLabel personName = new JLabel("Person Paid");
        personName.setOpaque(true);
        personName.setBackground(new Color(30,30,30));
        personName.setForeground(Color.white);
        c.gridx = 0;
        c.gridy = 2;
        this.add(personName, c);

        String[] personChoises=p_db.getDbArray();
        personNamePane = new JComboBox<>(personChoises);
        c.gridx = 1;
        c.gridy = 2;
        this.add(personNamePane, c);

        JLabel priceName = new JLabel("Price");
        priceName.setOpaque(true);
        priceName.setBackground(new Color(30,30,30));
        priceName.setForeground(Color.white);
        c.gridx = 0;
        c.gridy = 3;
        this.add(priceName, c);

        priceNameField = new JTextField();
        c.gridx = 1;
        c.gridy = 3;
        this.add(priceNameField, c);

        JLabel date = new JLabel("Date");
        date.setOpaque(true);
        date.setBackground(new Color(30,30,30));
        date.setForeground(Color.white);
        c.gridx = 0;
        c.gridy = 4;
        this.add(date, c);


        UtilDateModel model = new UtilDateModel();
        model.setDate(2023,11,12);
        // Need this...
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        // Don't know about the formatter, but there it is...
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        c.gridx = 1;
        c.gridy = 4;
        this.add(datePicker, c);

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

        c.insets.bottom = 0;
        c.gridx = 0;
        c.gridy = 5;
        this.add(even, c);
        c.gridx = 1;
        c.gridy = 5;
        this.add(uneven, c);
        even.addActionListener(e -> {
            Split = "even";
        });
        uneven.addActionListener(e -> {
            Split = "uneven";
            });
        this.Error = new JLabel("There are empty fields!");
        Error.setForeground(new Color(120,30,30));
        Error.setBackground(new Color(30,30,30));
        Error.setOpaque(false);
        Error.setVisible(false);
        c.gridx = 0;
        c.gridy = c.gridy+1;
        this.add(Error,c);
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

    //public JTextField getDateField(){return dateField;}

    public String getSplit() {
        return Split;
    }

    public JDatePickerImpl getDatePicker() {
        return datePicker;
    }

    public void SetErrorToTrue(){
        Error.setVisible(true);
    }
    public void SetErrorToFalse(){
        Error.setVisible(false);
    }
}
