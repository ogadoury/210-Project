package model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Date implements Observer {

    private String date;
    private ArrayList<Plan> plans;
    private ArrayList<Plan> reminderPlans;

    public Date() {
        this.date = getDate();
        plans = new ArrayList<>();
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Plan> getPlans() {
        return plans;
    }

    // REQUIRES: the plan given does not already exist in the current list of plans
    // MODIFIES: this
    // EFFECTS: adds the given plan to the list of plans
    public void addPlan(Plan plan) {
        plans.add(plan);
    }


    // REQUIRES: the plan given exists in the list of plans
    // MODIFIES: this
    // EFFECTS: removes the given plan from the list of plans
    public void removePlan(Plan plan) {
        if (getPlans().contains(plan)) {
            plans.remove(plan);
        }
    }

    public void printPlans() {
        for(Plan p : plans) {
            System.out.println("\t - " + p.getActivity());
        }
    }

    public Plan findPlan(String planName) {
        Plan plan = null;
        for (Plan p : plans) {
            if (p.getActivity() == planName) {
                plan = p;
            }
        }
        return plan;
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public ArrayList<Plan> getReminderPlans() {
        return reminderPlans;
    }

    public void addReminderPlan (Plan p) {
        reminderPlans.add(p);
    }


}
