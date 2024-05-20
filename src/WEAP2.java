import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class WEAP2 {
	private JFrame frame;
	private JFrame frmAddress;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBox;
	private JComboBox comboBox1;
	String url = "jdbc:mysql://localhost:33061/army";;
	String user = "root";
	String password = "root@123";
	public String sr_id;
	public String wp_id;
	public String w_id;
	public String wp_name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WEAP2 window = new WEAP2();
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

	public void fillComboBox() {
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			String query = "select distinct(sr_id) from weapon_info";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				comboBox.addItem(rs.getString("sr_id"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WEAP2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frmAddress = new JFrame();
		frmAddress.getContentPane().setBackground(new Color(255, 255, 255));
		frmAddress.setTitle("ADDRESS");
		frmAddress.setBounds(100, 100, 1345, 752);
		frmAddress.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddress.getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("WEAPON ");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 48));
		lblNewLabel_1.setBounds(552, 35, 506, 40);
		frmAddress.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton_1_3 = new JButton("");
		btnNewButton_1_3.setBackground(new Color(255, 255, 255));
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				WEAPON.main(new String[] {});
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/341.png")).getImage();
		btnNewButton_1_3.setIcon(new ImageIcon(img));
		btnNewButton_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1_3.setBounds(38, 35, 65, 30);
		frmAddress.getContentPane().add(btnNewButton_1_3);

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
		btnNewButton_1_2.setBounds(627, 136, 120, 32);
		frmAddress.getContentPane().add(btnNewButton_1_2);

		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
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

		JLabel lblNewLabel = new JLabel("SOLDIER ID");
		lblNewLabel.setBounds(331, 222, 261, 40);
		frmAddress.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JLabel lblNewLabel_3 = new JLabel("WEAPON ID");
		lblNewLabel_3.setBounds(331, 308, 261, 40);
		frmAddress.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));

		textField_1 = new JTextField();
		textField_1.setBounds(948, 313, 187, 35);
		frmAddress.getContentPane().add(textField_1);
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("WEAPON NAME");
		lblNewLabel_2.setBounds(331, 392, 261, 40);
		frmAddress.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));

		textField_2 = new JTextField();
		textField_2.setBounds(772, 389, 375, 35);
		frmAddress.getContentPane().add(textField_2);
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_2.setColumns(10);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBackground(new Color(255, 255, 255));
		btnUpdate.setForeground(new Color(255, 0, 0));
		btnUpdate.setBounds(937, 485, 140, 35);
		frmAddress.getContentPane().add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Connecting to DATABASE");
				sr_id = comboBox.getSelectedItem().toString();
				wp_id = comboBox1.getSelectedItem().toString();
				w_id = textField_1.getText();
				wp_name = textField_2.getText();

				System.out.println(sr_id);
				System.out.println(wp_id);
				System.out.println(wp_name);

				if (sr_id == null || sr_id.trim().length() == 0 || wp_id == null || wp_id.trim().length() == 0
						|| wp_name == null || wp_name.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Please Enter all the Fields");
				} else {
					try {
						Connection connection = DriverManager.getConnection(url, user, password);
						System.out.println("Connected to database");
						if (w_id.trim().length() == 0) {
							String query = "Update weapon_info set sr_id='" + comboBox.getSelectedItem().toString()
									+ "',wp_id='" + comboBox1.getSelectedItem().toString() + "',wp_name='"
									+ textField_2.getText() + "' where sr_id='" + comboBox.getSelectedItem().toString()
									+ "' and wp_id='" + comboBox1.getSelectedItem().toString() + "' ";
							PreparedStatement preparedStmt = connection.prepareStatement(query);

							preparedStmt.execute();

							System.out.println("Updated Successfully");
							// Search_CB.addItem(R_Name);
							JOptionPane.showMessageDialog(null, "Data Updated Successfully");
							connection.close();
						} else {
							String query = "Update weapon_info set sr_id='" + comboBox.getSelectedItem().toString()
									+ "',wp_id='" + textField_1.getText() + "',wp_name='" + textField_2.getText()
									+ "' where sr_id='" + comboBox.getSelectedItem().toString() + "' and wp_id='"
									+ comboBox1.getSelectedItem().toString() + "' ";
							PreparedStatement preparedStmt = connection.prepareStatement(query);

							preparedStmt.execute();

							System.out.println("Updated Successfully");
							// Search_CB.addItem(R_Name);
							JOptionPane.showMessageDialog(null, "Data Updated Successfully");
							connection.close();
						}
					} catch (Exception e7) {
						JOptionPane.showMessageDialog(null, " Enter correct input");
					}

					comboBox.setSelectedItem(null);
					textField_1.setText(null);
					textField_2.setText(null);
				}

			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JButton btnReset = new JButton("RESET");
		btnReset.setBackground(new Color(255, 255, 255));
		btnReset.setBounds(692, 485, 140, 35);
		frmAddress.getContentPane().add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setSelectedItem(null);
				comboBox1.setSelectedItem(null);
				textField_1.setText(null);
				textField_2.setText(null);
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Connecting to DATABASE");
				wp_id = comboBox1.getSelectedItem().toString();
				System.out.println(wp_id);

				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					System.out.println("Connected to database");
					String query = "Delete from weapon_info where wp_id='" + comboBox1.getSelectedItem().toString()
							+ "'  ";
					PreparedStatement preparedStmt = connection.prepareStatement(query);
					preparedStmt.execute();
					JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
					connection.close();
					preparedStmt.close();
				}

				catch (Exception e71) {
					JOptionPane.showMessageDialog(null, " Enter correct input");
				}
				textField_1.setText(null);
				textField_2.setText(null);
				comboBox.setSelectedItem(null);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(403, 485, 140, 35);
		frmAddress.getContentPane().add(btnNewButton_1);

		comboBox = new JComboBox();
		comboBox.setMaximumRowCount(20);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox.setBounds(772, 230, 375, 35);
		frmAddress.getContentPane().add(comboBox);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					System.out.println("Connected to database");
					String query = "select * from weapon_info where sr_id=? ";
					PreparedStatement preparedStmt = connection.prepareStatement(query);
					preparedStmt.setString(1, (String) comboBox.getSelectedItem());
					ResultSet rs = preparedStmt.executeQuery();

					int count = comboBox1.getItemCount();
					for (int i = 0; i < count; i++)
						comboBox1.removeItemAt(0);

					while (rs.next()) {
						comboBox1.addItem(rs.getString("wp_id"));
					}
					connection.close();
					preparedStmt.close();

				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, " Enter correct input");
				}
			}
		});

		comboBox1 = new JComboBox();
		comboBox1.setMaximumRowCount(20);
		comboBox1.setBackground(new Color(255, 255, 255));
		comboBox1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox1.setBounds(772, 315, 140, 35);
		frmAddress.getContentPane().add(comboBox1);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(0, -140, 1750, 1400);
		frmAddress.getContentPane().add(lblNewLabel_4);

		comboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					System.out.println("Connected to database");
					String query = "select * from weapon_info where wp_id=? ";
					PreparedStatement preparedStmt = connection.prepareStatement(query);
					preparedStmt.setString(1, (String) comboBox1.getSelectedItem());
					ResultSet rs = preparedStmt.executeQuery();

					while (rs.next()) {
						textField_2.setText(rs.getString("wp_name"));
					}
					connection.close();
					preparedStmt.close();

				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, " Enter correct input");
				}
			}
		});
		Image img3 = new ImageIcon(this.getClass().getResource("/ba1.png")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(img3));

		fillComboBox();
	}
}