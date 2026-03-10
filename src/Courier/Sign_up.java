package Courier;

import DB.DBC;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;

public class Sign_up extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Sign_up frame = new Sign_up();
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
    public Sign_up() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(240, 248, 255));
        setContentPane(contentPane);

        // Title
        JLabel lblTitle = new JLabel("FastTrack Courier System");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setBounds(90, 10, 300, 30);
        contentPane.add(lblTitle);

        // Subtitle
        JLabel lblSignUp = new JLabel("Sign Up");
        lblSignUp.setFont(new Font("Arial", Font.PLAIN, 16));
        lblSignUp.setBounds(185, 45, 100, 20);
        contentPane.add(lblSignUp);

        // Username Label and Field
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Arial", Font.PLAIN, 14));
        lblUsername.setBounds(100, 80, 80, 20);
        contentPane.add(lblUsername);

        textField = new JTextField();
        textField.setBounds(190, 80, 150, 25);
        contentPane.add(textField);
        textField.setColumns(10);

        // Password Label and Field
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        lblPassword.setBounds(100, 120, 80, 20);
        contentPane.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(190, 120, 150, 25);
        contentPane.add(passwordField);

        // Submit Button
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setFont(new Font("Arial", Font.PLAIN, 14));
        btnSubmit.setBounds(120, 170, 100, 30);
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Create_acc();
                
            }
        });
        contentPane.add(btnSubmit);

        // Sign In Button
        JButton btnSignIn = new JButton("Sign In");
        btnSignIn.setFont(new Font("Arial", Font.PLAIN, 14));
        btnSignIn.setBounds(230, 170, 100, 30);
        btnSignIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login_Page frame = new Login_Page();
                frame.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnSignIn);
    }

    // Method to create account
    void Create_acc() {
        String uname = textField.getText();
        String password = String.valueOf(passwordField.getPassword());

        try (Connection conn = DBC.get_Connection()) {
            String query = "INSERT INTO Login(username, pass_word) VALUES(?, ?);";
            java.sql.PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, password);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Account Created Successfully!");
                HOME frame = new HOME();
                frame.setVisible(true);
                dispose();
            }else {
                javax.swing.JOptionPane.showMessageDialog(this, "Invalid Username or Password!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage());
        }
    }
    
}
