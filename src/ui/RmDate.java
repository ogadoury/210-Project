package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RmDate {
    private JPanel panelMain;
    private JButton removeButton;
    private JTextField dateName;
    private JLabel dateLabel;


    public RmDate() {
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Schedule.findAndRemoveDate(dateName.getText());
            }
        });
    }

    public static void main() {
        JFrame frame = new JFrame("RmDate");
        frame.setContentPane(new RmDate().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
