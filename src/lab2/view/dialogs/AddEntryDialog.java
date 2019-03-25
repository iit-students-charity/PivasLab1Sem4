package lab2.view.dialogs;

import javax.swing.*;
import java.awt.*;

public class AddEntryDialog {
    JFrame ownerFrame;
    public JDialog buildDialog(){
        JDialog dialog = new JDialog(ownerFrame, "Add new entry", true);
        dialog.setSize(new Dimension(600, 600));
        JPanel rootDialogPanel = new JPanel(new BorderLayout());
        dialog.add(rootDialogPanel);
        JPanel textFieldsPanel = new JPanel(new GridLayout(12, 3, 10, 20));
        JTextField nameField = new JTextField();
        JTextField group = new JTextField();
        JTextField sem1 = new JTextField();
        JTextField sem2 = new JTextField();
        JTextField sem3 = new JTextField();
        JTextField sem4 = new JTextField();
        JTextField sem5 = new JTextField();
        JTextField sem6 = new JTextField();
        JTextField sem7 = new JTextField();
        JTextField sem8 = new JTextField();
        JTextField sem9 = new JTextField();
        JTextField sem10 = new JTextField();
        JLabel nameCaption = new JLabel("Name:");
        JLabel groupCaption = new JLabel("Group:");
        JLabel sem1Caption = new JLabel("Semester 1:");
        JLabel sem2Caption = new JLabel("Semester 2:");
        JLabel sem3Caption = new JLabel("Semester 3:");
        JLabel sem4Caption = new JLabel("Semester 4:");
        JLabel sem5Caption = new JLabel("Semester 5:");
        JLabel sem6Caption = new JLabel("Semester 6:");
        JLabel sem7Caption = new JLabel("Semester 7:");
        JLabel sem8Caption = new JLabel("Semester 8:");
        JLabel sem9Caption = new JLabel("Semester 9:");
        JLabel sem10Caption = new JLabel("Semester 10:");
        JButton submitButton = new JButton("Submit Entry");
        submitButton.addActionListener(e -> {

        });
        textFieldsPanel.add(nameCaption);
        textFieldsPanel.add(nameField);
        textFieldsPanel.add(groupCaption);
        textFieldsPanel.add(group);
        textFieldsPanel.add(sem1Caption);
        textFieldsPanel.add(sem1);
        textFieldsPanel.add(sem2Caption);
        textFieldsPanel.add(sem2);
        textFieldsPanel.add(sem3Caption);
        textFieldsPanel.add(sem3);
        textFieldsPanel.add(sem4Caption);
        textFieldsPanel.add(sem4);
        textFieldsPanel.add(sem5Caption);
        textFieldsPanel.add(sem5);
        textFieldsPanel.add(sem6Caption);
        textFieldsPanel.add(sem6);
        textFieldsPanel.add(sem7Caption);
        textFieldsPanel.add(sem7);
        textFieldsPanel.add(sem8Caption);
        textFieldsPanel.add(sem8);
        textFieldsPanel.add(sem9Caption);
        textFieldsPanel.add(sem9);
        textFieldsPanel.add(sem10Caption);
        textFieldsPanel.add(sem10);
        rootDialogPanel.add(textFieldsPanel, BorderLayout.CENTER);
        dialog.add(submitButton, BorderLayout.SOUTH);
        dialog.pack();
        return dialog;
    }

    public AddEntryDialog(JFrame owner) {
        ownerFrame=owner;
    }
}

