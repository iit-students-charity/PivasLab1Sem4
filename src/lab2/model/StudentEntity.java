package lab2.model;

public class StudentEntity {
    private String firstName;
    private String secondName;
    private String fatherName;
    private String group;
    private int[] socialWork;
    public String getFirstName() {
        return firstName;
    }
    public String getName(){return "prank";}

    public String getGroup() {
        return group;
    }

    public int[] getSocialWork() {
        return socialWork;
    }
    StudentEntity(String name, String group, int[] hours)
    {
        this.firstName=name;
        this.group=group;
        this.socialWork=hours;
    }
    public int calculateHours(){
        int sum=0;
        for (int i1 : socialWork) {
            sum += i1;
        }
        return sum;
    }
    public String assembleFullName(){
        return secondName+firstName+fatherName;
    }
}
