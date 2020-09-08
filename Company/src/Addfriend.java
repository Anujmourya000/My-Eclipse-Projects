import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

public class Addfriend {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addfriend window = new Addfriend();
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
	public Addfriend() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 455, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddressBookSystem = new JLabel("Address Book system");
		lblAddressBookSystem.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddressBookSystem.setBounds(38, 11, 254, 37);
		frame.getContentPane().add(lblAddressBookSystem);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(10, 59, 68, 23);
		frame.getContentPane().add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(88, 59, 68, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(166, 59, 68, 23);
		frame.getContentPane().add(btnDelete);
		
		textField = new JTextField();
		textField.setBounds(343, 60, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
