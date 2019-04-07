package lab2.view.dialogs;

import lab2.controller.Controller;
import lab2.view.StudentsTable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AddEntryDialog {
    private JFrame ownerFrame;
    private StudentsTable ownerTable;
    private Controller ownerController;
    private JTextField firstNameField;
    private JTextField secondNameField;
    private JTextField fatherNameField;
    private JTextField group;
    private JTextField sem1;
    private JTextField sem2;
    private JTextField sem3;
    private JTextField sem4;
    private JTextField sem5;
    private JTextField sem6;
    private JTextField sem7;
    private JTextField sem8;
    private JTextField sem9;
    private JTextField sem10;

    public JDialog buildDialog() {
        JDialog dialog = new JDialog(ownerFrame, "Add new entry", true);
        JPanel rootDialogPanel = new JPanel(new BorderLayout());
        dialog.add(rootDialogPanel);
        JPanel textFieldsPanel = new JPanel(new GridLayout(14, 2, 10, 20));
        setFirstNameField(new JTextField());
        firstNameField.setText("Name");
        setSecondNameField(new JTextField());
        secondNameField.setText("secondName");
        setFatherNameField(new JTextField());
        fatherNameField.setText("fatherName");
        setGroup(new JTextField());
        group.setText("721701");
        setSem1(new JTextField());
        sem1.setText("1");
        setSem2(new JTextField());
        sem2.setText("2");
        setSem3(new JTextField());
        sem3.setText("3");
        setSem4(new JTextField());
        setSem5(new JTextField());
        setSem6(new JTextField());
        setSem7(new JTextField());
        setSem8(new JTextField());
        setSem9(new JTextField());
        setSem10(new JTextField());
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
            if(checkEmptyTextFields()) {
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
            } else{
                JOptionPane.showMessageDialog(null, "You must fill all the fields");
            }
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
        setOwnerFrame(owner);
        setOwnerTable(table);
        setOwnerController(controller);
    }

    private boolean checkEmptyTextFields() {
        return !firstNameField.getText().equals("") &&
                !secondNameField.getText().equals("") &&
                !fatherNameField.getText().equals("") &&
                !sem1.getText().equals("") &&
                !sem2.getText().equals("") &&
                !sem3.getText().equals("") &&
                !sem4.getText().equals("") &&
                !sem5.getText().equals("") &&
                !sem6.getText().equals("") &&
                !sem7.getText().equals("") &&
                !sem8.getText().equals("") &&
                !sem9.getText().equals("") &&
                !sem10.getText().equals("");
    }

    public void setOwnerFrame(JFrame ownerFrame) {
        this.ownerFrame = ownerFrame;
    }

    public void setOwnerTable(StudentsTable ownerTable) {
        this.ownerTable = ownerTable;
    }

    public void setOwnerController(Controller ownerController) {
        this.ownerController = ownerController;
    }

    public void setFirstNameField(JTextField firstNameField) {
        this.firstNameField = firstNameField;
    }

    public void setSecondNameField(JTextField secondNameField) {
        this.secondNameField = secondNameField;
    }

    public void setFatherNameField(JTextField fatherNameField) {
        this.fatherNameField = fatherNameField;
    }

    public void setGroup(JTextField group) {
        this.group = group;
    }

    public void setSem1(JTextField sem1) {
        this.sem1 = sem1;
    }

    public void setSem2(JTextField sem2) {
        this.sem2 = sem2;
    }

    public void setSem3(JTextField sem3) {
        this.sem3 = sem3;
    }

    public void setSem4(JTextField sem4) {
        this.sem4 = sem4;
    }

    public void setSem5(JTextField sem5) {
        this.sem5 = sem5;
    }

    public void setSem6(JTextField sem6) {
        this.sem6 = sem6;
    }

    public void setSem7(JTextField sem7) {
        this.sem7 = sem7;
    }

    public void setSem8(JTextField sem8) {
        this.sem8 = sem8;
    }

    public void setSem9(JTextField sem9) {
        this.sem9 = sem9;
    }

    public void setSem10(JTextField sem10) {
        this.sem10 = sem10;
    }
}

