package UI.ResultPanels;

import javax.swing.*;
import java.awt.*;

public class BalanceElementPanel extends JPanel
{
    public BalanceElementPanel()
    {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel title = new JLabel("Eliott owes €466 in total");
        c.anchor = GridBagConstraints.LINE_START;
        c.weightx = 1.0;
        c.gridy = 0;
        this.add(title, c);

        // for loop of all people normally

        // TEMP
        JLabel person1 = new JLabel("Eliott owes Person1 €200");
        person1.setBackground(new Color(200,200,200));
        person1.setOpaque(true);
        c.weightx = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 1;
        this.add(person1, c);

        JLabel person2 = new JLabel("Eliott owes Person2 €266");
        person2.setBackground(new Color(200,200,200));
        person2.setOpaque(true);
        c.gridy = 2;
        this.add(person2, c);

    }
}
