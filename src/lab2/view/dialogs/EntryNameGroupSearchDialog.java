package lab2.view.dialogs;

import lab2.controller.Controller;
import lab2.view.StudentsTable;

import javax.swing.*;
import java.awt.*;

public class EntryNameGroupSearchDialog {
    private DialogComponentsFactory core;
    private StudentsTable table;

    public EntryNameGroupSearchDialog(Controller ownerController) {
        core = new DialogComponentsFactory(ownerController);
        core.nameGroupAssemble();
        table=new StudentsTable();
    }

    public JDialog buildDialog() {
        JDialog dialog = new JDialog();
        dialog.setModal(true);
        dialog.setTitle("Search entries by name and group");
        JButton dialogSearch= new JButton("Search");
        JPanel rootDialogPanel=new JPanel(new BorderLayout());
        rootDialogPanel.add(core.panelOfChoice, BorderLayout.NORTH);
        rootDialogPanel.add(table.createTableComponent(), BorderLayout.CENTER);
        rootDialogPanel.add(dialogSearch, BorderLayout.SOUTH);
        dialog.add(rootDialogPanel);
        dialog.pack();
        return dialog;


    }
}
