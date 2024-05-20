import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.*;
import java.sql.*;
import java.awt.SystemColor;

public class FAMILY extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JComboBox comboBox;
	String url = "jdbc:mysql://localhost:33061/army";;
	String user = "root";
	String password = "root@123";

	public String sol_id;
	public String name;
	public String relationship;
	public String ph_no;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FAMILY frame = new FAMILY();
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

	public FAMILY() {
		frame = new JFrame();
		setTitle("FAMILY");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1365, 646);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("FAMILY INFORMATION");
		lblNewLabel.setForeground(new Color(153, 102, 0));
		lblNewLabel.setBounds(388, 48, 739, 42);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 48));
		contentPane.add(lblNewLabel);

		JButton btnNewButton_3 = new JButton("Delete And Update");
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBackground(new Color(204, 153, 0));
		btnNewButton_3.setFont(new Font("Serif", Font.BOLD, 18));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				FAM2.main(new String[] {});
			}
		});
		btnNewButton_3.setBounds(960, 230, 200, 40);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.setOpaque(true);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HOME.main(new String[] {});
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/341.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(img));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		btnNewButton_2.setBounds(38, 35, 65, 30);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_5 = new JButton("VIEW");
		btnNewButton_5.setForeground(new Color(0, 0, 0));
		btnNewButton_5.setBackground(new Color(204, 153, 0));
		btnNewButton_5.setFont(new Font("Serif", Font.BOLD, 14));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				VIEWF.main(new String[] {});
			}
		});
		btnNewButton_5.setBounds(990, 281, 92, 30);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login.main(new String[] {});
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/login5.png")).getImage();

		btnNewButton_4.setIcon(new ImageIcon(img1));
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_4.setBounds(1329, 10, 123, 40);
		contentPane.add(btnNewButton_4);

		JLabel lblNewLabel_1 = new JLabel("SOLDIER ID");
		lblNewLabel_1.setBounds(289, 138, 207, 42);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JLabel lblNewLabel_2 = new JLabel("NAME");
		lblNewLabel_2.setBounds(289, 213, 148, 30);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JLabel lblNewLabel_3 = new JLabel("RELATIONSHIP");
		lblNewLabel_3.setBounds(289, 277, 194, 30);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JLabel lblNewLabel_4 = new JLabel("PHN NO");
		lblNewLabel_4.setBounds(289, 349, 201, 30);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setForeground(new Color(153, 102, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(378, 424, 105, 35);
		contentPane.add(btnNewButton);
		// Image img11 = new
		// ImageIcon(this.getClass().getResource("/savee1.png")).getImage();
		// btnNewButton.setIcon(new ImageIcon(img11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Connecting to DATABASE");
				sol_id = comboBox.getSelectedItem().toString();
				name = textField_1.getText();
				relationship = textField_2.getText();
				ph_no = textField_3.getText();

				System.out.println(sol_id);
				System.out.println(name);
				System.out.println(relationship);
				System.out.println(ph_no);

				if (sol_id == null || sol_id.trim().length() == 0 || name == null || name.trim().length() == 0
						|| relationship == null || relationship.trim().length() == 0 || ph_no == null
						|| ph_no.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Please Enter all the Fields");
				} else {
					try {
						Connection connection = DriverManager.getConnection(url, user, password);
						System.out.println("Connected to database");
						String query = "insert into family_info values(?,?,?,?)";
						PreparedStatement preparedStmt = connection.prepareStatement(query);
						preparedStmt.setString(1, sol_id);
						preparedStmt.setString(2, name);
						preparedStmt.setString(3, relationship);
						preparedStmt.setString(4, ph_no);
						preparedStmt.execute();

						System.out.println("Inserted Successfully");
						// Search_CB.addItem(R_Name);
						JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
						connection.close();

					} catch (Exception e7) {

						JOptionPane.showMessageDialog(null, " Enter correct input");
					}

					// textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					comboBox.setSelectedItem(null);
				}

			}
		});

		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));

		JButton btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.setForeground(new Color(153, 102, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(599, 424, 105, 35);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				comboBox.setSelectedItem(null);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_1.setBounds(527, 218, 278, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_2.setBounds(527, 282, 278, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_3.setBounds(527, 354, 278, 30);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setMaximumRowCount(20);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(527, 153, 278, 30);
		contentPane.add(comboBox);

		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setBackground(new Color(255, 255, 255));
		lblNewLabel_11.setBounds(1239, 440, 245, 193);
		contentPane.add(lblNewLabel_11);
		Image img20 = new ImageIcon(this.getClass().getResource("/new.gif")).getImage();
		lblNewLabel_11.setIcon(new ImageIcon(img20));

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(0, -130, 1750, 1100);
		contentPane.add(lblNewLabel_5);
		// Image img11 = new
		// ImageIcon(this.getClass().getResource("/gif.mp4")).getImage();
		Image img3 = new ImageIcon(this.getClass().getResource("/background2.png")).getImage();
		lblNewLabel_5.setIcon(new ImageIcon(img3));
		fillComboBox();
	}
}