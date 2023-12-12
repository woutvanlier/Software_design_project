package UI.Views;

import UI.FrameManager;
import UI.HomePanels.LogPanel;
import UI.Panels.BackButtonPanel;
import UI.Panels.SeparatorPanel;
import UI.Panels.TitlePanel;
import UI.TicketPanels.AddTicketButtonPanel;
import UI.TicketPanels.TicketPanel;

import javax.swing.*;
import java.awt.*;

public class TicketView extends JPanel
{
    TicketPanel ticketPanel;
    public TicketView(LogPanel logPanel, HomeView homeView, FrameManager frameManager, LoginView loginview)
    {
        this.setBackground(new Color(30,30,30));

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Title
        TitlePanel titlePanel = new TitlePanel("N E W   T I C K E T");
        titlePanel.setLayout(new GridLayout(1,1));
        //region >> Constraints
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.PAGE_START;
        //endregion
        this.add(titlePanel, c);

        // Line 1
        SeparatorPanel separatorPanel = new SeparatorPanel(SwingConstants.HORIZONTAL);
        separatorPanel.setLayout(new GridLayout(1,1));
        //region >> Constraints
        c.gridy = 1;
        //endregion
        this.add(separatorPanel,c);

        // TicketPane
        ticketPanel = new TicketPanel(frameManager.getPersonDatabase());
        //region >> Constraints
        c.gridy = 2;
        c.weighty = 1.0;
        c.insets = new Insets(20,20,20,20);
        //endregion
        this.add(ticketPanel, c);

        //Button
        AddTicketButtonPanel addButton = new AddTicketButtonPanel(this, logPanel, frameManager, homeView, ticketPanel,loginview);
        addButton.setLayout(new GridLayout(1,1));
        //region >> Constraints
        c.weighty = 0.0;
        c.gridy = 3;
        c.insets.bottom = 0;
        c.anchor = GridBagConstraints.PAGE_END;
        //endregion
        this.add(addButton, c);

        //Button
        BackButtonPanel backButton = new BackButtonPanel(frameManager, homeView);
        backButton.setLayout(new GridLayout(1,1));
        //region >> Constraints
        c.gridy = 4;
        c.insets.bottom = 20;
        c.insets.top = 5;
        //endregion
        this.add(backButton, c);



    }

    public String getTicketName()
    {
        return ticketPanel.getTicketNameField().getText();
    }

    public double getPricePaid()
    {
        return Double.parseDouble(ticketPanel.getPriceNameField().getText());
    }

    public String getPersonPaid()
    {
        return ticketPanel.getPersonNamePane().getSelectedItem().toString();
    }

    public String getTicketCat()
    {
        return ticketPanel.getCatNamePane().getSelectedItem().toString();
    }

    public String getDatePaid(){return ticketPanel.getDateField().getText();}

}
