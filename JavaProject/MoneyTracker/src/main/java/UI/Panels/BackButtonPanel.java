package UI.Panels;
import UI.FrameManager;
import UI.Views.HomeView;
import  UI.ButtonSound;


import javax.swing.*;

public class BackButtonPanel extends JPanel
{

    ButtonSound buttonSound = new ButtonSound();

    public BackButtonPanel(FrameManager frameManager, HomeView homeView)
    {
        JButton button = new JButton("GO BACK");
        button.addActionListener(e ->
        {
            frameManager.setContentPane(homeView);
            frameManager.revalidate();
            buttonSound.playSound("src/main/java/UI/Resources/button.wav");
        });


        this.add(button);
    }
}
