package com.properlynamed;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashSet;

@SuppressWarnings("FieldCanBeLocal")
public class Window
{
    private JButton controlGroup1button = new JButton("Submit text");
    private JTextField controlGroup1TextField = new JTextField();
    private JComboBox controlGroup1ComboBox = new JComboBox();
    private JTextField controlGroup2TextField = new JTextField();
    private JButton controlGroup2ButtonTextSet = new JButton("Set text on another button");
    private JButton controlGroup2SwapButton = new JButton("Swap text between buttons");
    private JTextField controlGroup3TextField = new JTextField();
    private JButton controlGroup3Button = new JButton("Select");
    private JRadioButton controlGroup3RB1 = new JRadioButton("1");
    private JRadioButton controlGroup3RB2 = new JRadioButton("2");
    private JRadioButton controlGroup3RB3 = new JRadioButton("3");
    private JTextField controlGroup4TextField = new JTextField();
    private JCheckBox controlGroupCheck1 = new JCheckBox("1");
    private JCheckBox controlGroupCheck2 = new JCheckBox("2");
    private JCheckBox controlGroupCheck3 = new JCheckBox("3");
    private JButton controlGroup4Button = new JButton("select");
    private JTextField controlGroup5TextField = new JTextField();
    private JButton controlGroup5SwapButton = new JButton("Swap");
    private JButton controlGroup5SubmitButton = new JButton("Submit");
    private JTable controlGroup5Table = new JTable();
    private HashSet<String> itemsInControlGroup1ComboBox = new HashSet<>();
    private JPanel controlGroup1 = new JPanel();
    private JPanel controlGroup2 = new JPanel();
    private JPanel controlGroup3 = new JPanel();
    private JPanel controlGroup4 = new JPanel();
    private JPanel controlGroup5 = new JPanel();

