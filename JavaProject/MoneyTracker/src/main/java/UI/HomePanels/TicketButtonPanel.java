package UI.HomePanels;

import UI.ButtonSound;
import UI.FrameManager;
import UI.Views.HomeView;
import UI.Views.LoginView;
import UI.Views.TicketView;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import  UI.ButtonSound;

public class TicketButtonPanel extends JPanel
{

    ButtonSound buttonSound = new ButtonSound();
    public TicketButtonPanel(LogPanel logPanel, FrameManager frameManager, HomeView homeView, LoginView loginview)
    {
        String src = new File("src/main/java/UI/Resources/button3.png").getAbsolutePath();
        ImageIcon icon = new ImageIcon(src);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance( 75, 44,  Image.SCALE_SMOOTH );
        icon = new ImageIcon(newImg);
        JButton button = new JButton(icon);

        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);

        button.setPreferredSize(new Dimension(75,44));

        button.addActionListener(e ->
        {
            TicketView ticketView = new TicketView(logPanel, homeView, frameManager, loginview);
            frameManager.setContentPane(ticketView);
            frameManager.revalidate();
            buttonSound.playSound("src/main/java/UI/tap.wav");
        });

        this.add(button);
    }
}
