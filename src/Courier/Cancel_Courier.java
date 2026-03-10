package Courier;
import DB.DBC;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;

public class Cancel_Courier extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cancel_Courier frame = new Cancel_Courier();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Cancel_Courier() {
		setTitle("Cancel Courier");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Header Panel
		JPanel headerPanel = new JPanel();
		headerPanel.setBounds(20, 10, 390, 60);
		headerPanel.setLayout(null);
		contentPane.add(headerPanel);

		Label lblTitle = new Label("Cancel Courier");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
		lblTitle.setBounds(90, 10, 220, 40);
		headerPanel.add(lblTitle);

		// Input Panel
		JPanel inputPanel = new JPanel();
		inputPanel.setBounds(20, 80, 390, 210);
		inputPanel.setLayout(null);
		contentPane.add(inputPanel);

		textField = new JTextField();
		textField.setBounds(20, 20, 250, 25);
		inputPanel.add(textField);
		textField.setColumns(10);

		JButton btnCancel = new JButton("Cancel Order");
		btnCancel.setBounds(280, 20, 110, 25);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		inputPanel.add(btnCancel);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(20, 60, 350, 120);
		textArea.setFont(new Font("Arial", Font.PLAIN, 14));
		inputPanel.add(textArea);

		// Back Button
		JButton btnBack = new JButton("Back to Dashboard");
		btnBack.setFont(new Font("Arial", Font.BOLD, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboard frame = new dashboard();
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(120, 300, 200, 25);
		contentPane.add(btnBack);
	}

	void cancel() {
		String id = textField.getText();
		try(Connection conn = DBC.get_Connection()){
			String query = "Delete from parcels where tracking_no = ?;";
			java.sql.PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			int rs = ps.executeUpdate();
			if(rs > 0) {
				textArea.setText("Courier with id :"+id+" is Cancelled");
			}
			else {
				textArea.setText("Courier not Cancelled");
			}
		}catch(Exception e) {
	        textArea.setText("Error: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
}
