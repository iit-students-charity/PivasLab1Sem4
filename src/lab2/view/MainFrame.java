package lab2.view;

import lab2.controller.Controller;
import lab2.view.dialogs.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
public class MainFrame {
    private JFrame frame = new JFrame();
    Controller controller;
    private StudentsTable studentsTable;
    private JToolBar bar;

    public MainFrame() {
        this.controller = new Controller();
        this.studentsTable = new StudentsTable();
        assembleToolBar();
    }

    public JFrame buildFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Lab 2");
        frame.setSize(new Dimension(800, 800));
        JMenuBar menuBar = new JMenuBar();
        JMenuItem addEntry = new JMenuItem("Add new entry");
        addEntry.addActionListener(ev -> {
            new AddEntryDialog(frame, studentsTable, controller).buildDialog().setVisible(true);
            studentsTable.setTableData(controller.representData());
        });
        JMenu searchEntries = new JMenu("Search for entries");
        JMenuItem searchByNameGroup = new JMenuItem("Search for entries by name and Group");
        searchByNameGroup.addActionListener(new searchNameGroupListener());
        JMenuItem searchByNameWork = new JMenuItem("Search for entries by name and social work hours");
        searchByNameWork.addActionListener(new searchNameWorkListener());
        JMenuItem searchByGroupWork = new JMenuItem("Search for entries by group and social work hours");
        searchByGroupWork.addActionListener(new searchGroupWorkListener());
        JMenuItem deleteByNameGroup = new JMenuItem("Delete entries by name and group");
        deleteByNameGroup.addActionListener(new deleteNameGroupListener());
        JMenuItem deleteByNameWork = new JMenuItem("Delete entries by name and work hours");
        deleteByNameWork.addActionListener(new deleteNameWorkListener());
        JMenuItem deleteByGroupWork = new JMenuItem("Delete entries by group and work hours");
        deleteByGroupWork.addActionListener(new deleteGroupWorkListener());
        searchEntries.add(searchByNameGroup);
        searchEntries.add(searchByNameWork);
        searchEntries.add(searchByGroupWork);
        JMenu deleteEntries = new JMenu("Delete Entries");
        deleteEntries.add(deleteByNameGroup);
        deleteEntries.add(deleteByNameWork);
        deleteEntries.add(deleteByGroupWork);
        JMenuItem saveToFile = new JMenuItem("Save to file");
        saveToFile.addActionListener(new fileSaveListener());
        JMenuItem loadFromFile = new JMenuItem("Load from file");
        loadFromFile.addActionListener(new fileLoadListener());
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
        rootPanel.add(bar, BorderLayout.NORTH);
        rootPanel.validate();
        frame.add(rootPanel);
        return frame;
    }

    private void assembleToolBar(){
        bar = new JToolBar();
        JButton barSearchNameGroup = new JButton("search by name and group");
        barSearchNameGroup.addActionListener(new searchNameGroupListener());
        JButton barSearchNameWork = new JButton("search by name and work");
        barSearchNameWork.addActionListener(new searchNameWorkListener());
        JButton barSearchGroupWork = new JButton("search by group and work");
        barSearchGroupWork.addActionListener(new searchGroupWorkListener());
        JButton barDeleteNameGroup = new JButton("delete by name and group");
        barDeleteNameGroup.addActionListener(new deleteNameGroupListener());
        JButton barDeleteNameWork = new JButton("delete by name and work");
        barDeleteNameWork.addActionListener(new deleteNameWorkListener());
        JButton barDeleteGroupWork = new JButton("delete by group and work");
        barDeleteGroupWork.addActionListener(new deleteGroupWorkListener());
        JButton barFileSave = new JButton("Save to file");
        barFileSave.addActionListener(new fileSaveListener());
        JButton barFileLoad = new JButton("Load from file");
        barFileLoad.addActionListener(new fileLoadListener());
        bar.add(barSearchNameGroup);
        bar.add(barSearchNameWork);
        bar.add(barSearchGroupWork);
        bar.add(barDeleteNameGroup);
        bar.add(barDeleteNameWork);
        bar.add(barDeleteGroupWork);
        bar.add(barFileSave);
        bar.add(barFileLoad);
        bar.setFloatable(false);
    }

    private class searchNameGroupListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            new EntryNameGroupSearchDialog(new Controller(controller)).buildDialog().setVisible(true);
        }
    }
    private class searchNameWorkListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            new EntryNameWorkSearchDialog(new Controller(controller)).buildDialog().setVisible(true);
        }
    }
    private class searchGroupWorkListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            new EntryGroupWorkSearchDIalog(new Controller(controller)).buildDialog().setVisible(true);
        }
    }
    private class deleteNameGroupListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            new EntryNameGroupDeleteDialog(controller).buildDialog().setVisible(true);
            studentsTable.setTableData(controller.representData());
        }
    }
    private class deleteNameWorkListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            new EntryNameWorkDeleteDialog(controller).buildDialog().setVisible(true);
            studentsTable.setTableData(controller.representData());
        }
    }
    private class deleteGroupWorkListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            new EntryGroupWorkDeleteDialog(controller).buildDialog().setVisible(true);
            studentsTable.setTableData(controller.representData());
        }
    }
    private class fileSaveListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JFileChooser chooser = new JFileChooser("D:\\ppvis lab 2 test");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("XML files", "xml");
            chooser.setFileFilter(filter);
            int chooserVal;
            chooserVal = chooser.showSaveDialog(frame);
            if (chooserVal == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                controller.saveData(file.getPath());
            }
        }
    }
    private class fileLoadListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JFileChooser chooser = new JFileChooser("D:\\ppvis lab 2 test");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("XML files", "xml");
            chooser.setFileFilter(filter);
            int chooserVal;
            chooserVal = chooser.showOpenDialog(frame);
            if (chooserVal == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                controller.loadData(file.getPath());
                studentsTable.setTableData(controller.representData());
            }
        }
    }
}
