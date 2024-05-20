import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.sql.*;

public class REGI2 extends JFrame {

	String url = "jdbc:mysql://localhost:33061/army";
	String user = "root";
	String password = "root@123";
	private JComboBox comboBox;
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField_1;
	public String reg_name;
	public String center;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					REGI2 frame = new REGI2();
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
			String query = "select * from regiment_info";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				comboBox.addItem(rs.getString("reg_name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public REGI2() {
		frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1455, 764);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("REGIMENT ");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 48));
		lblNewLabel.setBounds(608, 35, 568, 40);
		contentPane.add(lblNewLabel);

		JButton btnNewButton_1_3 = new JButton("");
		btnNewButton_1_3.setBackground(new Color(255, 255, 255));
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				REGIMENT.main(new String[] {});
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
		btnNewButton_1_2.setBounds(730, 159, 120, 32);
		contentPane.add(btnNewButton_1_2);

		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login.main(new String[] {});
			}
		});

		Image img1 = new ImageIcon(this.getClass().getResource("/login5.png")).getImage();

		btnNewButton.setIcon(new ImageIcon(img1));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(1329, 10, 123, 40);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("REG NAME");
		lblNewLabel_1.setBounds(525, 248, 245, 40);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JLabel lblNewLabel_2 = new JLabel("CENTRE");
		lblNewLabel_2.setBounds(525, 333, 168, 40);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setForeground(new Color(255, 0, 0));
		btnNewButton_2.setBounds(456, 455, 140, 35);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Connecting to DATABASE");
				reg_name = comboBox.getSelectedItem().toString();
				System.out.println(reg_name);

				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					System.out.println("Connected to database");
					String query = "Delete from regiment_info where reg_name='" + comboBox.getSelectedItem().toString()
							+ "'  ";
					PreparedStatement preparedStmt = connection.prepareStatement(query);
					preparedStmt.execute();
					JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
					connection.close();
					preparedStmt.close();
				} catch (Exception e71) {
					e71.printStackTrace();

				}
				textField_1.setText(null);
				comboBox.setSelectedItem(null);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JButton btnReset = new JButton("RESET");
		btnReset.setBackground(new Color(255, 255, 255));
		btnReset.setBounds(756, 455, 140, 35);
		contentPane.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setSelectedItem(null);
				textField_1.setText(null);
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBackground(new Color(255, 255, 255));
		btnUpdate.setForeground(new Color(255, 0, 0));
		btnUpdate.setBounds(1080, 455, 140, 35);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Connecting to DATABASE");
				reg_name = comboBox.getSelectedItem().toString();
				;
				center = textField_1.getText();

				System.out.println(reg_name);
				System.out.println(center);

				if (reg_name == null || reg_name.trim().length() == 0 || center == null
						|| center.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Please Enter all the Fields");
				} else {
					try {
						Connection connection = DriverManager.getConnection(url, user, password);
						System.out.println("Connected to database");
						String query = "Update regiment_info set reg_name='" + comboBox.getSelectedItem().toString()
								+ "', center='" + textField_1.getText() + "' where reg_name='"
								+ comboBox.getSelectedItem().toString() + "'  ";
						PreparedStatement preparedStmt = connection.prepareStatement(query);
						preparedStmt.execute();
						JOptionPane.showMessageDialog(null, "Data Updated Successfully");
						connection.close();
						preparedStmt.close();
					} catch (Exception e7) {
						e7.printStackTrace();
					}

					comboBox.setSelectedItem(null);
					textField_1.setText(null);

				}

			}
		});

		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 20));

		textField_1 = new JTextField();
		textField_1.setBounds(826, 336, 294, 35);
		contentPane.add(textField_1);
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_1.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setMaximumRowCount(20);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox.setBounds(826, 262, 294, 35);
		contentPane.add(comboBox);
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(0, -140, 1750, 1400);
		contentPane.add(lblNewLabel_5);
		Image img3 = new ImageIcon(this.getClass().getResource("/ba1.png")).getImage();
		lblNewLabel_5.setIcon(new ImageIcon(img3));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					System.out.println("Connected to database");
					String query = "select * from regiment_info where reg_name=? ";
					PreparedStatement preparedStmt = connection.prepareStatement(query);
					preparedStmt.setString(1, (String) comboBox.getSelectedItem());
					ResultSet rs = preparedStmt.executeQuery();

					while (rs.next()) {
						textField_1.setText(rs.getString("center"));
					}
					connection.close();
					preparedStmt.close();

				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		});

		fillComboBox();
	}
}