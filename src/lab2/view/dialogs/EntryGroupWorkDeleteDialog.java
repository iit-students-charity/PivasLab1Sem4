package lab2.view.dialogs;

import javax.swing.*;
import java.awt.*;

public class EntryGroupWorkDeleteDialog {
    public JDialog buildDialog() {
        JDialog dialog = new JDialog();
        dialog.setModal(true);
        dialog.setTitle("Delete entries by group and work hours");
        JComboBox group = new JComboBox();
        JTextField workLower = new JTextField();
        JTextField workHigher = new JTextField();
        JLabel nameCaption = new JLabel("Group:");
        JLabel lowerWorkCaption = new JLabel("Lower Work Limit");
        JLabel higherWorkCaption = new JLabel("Higher Work Limit");
        JPanel parametersPanel = new JPanel(new GridLayout(3, 2, 10, 20));
        parametersPanel.add(nameCaption);
        parametersPanel.add(group);
        parametersPanel.add(lowerWorkCaption);
        parametersPanel.add(workLower);
        parametersPanel.add(higherWorkCaption);
        parametersPanel.add(workHigher);
        JButton dialogSearch = new JButton("Delete");
        JPanel buttons = new JPanel();
        buttons.add(dialogSearch);
        JPanel rootDialogPanel = new JPanel(new BorderLayout());
        rootDialogPanel.add(parametersPanel, BorderLayout.CENTER);
        rootDialogPanel.add(buttons, BorderLayout.SOUTH);
        dialog.add(rootDialogPanel);
        dialog.pack();
        return dialog;
    }
}
