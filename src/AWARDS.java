import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;

public class AWARDS extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField_1;
	private JComboBox comboBox;
	String url = "jdbc:mysql://localhost:33061/army";;
	String user = "root";
	String password = "root@123";

	public String sd_id;
	public String award_name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AWARDS frame = new AWARDS();
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

	public AWARDS() {
		frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1455, 764);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("AWARDS INFORMATION");
		lblNewLabel.setForeground(new Color(153, 102, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 48));
		lblNewLabel.setBounds(413, 62, 568, 40);
		contentPane.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_1.setBounds(559, 306, 294, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HOME.main(new String[] {});
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/341.png")).getImage();
		btnNewButton_4.setIcon(new ImageIcon(img));
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_4.setBounds(38, 35, 65, 30);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_3 = new JButton(" Delete And Update");
		btnNewButton_3.setBackground(new Color(204, 153, 0));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AWARD2.main(new String[] {});
			}
		});
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setFont(new Font("Serif", Font.BOLD, 18));
		btnNewButton_3.setBounds(965, 221, 200, 40);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_2 = new JButton("VIEW");
		btnNewButton_2.setBackground(new Color(204, 153, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				VIEWAW.main(new String[] {});
			}
		});
		btnNewButton_2.setFont(new Font("Serif", Font.BOLD, 14));
		btnNewButton_2.setBounds(995, 268, 92, 30);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_5 = new JButton("Logout");
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.setBounds(1329, 10, 123, 40);
		contentPane.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login.main(new String[] {});
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/login5.png")).getImage();

		btnNewButton_5.setIcon(new ImageIcon(img1));

		JLabel lblNewLabel_1 = new JLabel("SOLDIER ID");
		lblNewLabel_1.setBounds(319, 194, 211, 40);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JLabel lblNewLabel_2 = new JLabel("AWARD NAME");
		lblNewLabel_2.setBounds(319, 303, 217, 40);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setForeground(new Color(153, 102, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(395, 432, 105, 35);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Connecting to DATABASE");
				sd_id = comboBox.getSelectedItem().toString();
				award_name = textField_1.getText();

				System.out.println(sd_id);
				System.out.println(award_name);

				if (sd_id == null || sd_id.trim().length() == 0 || award_name == null
						|| award_name.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Please Enter all the Fields");
				} else {
					try {
						Connection connection = DriverManager.getConnection(url, user, password);
						System.out.println("Connected to database");
						String query = "insert into awards_info values(?,?)";
						PreparedStatement preparedStmt = connection.prepareStatement(query);
						preparedStmt.setString(1, sd_id);
						preparedStmt.setString(2, award_name);
						preparedStmt.execute();

						System.out.println("Inserted Successfully");
						// Search_CB.addItem(R_Name);
						JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
						connection.close();

					} catch (Exception e7) {
						JOptionPane.showMessageDialog(null, " Enter correct input");
					}

					// textField.setText(null);
					comboBox.setSelectedItem(null);
					textField_1.setText(null);

				}

			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));

		JButton btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.setForeground(new Color(153, 102, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(642, 432, 105, 35);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// textField.setText(null);
				comboBox.setSelectedItem(null);
				textField_1.setText(null);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));

		comboBox = new JComboBox();
		comboBox.setMaximumRowCount(20);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox.setBounds(559, 201, 294, 35);
		contentPane.add(comboBox);
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setBackground(new Color(255, 255, 255));
		lblNewLabel_11.setBounds(1239, 440, 245, 193);
		contentPane.add(lblNewLabel_11);
		Image img20 = new ImageIcon(this.getClass().getResource("/new.gif")).getImage();
		lblNewLabel_11.setIcon(new ImageIcon(img20));

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(0, -130, 1750, 1100);
		contentPane.add(lblNewLabel_4);
		Image img3 = new ImageIcon(this.getClass().getResource("/background2.png")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(img3));
		fillComboBox();
	}
}