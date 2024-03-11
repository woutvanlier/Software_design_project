package UI.HomePanels;

import UI.FrameManager;
import UI.Views.HomeView;
import UI.Views.LoginView;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class AllButtons extends JPanel
{
    public AllButtons(LogPanel logPanel, FrameManager frameManager, HomeView homeView, LoginView loginview)
    {
        String src = new File("src/main/java/UI/Resources/buttonLong.png").getAbsolutePath();
        ImageIcon icon = new ImageIcon(src);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance( 340, 60,  Image.SCALE_SMOOTH );
        icon = new ImageIcon(newImg);
        JLabel label = new JLabel(icon);
        label.setPreferredSize(new Dimension(340,60));

        label.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Buttons
        PersonButtonPanel addPersonPanel = new PersonButtonPanel(frameManager, homeView);
        addPersonPanel.setLayout(new GridLayout(1,1));
        addPersonPanel.setOpaque(false);
        addPersonPanel.setBackground(new Color(30,30,30));
        c.gridx = 0;
        label.add(addPersonPanel, c);

        ResultButtonPanel calcResultPanel = new ResultButtonPanel(frameManager, homeView, loginview);
        calcResultPanel.setLayout(new GridLayout(1,1));
        calcResultPanel.setOpaque(false);
        calcResultPanel.setBackground(new Color(30,30,30));
        c.gridx = 1;
        c.insets.right = 4;
        c.insets.left = 8;

        label.add(calcResultPanel, c);

        TicketButtonPanel addTicketPanel = new TicketButtonPanel(logPanel, frameManager, homeView, loginview);
        addTicketPanel.setLayout(new GridLayout(1,1));
        addTicketPanel.setOpaque(false);
        addTicketPanel.setBackground(new Color(30,30,30));
        c.gridx = 2;
        c.insets.right = 8;
        c.insets.left = 4;

        label.add(addTicketPanel, c);

        SignOutButtonPanel addSignOut = new SignOutButtonPanel(frameManager,loginview);
        addSignOut.setLayout(new GridLayout(1,1));
        addSignOut.setOpaque(false);
        addSignOut.setBackground(new Color(30,30,30));
        c.gridx = 3;
        c.insets.right = 0;
        c.insets.left = 0;
        label.add(addSignOut, c);

        this.add(label);
    }
}
