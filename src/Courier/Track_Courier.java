package Courier;
import DB.DBC;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Track_Courier extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField trackingField;
    private JTextArea resultArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Track_Courier frame = new Track_Courier();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Track_Courier() {
        setTitle("Courier Tracking");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 480);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel titleLabel = new JLabel("Courier Tracking System", JLabel.CENTER);
        titleLabel.setBounds(15, 15, 456, 22);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        contentPane.add(titleLabel);

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        inputPanel.setBounds(15, 47, 456, 105);
        JLabel lblTracking = new JLabel("Enter Tracking No:");
        trackingField = new JTextField(15);
        JButton btnTrack = new JButton("Track");
        JButton btnClear = new JButton("Clear");

        inputPanel.add(lblTracking);
        inputPanel.add(trackingField);
        inputPanel.add(btnTrack);
        inputPanel.add(btnClear);
        contentPane.add(inputPanel);

        resultArea = new JTextArea(10, 35);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(resultArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(15, 162, 456, 220);
        contentPane.add(scrollPane);

        JButton btnDashboard = new JButton("Back to Dashboard");
        btnDashboard.setBounds(170, 395, 160, 30);
        contentPane.add(btnDashboard);

        btnTrack.addActionListener(e -> {
            String trkNo = trackingField.getText().trim();
            if (!trkNo.isEmpty()) {
                trackParcel(trkNo);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a Tracking Number.",
                        "Input Required", JOptionPane.WARNING_MESSAGE);
            }
        });

        btnClear.addActionListener(e -> {
            trackingField.setText("");
            resultArea.setText("");
        });

        btnDashboard.addActionListener(e -> {
            dashboard frame = new dashboard();
            frame.setVisible(true);
            dispose();
        });
    }

    // ---------- Track Parcel Logic ----------
    void trackParcel(String trackingNo) {
        try (Connection conn = DBC.get_Connection()) {
            String query = "SELECT * FROM parcels WHERE tracking_no = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, trackingNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                StringBuilder sb = new StringBuilder();
                sb.append("📦 Tracking Information\n");
                sb.append("-----------------------------\n");
                sb.append("Tracking No: ").append(rs.getString("tracking_no")).append("\n");
                sb.append("Sender: ").append(rs.getString("sender_name")).append("\n");
                sb.append("Receiver: ").append(rs.getString("receiver_name")).append("\n");
                sb.append("Weight: ").append(rs.getString("weight")).append(" kg\n");
                sb.append("Mode: ").append(rs.getString("mode")).append("\n");
                sb.append("Cost: ₹").append(rs.getString("cost")).append("\n");
                sb.append("Status: ").append(rs.getString("status")).append("\n");
                sb.append("Booking Date: ").append(rs.getString("booking_date")).append("\n");

                resultArea.setText(sb.toString());
            } else {
                resultArea.setText("❌ No parcel found with Tracking No: " + trackingNo);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resultArea.setText("⚠ Error while tracking parcel!");
        }
    }
}
