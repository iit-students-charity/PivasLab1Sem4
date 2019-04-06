package lab2.view.dialogs;

import lab2.controller.Controller;
import lab2.view.StudentsTable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AddEntryDialog {
    JFrame ownerFrame;
    StudentsTable ownerTable;
    Controller ownerController;

    public JDialog buildDialog() {
        JDialog dialog = new JDialog(ownerFrame, "Add new entry", true);
        JPanel rootDialogPanel = new JPanel(new BorderLayout());
        dialog.add(rootDialogPanel);
        JPanel textFieldsPanel = new JPanel(new GridLayout(14, 2, 10, 20));
        JTextField firstNameField = new JTextField();
        firstNameField.setText("Name");
        JTextField secondNameField = new JTextField();
        secondNameField.setText("secondName");
        JTextField fatherNameField = new JTextField();
        fatherNameField.setText("fatherName");
        JTextField group = new JTextField();
        group.setText("721701");
        JTextField sem1 = new JTextField();
        sem1.setText("1");
        JTextField sem2 = new JTextField();
        sem2.setText("2");
        JTextField sem3 = new JTextField();
        sem3.setText("3");
        JTextField sem4 = new JTextField();
        JTextField sem5 = new JTextField();
        JTextField sem6 = new JTextField();
        JTextField sem7 = new JTextField();
        JTextField sem8 = new JTextField();
        JTextField sem9 = new JTextField();
        JTextField sem10 = new JTextField();
        sem4.setText("4");
        sem5.setText("5");
        sem6.setText("6");
        sem7.setText("7");
        sem8.setText("8");
        sem9.setText("9");
        sem10.setText("10");
        JLabel firstNameCaption = new JLabel("Имя:");
        JLabel secondNameCaption = new JLabel("Фамилия:");
        JLabel fatherNameCaption = new JLabel("Отчество:");
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
            ArrayList<String> name = new ArrayList<>(Arrays.asList(firstNameField.getText(),
                    secondNameField.getText(),
                    fatherNameField.getText()));
            ArrayList<Integer> work = new ArrayList<>(Arrays.asList(
                    Integer.parseInt(sem1.getText()),
                    Integer.parseInt(sem2.getText()),
                    Integer.parseInt(sem3.getText()),
                    Integer.parseInt(sem4.getText()),
                    Integer.parseInt(sem5.getText()),
                    Integer.parseInt(sem6.getText()),
                    Integer.parseInt(sem7.getText()),
                    Integer.parseInt(sem8.getText()),
                    Integer.parseInt(sem9.getText()),
                    Integer.parseInt(sem10.getText())
            ));
            ownerController.addEntry(name, group.getText(), work);
            ownerTable.setTableData(ownerController.representData());
        });
        textFieldsPanel.add(firstNameCaption);
        textFieldsPanel.add(firstNameField);
        textFieldsPanel.add(secondNameCaption);
        textFieldsPanel.add(secondNameField);
        textFieldsPanel.add(fatherNameCaption);
        textFieldsPanel.add(fatherNameField);
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

    public AddEntryDialog(JFrame owner, StudentsTable table, Controller controller) {
        ownerFrame = owner;
        ownerTable = table;
        ownerController = controller;
    }
}

