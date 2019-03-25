package lab2.view.dialogs;

import javax.swing.*;
import java.awt.*;

public class EntryNameGroupDeleteDialog {
    public JDialog buildDialog() {
        JDialog dialog = new JDialog();
        dialog.setModal(true);
        dialog.setTitle("Delete entries by name and group");
        JTextField nameField = new JTextField();
        JTextField groupField = new JTextField();
        JLabel nameCaption = new JLabel("Name:");
        JLabel groupCaption = new JLabel("Group:");
        JPanel parametersPanel = new JPanel(new GridLayout(2, 2, 10, 20));
        parametersPanel.add(nameCaption);
        parametersPanel.add(nameField);
        parametersPanel.add(groupCaption);
        parametersPanel.add(groupField);
        JButton dialogSearch = new JButton("Delete");
        JPanel buttons = new JPanel();
        buttons.add(dialogSearch);
        JPanel rootDialogPanel = new JPanel(new BorderLayout());
         rootDialogPanel.add(buttons, BorderLayout.SOUTH);
        dialog.add(rootDialogPanel);
        dialog.pack();
        return dialog;
    }
}
