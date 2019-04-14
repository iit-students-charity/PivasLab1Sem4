package lab2.view.dialogs;

import lab2.controller.Controller;
import lab2.view.StudentsTable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EntryGroupWorkSearchDIalog {
    private  DialogComponentsFactory core;
    private StudentsTable studentsTable;
    private Controller mainFrameController;

    public EntryGroupWorkSearchDIalog(Controller ownerController) {
        this.core = new DialogComponentsFactory(ownerController);
        mainFrameController=ownerController;
        core.groupWorkAssemble();
        studentsTable = new StudentsTable();
    }

    public JDialog buildDialog() {
        JDialog dialog = new JDialog();
        dialog.setModal(true);
        dialog.setTitle("Search entries by group and work hours");
        JPanel rootDialogPanel = new JPanel(new BorderLayout());
        JButton dialogSearch = new JButton("Search");
        dialogSearch.addActionListener(ev -> {
            core.dialogController = new Controller(mainFrameController);
            core.dialogController.searchGroupWork(core.group.getSelectedItem().toString(),
                    Integer.parseInt(core.workLowerField.getText()),
                    Integer.parseInt(core.workHigherField.getText()));
            studentsTable.setTableData(core.dialogController.representData());
        });
        rootDialogPanel.add(core.panelOfChoice, BorderLayout.NORTH);
        rootDialogPanel.add(studentsTable.createTableComponent(), BorderLayout.CENTER);
        rootDialogPanel.add(dialogSearch, BorderLayout.SOUTH);
        dialog.add(rootDialogPanel);
        dialog.pack();
        return dialog;
    }
}