package UI;

import UI.Views.HomeView;
import database.Person_database;

import javax.swing.*;
import java.awt.*;

public class FrameManager extends JFrame {
    public FrameManager() {
        super("Splitwise");
    }

    public void initialize(Person_database personDatabase)
    {
        HomeView homeView = new HomeView(this, personDatabase);

        this.setSize(350, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(30, 30, 30));

        this.setContentPane(homeView);

        this.setVisible(true);
    }
}
