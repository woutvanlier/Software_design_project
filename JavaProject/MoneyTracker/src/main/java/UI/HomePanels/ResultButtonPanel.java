package UI.HomePanels;

import UI.FrameManager;
import UI.Views.HomeView;
import UI.Views.ResultView;
import database.Person_database;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ResultButtonPanel extends JPanel
{
    public ResultButtonPanel(FrameManager frameManager, HomeView homeView) // From Higher class Button??
    {
        String src = new File("src/main/java/UI/Resources/button2.png").getAbsolutePath();;
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
            ResultView resultView = new ResultView(frameManager, homeView);
            frameManager.setContentPane(resultView);
            frameManager.revalidate();
        });

        this.add(button);
    }
}
