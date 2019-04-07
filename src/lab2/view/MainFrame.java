package lab2.view;

import lab2.controller.Controller;
import lab2.view.dialogs.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
public class MainFrame {
    private JFrame frame = new JFrame();
    Controller controller;
    private StudentsTable studentsTable;

    public MainFrame() {
        this.controller = new Controller();
        this.studentsTable = new StudentsTable();
    }

    public JFrame buildFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Lab 2");
        frame.setSize(new Dimension(800, 800));
        JMenuBar menuBar = new JMenuBar();
        JMenuItem addEntry = new JMenuItem("Add new entry");
        addEntry.addActionListener(ev -> new AddEntryDialog(frame, studentsTable, controller).buildDialog().setVisible(true));
        JMenu searchEntries = new JMenu("Search for entries");
        JMenuItem searchByNameGroup = new JMenuItem("Search for entries by name and Group");
        searchByNameGroup.addActionListener(ev -> new EntryNameGroupSearchDialog(new Controller(controller)).buildDialog().setVisible(true));
        JMenuItem searchByNameWork = new JMenuItem("Search for entries by name and social work hours");
        searchByNameWork.addActionListener(ev -> new EntryNameWorkSearchDialog(new Controller(controller)).buildDialog().setVisible(true));
        JMenuItem searchByGroupWork = new JMenuItem("Search for entries by group and social work hours");
        searchByGroupWork.addActionListener(ev -> new EntryGroupWorkSearchDIalog(new Controller(controller)).buildDialog().setVisible(true));
        JMenuItem deleteByNameGroup = new JMenuItem("Delete entries by name and group");
        deleteByNameGroup.addActionListener(ev -> {
            new EntryNameGroupDeleteDialog(controller).buildDialog().setVisible(true);
            studentsTable.setTableData(controller.representData());
        });
        JMenuItem deleteByNameWork = new JMenuItem("Delete entries by name and work hours");
        deleteByNameWork.addActionListener(ev -> {
            new EntryNameWorkDeleteDialog(controller).buildDialog().setVisible(true);
            studentsTable.setTableData(controller.representData());
        });
        JMenuItem deleteByGroupWork = new JMenuItem("Delete entries by group and work hours");
        deleteByGroupWork.addActionListener(ev -> {
            new EntryGroupWorkDeleteDialog(controller).buildDialog().setVisible(true);
            studentsTable.setTableData(controller.representData());
        });
        searchEntries.add(searchByNameGroup);
        searchEntries.add(searchByNameWork);
        searchEntries.add(searchByGroupWork);
        JMenu deleteEntries = new JMenu("Delete Entries");
        deleteEntries.add(deleteByNameGroup);
        deleteEntries.add(deleteByNameWork);
        deleteEntries.add(deleteByGroupWork);
        JMenuItem saveToFile = new JMenuItem("Save to file");
        saveToFile.addActionListener(ev -> {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("XML files", "xml");
            chooser.setFileFilter(filter);
            int chooserVal;
            chooserVal = chooser.showSaveDialog(frame);
            if (chooserVal == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                controller.saveData(file.getPath());
            }
        });
        JMenuItem loadFromFile = new JMenuItem("Load from file");
        loadFromFile.addActionListener(ev -> {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("XML files", "xml");
            chooser.setFileFilter(filter);
            int chooserVal;
            chooserVal = chooser.showOpenDialog(frame);
            if (chooserVal == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                controller.loadData(file.getPath());
                studentsTable.setTableData(controller.representData());
            }
        });
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
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout());
        DefaultTableModel studentsTableModel = studentsTable.getTableModel();
        rootPanel.add(studentsTable.createTableComponent(), BorderLayout.CENTER);
        rootPanel.validate();
        frame.add(rootPanel);
        return frame;
    }
}
