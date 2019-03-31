package lab2.model;

import java.util.ArrayList;

public class SocialWork {
    private ArrayList<Integer> work;

    public ArrayList<Integer> getWork() {
        return work;
    }

    public SocialWork(ArrayList<Integer> work) {
        this.work = work;
    }

    public Integer calculateWorkHours() {
        Integer hours = 0;
        for (Integer integer : work) {
            hours += integer;
        }
        return hours;
    }
}
