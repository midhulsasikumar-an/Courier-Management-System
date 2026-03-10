package Courier;

import java.awt.*;
import javax.swing.*;

public class FAQ_Help extends JFrame {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FAQ_Help frame = new FAQ_Help();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public FAQ_Help() {
        setTitle("FAQ / Help - Courier Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 450); // Normal fixed size
        setLocationRelativeTo(null); // Center on screen

        // Main panel
        JPanel contentPane = new JPanel(new BorderLayout(15, 15));
        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setContentPane(contentPane);

        // ---------- Title ----------
        JLabel titleLabel = new JLabel("FAQ / Help", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        contentPane.add(titleLabel, BorderLayout.NORTH);

        // ---------- FAQ Content ----------
        JTextArea faqArea = new JTextArea();
        faqArea.setEditable(false);
        faqArea.setFont(new Font("Serif", Font.PLAIN, 15));
        faqArea.setText(
            "📌 Frequently Asked Questions\n" +
            "----------------------------------------\n\n" +
            "1. How do I book a courier?\n" +
            "   → Go to the Dashboard → Book Courier → Enter details and confirm.\n\n" +
            "2. How do I track my parcel?\n" +
            "   → Enter your tracking number in the 'Track Parcel' section.\n\n" +
            "3. What are the delivery modes available?\n" +
            "   → Normal (Standard delivery)\n" +
            "   → Express (Faster delivery, extra charges apply).\n\n" +
            "4. How is the cost calculated?\n" +
            "   → Cost depends on weight and mode of delivery.\n\n" +
            "5. What if I entered the wrong details while booking?\n" +
            "   → Please contact support immediately.\n\n" +
            "6. How do I contact support?\n" +
            "   → Use the 'Contact Us' option on the Dashboard.\n\n" +
            "----------------------------------------\n" +
            "For more help, reach us at support@couriersystem.com"
        );

        JScrollPane scrollPane = new JScrollPane(faqArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        contentPane.add(scrollPane, BorderLayout.CENTER);

        // ---------- Bottom Panel ----------
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnDashboard = new JButton("Back to Dashboard");
        btnDashboard.setFont(new Font("Arial", Font.BOLD, 14));

        btnDashboard.addActionListener(e -> {
            dashboard dash = new dashboard();
            dash.setVisible(true);
            dispose();
        });

        bottomPanel.add(btnDashboard);
        contentPane.add(bottomPanel, BorderLayout.SOUTH);
    }
}
