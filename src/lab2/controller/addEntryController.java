package lab2.controller;

import lab2.model.EntryModel;

import java.util.ArrayList;

public class addEntryController {
    EntryModel modelToAdd;

    public void addEntry(ArrayList<String> name, String group, ArrayList<Integer> workData){
        modelToAdd.addStudent(name, group, workData);
    }

    public addEntryController(EntryModel modelToAdd) {
        this.modelToAdd = modelToAdd;
    }
}
