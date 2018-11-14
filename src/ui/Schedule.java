package ui;

import model.Date;
import model.Guest;
import model.Plan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Schedule {

    private static ArrayList<Date> dates = new ArrayList<>();


    public Scanner scanner;

    public Schedule() {
        scanner = new Scanner(System.in);
    }



    public static ArrayList<Date> getDates() {
        return dates;
    }


    public static void setDates(ArrayList<Date> dates) {
        Schedule.dates = dates;
    }


    // MAIN RUN FUNCTION

    public void run() {
        System.out.println("Please choose an option for the Schedule:");
        System.out.println("AddDate, RemoveDate, RemoveAll, AddPlan, RemovePlan, PrintSchedule, Quit");
        String userIn = scanner.nextLine();
        if (userIn.equals("AddDate")) {
            userAddDate();
            run();
        } else if (userIn.equals("RemoveDate")) {
            userRemoveDate();
            run();
        } else if (userIn.equals("RemoveAll")) {
            removeAllDates();
            run();
        } else if (userIn.equals("AddPlan")) {
            userAddPlan();
            run();
        } else if (userIn.equals("RemovePlan")) {
            userRemovePlan();
            run();
        } else if (userIn.equals("PrintSchedule")) {
            printDates();
            run();
        } else if (userIn.equals("Save")) {
            saveSchedule();
            run();
        } else if (userIn.equals("Quit")) {
            saveSchedule();
            System.out.println("Ciao!");
        } else {
            // throw error
            System.out.println("WRONG OUTPUT");
            run();
        }

    }


    // MAIN METHODS


    // REQUIRES: The date given does not already exist in the schedule's list of dates
    // MODIFIES: this
    // EFFECTS: adds the given date to the schedule's list of dates
    public static void addDate(Date d) {
            dates.add(d);
        }


    // REQUIRES: The date given exists in the schedule's list of dates
    // MODIFIES: this
    // EFFECTS: removes the given date from the schedule's list of dates
    public void removeDate(Date d) {
        for (Plan p : d.getPlans()) {
            p.cancelPlan();
        }
        dates.remove(d);
    }

    // REQUIRES: The date given exists in the schedule's list of dates
    // MODIFIES: this
    // EFFECTS: removes all dates from the schedule's list of dates
    public void removeAllDates() {
        setDates(new ArrayList<>());
    }


    // EFFECTS: prints out the current list of dates
    public void printDates() {
        System.out.println("\n");
        for (Date d : dates) {
            System.out.println(d.getDate());
            d.printPlans();
            System.out.println("\n");
        }
    }


    // USER FUNCTIONALITY

    public void userAddDate() {
        System.out.println("What is the date you would like to add?");
        String dateToAdd = scanner.nextLine();
        if (!findDate(dateToAdd)) {
            Date d = new Date();
            d.setDate(dateToAdd);
            addDate(d);
        } else {
            System.out.println("That date already exists in the schedule.");
        }
    }

    public void userRemoveDate() {
        System.out.println("Which date would you like to remove?");
        String userIn = scanner.nextLine();
        if (findDate(userIn)) {
            findAndRemoveDate(userIn);
            System.out.println("Date removed");
        } else {
            System.out.println("The date given does not exist");
        }
    }



    public void userAddPlan() {
        System.out.println("Which day is the plan to be added to?");
        String dateName = scanner.nextLine();
        if (findDate(dateName)) {
            System.out.println("What is the name of the plan you would like to add?");
            String planName = scanner.nextLine();
            if (findDate(dateName)) {
                Plan p = new Plan();
                p.setActivity(planName);
                findDateAndAddPlan(dateName, p);
                // add observer to plan here
                System.out.println("Add guests to this plan?");
                String addguests = scanner.nextLine();
                if (addguests.equals("Y")) {
                    userAddGuests(p);
                }
            }
        } else {
            System.out.println("The date given does not exist");
        }
    }

    public void userRemovePlan() {
        System.out.println("Which day is the plan to be removed from?");
        String dateName = scanner.nextLine();
        System.out.println("What is the name of the plan you would like to remove?");
        String planName = scanner.nextLine();
        if (findDate(dateName)) {
            findDateAndRmPlan(dateName, planName);
        } else {
            System.out.println("The date given does not exist.");
        }
    }

    public void userAddGuests(Plan p) {
        System.out.println("What is the name of the guest to be added?");
        String guestName = scanner.nextLine();
        Guest g = new Guest();
        g.setName(guestName);
        p.addObserver(g);
    }


    // GENERAL HELPERS


    public boolean findDate(String dateName) {
        boolean foundDate = false;
        for (Date date : dates) {
            if (date.getDate().equals(dateName)) {
                foundDate = true;
            }
        }
        return foundDate;
    }

    public void findAndRemoveDate(String dateName) {
        for (Date d : dates) {
            if (d.getDate().equals(dateName)) {
                removeDate(d);
            }
        }
    }

    public void findDateAndAddPlan(String dateName, Plan plan) {
        for (Date d : dates) {
            if (d.getDate().equals(dateName)) {
                d.addPlan(plan);
            }
        }
    }

    public void findDateAndRmPlan(String dateName, String planName) {
        for (Date d : dates) {
            if (d.getDate().equals(dateName)) {
                for (Plan p : d.getPlans()) {
                    if (p.getActivity().equals(planName)) {
                        p.cancelPlan();
                        d.removePlan(p);
                    }
                }
            }
        }
    }

    public void saveSchedule() {
        try {
            CreateJSONFile.create();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadSchedule() {
        ReadJSONFile.run();
    }
}

