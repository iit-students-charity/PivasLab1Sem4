package lab2.model;

public class StudentFullName {
    private String firstName;
    private String secondName;
    private String fatherName;

    public String getFullName(){
        return secondName+firstName+fatherName;
    }

    public StudentFullName(String firstName, String secondName, String fatherName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.fatherName = fatherName;
    }
}
