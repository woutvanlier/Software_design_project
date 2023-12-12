package UI.Views;

import UI.FrameManager;
import UI.HomePanels.*;
import UI.Panels.SeparatorPanel;
import UI.Panels.TitlePanel;
import database.Person_database;
import Person.Person;
import database.Ticket_database;

import javax.swing.*;
import java.awt.*;
public class LoginView extends JPanel {
    TitlePanel titlePanel;
    JComboBox<String> LoginNamePane;

    String LoginName;
    public LoginView(FrameManager frameManager, Person_database p_db, Ticket_database t_db) {
        this.setLayout(new GridLayout(3,2));
        this.setBackground(new Color(30, 30, 30));

        // Page Title
        titlePanel = new TitlePanel("L O G I N");
        titlePanel.setLayout(new GridBagLayout());
        titlePanel.setBackground(new Color(30, 30, 30));
        titlePanel.setForeground(Color.white);
        GridBagConstraints titleConstraints = new GridBagConstraints();
        titleConstraints.gridy = 0;
        titleConstraints.gridwidth = 2;
        this.add(titlePanel, titleConstraints);

        // Choose login name
        JLabel Login = new JLabel("Login");
        Login.setOpaque(true);
        Login.setBackground(new Color(30, 30, 30));
        Login.setForeground(Color.white);
        GridBagConstraints loginLabelConstraints = new GridBagConstraints();
        loginLabelConstraints.gridx = 0;
        loginLabelConstraints.gridy = 1;
        this.add(Login, loginLabelConstraints);

        String[] LoginChoices = new String[p_db.getDb().size()];
        LoginChoices = p_db.getdbNames().toArray(LoginChoices);
        LoginNamePane = new JComboBox<>(LoginChoices);
        GridBagConstraints loginPaneConstraints = new GridBagConstraints();
        loginPaneConstraints.gridx = 3;
        loginPaneConstraints.gridy = 1;
        this.add(LoginNamePane, loginPaneConstraints);
        LoginName = LoginChoices[0];
        LoginNamePane.addActionListener(e -> {
            LoginName = LoginNamePane.getSelectedItem().toString();
        });

        // end section

        // Login button

        JButton LoginButton = new JButton("Login");

        LoginButton.setPreferredSize(new Dimension(70,50));
        GridBagConstraints LoginButtonConstraints = new GridBagConstraints();
        LoginButtonConstraints.gridx = 0;
        LoginButtonConstraints.gridy = 2;
        this.add(LoginButton,LoginButtonConstraints);

        LoginButton.addActionListener(e -> {
            HomeView homeView = new HomeView(frameManager, p_db, t_db,this);
            frameManager.setContentPane(homeView);
            frameManager.revalidate();
        });
        // end section
        // Set frame size and make it visible
        frameManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public String getLoginName() {
        return LoginName;
    }
    public Person getLoginPerson(){
        return Person_database.getInstance().getPerson(getLoginName());
    }
}
