import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.*;
import java.sql.*;

public class TRAINING extends JFrame {

	private JFrame frame;

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_3;
	private JComboBox comboBox;
	private JComboBox comboBox1;
	String url = "jdbc:mysql://localhost:33061/army";;
	String user = "root";
	String password = "root@123";
	public String so_id;
	public String type;
	public String r_name;
	public String duration;

	/**
	 * Launch the application.
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

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TRAINING frame = new TRAINING();
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
	public TRAINING() {
		frame = new JFrame();
		setTitle("TRAINING");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1337, 737);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("TRAINING INFORMATION");
		lblNewLabel.setForeground(new Color(153, 102, 0));
		lblNewLabel.setBounds(336, 60, 661, 42);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 48));
		contentPane.add(lblNewLabel);

		JButton btnNewButton_3 = new JButton(" Delete And Update");
		btnNewButton_3.setBackground(new Color(204, 153, 0));
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setFont(new Font("Serif", Font.BOLD, 18));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				TRAIN2.main(new String[] {});
			}
		});
		btnNewButton_3.setBounds(958, 240, 200, 40);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4_1 = new JButton("");
		btnNewButton_4_1.setBackground(new Color(255, 255, 255));
		btnNewButton_4_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HOME.main(new String[] {});
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/341.png")).getImage();
		btnNewButton_4_1.setIcon(new ImageIcon(img));
		btnNewButton_4_1.setBounds(38, 35, 65, 30);
		contentPane.add(btnNewButton_4_1);

		JButton btnNewButton_2 = new JButton("VIEW");
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(new Color(204, 153, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				VIEWT.main(new String[] {});
			}
		});
		btnNewButton_2.setFont(new Font("Serif", Font.BOLD, 14));
		btnNewButton_2.setBounds(1009, 290, 92, 30);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setBounds(1329, 10, 123, 40);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login.main(new String[] {});
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/login5.png")).getImage();

		btnNewButton_4.setIcon(new ImageIcon(img1));

		JLabel lblNewLabel_1 = new JLabel("SOLDIER ID");
		lblNewLabel_1.setBounds(289, 167, 184, 23);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JLabel lblNewLabel_2 = new JLabel("TYPE");
		lblNewLabel_2.setBounds(289, 234, 184, 23);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));

		textField_1 = new JTextField();
		textField_1.setBounds(598, 230, 238, 30);
		contentPane.add(textField_1);
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("REGIMENT NAME");
		lblNewLabel_3.setBounds(289, 304, 243, 23);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JLabel lblNewLabel_4 = new JLabel("DURATION");
		lblNewLabel_4.setBounds(289, 379, 200, 23);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));

		textField_3 = new JTextField();
		textField_3.setBounds(598, 375, 238, 30);
		contentPane.add(textField_3);
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_3.setColumns(10);

		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(153, 102, 0));
		btnNewButton.setBounds(364, 437, 105, 35);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Connecting to DATABASE");
				so_id = comboBox.getSelectedItem().toString();
				type = textField_1.getText();
				r_name = comboBox1.getSelectedItem().toString();
				duration = textField_3.getText();

				System.out.println(so_id);
				System.out.println(type);
				System.out.println(r_name);
				System.out.println(duration);

				if (so_id == null || so_id.trim().length() == 0 || type == null || type.trim().length() == 0
						|| r_name == null || r_name.trim().length() == 0 || duration == null
						|| duration.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Please Enter all the Fields");
				} else {
					try {
						Connection connection = DriverManager.getConnection(url, user, password);
						System.out.println("Connected to database");
						String query = "insert into traininf_info values(?,?,?,?)";
						PreparedStatement preparedStmt = connection.prepareStatement(query);
						preparedStmt.setString(1, so_id);
						preparedStmt.setString(2, type);
						preparedStmt.setString(3, r_name);
						preparedStmt.setString(4, duration);
						preparedStmt.execute();

						System.out.println("Inserted Successfully");
						// Search_CB.addItem(R_Name);
						JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
						connection.close();

					} catch (Exception e7) {
						JOptionPane.showMessageDialog(null, " Enter correct input");
					}

					comboBox.setSelectedItem(null);
					textField_1.setText(null);
					comboBox1.setSelectedItem(null);
					textField_3.setText(null);

				}

			}
		});

		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));

		JButton btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setForeground(new Color(153, 102, 0));
		btnNewButton_1.setBounds(635, 437, 105, 35);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));

		comboBox = new JComboBox();
		comboBox.setMaximumRowCount(20);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox.setBounds(598, 172, 238, 30);
		contentPane.add(comboBox);

		comboBox1 = new JComboBox();
		comboBox1.setMaximumRowCount(20);
		comboBox1.setBackground(new Color(255, 255, 255));
		comboBox1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox1.setBounds(598, 302, 238, 30);
		contentPane.add(comboBox1);

		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setBackground(new Color(255, 255, 255));
		lblNewLabel_11.setBounds(1239, 440, 245, 193);
		contentPane.add(lblNewLabel_11);
		Image img20 = new ImageIcon(this.getClass().getResource("/new.gif")).getImage();
		lblNewLabel_11.setIcon(new ImageIcon(img20));

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(0, -130, 1750, 1100);
		contentPane.add(lblNewLabel_5);
		Image img3 = new ImageIcon(this.getClass().getResource("/background2.png")).getImage();
		lblNewLabel_5.setIcon(new ImageIcon(img3));
		fillComboBox();
		fillComboBox1();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText(null);
				comboBox1.setSelectedItem(null);
				textField_3.setText(null);
				comboBox.setSelectedItem(null);

				// textField_8.setText(null);
				// comboBox.setSelectedItem(null);
			}
		});

	}
}