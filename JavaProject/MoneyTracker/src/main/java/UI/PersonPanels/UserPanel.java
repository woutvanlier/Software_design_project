package UI.PersonPanels;
import javax.swing.*;
import java.awt.*;


public class UserPanel extends JPanel
{
    String name;
    public UserPanel(String name, PersonPanel personPanel)
    {
        this.name = name;
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel label = new JLabel(name);
        c.gridx = 0;
        c.anchor = GridBagConstraints.LINE_START;
        c.weightx = 1.0;
        this.add(label, c);

        JButton button = new JButton("x");
        button.addActionListener(e ->
        {
            personPanel.removePerson(name);
        });
        c.gridx = 1;
        c.weightx = 0.0;
        c.anchor = GridBagConstraints.LINE_END;
        this.add(button, c);
    }

    public String getName() {
        return name;
    }
}
