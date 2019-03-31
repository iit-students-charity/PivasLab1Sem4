package lab2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class EntryModel {
    private ArrayList<StudentEntity> students;
    private int pageCount;
    private int entriesPerPage;

    public void calculatePageCount() {
        int studentsCount = students.size();
        if (studentsCount % entriesPerPage == 0) {
            pageCount = studentsCount / entriesPerPage;
        } else {
            pageCount = studentsCount / entriesPerPage + 1;
        }
    }

    public void addStudent(ArrayList<String> name, String group, ArrayList<Integer> hours) {
        StudentEntity studentEntity = new StudentEntity(name, group, hours);
        students.add(studentEntity);
    }

    public ArrayList<StudentEntity> getStudents() {
        return students;
    }

    public int getPageCount() {
        return pageCount;
    }

    public EntryModel() {
        this.students = new ArrayList<>();
        this.pageCount = 0;
        this.entriesPerPage=10;
    }

    public Vector<StudentEntity> deleteByNameGroup(String name, String group) {
        Vector<StudentEntity> result = new Vector<>();
        for (int i = 0; i < students.size(); i++) {
            StudentEntity studentToCompare = students.get(i);
            if (studentToCompare.getName().equals(name) && studentToCompare.getGroup().equals(group)) {
                result.add(studentToCompare);
                students.remove(i);
            }
        }
        return result;
    }

    public Vector<StudentEntity> deleteByNameWork(String name, int lower, int higher) {
        Vector<StudentEntity> result = new Vector<StudentEntity>();
        for (int i = 0; i < students.size(); i++) {
            StudentEntity studentToCompare = students.get(i);
            int studentWorkHours = studentToCompare.getHoursSum();
            if (studentToCompare.getName().equals(name) && studentWorkHours > lower && studentWorkHours < higher) {
                result.add(studentToCompare);
                students.remove(i);
            }
        }
        return result;
    }

    public Vector<StudentEntity> deleteByGroupWork(String group, int lower, int higher) {
        Vector<StudentEntity> result = new Vector<StudentEntity>();
        for (int i = 0; i < students.size(); i++) {
            StudentEntity studentToCompare = students.get(i);
            int studentWorkHours = studentToCompare.getHoursSum();
            if (studentToCompare.getGroup().equals(group) && studentWorkHours > lower && studentWorkHours < higher) {
                result.add(studentToCompare);
                students.remove(i);
            }
        }
        return result;
    }

    public Vector<StudentEntity> searchByNameGroup(String name, String group) {
        Vector<StudentEntity> result = new Vector<StudentEntity>();
        for (int i = 0; i < students.size(); i++) {
            StudentEntity studentToCompare = students.get(i);
            if (studentToCompare.getName().equals(name) && studentToCompare.getGroup().equals(group)) {
                result.add(studentToCompare);
            }
        }
        return result;
    }

    public Vector<StudentEntity> searchByNameWork(String name, int lower, int higher) {
        Vector<StudentEntity> result = new Vector<StudentEntity>();
        for (int i = 0; i < students.size(); i++) {
            StudentEntity studentToCompare = students.get(i);
            int studentWorkHours = studentToCompare.getHoursSum();
            if (studentToCompare.getName().equals(name) && studentWorkHours > lower && studentWorkHours < higher) {
                result.add(studentToCompare);
            }
        }
        return result;
    }

    public Vector<StudentEntity> searchByGroupWork(String group, int lower, int higher) {
        Vector<StudentEntity> result = new Vector<StudentEntity>();
        for (int i = 0; i < students.size(); i++) {
            StudentEntity studentToCompare = students.get(i);
            int studentWorkHours = studentToCompare.getHoursSum();
            if (studentToCompare.getGroup().equals(group) && studentWorkHours > lower && studentWorkHours < higher) {
                result.add(studentToCompare);
            }
        }
        return result;
    }

    public Object[] getCurrentData() {
        int HOURS_AMOUNT = 10;
        final int INDEX_OF_NAME = 0;
        int INDEX_OF_GROUP = 1;
        int dataSize = students.size();
        Object[][] data = new Object[dataSize][12];
        for (int i = 0; i < dataSize; i++) {
            StudentEntity currentStudent = students.get(i);
            data[i][INDEX_OF_NAME] = currentStudent.getName();
            data[i][INDEX_OF_GROUP] = currentStudent.getGroup();
            for (int j = 0; j < HOURS_AMOUNT; j++) {
                data[i][j+2]=currentStudent.getHoursData().get(j);
            }
        }
        return data;
    }
}
