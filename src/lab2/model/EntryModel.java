package lab2.model;

import java.util.*;

public class EntryModel {
    private List<StudentEntity> students;
    private int pageCount;
    private int entriesPerPage;
    private Set<String> groups;

    public void calculatePageCount() {
        int studentsCount = students.size();
        if (studentsCount % entriesPerPage == 0) {
            pageCount = studentsCount / entriesPerPage;
        } else {
            pageCount = studentsCount / entriesPerPage + 1;
        }
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }

    public void addStudent(ArrayList<String> name, String group, ArrayList<Integer> hours) {
        StudentEntity studentEntity = new StudentEntity(name, group, hours);
        students.add(studentEntity);
        groups.add(studentEntity.getGroup());
    }

    public List<String> getGroupsList() {
        return new ArrayList<>(groups);
    }

    public void setGroups(Set<String> groups) {
        this.groups = groups;
    }

    public Set<String> getGroups() {
        return groups;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public int getPageCount() {
        return pageCount;
    }

    public EntryModel() {
        this.students = new ArrayList<>();
        this.pageCount = 0;
        this.entriesPerPage = 10;
        this.groups = new TreeSet<>();
    }

    public int deleteByNameGroup(List<String> name, String group) {
        List<StudentEntity> toRemove = searchByNameGroup(name, group);
        students.removeAll(toRemove);
        return toRemove.size();
    }

    public int deleteByNameWork(List<String> name, int lower, int higher) {
        List<StudentEntity> toRemove = searchByNameWork(name, lower, higher);
        students.removeAll(toRemove);
        return toRemove.size();
    }

    public int deleteByGroupWork(String group, int lower, int higher) {
        List<StudentEntity> toRemove = searchByGroupWork(group, lower, higher);
        students.removeAll(toRemove);
        return toRemove.size();
    }

    public List<StudentEntity> searchByNameGroup(List<String> name, String group) {
        List<StudentEntity> result = new Vector<>();
        for (StudentEntity studentToCompare : students) {
            if (studentToCompare.getNameParts().equals(name) && studentToCompare.getGroup().equals(group)) {
                result.add(studentToCompare);
            }
        }
        return result;
    }

    public List<StudentEntity> searchByNameWork(List<String> name, int lower, int higher) {
        Vector<StudentEntity> result = new Vector<StudentEntity>();
        for (StudentEntity studentToCompare : students) {
            int studentWorkHours = studentToCompare.getHoursSum();
            if (studentToCompare.getNameParts().equals(name) && studentWorkHours > lower && studentWorkHours < higher) {
                result.add(studentToCompare);
            }
        }
        return result;
    }

    public List<StudentEntity> searchByGroupWork(String group, int lower, int higher) {
        Vector<StudentEntity> result = new Vector<>();
        for (StudentEntity studentToCompare : students) {
            int studentWorkHours = studentToCompare.getHoursSum();
            if (studentToCompare.getGroup().equals(group) && studentWorkHours > lower && studentWorkHours < higher) {
                result.add(studentToCompare);
            }
        }
        return result;
    }
}
