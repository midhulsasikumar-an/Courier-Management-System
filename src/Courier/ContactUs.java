package Courier;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ContactUs extends JFrame {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ContactUs frame = new ContactUs();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ContactUs() {
        setTitle("Contact Us - Courier Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 497); // Normal fixed size
        setLocationRelativeTo(null); // Center on screen

        // Main panel
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // ---------- Title ----------
        JLabel titleLabel = new JLabel("Contact Us", JLabel.CENTER);
        titleLabel.setBounds(20, 20, 546, 33);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        contentPane.add(titleLabel);

        // ---------- Center Panel ----------
        JPanel contactPanel = new JPanel();
        contactPanel.setBounds(20, 73, 546, 307);
        contactPanel.setLayout(new GridLayout(5, 1, 8, 8));

        JLabel lblInfo = new JLabel("We are here to assist you!" +
                "Reach out to us through any of the following:", JLabel.CENTER);
        lblInfo.setFont(new Font("Serif", Font.PLAIN, 16));

        JLabel lblPhone = new JLabel("📞 Phone: +91 98765 43210", JLabel.CENTER);
        lblPhone.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel lblEmail = new JLabel("✉ Email: support@couriersystem.com", JLabel.CENTER);
        lblEmail.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel lblAddress = new JLabel("<html><center>🏢 Address: Courier Management System Pvt Ltd,<br>" +
                "123 Business Street, Kochi, Kerala - 682001</center></html>", JLabel.CENTER);
        lblAddress.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel lblHours = new JLabel("🕒 Working Hours: Mon - Sat (9:00 AM - 7:00 PM)", JLabel.CENTER);
        lblHours.setFont(new Font("Arial", Font.PLAIN, 16));

        contactPanel.add(lblInfo);
        contactPanel.add(lblPhone);
        contactPanel.add(lblEmail);
        contactPanel.add(lblAddress);
        contactPanel.add(lblHours);

        contentPane.add(contactPanel);

        // ---------- Bottom Panel ----------
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        bottomPanel.setBounds(20, 400, 546, 45);
        JButton btnDashboard = new JButton("Back to Dashboard");
        btnDashboard.setFont(new Font("Arial", Font.BOLD, 14));

        btnDashboard.addActionListener(e -> {
            dashboard dash = new dashboard();
            dash.setVisible(true);
            dispose();
        });

        bottomPanel.add(btnDashboard);
        contentPane.add(bottomPanel);
    }
}
