package UI.Views;

import UI.FrameManager;
import UI.HomePanels.*;
import UI.Panels.LoginPanel;
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
    JButton LogInButton;
    FrameManager frameManager;
    String LoginName;
    public LoginView(FrameManager frameManager)
    {
        this.frameManager = frameManager;

        this.setBackground(new Color(30,30,30));

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Title
        JLabel title = new JLabel("MONEYTRACKER", SwingConstants.CENTER);
        title.setOpaque(true);
        title.setBackground(new Color(30, 30, 30));
        title.setForeground(Color.white);
        title.setFont(new Font("SansSerif", Font.BOLD, 25));
        c.gridy = 0;
        c.insets.top = 20;
        this.add(title, c);

        LoginNamePane = new JComboBox<>();

        String[] LoginChoices = frameManager.getPersonDatabase().getDbArray();
        DefaultComboBoxModel model = new DefaultComboBoxModel(LoginChoices);
        LoginNamePane.setModel(model);

        LoginName = LoginChoices[0];
        LogInButton = new JButton("Login as " + LoginName);

        LoginNamePane.addActionListener(e ->
        {
            LoginName = LoginNamePane.getSelectedItem().toString();
            LogInButton.setText("Login as "+ LoginName);
        });

        LoginPanel loginPanel = new LoginPanel(LoginNamePane, LogInButton, this, frameManager);
        c.gridy = 1;
        c.insets = new Insets(0, 40, 0, 40);
        c.anchor = GridBagConstraints.CENTER;
        c.weighty = 1.0;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(loginPanel, c);

    }

    public String getLoginName() {
        return LoginName;
    }

    public void setLoginName(String loginName) {
        LoginName = loginName;
    }

    public Person getLoginPerson(){
        return Person_database.getInstance().getPerson(getLoginName());
    }

    public void UpdateLogInBox()
    {
        String[] LoginChoices = frameManager.getPersonDatabase().getDbArray();
        DefaultComboBoxModel model = new DefaultComboBoxModel(LoginChoices);
        LoginNamePane.setModel(model);
    }
}
