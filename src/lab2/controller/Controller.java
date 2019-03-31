package lab2.controller;

import lab2.model.EntryModel;
import lab2.model.StudentEntity;

import java.util.ArrayList;
import java.util.Vector;

public class Controller {
    private EntryModel modelToControl;

    public void addEntry(ArrayList<String> name, String group, ArrayList<Integer> workData){
        modelToControl.addStudent(name, group, workData);
    }

    public Vector<Vector<Object>> representData(){
        ArrayList<StudentEntity> data = modelToControl.getStudents();
        Vector<Vector<Object>> representedData = new Vector<>();
        for(StudentEntity entity : data){
            Vector<Object> record = new Vector<>();
            record.add(entity.getName());
            record.add(entity.getGroup());
            record.addAll(entity.getStringHoursData());
            representedData.add(record);
        }
        return representedData;
    }

    public Controller() {
        this.modelToControl = new EntryModel();
    }
}
