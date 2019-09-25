package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Plan extends Observable {
    private String activity;
    private List<Guest> guests = new ArrayList<>();

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void addObserver (Guest g) {
        guests.add(g);
    }

    public void removeObserver (Guest g) {
        guests.remove(g);
    }

    public List<Guest> getObservers() {
        return guests;
    }

    public String printObservers() {
        String output = "";
        for (Guest g:guests) {
            output += g.getName() + ";";
        }
        return output;
    }

    public void cancelPlan() {
        for (Guest guest : guests) {
            guest.update(this, this);
        }
    }


}
