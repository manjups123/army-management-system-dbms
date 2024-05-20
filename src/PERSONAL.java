import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class PERSONAL extends JFrame {

	String url = "jdbc:mysql://localhost:33061/army";;
	String user = "root";
	String password = "root@123";

	private JFrame frame;
	private JComboBox comboBox1;
	private JComboBox comboBox;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_5;
	private ButtonGroup bg = new ButtonGroup();

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
					PERSONAL frame = new PERSONAL();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void fillComboBox() {
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

	/**
	 * Create the frame.
	 */
	public PERSONAL() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(0, 0, 1780, 840);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		setTitle("personal_info");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1327, 770);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("PERSONAL INFORMATION");
		lblNewLabel.setForeground(new Color(153, 102, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 48));
		lblNewLabel.setBounds(324, 10, 641, 56);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HOME.main(new String[] {});
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/341.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(38, 35, 65, 30);
		contentPane.add(btnNewButton);

		JButton btnNewButton_3 = new JButton("Delete & Update");
		btnNewButton_3.setBackground(new Color(204, 153, 0));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PERS2.main(new String[] {});
			}
		});
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setFont(new Font("Serif", Font.BOLD, 18));
		btnNewButton_3.setBounds(878, 268, 200, 40);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_5 = new JButton("VIEW");
		btnNewButton_5.setForeground(new Color(0, 0, 0));
		btnNewButton_5.setBackground(new Color(204, 153, 0));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				VIEWP.main(new String[] {});
			}
		});
		btnNewButton_5.setFont(new Font("Serif", Font.BOLD, 14));
		btnNewButton_5.setBounds(929, 318, 92, 30);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
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

		JLabel lblNewLabel_1 = new JLabel("SOLDIER  ID");
		lblNewLabel_1.setBounds(278, 94, 188, 31);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));

		textField = new JTextField();
		textField.setBounds(476, 94, 303, 31);
		contentPane.add(textField);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("NAME");
		lblNewLabel_2.setBounds(278, 148, 188, 24);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));

		textField_1 = new JTextField();
		textField_1.setBounds(476, 145, 303, 31);
		contentPane.add(textField_1);
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("GENDER");
		lblNewLabel_3.setBounds(278, 208, 188, 31);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JLabel lblNewLabel_4 = new JLabel("DATE OF BIRTH");
		lblNewLabel_4.setBounds(278, 272, 188, 31);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));

		textField_3 = new JTextField();
		textField_3.setBounds(476, 272, 303, 31);
		contentPane.add(textField_3);
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_3.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("BLOOD GROUP");
		lblNewLabel_5.setBounds(278, 334, 188, 31);
		contentPane.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JLabel lblNewLabel_6 = new JLabel("DATE OF JOIN");
		lblNewLabel_6.setBounds(278, 404, 188, 24);
		contentPane.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 20));

		textField_5 = new JTextField();
		textField_5.setBounds(476, 401, 303, 31);
		contentPane.add(textField_5);
		textField_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_5.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("REGI NAME");
		lblNewLabel_7.setBounds(278, 462, 188, 24);
		contentPane.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 20));

		// JComboBox comboBox = new JComboBox<String>();
		// comboBox.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		// comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male","Female"}));
		// comboBox.setBounds(346, 180, 303, 31);
		// panel.add(comboBox);

		JButton btnNewButton_1 = new JButton("SAVE");
		btnNewButton_1.setForeground(new Color(153, 102, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(714, 520, 105, 35);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));

		JButton btnNewButton_2 = new JButton("CLEAR");
		btnNewButton_2.setForeground(new Color(153, 102, 0));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(878, 520, 105, 35);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		String[] column = { "", "F", "M" };

		comboBox1 = new JComboBox();
		comboBox1.setBackground(new Color(255, 255, 255));
		comboBox1.setMaximumRowCount(20);
		comboBox1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox1.setBounds(476, 466, 303, 31);
		contentPane.add(comboBox1);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("M");
		rdbtnNewRadioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				System.out.println("itemStateChanged()");
			}
		});
		rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		rdbtnNewRadioButton.setBounds(476, 215, 80, 20);
		contentPane.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("F");
		rdbtnNewRadioButton_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				System.out.println("itemStateChanged()");
			}
		});
		rdbtnNewRadioButton_1.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		rdbtnNewRadioButton_1.setBounds(581, 215, 80, 20);
		contentPane.add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Other");
		rdbtnNewRadioButton_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				System.out.println("itemStateChanged()");
			}
		});
		rdbtnNewRadioButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		rdbtnNewRadioButton_2.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_2.setBounds(676, 215, 80, 20);
		contentPane.add(rdbtnNewRadioButton_2);

		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton_2);

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_3.setText(null);
				comboBox.setSelectedItem(null);
				textField_5.setText(null);
				rdbtnNewRadioButton.setSelected(false);
				rdbtnNewRadioButton_1.setSelected(false);
				rdbtnNewRadioButton_2.setSelected(false);
				comboBox1.setSelectedItem(null);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Connecting to DATABASE");
				soldier_id = textField.getText();
				s_name = textField_1.getText();
				String d = null;
				if (rdbtnNewRadioButton.isSelected()) {
					d = "M";
				} else if (rdbtnNewRadioButton_1.isSelected()) {
					d = "F";
				} else if (rdbtnNewRadioButton_2.isSelected()) {
					d = "Other";
				}
				gender = d;
				dob = textField_3.getText();
				blood_group = comboBox1.getSelectedItem().toString();
				date_of_join = textField_5.getText();
				regi_name = comboBox1.getSelectedItem().toString();
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
						String query = "insert into personal_info values(?,?,?,?,?,?,?)";
						PreparedStatement preparedStmt = connection.prepareStatement(query);
						preparedStmt.setString(1, soldier_id);
						preparedStmt.setString(2, s_name);
						preparedStmt.setString(3, gender);
						preparedStmt.setString(4, dob);
						preparedStmt.setString(5, blood_group);
						preparedStmt.setString(6, date_of_join);
						preparedStmt.setString(7, regi_name);
						preparedStmt.execute();
						System.out.println("Inserted successfully");
						JOptionPane.showMessageDialog(null, "Data inserted successfully");
						connection.close();
					} catch (Exception e7) {
						JOptionPane.showMessageDialog(null, " Enter correct input");
					}
					textField.setText(null);
					textField_1.setText(null);
					textField_3.setText(null);
					// textField_4.setText(null);
					textField_5.setText(null);
					rdbtnNewRadioButton.setSelected(false);
					rdbtnNewRadioButton_1.setSelected(false);
					rdbtnNewRadioButton_2.setSelected(false);
					comboBox.setSelectedItem(null);
					comboBox1.setSelectedItem(null);
				}
			}

		});
		String[] col = { " ", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" };
		comboBox = new JComboBox(col);
		comboBox.setBackground(Color.WHITE);
		comboBox.setMaximumRowCount(10);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox.setBounds(476, 341, 303, 31);
		contentPane.add(comboBox);

		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setBackground(new Color(255, 255, 255));
		lblNewLabel_11.setBounds(1239, 440, 245, 193);
		contentPane.add(lblNewLabel_11);
		Image img20 = new ImageIcon(this.getClass().getResource("/new.gif")).getImage();
		lblNewLabel_11.setIcon(new ImageIcon(img20));

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(0, -130, 1750, 1100);
		contentPane.add(lblNewLabel_8);
		Image img2 = new ImageIcon(this.getClass().getResource("/background2.png")).getImage();
		lblNewLabel_8.setIcon(new ImageIcon(img2));

		fillComboBox();
	}
}