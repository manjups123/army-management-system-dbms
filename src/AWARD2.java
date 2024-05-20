import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AWARD2 extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField_1;
	private JComboBox comboBox;
	private JComboBox comboBox1;
	String url = "jdbc:mysql://localhost:33061/army";;
	String user = "root";
	String password = "root@123";

	public String sd_id;
	public String award_name;
	public String a_name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AWARD2 frame = new AWARD2();
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
			String query = "select distinct(sd_id) from awards_info";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				comboBox.addItem(rs.getString("sd_id"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AWARD2() {
		frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1455, 764);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("AWARDS ");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 48));
		lblNewLabel.setBounds(650, 22, 568, 40);
		contentPane.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_1.setBounds(987, 369, 140, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton_1_3 = new JButton("");
		btnNewButton_1_3.setBackground(new Color(255, 255, 255));
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AWARDS.main(new String[] {});
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/341.png")).getImage();
		btnNewButton_1_3.setIcon(new ImageIcon(img));
		btnNewButton_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1_3.setBounds(38, 35, 65, 30);
		contentPane.add(btnNewButton_1_3);

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
		btnNewButton_1_2.setBounds(740, 145, 120, 32);
		contentPane.add(btnNewButton_1_2);

		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(1329, 10, 123, 40);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login.main(new String[] {});
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/login5.png")).getImage();

		btnNewButton.setIcon(new ImageIcon(img1));

		JLabel lblNewLabel_1 = new JLabel("SOLDIER ID");
		lblNewLabel_1.setBounds(477, 239, 261, 40);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JLabel lblNewLabel_2 = new JLabel("AWARD NAME");
		lblNewLabel_2.setBounds(477, 364, 217, 40);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JButton btnReset = new JButton("RESET");
		btnReset.setBackground(new Color(255, 255, 255));
		btnReset.setBounds(775, 490, 140, 35);
		contentPane.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setSelectedItem(null);
				textField_1.setText(null);
				comboBox1.setSelectedItem(null);
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBackground(new Color(255, 255, 255));
		btnUpdate.setForeground(new Color(255, 0, 0));
		btnUpdate.setBounds(987, 490, 140, 35);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Connecting to DATABASE");
				sd_id = comboBox.getSelectedItem().toString();
				award_name = comboBox.getSelectedItem().toString();
				a_name = textField_1.getText();

				System.out.println(sd_id);
				System.out.println(award_name);

				if (sd_id == null || sd_id.trim().length() == 0 || award_name == null
						|| award_name.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Please Enter all the Fields");
				} else {
					try {
						Connection connection = DriverManager.getConnection(url, user, password);
						System.out.println("Connected to database");

						String query = "Update awards_info set sd_id='" + comboBox.getSelectedItem().toString()
								+ "', award_name='" + textField_1.getText() + "' where sd_id='"
								+ comboBox.getSelectedItem().toString() + "' and award_name='"
								+ comboBox1.getSelectedItem().toString() + "'  ";
						PreparedStatement preparedStmt = connection.prepareStatement(query);

						preparedStmt.execute();

						System.out.println("Updated Successfully");
						// Search_CB.addItem(R_Name);
						JOptionPane.showMessageDialog(null, "Data Updated Successfully");
						connection.close();

					} catch (Exception e7) {
						JOptionPane.showMessageDialog(null, " Enter correct input");
					}

					comboBox.setSelectedItem(null);
					textField_1.setText(null);
					comboBox1.setSelectedItem(null);

				}

			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 20));

		comboBox = new JComboBox();
		comboBox.setMaximumRowCount(20);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(833, 244, 294, 35);
		contentPane.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					System.out.println("Connected to database");
					String query = "select * from awards_info where sd_id=? ";
					PreparedStatement preparedStmt = connection.prepareStatement(query);
					preparedStmt.setString(1, (String) comboBox.getSelectedItem());
					ResultSet rs = preparedStmt.executeQuery();

					int count = comboBox1.getItemCount();
					for (int i = 0; i < count; i++)
						comboBox1.removeItemAt(0);

					while (rs.next()) {
						comboBox1.addItem(rs.getString("award_name"));
					}
					connection.close();
					preparedStmt.close();

				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, " Enter correct input");
				}
			}
		});

		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Connecting to DATABASE");
				sd_id = comboBox.getSelectedItem().toString();
				award_name = comboBox1.getSelectedItem().toString();
				System.out.println(sd_id);

				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					System.out.println("Connected to database");
					String query = "Delete from awards_info where sd_id='" + comboBox.getSelectedItem().toString()
							+ "' and award_name='" + comboBox1.getSelectedItem().toString() + "' ";
					PreparedStatement preparedStmt = connection.prepareStatement(query);
					preparedStmt.execute();
					JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
					connection.close();
					preparedStmt.close();
				} catch (Exception e71) {
					JOptionPane.showMessageDialog(null, " Enter correct input");
				}
				textField_1.setText(null);
				comboBox.setSelectedItem(null);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(517, 490, 140, 35);
		contentPane.add(btnNewButton_1);

		comboBox1 = new JComboBox();
		comboBox1.setBackground(new Color(255, 255, 255));
		comboBox1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox1.setMaximumRowCount(20);
		comboBox1.setBounds(833, 369, 140, 35);
		contentPane.add(comboBox1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, -140, 1750, 1400);
		contentPane.add(lblNewLabel_3);
		Image img3 = new ImageIcon(this.getClass().getResource("/ba1.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img3));

		fillComboBox();
	}
}