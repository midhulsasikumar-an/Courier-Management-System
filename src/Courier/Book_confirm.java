package Courier;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

public class Book_confirm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public Book_confirm(String s_name, String r_name, String tr_no, String cost) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Booking Confirmed");
        lblTitle.setBounds(156, 28, 128, 12);
        contentPane.add(lblTitle);

        JLabel lblBookingDetails = new JLabel("Booking Details");
        lblBookingDetails.setBounds(38, 60, 139, 12);
        contentPane.add(lblBookingDetails);

        JLabel lblTracking = new JLabel("Tracking No : " + tr_no);
        lblTracking.setBounds(38, 82, 266, 12);
        contentPane.add(lblTracking);

        JLabel lblCost = new JLabel("Cost : " + cost);
        lblCost.setBounds(38, 104, 266, 12);
        contentPane.add(lblCost);

        JLabel lblStatus = new JLabel("Booking Status : Confirmed");
        lblStatus.setBounds(38, 126, 266, 12);
        contentPane.add(lblStatus);

        JLabel lblSender = new JLabel("Sender Name : " + s_name);
        lblSender.setBounds(38, 148, 266, 12);
        contentPane.add(lblSender);

        JLabel lblReceiver = new JLabel("Receiver Name : " + r_name);
        lblReceiver.setBounds(38, 170, 266, 12);
        contentPane.add(lblReceiver);

        JButton btnDashboard = new JButton("Back to Dashboard");
        btnDashboard.addActionListener(e -> {
            dashboard frame = new dashboard();
            frame.setVisible(true);
            dispose();
        });
        btnDashboard.setBounds(155, 216, 149, 37);
        contentPane.add(btnDashboard);
    }
}
