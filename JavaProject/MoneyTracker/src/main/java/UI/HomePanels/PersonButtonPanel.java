package UI.HomePanels;

import UI.FrameManager;
import UI.Views.HomeView;
import UI.Views.PersonView;
import database.Person_database;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import  UI.ButtonSound;

public class PersonButtonPanel extends JPanel
{

    ButtonSound buttonSound = new ButtonSound();

    public PersonButtonPanel(FrameManager frameManager, HomeView homeView)
    {
        String src = new File("src/main/java/UI/Resources/button1.png").getAbsolutePath();
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
            PersonView personView = new PersonView(homeView, frameManager, frameManager.getPersonDatabase());
            frameManager.setContentPane(personView);
            frameManager.revalidate();
            buttonSound.playSound("src/main/java/UI/Resources/tap.wav");
        });
        this.add(button);
    }
}
