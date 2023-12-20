package UI.Views;

import UI.FrameManager;
import UI.Panels.BackButtonPanel;
import UI.Panels.SeparatorPanel;
import UI.Panels.TitlePanel;
import UI.ResultPanels.BalancePanel;
import javax.swing.*;
import java.awt.*;

public class ResultView extends JPanel
{
    public ResultView(FrameManager frameManager, HomeView homeView, LoginView loginView)
    {
        this.setBackground(new Color(30,30,30));

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Title
        TitlePanel titlePanel = new TitlePanel("B A L A N C E S");
        titlePanel.setLayout(new GridLayout(1,1));
        //region >> Constraints
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.PAGE_START;
        //endregion
        this.add(titlePanel, c);

        // Line 1
        SeparatorPanel separatorPanel = new SeparatorPanel(SwingConstants.HORIZONTAL);
        separatorPanel.setLayout(new GridLayout(1,1));
        //region >> Constraints
        c.gridy = 1;
        //endregion
        this.add(separatorPanel,c);

        // Log
        BalancePanel balancePanel = new BalancePanel(frameManager, loginView);
        balancePanel.setOpaque(false);
        //region >> Constraints
        c.gridy = 2;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(20,20,20,20);
        //endregion
        JScrollPane scrollPane = new JScrollPane(balancePanel);
        //region >> Constraints
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(200,475));
        scrollPane.setAlignmentY(JScrollPane.TOP_ALIGNMENT);
        scrollPane.getViewport().setBackground(new Color(30,30,30));
        //endregion
        this.add(scrollPane, c);

        //Button
        BackButtonPanel addPerson = new BackButtonPanel(frameManager, homeView);
        addPerson.setLayout(new GridLayout(1,1));
        //region >> Constraints
        c.weighty = 0.0;
        c.gridy = 3;
        c.anchor = GridBagConstraints.PAGE_END;
        //endregion
        this.add(addPerson, c);
    }
}
