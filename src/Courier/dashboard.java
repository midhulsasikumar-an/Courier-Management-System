package Courier;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dashboard extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    dashboard frame = new dashboard();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public dashboard() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 520, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(240, 248, 255));
        setContentPane(contentPane);

        // Title
        JLabel lblTitle = new JLabel("Dashboard");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setBounds(190, 20, 200, 30);
        contentPane.add(lblTitle);

        // Book Courier Button
        JButton btnBook = new JButton("Book Courier");
        btnBook.setFont(new Font("Arial", Font.PLAIN, 14));
        btnBook.setBounds(60, 80, 150, 40);
        btnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Book_Courier frame = new Book_Courier();
                frame.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnBook);

        // Track Parcel Button
        JButton btnTrack = new JButton("Track Parcel");
        btnTrack.setFont(new Font("Arial", Font.PLAIN, 14));
        btnTrack.setBounds(280, 80, 150, 40);
        btnTrack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Track_Courier frame = new Track_Courier();
                frame.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnTrack);

        // About Us Button
        JButton btnAbout = new JButton("About Us");
        btnAbout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Aboutus frame = new Aboutus();
                frame.setVisible(true);
                dispose();
        	}
        });
        btnAbout.setFont(new Font("Arial", Font.PLAIN, 14));
        btnAbout.setBounds(60, 150, 150, 40);
        contentPane.add(btnAbout);

        // Contact Us Button
        JButton btnContact = new JButton("Contact Us");
        btnContact.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ContactUs frame = new ContactUs();
                frame.setVisible(true);
                dispose();
        	}
        });
        btnContact.setFont(new Font("Arial", Font.PLAIN, 14));
        btnContact.setBounds(280, 150, 150, 40);
        contentPane.add(btnContact);

        // FAQ Button
        JButton btnFaq = new JButton("FAQ / Help");
        btnFaq.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		FAQ_Help frame = new FAQ_Help();
        		frame.setVisible(true);
        		dispose();
        	}
        });
        btnFaq.setFont(new Font("Arial", Font.PLAIN, 14));
        btnFaq.setBounds(60, 220, 150, 40);
        contentPane.add(btnFaq);

        // Back to Home Button
        JButton btnHome = new JButton("Cancel Courier");
        btnHome.setFont(new Font("Arial", Font.PLAIN, 14));
        btnHome.setBounds(280, 220, 150, 40);
        btnHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Cancel_Courier frame = new Cancel_Courier();
        		frame.setVisible(true);
        		dispose();
                
            }
        });
        contentPane.add(btnHome);
        
        JButton btnNewButton = new JButton("Back to Home");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		HOME frame = new HOME();
                frame.setVisible(true);
                dispose();
        	}
        });
        btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
        btnNewButton.setBounds(179, 290, 141, 40);
        contentPane.add(btnNewButton);
    }
}
