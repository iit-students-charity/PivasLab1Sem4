package lab2.view.dialogs;

import lab2.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EntryGroupWorkDeleteDialog {
    private  DialogComponentsFactory core;

    public EntryGroupWorkDeleteDialog(Controller ownerController) {
        this.core = new DialogComponentsFactory(ownerController);
        core.groupWorkAssemble();
    }

    public JDialog buildDialog() {
        JDialog dialog = new JDialog();
        dialog.setModal(true);
        dialog.setTitle("Delete entries by group and work hours");
        JPanel rootDialogPanel = new JPanel(new BorderLayout());
        JButton dialogDelete = new JButton("Delete");
        dialogDelete.addActionListener(ev -> {
            Integer deletedEntriesCounter = core.dialogController.deleteGroupWork(core.group.getSelectedItem().toString(),
                    Integer.parseInt(core.workLowerField.getText()),
                    Integer.parseInt(core.workHigherField.getText()));
            if (deletedEntriesCounter.equals(0)) {
                JOptionPane.showMessageDialog(null, "No such entries");
            } else {
                JOptionPane.showMessageDialog(null, "Deleted entries: " +
                        deletedEntriesCounter.toString());
            }
        });
        rootDialogPanel.add(core.panelOfChoice, BorderLayout.NORTH);
        rootDialogPanel.add(dialogDelete, BorderLayout.SOUTH);
        dialog.add(rootDialogPanel);
        dialog.pack();
        return dialog;
    }
}
