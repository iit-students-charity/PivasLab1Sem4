package com.properlynamed;

import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("unused")
public class LabForm {
    private JPanel rootPanel;
    private JButton controlGroup1button;
    private JTextField controlGroup1TextField;
    private JComboBox controlGroup1ComboBox;
    private JPanel panelGroup1;
    private JPanel panelGroup2;
    private JTextField controlGroup2TextField;
    private JButton controlGroup2ButtonTextSet;
    private JButton controlGroup2SwapButton;
    private JPanel panelGroup3;
    private JTextField controlGroup3TextField;
    private JButton ControlGroup3Button;
    private JRadioButton controlGroup3RB1;
    private JRadioButton controlGroup3RB2;
    private JRadioButton controlGroup3RB3;
    private JTextField controlGroup4TextField;
    private JCheckBox controlGroupCheck1;
    private JCheckBox controlGroupCheck2;
    private JCheckBox controlGroupCheck3;
    private JButton controlGroup4Button;
    private JTextField controlGroup5TextField;
    private JButton controlGroup5SwapButton;
    private JButton controlGroup5SubmitButton;
    private JPanel controlGroup4;
    private JPanel controlGroup5;
    private JTable controlGroup5Table;
    private HashSet<String> itemsInControlGroup1ComboBox = new HashSet<>();
    private boolean tableFlip = false;


    private LabForm() {
        controlGroup5Table.setModel(new DefaultTableModel(0, 2));
        DefaultTableModel model = (DefaultTableModel) controlGroup5Table.getModel();
        controlGroup1button.addActionListener(e -> {
            String textFieldText = controlGroup1TextField.getText();
            if (textFieldText.equals("")) {
                JOptionPane.showMessageDialog(null, "Write something first.");
            } else if (itemsInControlGroup1ComboBox.contains(textFieldText)) {
                JOptionPane.showMessageDialog(null, "This combobox already has that string");
            } else {
                controlGroup1ComboBox.addItem(textFieldText);
                itemsInControlGroup1ComboBox.add(textFieldText);
                controlGroup1TextField.setText("");
            }

        });
        controlGroup2ButtonTextSet.addActionListener(e -> {
            String textFieldText = controlGroup2TextField.getText();
            if (textFieldText.equals("")) {
                JOptionPane.showMessageDialog(null, "Write something first.");
            } else {
                controlGroup2SwapButton.setText(textFieldText);
                controlGroup1TextField.setText("");
            }
        });
        controlGroup2SwapButton.addActionListener(e -> {
            String textFieldText = controlGroup2SwapButton.getText();
            controlGroup2SwapButton.setText(controlGroup2ButtonTextSet.getText());
            controlGroup2ButtonTextSet.setText(textFieldText);
        });
        ControlGroup3Button.addActionListener(e -> {
            String textFieldText = controlGroup3TextField.getText();
            if (textFieldText.equals("")) {
                JOptionPane.showMessageDialog(null, "Write something first.");
            }
            switch (textFieldText) {
                case "1":
                    controlGroup3RB1.setSelected(true);
                    break;
                case "2":
                    controlGroup3RB2.setSelected(true);
                    break;
                case "3":
                    controlGroup3RB3.setSelected(true);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "No such radiobutton.");
                    break;
            }
        });
        controlGroup4Button.addActionListener(e -> {
            String textFieldText = controlGroup4TextField.getText();
            if (textFieldText.equals("")) {
                JOptionPane.showMessageDialog(null, "Write something first.");
                return;
            }
            boolean check1 = controlGroupCheck1.isSelected(), check2 = controlGroupCheck2.isSelected(),
                    check3 = controlGroupCheck3.isSelected();
            textFieldText = textFieldText.replaceAll("\\s", "");
            while (!textFieldText.equals((""))) {
                if (textFieldText.charAt(0) != '1' && textFieldText.charAt(0) != '2' &&
                        textFieldText.charAt(0) != '3') {
                    JOptionPane.showMessageDialog(null, "Incorrect input");
                    return;
                }
                switch (textFieldText.charAt(0)) {
                    case '1':
                        check1 = !check1;
                        textFieldText = textFieldText.replaceAll("1", "");
                        break;
                    case '2':
                        check2 = !check2;
                        textFieldText = textFieldText.replaceAll("2", "");
                        break;
                    case '3':
                        check3 = !check3;
                        textFieldText = textFieldText.replaceAll("3", "");
                        break;
                }
                controlGroupCheck1.setSelected(check1);
                controlGroupCheck2.setSelected(check2);
                controlGroupCheck3.setSelected(check3);
            }
        });
        controlGroup5SubmitButton.addActionListener(e -> {
            String textFieldText = controlGroup5TextField.getText();
            if (textFieldText.equals("")) {
                JOptionPane.showMessageDialog(null, "Write something first.");
            } else if (!tableFlip) {
                model.addRow(new Object[]{textFieldText, ""});
            } else if (tableFlip) {
                model.addRow(new Object[]{"", textFieldText});
            }
        });
        controlGroup5SwapButton.addActionListener(e -> {
            if (!tableFlip) {
                for (int index = 0; index < model.getRowCount(); index++) {
                    Object data = model.getValueAt(index, 0);
                    model.setValueAt(data, index, 1);
                    model.setValueAt("", index, 0);
                }

            } else if (tableFlip) {
                for (int index = 0; index < model.getRowCount(); index++) {
                    Object data = model.getValueAt(index, 1);
                    model.setValueAt(data, index, 0);
                    model.setValueAt("", index, 1);
                }
            }
            tableFlip = !tableFlip;
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("LabForm");
        frame.setContentPane(new LabForm().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
