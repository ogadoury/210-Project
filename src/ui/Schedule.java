package ui;

import model.Date;
import model.Guest;
import model.Plan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
        guiMain.main();
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
    public static void removeDate(Date d) {
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

    // this version prints to console
    public static void printDates() {
        System.out.println("\n");
        for (Date d : dates) {
            System.out.println(d.getDate());
            d.printPlans();
            System.out.println("\n");
        }
    }

    public static Object[] getDatesObject() {
        ArrayList<String> currentSchedule = new ArrayList<>();
        for (Date d : getDates()) {
            String dateWPlans = d.getDate() + " : ";

            ArrayList<String> plans = new ArrayList<>();
            for (Plan p : d.getPlans()) {
                dateWPlans +=  '\n' + "plan: " +p.getActivity() + '\n';
                if (!p.getObservers().isEmpty()) {
                    dateWPlans += "\nguests: " + p.printObservers() + "\n";
                }
            }
            currentSchedule.add(dateWPlans);
        }
        return currentSchedule.toArray();
    }


    // USER FUNCTIONALITY


//
//    public void userAddDate() {
//        String dateToAdd = ;
//        if (!findDate(dateToAdd)) {
//        } else {
//            System.out.println("That date already exists in the schedule.");
//        }
//    }

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


    public static boolean findDate(String dateName) {
        boolean foundDate = false;
        for (Date date : dates) {
            if (date.getDate().equals(dateName)) {
                foundDate = true;
            }
        }
        return foundDate;
    }

    public static void findAndRemoveDate(String dateName) {
        Iterator<Date> iterator = dates.iterator();
        while (iterator.hasNext()) {
            Date curDate = iterator.next();
            if (curDate.getDate().equals(dateName)) {
                iterator.remove();
                System.out.println("removing: " + curDate);
            }
        }
    }

    public static void findDateAndAddPlan(String dateName, Plan plan) {
        for (Date d : dates) {
            if (d.getDate().equals(dateName)) {
                d.addPlan(plan);
            }
        }
    }

    public static void findDateAndRmPlan(String dateName, String planName) {
        Iterator<Date> iterator = dates.iterator();
        while (iterator.hasNext()) {
            Date curDate = iterator.next();
            if (curDate.getDate().equals(dateName)) {
                curDate.removePlan(planName);
                }
            }
        }

    public static void save() {
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

