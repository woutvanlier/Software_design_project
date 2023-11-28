package UI.HomePanels;

import UI.FrameManager;
import UI.Views.HomeView;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class AllButtons extends JPanel
{
    public AllButtons(LogPanel logPanel, FrameManager frameManager, HomeView homeView)
    {
        String src = new File("src/main/java/UI/Resources/buttonLong.png").getAbsolutePath();
        ImageIcon icon = new ImageIcon(src);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance( 230, 60,  Image.SCALE_SMOOTH );
        icon = new ImageIcon(newImg);
        JLabel label = new JLabel(icon);
        label.setPreferredSize(new Dimension(230,60));

        label.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Buttons
        PersonButtonPanel addPersonPanel = new PersonButtonPanel(frameManager, homeView);
        addPersonPanel.setLayout(new GridLayout(1,1));
        addPersonPanel.setOpaque(false);
        addPersonPanel.setBackground(new Color(30,30,30));
        c.gridx = 0;
        label.add(addPersonPanel, c);

        ResultButtonPanel calcResultPanel = new ResultButtonPanel(frameManager, homeView);
        calcResultPanel.setLayout(new GridLayout(1,1));
        calcResultPanel.setOpaque(false);
        calcResultPanel.setBackground(new Color(30,30,30));
        c.gridx = 1;
        c.insets.right = 5;
        c.insets.left = 5;

        label.add(calcResultPanel, c);

        TicketButtonPanel addTicketPanel = new TicketButtonPanel(logPanel, frameManager, homeView);
        addTicketPanel.setLayout(new GridLayout(1,1));
        addTicketPanel.setOpaque(false);
        addTicketPanel.setBackground(new Color(30,30,30));
        c.gridx = 2;
        c.insets.right = 0;
        c.insets.left = 0;

        label.add(addTicketPanel, c);



        this.add(label);
    }
}
