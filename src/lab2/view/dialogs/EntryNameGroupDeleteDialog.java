package lab2.view.dialogs;

import lab2.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EntryNameGroupDeleteDialog {
    private DialogComponentsFactory core;
    JDialog dialog;

    public EntryNameGroupDeleteDialog(Controller ownerController) {
        this.core = new DialogComponentsFactory(ownerController);
        core.nameGroupAssemble();
    }

    public JDialog buildDialog() {
        dialog = new JDialog();
        dialog.setModal(true);
        dialog.setTitle("Delete entries by name and group");
        JPanel rootDialogPanel = new JPanel(new BorderLayout());
        JButton dialogDelete = new JButton("Delete");
        dialogDelete.addActionListener(ev -> {
            ArrayList<String> name = new ArrayList<>();
            name.add(core.secondNameField.getText());
            name.add(core.firstNameField.getText());
            name.add(core.fatherNameField.getText());
            Integer deletedEntriesCounter = core.dialogController.deleteNameGroup(name,
                    core.group.getSelectedItem().toString());
            if (deletedEntriesCounter.equals(0)) {
                JOptionPane.showMessageDialog(null, "No such entries");
            } else {
                JOptionPane.showMessageDialog(null, "Deleted entries: " +
                        deletedEntriesCounter.toString());
            }
            closeDialog();
        });
        rootDialogPanel.add(core.panelOfChoice, BorderLayout.NORTH);
        rootDialogPanel.add(dialogDelete, BorderLayout.SOUTH);
        dialog.add(rootDialogPanel);
        dialog.pack();
        return dialog;
    }
    private void closeDialog(){
        dialog.dispose();
    }
}
