import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ADDR2 {
	private JFrame frame;
	private JFrame frmAddress;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBox;
	String url = "jdbc:mysql://localhost:33061/army";
	String user = "root";
	String password = "root@123";

	public String s_id;
	public String state;
	public String address;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADDR2 window = new ADDR2();
					window.frmAddress.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ADDR2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public void fillComboBox() {
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			String query = "select * from adress_info";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				comboBox.addItem(rs.getString("s_id"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initialize() {
		frame = new JFrame();
		frmAddress = new JFrame();
		frmAddress.getContentPane().setBackground(Color.WHITE);
		frmAddress.setTitle("ADDRESS");
		frmAddress.setBounds(100, 100, 1345, 752);
		frmAddress.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddress.getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("ADDRESS ");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 48));
		lblNewLabel_1.setBounds(529, 35, 506, 40);
		frmAddress.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton_1_2 = new JButton("HOME");
		btnNewButton_1_2.setBackground(new Color(255, 255, 255));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HOME.main(new String[] {});
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/home5.png")).getImage();
		btnNewButton_1_2.setIcon(new ImageIcon(img2));

		btnNewButton_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1_2.setBounds(554, 138, 120, 35);
		frmAddress.getContentPane().add(btnNewButton_1_2);

		JButton btnNewButton_1_3 = new JButton("");
		btnNewButton_1_3.setBackground(new Color(255, 255, 255));
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ADDRESS.main(new String[] {});
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/341.png")).getImage();
		btnNewButton_1_3.setIcon(new ImageIcon(img));
		btnNewButton_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1_3.setBounds(38, 35, 65, 30);
		frmAddress.getContentPane().add(btnNewButton_1_3);

		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(1329, 10, 123, 40);
		frmAddress.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login.main(new String[] {});
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/login5.png")).getImage();

		btnNewButton.setIcon(new ImageIcon(img1));

		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					System.out.println("Connected to database");
					String query = "select * from adress_info where s_id=? ";
					PreparedStatement preparedStmt = connection.prepareStatement(query);
					preparedStmt.setString(1, (String) comboBox.getSelectedItem());
					ResultSet rs = preparedStmt.executeQuery();

					while (rs.next()) {
						textField_1.setText(rs.getString("state"));
						textField_2.setText(rs.getString("address"));
					}
					connection.close();
					preparedStmt.close();

				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		});
		comboBox.setBounds(649, 231, 370, 36);
		frmAddress.getContentPane().add(comboBox);

		JLabel lblNewLabel = new JLabel("SOLDIER ID");
		lblNewLabel.setBounds(294, 225, 261, 40);
		frmAddress.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JLabel lblNewLabel_3 = new JLabel("STATE");
		lblNewLabel_3.setBounds(294, 303, 261, 40);
		frmAddress.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));

		textField_1 = new JTextField();
		textField_1.setBounds(649, 306, 370, 35);
		frmAddress.getContentPane().add(textField_1);
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("ADDRESS");
		lblNewLabel_2.setBounds(294, 379, 261, 40);
		frmAddress.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));

		textField_2 = new JTextField();
		textField_2.setBounds(649, 382, 370, 35);
		frmAddress.getContentPane().add(textField_2);
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_2.setColumns(10);

		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(608, 491, 119, 36);
		frmAddress.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// textField.setText(null);
				comboBox.setSelectedItem(null);
				textField_1.setText(null);
				textField_2.setText(null);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JButton btnNewButton_1_1 = new JButton("UPDATE");
		btnNewButton_1_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.setBounds(881, 491, 138, 36);
		frmAddress.getContentPane().add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println("Connecting to DATABASE");
				// s_id= textField.getText();
				s_id = comboBox.getSelectedItem().toString();
				state = textField_1.getText();
				address = textField_2.getText();

				System.out.println(s_id);
				System.out.println(state);
				System.out.println(address);
				if (s_id == null || s_id.trim().length() == 0 || state == null || state.trim().length() == 0
						|| address == null || address.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Please Enter all the Fields");
				} else {
					try {
						Connection connection = DriverManager.getConnection(url, user, password);
						System.out.println("Connected to database");
						String query = "Update adress_info set s_id='" + comboBox.getSelectedItem().toString()
								+ "',state='" + textField_1.getText() + "',address='" + textField_2.getText()
								+ "'where s_id='" + comboBox.getSelectedItem().toString() + "'  ";
						PreparedStatement preparedStmt = connection.prepareStatement(query);
						preparedStmt.execute();

						System.out.println("Updated Successfully");
						// Search_CB.addItem(R_Name);
						JOptionPane.showMessageDialog(null, "Data Updated Successfully");
						connection.close();

					} catch (Exception e3) {
						JOptionPane.showMessageDialog(null, " Enter correct input");
					}

					// textField.setText(null);
					comboBox.setSelectedItem(null);
					textField_1.setText(null);
					textField_2.setText(null);

				}

			}
		});

		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Connecting to DATABASE");
				s_id = comboBox.getSelectedItem().toString();
				System.out.println(s_id);

				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					System.out.println("Connected to database");
					String query = "Delete from adress_info where s_id='" + comboBox.getSelectedItem().toString()
							+ "'  ";
					PreparedStatement preparedStmt = connection.prepareStatement(query);
					preparedStmt.execute();
					JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
					connection.close();
					preparedStmt.close();
				} catch (Exception e71) {
					JOptionPane.showMessageDialog(null, " Enter correct input");
				}
				textField_1.setText(null);
				textField_2.setText(null);
				comboBox.setSelectedItem(null);
			}
		});
		btnNewButton_2.setForeground(new Color(255, 0, 0));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.setBounds(349, 491, 138, 36);
		frmAddress.getContentPane().add(btnNewButton_2);
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(null);
		lblNewLabel_4.setBounds(0, -140, 1750, 1400);
		frmAddress.getContentPane().add(lblNewLabel_4);
		Image img3 = new ImageIcon(this.getClass().getResource("/ba1.png")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(img3));
		fillComboBox();
	}
}