    public JFrame buildFrame()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Lab 1");
        frame.setSize(new Dimension(600,600));
        Container frameContainer = frame.getContentPane();
        frameContainer.setLayout(new BorderLayout());
        controlGroup1.setLayout(new BoxLayout(controlGroup1, 1));
        controlGroup1.add(controlGroup1ComboBox);
        controlGroup1.add(controlGroup1TextField);
        controlGroup1.add(controlGroup1button);
        controlGroup1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        frameContainer.add(controlGroup1, BorderLayout.CENTER);
        controlGroup2.setLayout(new BorderLayout());
        controlGroup2.add(controlGroup2SwapButton, BorderLayout.WEST);
        controlGroup2.add(controlGroup2ButtonTextSet, BorderLayout.EAST);
        controlGroup2.add(controlGroup2TextField,BorderLayout.SOUTH);
        frameContainer.add(controlGroup2, BorderLayout.SOUTH);
        controlGroup3.setLayout(new GridLayout(3,3,1,1));
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(controlGroup3RB1);
        radioGroup.add(controlGroup3RB2);
        radioGroup.add(controlGroup3RB3);
        controlGroup3.add(controlGroup3RB1);
        controlGroup3.add(controlGroup3TextField);
        controlGroup3.add(controlGroup3RB2);
        controlGroup3.add(controlGroup3Button);
        controlGroup3.add(controlGroup3RB3);
        frameContainer.add(controlGroup3, BorderLayout.NORTH);
        controlGroup4.setLayout(new GridLayout(3,3,11,100));
        controlGroup4.add(controlGroupCheck1);
        controlGroup4.add(controlGroup4TextField);
        controlGroup4.add(controlGroupCheck2);
        controlGroup4.add(controlGroup4Button);
        controlGroup4.add(controlGroupCheck3);
        frameContainer.add(controlGroup4, BorderLayout.WEST);
        controlGroup5.setLayout(new GridLayout(2,2,2,2));
        controlGroup5.add(controlGroup5Table);
        controlGroup5.add(controlGroup5SwapButton);
        controlGroup5.add(controlGroup5TextField);
        controlGroup5.add(controlGroup5SubmitButton);
        frameContainer.add(controlGroup5, BorderLayout.EAST);
        controlGroup5Table.setModel(new DefaultTableModel(0,2));
        DefaultTableModel model=(DefaultTableModel) controlGroup5Table.getModel();
        controlGroup1button.addActionListener(e -> {
            String textFieldText=controlGroup1TextField.getText();
            if(textFieldText.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Write something first.");
            }
            else if (itemsInControlGroup1ComboBox.contains(textFieldText))
            {
                JOptionPane.showMessageDialog(null, "This combobox already has that string");
            }
            else
            {
                controlGroup1ComboBox.addItem(textFieldText);
                itemsInControlGroup1ComboBox.add(textFieldText);
                controlGroup1TextField.setText("");
            }

        });
        controlGroup2ButtonTextSet.addActionListener(e -> {
            String textFieldText=controlGroup2TextField.getText();
            if(textFieldText.equals("")) {
                JOptionPane.showMessageDialog(null, "Write something first.");
            }
            else
            {
                controlGroup2SwapButton.setText(textFieldText);
                controlGroup1TextField.setText("");
            }
        });
        controlGroup2SwapButton.addActionListener(e -> {
            String textFieldText=controlGroup2SwapButton.getText();
            controlGroup2SwapButton.setText(controlGroup2ButtonTextSet.getText());
            controlGroup2ButtonTextSet.setText(textFieldText);
        });
        controlGroup3Button.addActionListener(e -> {
            String textFieldText=controlGroup3TextField.getText();
            if(textFieldText.equals("")) {
                JOptionPane.showMessageDialog(null, "Write something first.");
            }
            switch (textFieldText)
            {
                case "1":
                    controlGroup3RB1.setSelected(true);
                    break;
                case "2":
                    controlGroup3RB2.setSelected(true);
                    break;
                case "3":
                    controlGroup3RB3.setSelected(true);
                    break;
                default: JOptionPane.showMessageDialog(null, "No such radiobutton.");
                    break;
            }
        });
        controlGroup4Button.addActionListener(e -> {
            String textFieldText=controlGroup4TextField.getText();
            if(textFieldText.equals("")) {
                JOptionPane.showMessageDialog(null, "Write something first.");
                return;
            }
            boolean check1=controlGroupCheck1.isSelected(), check2=controlGroupCheck2.isSelected(),
                    check3=controlGroupCheck3.isSelected();
            textFieldText = textFieldText.replaceAll("\\s","");
            while (!textFieldText.equals(("")))
            {
                if(textFieldText.charAt(0)!='1' && textFieldText.charAt(0)!='2' &&
                        textFieldText.charAt(0)!='3')
                {
                    JOptionPane.showMessageDialog(null, "Incorrect input");
                    return;
                }
                switch (textFieldText.charAt(0))
                {
                    case '1':
                        check1=!check1;
                        textFieldText = textFieldText.replaceAll("1","");
                        break;
                    case '2':
                        check2=!check2;
                        textFieldText = textFieldText.replaceAll("2","");
                        break;
                    case '3':
                        check3=!check3;
                        textFieldText = textFieldText.replaceAll("3","");
                        break;
                }
                controlGroupCheck1.setSelected(check1);
                controlGroupCheck2.setSelected(check2);
                controlGroupCheck3.setSelected(check3);
            }
        });
        controlGroup5SubmitButton.addActionListener(e -> {
            String textFieldText=controlGroup5TextField.getText();
            if(textFieldText.equals("")) {
                JOptionPane.showMessageDialog(null, "Write something first.");
                return;
            }
            model.addRow(new Object[]{textFieldText,""});
        });
        controlGroup5SwapButton.addActionListener(e -> {
            int selectedRow = controlGroup5Table.getSelectedRow();
            if(selectedRow == -1)
            {
                JOptionPane.showMessageDialog(null, "Select row first");
                return;
            }
            Object data1 = model.getValueAt(selectedRow, 0);
            Object data2 = model.getValueAt(selectedRow, 1);
            model.setValueAt(data1, selectedRow, 1);
            model.setValueAt(data2, selectedRow, 0);
        });
        frame.pack();
        return frame;
    }


    public Window()
    {

    }
}
