package UI.HomePanels;

import UI.FrameManager;
import UI.Views.HomeView;
import UI.Views.PersonView;
import database.Person_database;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class PersonButtonPanel extends JPanel
{
    public PersonButtonPanel(FrameManager frameManager, HomeView homeView, Person_database personDatabase)
    {
        String src = new File("src/main/java/UI/Resources/button1.png").getAbsolutePath();
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
            PersonView personView = new PersonView(homeView, frameManager, personDatabase);
            frameManager.setContentPane(personView);
            frameManager.revalidate();
        });
        this.add(button);
    }
}
