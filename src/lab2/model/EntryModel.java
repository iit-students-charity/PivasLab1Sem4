package lab2.model;

import java.util.Collection;
import java.util.Vector;

public class EntryModel {
    private Vector<StudentEntity> students;
    private int pageCount;

    public void calculatePageCount() {
        int studentsCount = students.size();
        if (studentsCount % 10 == 0) {
            pageCount = studentsCount / 10;
        } else {
            pageCount = studentsCount / 10 + 1;
        }
    }

    public void addStudent(String name, String group, int[] hours) {
        StudentEntity studentEntity = new StudentEntity(name, group, hours);
        students.add(studentEntity);
    }

    public Vector<StudentEntity> getStudents() {
        return students;
    }

    public int getPageCount() {
        return pageCount;
    }

    public EntryModel(Collection<StudentEntity> students, int pageCount) {
        this.students = new Vector<>(students);
        this.pageCount = pageCount;
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
            int studentWorkHours = studentToCompare.calculateHours();
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
            int studentWorkHours = studentToCompare.calculateHours();
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
            int studentWorkHours = studentToCompare.calculateHours();
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
            int studentWorkHours = studentToCompare.calculateHours();
            if (studentToCompare.getGroup().equals(group) && studentWorkHours > lower && studentWorkHours < higher) {
                result.add(studentToCompare);
            }
        }
        return result;
    }

    public Object[] getCurrentData() {
        int HOURSAMOUNT = 10;
        final int INDEXOFNAME = 0;
        int INDEXOFGROUP = 1;
        int dataSize = students.size();
        Object[][] data = new Object[dataSize][12];
        for (int i = 0; i < dataSize; i++) {
            StudentEntity currentStudent = students.get(i);
            data[i][INDEXOFNAME] = currentStudent.getName();
            data[i][INDEXOFGROUP] = currentStudent.getGroup();
            for (int j = 0; j < HOURSAMOUNT; j++) {
                data[i][j+2]=currentStudent.getSocialWork()[j];
            }
        }
        return data;
    }
}
