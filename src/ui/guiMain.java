package ui;

import model.Date;

import javax.swing.*;
import java.util.ArrayList;

public class guiMain {
    private JPanel panelMain;
    private JButton addDateButton;
    private JButton removeDateButton;
    private JButton addPlanButton;
    private JButton removePlanButton;
    private JList currentSched;

    public void showSchedule() {
        currentSched.setListData(Schedule.getDates());
    }


    public static void main() {
        JFrame frame = new JFrame("Main");
        frame.setContentPane(new guiMain().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
