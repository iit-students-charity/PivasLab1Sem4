package lab2.view;

import lab2.view.customtable.ColumnGroup;
import lab2.view.customtable.GroupableTableColumnModel;
import lab2.view.customtable.GroupableTableHeader;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.Vector;

public class StudentsTable {
    private DefaultTableModel dm;
    private JTable table;
    private Integer entries;
    private Vector<Object> header;
    private Integer entriesPerPage;
    private Integer pagesTotal;
    private Integer currentPageNumber;
    private JLabel currentEntriesPerPage;
    private JLabel currentPageLabel;
    private GroupableTableColumnModel cm;
    private Vector<Vector<Object>> data;
    private PageModel dataNew;

    public StudentsTable() {
        dm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        entriesPerPage = 10;
        entries = 0;
        currentPageNumber=0;
        this.dataNew = new PageModel();
    }

    private void updateColumnModel(){
        cm = (GroupableTableColumnModel) table.getColumnModel();
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
    }

    public JPanel createTableComponent() {
        header = new Vector<>(Arrays.asList("ФИО студента", "Группа", "1 семестр", "2 семестр", "3 семестр", "4 семестр", "5 семестр",
                "6 семестр", "7 семестр", "8 семестр", "9 семестр", "10 семестр"));
        dm.setDataVector(new Vector<>(), header);

        // Setup table
        table = new JTable( /*dm, new GroupableTableColumnModel()*/);
        table.setColumnModel(new GroupableTableColumnModel());
        table.setTableHeader(new GroupableTableHeader((GroupableTableColumnModel) table.getColumnModel()));
        table.setModel(dm);

        // Setup Column Groups
        cm = (GroupableTableColumnModel) table.getColumnModel();
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
        JTextField pagesField = new JTextField(10);
        JButton dialogFirst = new JButton(("<<"));
        dialogFirst.addActionListener(ev->{
            dataNew.setCurrentPage(0);
            updateTableModel();
        });
        JButton dialogPrev = new JButton("<");
        dialogPrev.addActionListener(ev->{
            dataNew.decrementPage();
            updateTableModel();
        });
        JButton dialogNext = new JButton(">");
        dialogNext.addActionListener(ev->{
            dataNew.incrementPage();
            updateTableModel();
        });
        JButton dialogLast = new JButton(">>");
        dialogLast.addActionListener(ev->{
            dataNew.setCurrentPage(dataNew.getPagesTotal());
            updateTableModel();
        });
        JButton changeEntriesPerPage = new JButton("Change entries per page");
        changeEntriesPerPage.addActionListener(ev->{
            dataNew.setEntriesPerPage(Integer.parseInt(pagesField.getText()));
            currentEntriesPerPage.setText(dataNew.getEntriesPerPage().toString());
            updateTableModel();
        });
        currentEntriesPerPage = new JLabel("");
        currentPageLabel = new JLabel("");
        currentPageLabel.setText(dataNew.getCurrentPage().toString());
        currentEntriesPerPage.setText(dataNew.getEntriesPerPage().toString());
        JPanel buttons = new JPanel();
        buttons.add(dialogFirst);
        buttons.add(dialogPrev);
        buttons.add(currentPageLabel);
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

    public void updateTableModel() {
        dm.setDataVector(dataNew.getRequestedPage(), header);
        updateColumnModel();
        currentPageLabel.setText(dataNew.getCurrentPage().toString());
    }

    public void setTableData(Vector<Vector<Object>> data){
        this.dataNew.setPages(data);
        dm.setDataVector(dataNew.getRequestedPage(), header);
        updateColumnModel();
    }

    private void calculatePagesTotal() {
        pagesTotal = this.entries / entriesPerPage+1;
    }

    private Integer calculateLastPageEntriesNumber() {
        return (entries - entriesPerPage * (pagesTotal - 1));
    }

    private Vector<Vector<Object>> getDataPiece(Vector<Vector<Object>> data){
        Vector<Vector<Object>> dataPiece = new Vector<>();
        Integer test = calculateLastPageEntriesNumber();
        Integer start = entriesPerPage*(pagesTotal-1);
        test+=start;
        if(currentPageNumber==pagesTotal-1){
            for (int i=start; i<test;i++){
                dataPiece.add(data.get(i));
            }
        } else{
            for (int i=currentPageNumber*entriesPerPage; i<entriesPerPage*(currentPageNumber+1);i++){
                dataPiece.add(data.get(i));
            }
        }
        return dataPiece;
    }

}