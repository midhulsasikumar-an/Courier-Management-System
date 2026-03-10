package Courier;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Aboutus extends JFrame {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Aboutus frame = new Aboutus();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Aboutus() {
        setTitle("About Us - Courier Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Always open maximized
        setBounds(100, 100, 584, 643);

        // Main panel
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // ---------- Title ----------
        JLabel titleLabel = new JLabel("About Us", JLabel.CENTER);
        titleLabel.setBounds(30, 30, 510, 37);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        contentPane.add(titleLabel);

        // ---------- Center Panel (About text) ----------
        JTextArea aboutText = new JTextArea();
        aboutText.setFont(new Font("Serif", Font.PLAIN, 18));
        aboutText.setEditable(false);
        aboutText.setLineWrap(true);
        aboutText.setWrapStyleWord(true);

        aboutText.setText(
            "Welcome to the Courier Management System!\n\n" +
            "Our system is designed to simplify courier booking, tracking, and management. " +
            "Users can easily book parcels, generate tracking numbers, and monitor delivery status in real-time.\n\n" +
            "Key Features:\n" +
            "✔ Easy parcel booking with automatic tracking number generation.\n" +
            "✔ Real-time courier tracking with detailed status updates.\n" +
            "✔ User-friendly dashboard for managing all courier operations.\n" +
            "✔ Reliable and secure data handling.\n\n" +
            "We aim to provide a seamless courier experience with speed, accuracy, and convenience.\n\n" +
            "Thank you for choosing our service!"
        );

        JScrollPane scrollPane = new JScrollPane(aboutText,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(30, 87, 510, 414);
        contentPane.add(scrollPane);

        // ---------- Bottom Panel (Back Button) ----------
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        bottomPanel.setBounds(30, 521, 510, 71);
        JButton btnDashboard = new JButton("Back to Dashboard");
        btnDashboard.setFont(new Font("Arial", Font.BOLD, 18));

        btnDashboard.addActionListener(e -> {
            dashboard dash = new dashboard();
            dash.setVisible(true);
            dispose();
        });

        bottomPanel.add(btnDashboard);
        contentPane.add(bottomPanel);
    }
}
