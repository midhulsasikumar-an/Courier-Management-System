package Courier;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import DB.DBC;
import java.awt.Color;
import java.sql.Connection;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Book_Courier extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_2;
    private JTextField textField_5;
    private JTextArea textArea;
    private JTextArea textArea_1;
    private JComboBox comboBox;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Book_Courier frame = new Book_Courier();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Book_Courier() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 536, 404);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("COURIER BOOKING");
        lblNewLabel.setBounds(189, 26, 123, 26);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Sender Details :");
        lblNewLabel_1.setBounds(31, 64, 123, 12);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Name");
        lblNewLabel_2.setBounds(31, 90, 88, 12);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Mobile Number");
        lblNewLabel_3.setBounds(31, 112, 88, 12);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Address");
        lblNewLabel_4.setBounds(31, 134, 88, 12);
        contentPane.add(lblNewLabel_4);

        textField = new JTextField();
        textField.setBounds(148, 87, 96, 18);
        contentPane.add(textField);

        textField_1 = new JTextField();
        textField_1.setBounds(148, 109, 96, 18);
        contentPane.add(textField_1);

        JLabel lblNewLabel_5 = new JLabel("Reciever Details :");
        lblNewLabel_5.setBounds(304, 62, 123, 12);
        contentPane.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Name");
        lblNewLabel_6.setBounds(283, 90, 88, 12);
        contentPane.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("Mobile Number");
        lblNewLabel_7.setBounds(283, 112, 88, 12);
        contentPane.add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("Address");
        lblNewLabel_8.setBounds(283, 134, 88, 12);
        contentPane.add(lblNewLabel_8);

        textField_3 = new JTextField();
        textField_3.setBounds(381, 87, 96, 18);
        contentPane.add(textField_3);

        textField_4 = new JTextField();
        textField_4.setBounds(381, 109, 96, 18);
        contentPane.add(textField_4);

        textArea = new JTextArea();
        textArea.setBounds(148, 134, 95, 50);
        contentPane.add(textArea);

        textArea_1 = new JTextArea();
        textArea_1.setBounds(381, 134, 96, 50);
        contentPane.add(textArea_1);

        JLabel lblNewLabel_9 = new JLabel("Parcel Details :");
        lblNewLabel_9.setBounds(31, 194, 123, 12);
        contentPane.add(lblNewLabel_9);

        JLabel lblNewLabel_10 = new JLabel("Weight");
        lblNewLabel_10.setBounds(31, 216, 88, 12);
        contentPane.add(lblNewLabel_10);

        JLabel lblNewLabel_11 = new JLabel("Mode");
        lblNewLabel_11.setBounds(31, 238, 88, 12);
        contentPane.add(lblNewLabel_11);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"None", "Normal", "Express"}));
        comboBox.setBounds(148, 234, 96, 20);
        contentPane.add(comboBox);

        JLabel lblNewLabel_12 = new JLabel("Cost");
        lblNewLabel_12.setBounds(31, 260, 88, 12);
        contentPane.add(lblNewLabel_12);

        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(262, 62, 10, 115);
        contentPane.add(separator);

        textField_2 = new JTextField();
        textField_2.setBounds(148, 213, 96, 18);
        contentPane.add(textField_2);

        textField_5 = new JTextField();
        textField_5.setEditable(false);
        textField_5.setBounds(148, 257, 96, 18);
        contentPane.add(textField_5);

        JButton btnNewButton = new JButton("Book Now");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Book_now();
            }
        });
        btnNewButton.setBounds(31, 317, 106, 26);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Clear");
        btnNewButton_1.addActionListener(e -> {
            Book_Courier frame = new Book_Courier();
            frame.setVisible(true);
            dispose();
        });
        btnNewButton_1.setBounds(220, 317, 106, 26);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Dashboard");
        btnNewButton_2.addActionListener(e -> {
            dashboard frame = new dashboard();
            frame.setVisible(true);
            dispose();
        });
        btnNewButton_2.setBounds(393, 317, 96, 26);
        contentPane.add(btnNewButton_2);
    }

    void Book_now() {
        String s_name = textField.getText();
        String s_phn = textField_1.getText();
        String s_address = textArea.getText();
        String r_name = textField_3.getText();
        String r_phn = textField_4.getText();
        String r_address = textArea_1.getText();
        String p_weight = textField_2.getText();
        String mode = comboBox.getSelectedItem().toString();

        try (Connection conn = DBC.get_Connection()) {
            String query = "INSERT INTO parcels (tracking_no, sender_name, sender_phone, sender_address, "
                    + "receiver_name, receiver_phone, receiver_address, weight, mode, cost) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            java.sql.PreparedStatement ps = conn.prepareStatement(query, java.sql.Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, "TEMP");
            ps.setString(2, s_name);
            ps.setString(3, s_phn);
            ps.setString(4, s_address);
            ps.setString(5, r_name);
            ps.setString(6, r_phn);
            ps.setString(7, r_address);
            ps.setDouble(8, Double.parseDouble(p_weight));
            ps.setString(9, mode);
            ps.setDouble(10, Cost_cal());

            ps.executeUpdate();
            java.sql.ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                String trackingNo = "TRK" + String.format("%05d", id);

                String update = "UPDATE parcels SET tracking_no=? WHERE parcel_id=?";
                java.sql.PreparedStatement ps2 = conn.prepareStatement(update);
                ps2.setString(1, trackingNo);
                ps2.setInt(2, id);
                ps2.executeUpdate();

                JOptionPane.showMessageDialog(null, "Courier booked successfully!\nTracking Number: " + trackingNo);

                Book_confirm confirmPage = new Book_confirm(s_name, r_name, trackingNo, textField_5.getText());
                confirmPage.setVisible(true);
                this.dispose();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    double Cost_cal() {
        try {
            double Wgt = Double.parseDouble(textField_2.getText());
            String mode = comboBox.getSelectedItem().toString();
            double cost = 0;

            if (mode.equals("Normal")) {
                cost = Wgt * 50;
            } else if (mode.equals("Express")) {
                cost = Wgt * 75;
            } else {
                cost = 0;
            }

            textField_5.setText(String.valueOf(cost));
            return cost;
        } catch (NumberFormatException e) {
            textField_5.setText("0");
            return 0;
        }
    }
}
