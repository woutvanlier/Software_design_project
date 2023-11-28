package UI.Panels;

import UI.FrameManager;
import UI.Views.HomeView;

import javax.swing.*;

public class BackButtonPanel extends JPanel
{
    public BackButtonPanel(FrameManager frameManager, HomeView homeView)
    {
        JButton button = new JButton("GO BACK");
        button.addActionListener(e ->
        {
            frameManager.setContentPane(homeView);
            frameManager.revalidate();
        });
        this.add(button);
    }
}
