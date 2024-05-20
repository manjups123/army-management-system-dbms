import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class PERS2 extends JFrame {

	String url = "jdbc:mysql://localhost:33061/army";;
	String user = "root";
	String password = "root@123";

	private JComboBox comboBox;
	private JComboBox comboBox1;
	private JComboBox comboBox2;
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_2;
	public String soldier_id;
	public String s_name;
	public String gender;
	public String dob;
	public String blood_group;
	public String date_of_join;
	public String regi_name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PERS2 frame = new PERS2();
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

	public void fillComboBox() {
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			String query = "select * from personal_info";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				comboBox.addItem(rs.getString("soldier_id"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fillComboBox1() {
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			String query = "select * from regiment_info";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				comboBox1.addItem(rs.getString("reg_name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PERS2() {
		frame = new JFrame();
		setTitle("personal_info");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1393, 770);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("PERSONAL");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 48));
		lblNewLabel.setBounds(503, 52, 557, 50);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PERSONAL.main(new String[] {});
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/341.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(38, 35, 65, 30);
		contentPane.add(btnNewButton);

		JButton btnHome = new JButton("HOME");
		btnHome.setBackground(new Color(255, 255, 255));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HOME.main(new String[] {});
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/home5.png")).getImage();
		btnHome.setIcon(new ImageIcon(img2));
		btnHome.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnHome.setBounds(979, 137, 120, 32);
		contentPane.add(btnHome);

		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_3.setBounds(1329, 10, 123, 40);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login.main(new String[] {});
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/login5.png")).getImage();

		btnNewButton_3.setIcon(new ImageIcon(img1));

		JLabel lblNewLabel_1 = new JLabel("SOLDIER  ID");
		lblNewLabel_1.setBounds(279, 159, 188, 31);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JLabel lblNewLabel_2 = new JLabel("NAME");
		lblNewLabel_2.setBounds(279, 218, 188, 24);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JLabel lblNewLabel_3 = new JLabel("GENDER");
		lblNewLabel_3.setBounds(279, 267, 188, 31);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JLabel lblNewLabel_4 = new JLabel("DATE OF BIRTH");
		lblNewLabel_4.setBounds(279, 329, 188, 31);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JLabel lblNewLabel_5 = new JLabel("BLOOD GROUP");
		lblNewLabel_5.setBounds(279, 387, 188, 31);
		contentPane.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JLabel lblNewLabel_6 = new JLabel("DATE OF JOIN");
		lblNewLabel_6.setBounds(279, 446, 188, 24);
		contentPane.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JLabel lblNewLabel_7 = new JLabel("REGI NAME");
		lblNewLabel_7.setBounds(279, 501, 188, 24);
		contentPane.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 20));

		textField_1 = new JTextField();
		textField_1.setBounds(567, 215, 303, 31);
		contentPane.add(textField_1);
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_2.setBounds(567, 269, 303, 31);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(567, 329, 303, 31);
		contentPane.add(textField_3);
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_3.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(567, 443, 303, 31);
		contentPane.add(textField_5);
		textField_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_5.setColumns(10);

		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(979, 255, 140, 35);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				soldier_id = comboBox.getSelectedItem().toString();

				// gender=comboBox.getItemAt(comboBox.getSelectedIndex());
				System.out.println(soldier_id);

				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					System.out.println("Connected to database");
					String query = "Delete from personal_info where soldier_id='"
							+ comboBox.getSelectedItem().toString() + "'  ";
					PreparedStatement preparedStmt = connection.prepareStatement(query);

					preparedStmt.execute();
					System.out.println("Deleted successfully");
					JOptionPane.showMessageDialog(null, "Data Deleted successfully");
					connection.close();
				} catch (Exception e7) {
					JOptionPane.showMessageDialog(null, " Enter correct input");
				}
				comboBox.setSelectedItem(null);
				textField_1.setText(null);
				textField_3.setText(null);
				comboBox2.setSelectedItem(null);
				textField_5.setText(null);
				comboBox1.setSelectedItem(null);
				textField_2.setText(null);

			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JButton btnNewButton_2 = new JButton("RESET");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(979, 311, 140, 35);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setSelectedItem(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				comboBox2.setSelectedItem(null);
				textField_5.setText(null);
				comboBox1.setSelectedItem(null);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JButton btnNewButton_1_1 = new JButton("UPDATE");
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1_1.setBounds(979, 367, 140, 35);
		contentPane.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				soldier_id = comboBox.getSelectedItem().toString();
				s_name = textField_1.getText();
				gender = textField_2.getText();
				dob = textField_3.getText();
				blood_group = comboBox2.getSelectedItem().toString();
				date_of_join = textField_5.getText();
				regi_name = comboBox1.getSelectedItem().toString();
				// gender=comboBox.getItemAt(comboBox.getSelectedIndex());
				System.out.println(soldier_id);
				System.out.println(s_name);
				System.out.println(gender);
				System.out.println(dob);
				System.out.println(blood_group);
				System.out.println(date_of_join);
				System.out.println(regi_name);

				if (soldier_id == null || soldier_id.trim().length() == 0 || s_name == null
						|| s_name.trim().length() == 0 || gender == null || gender.trim().length() == 0 || dob == null
						|| dob.trim().length() == 0 || blood_group == null || blood_group.trim().length() == 0
						|| date_of_join == null || date_of_join.trim().length() == 0 || regi_name == null
						|| regi_name.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Please Enter all the fields");
				} else {
					try {
						Connection connection = DriverManager.getConnection(url, user, password);
						System.out.println("Connected to database");

						String query = "Update personal_info set soldier_id='" + comboBox.getSelectedItem().toString()
								+ "',s_name='" + textField_1.getText() + "', gender='" + textField_2.getText()
								+ "', dob='" + textField_3.getText() + "',blood_group='"
								+ comboBox2.getSelectedItem().toString() + "',date_of_join='" + textField_5.getText()
								+ "',regi_name='" + comboBox1.getSelectedItem().toString() + "' where soldier_id='"
								+ comboBox.getSelectedItem().toString() + "'   ";
						PreparedStatement preparedStmt = connection.prepareStatement(query);

						preparedStmt.execute();
						System.out.println("Updated successfully");
						JOptionPane.showMessageDialog(null, "Data updated successfully");
						connection.close();

					} catch (Exception e7) {
						JOptionPane.showMessageDialog(null, " Enter correct input");
					}
					comboBox.setSelectedItem(null);
					textField_1.setText(null);
					textField_3.setText(null);
					comboBox2.setSelectedItem(null);
					textField_5.setText(null);
					comboBox1.setSelectedItem(null);
					textField_2.setText(null);

				}
			}

		});
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));

		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox.setMaximumRowCount(20);
		comboBox.setBounds(567, 166, 303, 31);
		contentPane.add(comboBox);

		comboBox1 = new JComboBox();
		comboBox1.setBackground(new Color(255, 255, 255));
		comboBox1.setMaximumRowCount(20);
		comboBox1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox1.setBounds(567, 505, 303, 31);
		contentPane.add(comboBox1);

		String[] col = { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" };
		comboBox2 = new JComboBox(col);
		comboBox2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox2.setBounds(567, 394, 303, 31);
		contentPane.add(comboBox2);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(0, -140, 1750, 1400);
		contentPane.add(lblNewLabel_8);
		Image img3 = new ImageIcon(this.getClass().getResource("/ba1.png")).getImage();
		lblNewLabel_8.setIcon(new ImageIcon(img3));

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					System.out.println("Connected to database");
					String query = "select * from personal_info where soldier_id=? ";
					PreparedStatement preparedStmt = connection.prepareStatement(query);
					preparedStmt.setString(1, (String) comboBox.getSelectedItem());
					ResultSet rs = preparedStmt.executeQuery();

					while (rs.next()) {
						textField_1.setText(rs.getString("s_name"));
						textField_2.setText(rs.getString("gender"));
						textField_3.setText(rs.getString("dob"));
						comboBox2.setSelectedItem(rs.getString("blood_group"));
						textField_5.setText(rs.getString("date_of_join"));
						comboBox1.setSelectedItem(rs.getString("regi_name"));
					}
					connection.close();
					preparedStmt.close();

				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		});

		fillComboBox();
		fillComboBox1();

	}
}
