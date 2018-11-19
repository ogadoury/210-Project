package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RmPlan {
    private JButton removeButton;
    private JPanel panelMain;
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
            }
        });
    }

    public static void main() {
        JFrame frame = new JFrame("RmPlan");
        frame.setContentPane(new RmPlan().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
