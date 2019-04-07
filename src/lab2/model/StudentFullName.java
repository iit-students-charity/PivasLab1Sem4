package lab2.model;

import java.util.ArrayList;
import java.util.List;

public class StudentFullName {
    private String firstName;
    private String secondName;
    private String fatherName;

    public String getFullName(){
        return secondName+" "+firstName+" "+fatherName;
    }

    public StudentFullName(String firstName, String secondName, String fatherName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.fatherName = fatherName;
    }

    List<String> getNameParts(){
        List<String> parts = new ArrayList<>();
        parts.add(secondName);
        parts.add(firstName);
        parts.add(fatherName);
        return parts;
    }
}
