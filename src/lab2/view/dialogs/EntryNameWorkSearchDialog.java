package lab2.view.dialogs;

import lab2.view.ColumnGroup;
import lab2.view.GroupableTableColumnModel;
import lab2.view.GroupableTableHeader;
import lab2.view.StudentsTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class EntryNameWorkSearchDialog {
    private DialogComponentsFactory core;
    private StudentsTable table;

    public EntryNameWorkSearchDialog() {
        core = new DialogComponentsFactory();
        core.nameWorkAssemble();
        table = new StudentsTable();
    }

    public JDialog buildDialog() {
        JDialog dialog = new JDialog();
        dialog.setModal(true);
        dialog.setTitle("Search entries by name and work hours");
        JButton dialogSearch = new JButton("Search");
        JPanel rootDialogPanel = new JPanel(new BorderLayout());
        rootDialogPanel.add(core.panelOfChoice, BorderLayout.NORTH);
        rootDialogPanel.add(table.createTableComponent(), BorderLayout.CENTER);
        rootDialogPanel.add(dialogSearch, BorderLayout.SOUTH);
        dialog.add(rootDialogPanel);
        dialog.pack();
        return dialog;
    }
}
