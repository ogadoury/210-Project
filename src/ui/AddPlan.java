package ui;

import model.Guest;
import model.Plan;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPlan {
    private static JFrame frame = guiMain.frame;
    private JTextField PlanActivity;
    private JTextField GuestName;
    private JButton AddBtn;
    JPanel panelMain;
    private JTextField dateTo;

    public AddPlan() {
        AddBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String DateName = dateTo.getText();

                if (Schedule.findDate(DateName)) {
                    // creates the plan
                    Plan newPlan = new Plan();
                    newPlan.setActivity(PlanActivity.getText());
                    Schedule.findDateAndAddPlan(DateName, newPlan);

                    // checks if there is a guest in the field
                    String guestName = GuestName.getText();
                    if (!guestName.equals("")) {
                        Guest guest = new Guest();
                        guest.setName(guestName);
                        newPlan.addObserver(guest);
                    }


                    // prints the updated schedule
                    Schedule.printDates();

                    // back to main window
                    frame.setContentPane(new guiMain().panelMain);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                } else {
                    System.out.println("the date given does not exist!");
                }
            }
        });
    }

    public static void main() {
        frame.setContentPane(new AddPlan().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
