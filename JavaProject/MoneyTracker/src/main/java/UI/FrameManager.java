package UI;

import UI.Views.HomeView;

import javax.swing.*;
import java.awt.*;

public class FrameManager extends JFrame {
    public FrameManager() {
        super("Splitwise");
    }

    public void initialize()
    {
        HomeView homeView = new HomeView(this);

        this.setSize(350, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(30, 30, 30));

        this.setContentPane(homeView);

        this.setVisible(true);
    }
}
