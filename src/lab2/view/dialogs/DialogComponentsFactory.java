package lab2.view.dialogs;

import lab2.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DialogComponentsFactory {
    public JTextField firstNameField;
    JTextField secondNameField;
    JTextField fatherNameField;
    public JTextField workLowerField;
    public JTextField workHigherField;
    public JComboBox group;
    public JPanel panelOfChoice;
    Controller dialogController;

    public DialogComponentsFactory(Controller dialogController) {
        this.dialogController = dialogController;
    }

    void nameWorkAssemble() {
        firstNameField = new JTextField();
        secondNameField = new JTextField();
        fatherNameField = new JTextField();
        workLowerField = new JTextField();
        workHigherField = new JTextField();
        JLabel firstNameCaption = new JLabel("First Name:");
        JLabel secondNameCaption = new JLabel("Second Name:");
        JLabel fatherNameCaption = new JLabel("Father Name:");
        JLabel workLowerCaption = new JLabel("Lower limit:");
        JLabel workHigherCaption = new JLabel("Higher limit:");
        JPanel parametersPanel = new JPanel(new GridLayout(5, 2, 10, 20));
        parametersPanel.add(firstNameCaption);
        parametersPanel.add(firstNameField);
        parametersPanel.add(secondNameCaption);
        parametersPanel.add(secondNameField);
        parametersPanel.add(fatherNameCaption);
        parametersPanel.add(fatherNameField);
        parametersPanel.add(workLowerCaption);
        parametersPanel.add(workLowerField);
        parametersPanel.add(workHigherCaption);
        parametersPanel.add(workHigherField);
        panelOfChoice= parametersPanel;
    }

    void nameGroupAssemble() {
        firstNameField = new JTextField();
        secondNameField = new JTextField();
        fatherNameField = new JTextField();
        group = new JComboBox();
        fillGroups();
        JLabel groupCaption = new JLabel("Group:");
        JLabel firstNameCaption = new JLabel("First Name:");
        JLabel secondNameCaption = new JLabel("Second Name:");
        JLabel fatherNameCaption = new JLabel("Father Name:");
        JPanel parametersPanel = new JPanel(new GridLayout(5, 2, 10, 20));
        parametersPanel.add(firstNameCaption);
        parametersPanel.add(firstNameField);
        parametersPanel.add(secondNameCaption);
        parametersPanel.add(secondNameField);
        parametersPanel.add(fatherNameCaption);
        parametersPanel.add(fatherNameField);
        parametersPanel.add(groupCaption);
        parametersPanel.add(group);
        panelOfChoice= parametersPanel;
    }

    void groupWorkAssemble() {
        group = new JComboBox();
        fillGroups();
        workLowerField = new JTextField();
        workHigherField = new JTextField();
        JLabel nameCaption = new JLabel("Group:");
        JLabel lowerWorkCaption = new JLabel("Lower Work Limit");
        JLabel higherWorkCaption = new JLabel("Higher Work Limit");
        JPanel parametersPanel = new JPanel(new GridLayout(3, 2, 10, 20));
        parametersPanel.add(nameCaption);
        parametersPanel.add(group);
        parametersPanel.add(lowerWorkCaption);
        parametersPanel.add(workLowerField);
        parametersPanel.add(higherWorkCaption);
        parametersPanel.add(workHigherField);
        panelOfChoice= parametersPanel;
    }

    void fillGroups(){
        List<String> groups = dialogController.sendGroups();
        for(String group : groups){
            this.group.addItem(group);
        }
    }

}
