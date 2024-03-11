package UI.Panels;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel
{
    public TitlePanel(String Title)
    {
        JLabel title = new JLabel(Title, JLabel.CENTER);

        title.setOpaque(true); // Transparent background
        title.setBackground(new Color(30,30,30));
        title.setForeground(Color.white);

        this.add(title);
    }
}
