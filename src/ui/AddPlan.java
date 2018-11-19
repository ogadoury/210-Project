package ui;

import model.Plan;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPlan {
    private JTextField PlanActivity;
    private JTextField GuestName;
    private JButton AddBtn;
    private JPanel panelMain;
    private JTextField dateTo;

    public AddPlan() {
        AddBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String DateName = dateTo.getText();

                if (Schedule.findDate(DateName)) {
                    Plan newPlan = new Plan();
                    newPlan.setActivity(PlanActivity.getText());
                    Schedule.findDateAndAddPlan(DateName, newPlan);
                    Schedule.printDates();
                } else {
                    System.out.println("the date given does not exist!");
                }
            }
        });
    }

    public static void main() {
        JFrame frame = new JFrame("AddPlan");
        frame.setContentPane(new AddPlan().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
