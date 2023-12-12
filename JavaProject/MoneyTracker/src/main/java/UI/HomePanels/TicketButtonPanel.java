package UI.HomePanels;

import UI.FrameManager;
import UI.Views.HomeView;
import UI.Views.LoginView;
import UI.Views.TicketView;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class TicketButtonPanel extends JPanel
{
    public TicketButtonPanel(LogPanel logPanel, FrameManager frameManager, HomeView homeView, LoginView loginview)
    {
        String src = new File("src/main/java/UI/Resources/button3.png").getAbsolutePath();
        ImageIcon icon = new ImageIcon(src);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance( 70, 50,  Image.SCALE_SMOOTH );
        icon = new ImageIcon(newImg);
        JButton button = new JButton(icon);

        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);

        button.setPreferredSize(new Dimension(70,50));

        button.addActionListener(e ->
        {
            TicketView ticketView = new TicketView(logPanel, homeView, frameManager, loginview);
            frameManager.setContentPane(ticketView);
            frameManager.revalidate();
        });

        this.add(button);
    }
}
