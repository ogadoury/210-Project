package ui;

import model.Date;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDate {
    private JButton addDateButton;
    private JTextArea DateName;
    private JLabel DateLabel;
    private JPanel panelMain;


    public AddDate() {
        addDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dateName = DateName.getText();
                Date newDate = new Date();
                newDate.setDate(dateName);
                Schedule.addDate(newDate);
                System.out.println(newDate.getDate() + " successfully created.");
            }
        });
    }


    public static void main() {
        JFrame frame = new JFrame("AddDate");
        frame.setContentPane(new AddDate().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
