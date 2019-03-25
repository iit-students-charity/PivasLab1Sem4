package lab2.view.dialogs;

import lab2.view.ColumnGroup;
import lab2.view.GroupableTableColumnModel;
import lab2.view.GroupableTableHeader;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class EntryGroupWorkSearchDIalog {
    public JDialog buildDialog() {
        JDialog dialog = new JDialog();
        dialog.setModal(true);
        dialog.setTitle("Search entries by group and work hours");
        JTextField groupField = new JTextField();
        JTextField workLowerField = new JTextField();
        JTextField workHigherField = new JTextField();
        JLabel groupCaption = new JLabel("Group:");
        JLabel workLowerCaption = new JLabel("Lower limit:");
        JLabel workHigherCaption = new JLabel("Higher limit:");
        JPanel parametersPanel = new JPanel(new GridLayout(3, 2, 10, 20));
        parametersPanel.add(groupCaption);
        parametersPanel.add(groupField);
        parametersPanel.add(workLowerCaption);
        parametersPanel.add(workLowerField);
        parametersPanel.add(workHigherCaption);
        parametersPanel.add(workHigherField);
        DefaultTableModel dm = new DefaultTableModel();
        dm.setDataVector(new Object[][]{},
                new Object[]{"ФИО студента", "Группа", "1 семестр", "2 семестр", "3 семестр", "4 семестр", "5 семестр",
                        "6 семестр", "7 семестр", "8 семестр", "9 семестр", "10 семестр"});

        JTable table = new JTable( /*dm, new GroupableTableColumnModel()*/);
        table.setColumnModel(new GroupableTableColumnModel());
        table.setTableHeader(new GroupableTableHeader((GroupableTableColumnModel) table.getColumnModel()));
        table.setModel(dm);
        GroupableTableColumnModel cm = (GroupableTableColumnModel) table.getColumnModel();
        ColumnGroup socialActivity = new ColumnGroup("Общественная работа");
        socialActivity.add(cm.getColumn(2));
        socialActivity.add(cm.getColumn(3));
        socialActivity.add(cm.getColumn(4));
        socialActivity.add(cm.getColumn(5));
        socialActivity.add(cm.getColumn(6));
        socialActivity.add(cm.getColumn(7));
        socialActivity.add(cm.getColumn(8));
        socialActivity.add(cm.getColumn(9));
        socialActivity.add(cm.getColumn(10));
        socialActivity.add(cm.getColumn(11));
        cm.addColumnGroup(socialActivity);
        JScrollPane scroll = new JScrollPane(table);
        JButton dialogPrev = new JButton("<<");
        JButton dialogNext = new JButton(">>");
        JLabel dialogCurrentPage = new JLabel("");
        JButton dialogSearch = new JButton("Search");
        JPanel buttons = new JPanel();
        buttons.add(dialogPrev);
        buttons.add(dialogCurrentPage);
        buttons.add(dialogNext);
        buttons.add(dialogSearch);
        JPanel rootDialogPanel = new JPanel(new BorderLayout());
        rootDialogPanel.add(parametersPanel, BorderLayout.NORTH);
        rootDialogPanel.add(scroll, BorderLayout.CENTER);
        rootDialogPanel.add(buttons, BorderLayout.SOUTH);
        dialog.add(rootDialogPanel);
        dialog.pack();
        return dialog;
    }
}