package lab2.model;

import java.util.ArrayList;

public class StudentEntity {
    private StudentFullName name;
    private String group;
    private SocialWork socialWork;

    public String getName() {
        return name.getFullName();
    }

    public String getGroup() {
        return group;
    }

    public ArrayList<Integer> getHoursData() {
        return socialWork.getWork();
    }

    public ArrayList <String> getStringHoursData(){
        ArrayList<String> data=new ArrayList<>();
        for(Integer dataPiece : socialWork.getWork()){
            data.add(dataPiece.toString());
        }
        return data;
    }

    public Integer getHoursSum() {
        return socialWork.calculateWorkHours();
    }

    StudentEntity(ArrayList<String> fullName, String group, ArrayList<Integer> hours) {

        this.name = new StudentFullName(fullName.get(0), fullName.get(1), fullName.get(2));
        this.group = group;
        this.socialWork = new SocialWork(hours);
    }
}