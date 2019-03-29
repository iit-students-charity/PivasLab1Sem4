package lab2.view.dialogs;

import lab2.view.StudentsTable;

import javax.swing.*;
import java.awt.*;

public class EntryNameGroupDeleteDialog {
    private  DialogComponentsFactory core;

    public EntryNameGroupDeleteDialog() {
        this.core = new DialogComponentsFactory();
        core.nameGroupAssemble();
    }
    public JDialog buildDialog() {
        JDialog dialog = new JDialog();
        dialog.setModal(true);
        dialog.setTitle("Delete entries by name and group");
        JPanel rootDialogPanel = new JPanel(new BorderLayout());
        JButton dialogDelete = new JButton("Delete");
        rootDialogPanel.add(core.panelOfChoice, BorderLayout.NORTH);
        rootDialogPanel.add(dialogDelete, BorderLayout.SOUTH);
        dialog.add(rootDialogPanel);
        dialog.pack();
        return dialog;
    }
}
