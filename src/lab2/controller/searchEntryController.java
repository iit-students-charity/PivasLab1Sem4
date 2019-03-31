package lab2.controller;

import lab2.model.EntryModel;
import lab2.model.StudentEntity;

import java.util.ArrayList;

public class searchEntryController {
    EntryModel entriesToSearch;

    ArrayList<ArrayList<String>> representData(ArrayList<StudentEntity> data){
        ArrayList<ArrayList<String>> representedData = new ArrayList<>();
        for(StudentEntity entity : data){
            ArrayList<String> record = new ArrayList<>();
            record.add(entity.getName());
            record.add(entity.getGroup());
            record.addAll(entity.getStringHoursData());
            representedData.add(record);
        }
        return representedData;
    }
}
