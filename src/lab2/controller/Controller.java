package lab2.controller;

import lab2.model.EntryModel;
import lab2.model.StudentEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Controller {
    EntryModel modelToControl;

    public void addEntry(ArrayList<String> name, String group, ArrayList<Integer> workData) {
        modelToControl.addStudent(name, group, workData);
    }

    public Vector<Vector<Object>> representData() {
        List<StudentEntity> data = modelToControl.getStudents();
        Vector<Vector<Object>> representedData = new Vector<>();
        for (StudentEntity entity : data) {
            Vector<Object> record = new Vector<>();
            record.add(entity.getName());
            record.add(entity.getGroup());
            record.addAll(entity.getStringHoursData());
            representedData.add(record);
        }
        return representedData;
    }

    public List<String> sendGroups() {
        return modelToControl.getGroupsList();
    }

    public Controller() {
        this.modelToControl = new EntryModel();
    }

    public Controller(Controller copy) {
        this.modelToControl = new EntryModel();
        this.modelToControl.setStudents(copy.modelToControl.getStudents());
        this.modelToControl.setGroups(copy.modelToControl.getGroups());
    }
    public void saveData(String path){
        XMLSaveComponent saver = new XMLSaveComponent(path, modelToControl.getStudents());
        saver.writeToFile();
    }

    public void loadData(String path){
        this.modelToControl = new XMLLoadComponent(path).loadFromFile();
    }

    public void searchNameWork(String name, int lower, int higher){
        this.modelToControl.setStudents(modelToControl.searchByNameWork(name,lower,higher));
    }
}
