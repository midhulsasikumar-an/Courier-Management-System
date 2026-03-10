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
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;

public class Login_Page extends JFrame {

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
                    Login_Page frame = new Login_Page();
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
    public Login_Page() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(255, 255, 255));

        // Title
        JLabel lblTitle = new JLabel("Courier System");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(75, 20, 300, 30);
        contentPane.add(lblTitle);

        // Username Label
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Arial", Font.PLAIN, 14));
        lblUsername.setBounds(75, 80, 100, 25);
        contentPane.add(lblUsername);

        // Username Field
        textField = new JTextField();
        textField.setBounds(180, 80, 180, 25);
        contentPane.add(textField);
        textField.setColumns(10);

        // Password Label
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        lblPassword.setBounds(75, 120, 100, 25);
        contentPane.add(lblPassword);

        // Password Field
        passwordField = new JPasswordField();
        passwordField.setBounds(180, 120, 180, 25);
        contentPane.add(passwordField);

        // Sign In Button
        JButton btnSignIn = new JButton("Sign In");
        btnSignIn.setFont(new Font("Arial", Font.PLAIN, 14));
        btnSignIn.setBounds(150, 170, 120, 30);
        btnSignIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Sign_in();
            }
        });
        contentPane.add(btnSignIn);

        // Create Account Button
        JButton btnCreateAccount = new JButton("Create Account");
        btnCreateAccount.setFont(new Font("Arial", Font.PLAIN, 14));
        btnCreateAccount.setBounds(130, 210, 180, 30);
        btnCreateAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Sign_up();
            }
        });
        contentPane.add(btnCreateAccount);
        
        JButton btnNewButton = new JButton("New button");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		contentPane.setBackground(new Color(128, 255, 0));
        	}
        });
        btnNewButton.setBounds(291, 176, 84, 20);
        contentPane.add(btnNewButton);
    }

    /**
     * Sign in method.
     */
    void Sign_in() {
        String uname = textField.getText();
        String password = String.valueOf(passwordField.getPassword());

        try (Connection conn = DBC.get_Connection()) {
            String query = "SELECT * FROM Login WHERE username = ? AND pass_word = ?;";
            java.sql.PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, password);

            java.sql.ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Login Successful!");
                HOME frame = new HOME(); 
                frame.setVisible(true);
                dispose();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Invalid Username or Password!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage());
        }
    }

    /**
     * Open Sign Up page.
     */
    void Sign_up() {
        Sign_up frame = new Sign_up(); 
        frame.setVisible(true);
        dispose();
    }
}
