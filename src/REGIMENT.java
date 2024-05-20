import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.Color;
import javax.swing.*;
import java.sql.*;

public class REGIMENT extends JFrame {

	String url = "jdbc:mysql://localhost:33061/army";
	String user = "root";
	String password = "root@123";

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JFrame frame;
	public String reg_name;
	public String center;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					REGIMENT frame = new REGIMENT();
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
	public REGIMENT() {
		frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1455, 764);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("REGIMENT INFORMATION");
		lblNewLabel.setForeground(new Color(153, 102, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 48));
		lblNewLabel.setBounds(429, 45, 623, 40);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("REG NAME");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(311, 161, 245, 40);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("CENTRE");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setBounds(314, 274, 168, 40);
		contentPane.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setBounds(553, 167, 294, 33);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_1.setBounds(553, 280, 294, 33);
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

		JButton btnNewButton_3 = new JButton("Delete and Update");
		btnNewButton_3.setBackground(new Color(204, 153, 0));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				REGI2.main(new String[] {});
			}
		});
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setFont(new Font("Serif", Font.BOLD, 18));
		btnNewButton_3.setBounds(948, 202, 200, 40);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_2 = new JButton("VIEW");
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(new Color(204, 153, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				VIEWR.main(new String[] {});
			}
		});
		btnNewButton_2.setFont(new Font("Serif", Font.BOLD, 14));
		btnNewButton_2.setBounds(1002, 251, 92, 30);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_5 = new JButton("Logout");
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login.main(new String[] {});
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/login5.png")).getImage();

		btnNewButton_5.setIcon(new ImageIcon(img1));
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_5.setBounds(1329, 10, 123, 40);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setForeground(new Color(153, 102, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(447, 397, 105, 35);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Connecting to DATABASE");
				reg_name = textField.getText();
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
						String query = "insert into regiment_info values(?,?)";
						PreparedStatement preparedStmt = connection.prepareStatement(query);
						preparedStmt.setString(1, reg_name);
						preparedStmt.setString(2, center);
						preparedStmt.execute();

						System.out.println("Inserted Successfully");
						// Search_CB.addItem(R_Name);
						JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
						connection.close();

					} catch (Exception e7) {
						JOptionPane.showMessageDialog(null, " Enter correct input");
					}

					textField.setText(null);
					textField_1.setText(null);

				}

			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));

		JButton btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.setForeground(new Color(153, 102, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(654, 397, 105, 35);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));

		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setBackground(new Color(255, 255, 255));
		lblNewLabel_11.setBounds(1239, 440, 245, 193);
		contentPane.add(lblNewLabel_11);
		Image img20 = new ImageIcon(this.getClass().getResource("/new.gif")).getImage();
		lblNewLabel_11.setIcon(new ImageIcon(img20));

		JLabel lblNewLabel_3 = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/background2.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img3));
		lblNewLabel_3.setBounds(0, -130, 1750, 1100);
		contentPane.add(lblNewLabel_3);

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
			}
		});

	}
}