package lab2.controller;

import lab2.model.EntryModel;
import lab2.model.StudentEntity;

import java.util.Vector;

public class Controller {
    private EntryModel mainStudentModel;

    public void addEntry(String[] entryData) {
        int HOURSAMOUNT = 10;
        final int INDEXOFNAME=0;
        int INDEXOFGROUP=1;
        int[] hours = new int[HOURSAMOUNT];
        for (int i = 2; i < entryData.length - 2; i++) {
            hours[i - 2] = Integer.parseInt(entryData[i]);
        }
        String name = entryData[INDEXOFNAME];
        String group=entryData[INDEXOFGROUP];
        mainStudentModel.addStudent(name, group, hours);
    }

    public Controller() {
        this.mainStudentModel = new EntryModel(new Vector<StudentEntity>(), 0);
    }
}
