package lab2.view;

import lab2.view.dialogs.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
//import javax.swing.table.JTableHeader;
import java.awt.*;
//import javax.swing.table.DefaultTableCellRenderer;

public class MainFrame {
    private JFrame frame = new JFrame();
    private DefaultTableModel mainTableModel;
    JFrame buildFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Lab 2");
        frame.setSize(new Dimension(800, 800));
        JMenuBar menuBar = new JMenuBar();
        JMenuItem addEntry = new JMenuItem("Add new entry");
        addEntry.addActionListener(ev -> new AddEntryDialog(frame).buildDialog().setVisible(true));
        JMenu searchEntries = new JMenu("Search for entries");
        JMenuItem searchByNameGroup = new JMenuItem("Search for entries by name and Group");
        searchByNameGroup.addActionListener(ev -> new EntryNameGroupSearchDialog().buildDialog().setVisible(true));
        JMenuItem searchByNameWork = new JMenuItem("Search for entries by name and social work hours");
        searchByNameWork.addActionListener(ev -> new EntryNameWorkSearchDialog().buildDialog().setVisible(true));
        JMenuItem searchByGroupWork = new JMenuItem("Search for entries by group and social work hours");
        searchByGroupWork.addActionListener(ev -> new EntryGroupWorkSearchDIalog().buildDialog().setVisible(true));
        JMenuItem deleteByNameGroup = new JMenuItem("Delete entries by name and group");
        deleteByNameGroup.addActionListener(ev -> new EntryNameGroupDeleteDialog().buildDialog().setVisible(true));
        JMenuItem deleteByNameWork = new JMenuItem("Delete entries by name and work hours");
        deleteByNameWork.addActionListener(ev -> new EntryNameWorkDeleteDialog().buildDialog().setVisible(true));
        JMenuItem deleteByGroupWork = new JMenuItem("Delete entries by group and work hours");
        deleteByGroupWork.addActionListener(ev -> new EntryGroupWorkDeleteDialog().buildDialog().setVisible(true));
        searchEntries.add(searchByNameGroup);
        searchEntries.add(searchByNameWork);
        searchEntries.add(searchByGroupWork);
        JMenu deleteEntries = new JMenu("Delete Entries");
        deleteEntries.add(deleteByNameGroup);
        deleteEntries.add(deleteByNameWork);
        deleteEntries.add(deleteByGroupWork);
        JMenuItem saveToFile = new JMenuItem("Save to file");
        JMenuItem loadFromFile = new JMenuItem("Load from file");
        JMenu operationsMenu = new JMenu("Data manipulation");
        operationsMenu.add(searchEntries);
        operationsMenu.add(deleteEntries);
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(saveToFile);
        fileMenu.add(loadFromFile);
        operationsMenu.add(addEntry);
        menuBar.add(fileMenu);
        menuBar.add(operationsMenu);
        frame.setJMenuBar(menuBar);
        JTable pagesTable = new JTable(new DefaultTableModel(0, 4));
        mainTableModel = (DefaultTableModel) pagesTable.getModel();
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout());
        //rootPanel.add(pagesTable, BorderLayout.CENTER);
        JButton previousPage = new JButton("<<");
        JLabel currentPage = new JLabel("Page 1");
        JButton nextPage = new JButton(">>");
        JPanel pageButtons = new JPanel(new FlowLayout());
        pageButtons.add(previousPage);
        pageButtons.add(currentPage);
        pageButtons.add(nextPage);
        StudentsTable studentsTable = new StudentsTable();
        DefaultTableModel studentsTableModel = studentsTable.getTableModel();
        JScrollPane scroll = new JScrollPane(studentsTable.createTableInstance());
        rootPanel.add(scroll);
        rootPanel.add(pageButtons, BorderLayout.SOUTH);
        rootPanel.validate();
        frame.add(rootPanel);
        return frame;
    }
}

/*class GroupableTableCellRenderer extends DefaultTableCellRenderer {
    /**
     * @param table
     * @param value
     * @param selected
     * @param focused
     * @param row
     * @param column
     * @return
     */
    /*public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean selected, boolean focused, int row, int column) {
        JTableHeader header = table.getTableHeader();
        if (header != null) {
            setForeground(Color.WHITE);
            setBackground(Color.RED);
        }
        setHorizontalAlignment(SwingConstants.CENTER);
        setText(value != null ? value.toString() : " ");
        setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        return this;
    }
}*/
