package UI.PersonPanels;

import UI.Views.HomeView;

import javax.swing.*;

public class AddPersonButtonPanel extends JPanel
{
    public AddPersonButtonPanel(HomeView homeView, JFrame viewManager, JTextField personNameField)
    {
        JButton button = new JButton("ADD USER");
        button.addActionListener(e ->
        {
            //viewManager.setContentPane(homeView);
            personNameField.setText("");
            viewManager.revalidate();
        });
        this.add(button);
    }
}
