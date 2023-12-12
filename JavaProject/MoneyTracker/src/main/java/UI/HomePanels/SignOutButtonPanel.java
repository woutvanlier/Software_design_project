package UI.HomePanels;

import UI.FrameManager;
import UI.Views.LoginView;

import javax.swing.*;

public class SignOutButtonPanel extends JPanel
{
    public SignOutButtonPanel(FrameManager frameManager, LoginView loginView)
    {
        JButton button = new JButton("SIGN OUT");
        button.addActionListener(e ->
        {
            loginView.UpdateLogInBox();
            frameManager.setContentPane(loginView);
            frameManager.revalidate();
        });
        this.add(button);
    }
}
