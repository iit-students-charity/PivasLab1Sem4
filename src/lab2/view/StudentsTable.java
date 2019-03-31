package lab2.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.util.List;

public class StudentsTable {
    private DefaultTableModel dm;
    private Integer pages;
    private Integer entries;
    private Vector<Object> header;
    private int entriesPerPage;
    private Integer pagesTotal;
    private JLabel currentEntriesPerPage;
    private JLabel currentPage;

    public StudentsTable() {
        dm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        entriesPerPage = 10;
        entries = 0;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public JPanel createTableComponent() {
        header = new Vector<>(Arrays.asList("ФИО студента", "Группа", "1 семестр", "2 семестр", "3 семестр", "4 семестр", "5 семестр",
                "6 семестр", "7 семестр", "8 семестр", "9 семестр", "10 семестр"));
        dm.setDataVector(new Vector<>(), header);

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
        JButton dialogFirst = new JButton(("<<"));
        JButton dialogPrev = new JButton("<");
        JButton dialogNext = new JButton(">");
        JButton dialogLast = new JButton(">>");
        JButton changeEntriesPerPage = new JButton("Change entries per page");
        currentEntriesPerPage = new JLabel("");
        JTextField pagesField = new JTextField(10);
        currentPage = new JLabel("");
        JPanel buttons = new JPanel();
        buttons.add(dialogFirst);
        buttons.add(dialogPrev);
        buttons.add(currentPage);
        buttons.add(dialogNext);
        buttons.add(dialogLast);
        buttons.add(changeEntriesPerPage);
        buttons.add(currentEntriesPerPage);
        buttons.add(pagesField);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        tablePanel.add(buttons, BorderLayout.SOUTH);
        return tablePanel;
    }

    public DefaultTableModel getTableModel() {
        return dm;
    }

    public void updateTableModel(Vector<Vector<Object>> data) {
        dm.setDataVector(data, header);
        Integer dataSize=data.size();
        calculatePagesTotal(dataSize);
        entries++;
        currentEntriesPerPage.setText(pagesTotal.toString());

    }
    private void calculatePagesTotal(int dataLength){
        if (dataLength % entriesPerPage == 0) {
            pagesTotal = entries / entriesPerPage;
        } else {
            pagesTotal = entries / entriesPerPage + 1;
        }
    }

}