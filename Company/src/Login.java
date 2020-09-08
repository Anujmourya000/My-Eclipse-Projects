import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(150, 75, 190, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(150, 122, 190, 28);
		frame.getContentPane().add(passwordField);
		
		JLabel login_lbl = new JLabel("Login Name");
		login_lbl.setBounds(30, 75, 77, 28);
		frame.getContentPane().add(login_lbl);
		
		JLabel passw_lbl = new JLabel("Password");
		passw_lbl.setBounds(30, 122, 77, 28);
		frame.getContentPane().add(passw_lbl);
		
		JLabel heading_lbl = new JLabel("USER LOGIN");
		heading_lbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		heading_lbl.setBounds(75, 25, 102, 28);
		frame.getContentPane().add(heading_lbl);
		
		JButton signup_btn = new JButton("Sign Up");
		signup_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registration objsignup=new Registration();
				objsignup.Registration();
		}
		});
		signup_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		signup_btn.setBounds(150, 182, 89, 28);
		frame.getContentPane().add(signup_btn);
		
		JButton login_btn = new JButton("Login");
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection connection;
				PreparedStatement ps;
				try {
					connection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "1234");
					ps=connection.prepareStatement("SELECT Username , password FROM USER1  WHERE USERNAME =?  AND PASSWORD=?");
					ps.setString(1, textField.getText());
					ps.setString(2, passwordField.getText());
					ResultSet result=ps.executeQuery();
					
					if (result.next()) {
						JOptionPane.showMessageDialog(null, "login successfull");
					}
					else {
						JOptionPane.showMessageDialog(null, "invalid details");
					}
					connection.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
					
				}
			}
		});
		login_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		login_btn.setBounds(251, 182, 89, 28);
		frame.getContentPane().add(login_btn);
	}
}
