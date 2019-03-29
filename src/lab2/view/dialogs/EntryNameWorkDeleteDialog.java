package lab2.view.dialogs;

import javax.swing.*;
import java.awt.*;

public class EntryNameWorkDeleteDialog {
    private  DialogComponentsFactory core;

    public EntryNameWorkDeleteDialog() {
        this.core = new DialogComponentsFactory();
        core.nameWorkAssemble();
    }

    public JDialog buildDialog() {
        JDialog dialog = new JDialog();
        dialog.setModal(true);
        dialog.setTitle("Delete entries by name and work hours");
        JPanel rootDialogPanel = new JPanel(new BorderLayout());
        JButton dialogDelete = new JButton("Delete");
        rootDialogPanel.add(core.panelOfChoice, BorderLayout.NORTH);
        rootDialogPanel.add(dialogDelete, BorderLayout.SOUTH);
        dialog.add(rootDialogPanel);
        dialog.pack();
        return dialog;
    }
}