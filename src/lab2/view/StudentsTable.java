package lab2.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentsTable {
    private DefaultTableModel dm;

    public StudentsTable() {
        dm = new DefaultTableModel();
    }

    JTable createTableInstance(){
        //DefaultTableModel dm = new DefaultTableModel();
        dm.setDataVector(new Object[][]{/*
                        {"119", "Finbar", "John", "Saunders", "ja", "ko", "zh"},
                        {"911", "Roger", "Peter", "Melly", "en", "fr", "pt"}*/},
                new Object[]{"ФИО студента", "Группа", "1 семестр", "2 семестр", "3 семестр", "4 семестр", "5 семестр",
                        "6 семестр", "7 семестр", "8 семестр", "9 семестр", "10 семестр"});

        // Setup table
        JTable table = new JTable( /*dm, new GroupableTableColumnModel()*/);
        table.setColumnModel(new GroupableTableColumnModel());
        table.setTableHeader(new GroupableTableHeader((GroupableTableColumnModel) table.getColumnModel()));
        table.setModel(dm);

        // Setup Column Groups
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
        return  table;
    }

    public DefaultTableModel getTableModel() {
        return dm;
    }
}
