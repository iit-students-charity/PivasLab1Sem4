package com.properlynamed;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashSet;

@SuppressWarnings("FieldCanBeLocal")
class Window {


    JFrame buildFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Lab 1");
        frame.setSize(new Dimension(600, 600));
        JButton controlGroup1button = new JButton("Submit text");
        JTextField controlGroup1TextField = new JTextField(10);
        JComboBox controlGroup1ComboBox = new JComboBox();
        JTextField controlGroup2TextField = new JTextField(10);
        JButton controlGroup2ButtonTextSet = new JButton("Set text on another button");
        JButton controlGroup2SwapButton = new JButton("Swap text between buttons");
        JTextField controlGroup3TextField = new JTextField(10);
        JButton controlGroup3Button = new JButton("Select");
        JRadioButton controlGroup3RB1 = new JRadioButton("1");
        JRadioButton controlGroup3RB2 = new JRadioButton("2");
        JRadioButton controlGroup3RB3 = new JRadioButton("3");
        JTextField controlGroup4TextField = new JTextField(10);
        JCheckBox controlGroupCheck1 = new JCheckBox("1");
        JCheckBox controlGroupCheck2 = new JCheckBox("2");
        JCheckBox controlGroupCheck3 = new JCheckBox("3");
        JButton controlGroup4Button = new JButton("select");
        JTextField controlGroup5TextField = new JTextField(10);
        JButton controlGroup5SwapButton = new JButton("Swap");
        JButton controlGroup5SubmitButton = new JButton("Submit");
        JTable controlGroup5Table = new JTable();
        DefaultTableModel model = (DefaultTableModel) controlGroup5Table.getModel();
        HashSet<String> itemsInControlGroup1ComboBox = new HashSet<>();
        JPanel controlGroup1 = new JPanel();
        JPanel controlGroup2 = new JPanel();
        JPanel controlGroup3 = new JPanel();
        JPanel controlGroup4 = new JPanel();
        JPanel controlGroup5 = new JPanel();
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));
        JPanel startLayoutRoundabout = new JPanel();
        JButton startButton = new JButton("Start");
        LayoutThread layoutThread1 = new LayoutThread(controlGroup1);
        LayoutThread layoutThread2 = new LayoutThread(controlGroup2);
        LayoutThread layoutThread3 = new LayoutThread(controlGroup3);
        LayoutThread layoutThread4 = new LayoutThread(controlGroup4);
        LayoutThread layoutThread5 = new LayoutThread(controlGroup5);
        new Thread(layoutThread1, "layoutThread1").start();
        new Thread(layoutThread2, "layoutThread2").start();
        new Thread(layoutThread3, "layoutThread3").start();
        new Thread(layoutThread4, "layoutThread4").start();
        new Thread(layoutThread5, "layoutThread5").start();
        startButton.addActionListener(e -> {
            layoutThread1.turnOn();
            layoutThread2.turnOn();
            layoutThread3.turnOn();
            layoutThread4.turnOn();
            layoutThread5.turnOn();
        });
        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(e -> {
            layoutThread1.turnOff();
            layoutThread2.turnOff();
            layoutThread3.turnOff();
            layoutThread4.turnOff();
            layoutThread5.turnOff();
        });
        frame.add(rootPanel);
        controlGroup1.add(controlGroup1ComboBox);
        controlGroup1.add(controlGroup1TextField);
        controlGroup1.add(controlGroup1button);
        controlGroup1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
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
        rootPanel.add(controlGroup1);
        controlGroup2.add(controlGroup2ButtonTextSet);
        controlGroup2.add(controlGroup2SwapButton);
        controlGroup2.add(controlGroup2TextField);
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
        rootPanel.add(controlGroup2);
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(controlGroup3RB1);
        radioGroup.add(controlGroup3RB2);
        radioGroup.add(controlGroup3RB3);
        controlGroup3.add(controlGroup3RB1);
        controlGroup3.add(controlGroup3TextField);
        controlGroup3.add(controlGroup3RB2);
        controlGroup3.add(controlGroup3Button);
        controlGroup3.add(controlGroup3RB3);
        controlGroup3Button.addActionListener(e -> {
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
            controlGroup3.setLayout(new GridLayout(4, 4));
            frame.validate();
        });
        rootPanel.add(controlGroup3);
        controlGroup4.add(controlGroupCheck1);
        controlGroup4.add(controlGroup4TextField);
        controlGroup4.add(controlGroupCheck2);
        controlGroup4.add(controlGroup4Button);
        controlGroup4.add(controlGroupCheck3);
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
        rootPanel.add(controlGroup4);
        controlGroup5.add(controlGroup5Table);
        controlGroup5.add(controlGroup5SwapButton);
        controlGroup5.add(controlGroup5TextField);
        controlGroup5.add(controlGroup5SubmitButton);
        rootPanel.add(controlGroup5);
        rootPanel.add(startLayoutRoundabout);
        startLayoutRoundabout.add(startButton);
        startLayoutRoundabout.add(stopButton);
        controlGroup5Table.setModel(new DefaultTableModel(0, 2));
        controlGroup5SubmitButton.addActionListener(e -> {
            String textFieldText = controlGroup5TextField.getText();
            if (textFieldText.equals("")) {
                JOptionPane.showMessageDialog(null, "Write something first.");
                return;
            }
            model.addRow(new Object[]{textFieldText, ""});
        });
        controlGroup5SwapButton.addActionListener(e -> {
            int selectedRow = controlGroup5Table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Select row first");
                return;
            }
            Object data1 = model.getValueAt(selectedRow, 0);
            Object data2 = model.getValueAt(selectedRow, 1);
            model.setValueAt(data1, selectedRow, 1);
            model.setValueAt(data2, selectedRow, 0);
        });
        return frame;
    }


    Window() {

    }
}
