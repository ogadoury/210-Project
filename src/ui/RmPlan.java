package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RmPlan {
    private static JFrame frame = guiMain.frame;
    private JButton removeButton;
    JPanel panelMain;
    private JTextField DateField;
    private JTextField PlanField;


    public RmPlan() {
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dateName = DateField.getText();
                String planAct = PlanField.getText();
                Schedule.findDateAndRmPlan(dateName, planAct);
                DateField.setText("");
                PlanField.setText("");

                // back to main window
                frame.setContentPane(new guiMain().panelMain);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public static void main() {
        frame.setContentPane(new RmPlan().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
