package Courier;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class HOME extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HOME frame = new HOME();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public HOME() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 584, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(240, 248, 255));

        // Title
        JLabel lblTitle = new JLabel("FastTrack Couriers");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setBounds(120, 10, 300, 30);
        contentPane.add(lblTitle);

        // Welcome Text
        JTextArea txtrWelcome = new JTextArea();
        txtrWelcome.setFont(new Font("Arial", Font.PLAIN, 14));
        txtrWelcome.setBackground(new Color(240, 248, 255));
        txtrWelcome.setText(
                "Welcome to FastTrack Couriers – Your trusted partner\n" +
                "for quick and reliable deliveries."
        );
        txtrWelcome.setEditable(false);
        txtrWelcome.setBounds(40, 70, 420, 60);
        contentPane.add(txtrWelcome);

        // Buttons
        JButton btnHome = new JButton("Home");
        btnHome.setFont(new Font("Arial", Font.PLAIN, 14));
        btnHome.setBounds(20, 150, 100, 30);
        contentPane.add(btnHome);

        JButton btnDashboard = new JButton("Dashboard");
        btnDashboard.setFont(new Font("Arial", Font.PLAIN, 14));
        btnDashboard.setBounds(140, 150, 110, 30);
        btnDashboard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dashboard frame = new dashboard();
                frame.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnDashboard);

        JButton btnBookCourier = new JButton("Book Courier");
        btnBookCourier.setFont(new Font("Arial", Font.PLAIN, 14));
        btnBookCourier.setBounds(270, 150, 120, 30);
        btnBookCourier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Book_Courier frame = new Book_Courier();
                frame.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnBookCourier);

        JButton btnTrackParcel = new JButton("Track Parcel");
        btnTrackParcel.setFont(new Font("Arial", Font.PLAIN, 14));
        btnTrackParcel.setBounds(410, 150, 120, 30);
        btnTrackParcel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Track_Courier frame = new Track_Courier();
                frame.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnTrackParcel);
    }
}
