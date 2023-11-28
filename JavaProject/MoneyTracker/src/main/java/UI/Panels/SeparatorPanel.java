package UI.Panels;

import javax.swing.*;
import java.awt.*;

public class SeparatorPanel extends JPanel
{
    public SeparatorPanel(int swingConstant)
    {
        JSeparator line = new JSeparator(swingConstant);

        line.setOpaque(true);
        line.setBackground(new Color(30,30,30));
        line.setForeground(Color.white);

        this.add(line);
    }
}
