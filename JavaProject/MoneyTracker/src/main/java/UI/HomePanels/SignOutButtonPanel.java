package UI.HomePanels;

import UI.FrameManager;
import UI.Views.LoginView;
import UI.Views.TicketView;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import UI.ButtonSound;

public class SignOutButtonPanel extends JPanel
{
    ButtonSound buttonSound = new ButtonSound();

    public SignOutButtonPanel(FrameManager frameManager, LoginView loginView)
    {
        String src = new File("src/main/java/UI/Resources/button4.png").getAbsolutePath();
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
            loginView.UpdateLogInBox();
            loginView.ResetLogin();
            frameManager.setContentPane(loginView);
            frameManager.revalidate();
            buttonSound.playSound("src/main/java/UI/dong.wav");
        });

        this.add(button);
    }
}
