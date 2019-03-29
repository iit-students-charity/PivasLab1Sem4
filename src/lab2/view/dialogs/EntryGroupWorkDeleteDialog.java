package lab2.view.dialogs;

import lab2.view.StudentsTable;

import javax.swing.*;
import java.awt.*;

public class EntryGroupWorkDeleteDialog {
    private  DialogComponentsFactory core;

    public EntryGroupWorkDeleteDialog() {
        this.core = new DialogComponentsFactory();
        core.groupWorkAssemble();
    }

    public JDialog buildDialog() {
        JDialog dialog = new JDialog();
        dialog.setModal(true);
        dialog.setTitle("Delete entries by group and work hours");
        JPanel rootDialogPanel = new JPanel(new BorderLayout());
        JButton dialogDelete = new JButton("Delete");
        rootDialogPanel.add(core.panelOfChoice, BorderLayout.NORTH);
        rootDialogPanel.add(dialogDelete, BorderLayout.SOUTH);
        dialog.add(rootDialogPanel);
        dialog.pack();
        return dialog;
    }
}
