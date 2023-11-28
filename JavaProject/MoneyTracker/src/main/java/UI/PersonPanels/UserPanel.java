package UI.PersonPanels;

import javax.swing.*;
import java.awt.*;

public class UserPanel extends JPanel
{
    public UserPanel(String name)
    {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel label = new JLabel(name);
        c.gridx = 0;
        c.anchor = GridBagConstraints.LINE_START;
        c.weightx = 1.0;
        this.add(label, c);

        JButton button = new JButton("x");
        c.gridx = 1;
        c.weightx = 0.0;
        c.anchor = GridBagConstraints.LINE_END;
        this.add(button, c);
    }
}
