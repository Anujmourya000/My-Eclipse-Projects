import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Registration {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void Registration() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 389, 398);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(43, 100, 92, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("login name");
		lblNewLabel_1.setBounds(43, 144, 92, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("password");
		lblNewLabel_2.setBounds(43, 190, 92, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("phone");
		lblNewLabel_3.setBounds(43, 240, 65, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("address");
		lblNewLabel_4.setBounds(43, 287, 65, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(145, 97, 191, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(145, 141, 191, 27);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(145, 237, 191, 27);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(145, 284, 191, 27);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection;
				PreparedStatement ps;
				try {
					connection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "1234");
					ps=connection.prepareStatement("INSERT INTO USER1 (username, password, loginname,email, address) VALUES(?,?,?,?,?)");
					ps.setString(1, textField.getText());
					ps.setString(3, textField_1.getText());
					ps.setString(4, textField_3.getText());
					ps.setString(5, textField_4.getText());
					ps.setString(2, passwordField.getText());
					ps.executeUpdate();
					
					/*if (result.next()) {
						JOptionPane.showMessageDialog(null, "Registraion successfull");
					}
					else {
						JOptionPane.showMessageDialog(null, "Error occured try again.....");
					}*/
					connection.close();
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex);
					
				}

			}
		});
		btnNewButton.setBounds(190, 325, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewUserRegistration = new JLabel("New User registration");
		lblNewUserRegistration.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewUserRegistration.setBounds(64, 24, 191, 35);
		frame.getContentPane().add(lblNewUserRegistration);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(145, 187, 191, 27);
		frame.getContentPane().add(passwordField);
	}

	
}
