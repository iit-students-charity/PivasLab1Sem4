package lab2.view.dialogs;

import javax.swing.*;
import java.awt.*;

public class DialogComponentsFactory {
    public JTextField nameField;
    public JTextField workLowerField;
    public JTextField workHigherField;
    public JComboBox group;
    public JPanel panelOfChoice;

    public void nameWorkAssemble() {
        nameField = new JTextField();
        workLowerField = new JTextField();
        workHigherField = new JTextField();
        JLabel nameCaption = new JLabel("Name:");
        JLabel workLowerCaption = new JLabel("Lower limit:");
        JLabel workHigherCaption = new JLabel("Higher limit:");
        JPanel parametersPanel = new JPanel(new GridLayout(3, 2, 10, 20));
        parametersPanel.add(nameCaption);
        parametersPanel.add(nameField);
        parametersPanel.add(workLowerCaption);
        parametersPanel.add(workLowerField);
        parametersPanel.add(workHigherCaption);
        parametersPanel.add(workHigherField);
        panelOfChoice= parametersPanel;
    }

    public void nameGroupAssemble() {
        nameField = new JTextField();
        group = new JComboBox();
        JLabel groupCaption = new JLabel("Group:");
        JLabel nameCaption = new JLabel("Name:");
        JPanel parametersPanel = new JPanel(new GridLayout(3, 2, 10, 20));
        parametersPanel.add(nameCaption);
        parametersPanel.add(nameField);
        parametersPanel.add(groupCaption);
        parametersPanel.add(group);
        panelOfChoice= parametersPanel;
    }

    public void groupWorkAssemble() {
        group = new JComboBox();
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
}
