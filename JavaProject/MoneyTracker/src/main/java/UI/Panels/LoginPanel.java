package UI.Panels;

import UI.FrameManager;
import UI.Views.HomeView;
import UI.Views.LoginView;

import javax.swing.*;
import java.awt.*;
import  UI.ButtonSound;

public class LoginPanel extends JPanel
{

    ButtonSound buttonSound = new ButtonSound();
    public LoginPanel(JComboBox LoginNamePane, JButton LoginButton, LoginView loginView, FrameManager frameManager)
    {
        this.setBackground(new Color(30,30,30));

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Choose login name
        JLabel login = new JLabel("LOGIN", SwingConstants.CENTER);
        login.setOpaque(true);
        login.setBackground(new Color(30, 30, 30));
        login.setForeground(Color.white);
        c.anchor = GridBagConstraints.CENTER;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.insets = new Insets(0, 0,10,0);
        this.add(login, c);

        // ComboBox
        c.gridy = 1;
        c.insets = new Insets(10, 0,10,0);
        this.add(LoginNamePane, c);


        LoginButton.setPreferredSize(new Dimension(70,30));
        c.gridy = 2;
        c.weighty = 1.0;
        c.insets = new Insets(10, 0,0,0);
        this.add(LoginButton,c);

        LoginButton.addActionListener(e -> {
            HomeView homeView = new HomeView(frameManager, frameManager.getPersonDatabase(), frameManager.getTicketDatabase(),loginView);
            frameManager.setContentPane(homeView);
            frameManager.revalidate();
            buttonSound.playSound("src/main/java/UI/tap.wav");

        });
    }
}
