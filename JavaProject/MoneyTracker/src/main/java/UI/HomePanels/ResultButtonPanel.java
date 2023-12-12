package UI.HomePanels;

import UI.FrameManager;
import UI.Views.HomeView;
import UI.Views.LoginView;
import UI.Views.ResultView;
import database.Person_database;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import  UI.ButtonSound;

public class ResultButtonPanel extends JPanel
{

    ButtonSound buttonSound = new ButtonSound();

    public ResultButtonPanel(FrameManager frameManager, HomeView homeView, LoginView loginView) // From Higher class Button??
    {
        String src = new File("src/main/java/UI/Resources/button2.png").getAbsolutePath();;
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
            ResultView resultView = new ResultView(frameManager, homeView, loginView);
            frameManager.setContentPane(resultView);
            frameManager.revalidate();
            buttonSound.playSound("src/main/java/UI/tap.wav");
        });

        this.add(button);
    }
}
