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

public class FAM2 extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
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
					FAM2 frame = new FAM2();
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
			String query = "select * from family_info";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				comboBox.addItem(rs.getString("sol_id"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public FAM2() {
		frame = new JFrame();
		setTitle("FAMILY");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1378, 790);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("FAMILY ");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setBounds(577, 52, 445, 42);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 48));
		contentPane.add(lblNewLabel);

		JButton btnNewButton_1_3 = new JButton("");
		btnNewButton_1_3.setBackground(new Color(255, 255, 255));
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				FAMILY.main(new String[] {});
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
		btnNewButton_1_2.setBounds(628, 142, 120, 32);
		contentPane.add(btnNewButton_1_2);

		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
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
		lblNewLabel_1.setBounds(373, 215, 207, 42);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JLabel lblNewLabel_2 = new JLabel("NAME");
		lblNewLabel_2.setBounds(375, 289, 148, 30);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));

		textField_1 = new JTextField();
		textField_1.setBounds(771, 289, 334, 35);
		contentPane.add(textField_1);
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("RELATIONSHIP");
		lblNewLabel_3.setBounds(373, 360, 194, 30);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));

		textField_2 = new JTextField();
		textField_2.setBounds(771, 360, 334, 35);
		contentPane.add(textField_2);
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_2.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("PHN NO");
		lblNewLabel_4.setBounds(373, 434, 201, 30);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));

		textField_3 = new JTextField();
		textField_3.setBounds(771, 434, 334, 35);
		contentPane.add(textField_3);
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_3.setColumns(10);

		JButton btnReset = new JButton("RESET");
		btnReset.setBackground(new Color(255, 255, 255));
		btnReset.setBounds(669, 515, 140, 35);
		contentPane.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setSelectedItem(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBackground(new Color(255, 255, 255));
		btnUpdate.setForeground(new Color(255, 0, 0));
		btnUpdate.setBounds(935, 515, 140, 35);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
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
						String query = "Update family_info set sol_id='" + comboBox.getSelectedItem().toString()
								+ "',name='" + textField_1.getText() + "',relationship='" + textField_2.getText()
								+ "',ph_no='" + textField_3.getText() + "' where sol_id='"
								+ comboBox.getSelectedItem().toString() + "' ";
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
					textField_2.setText(null);
					textField_3.setText(null);

				}

			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 20));

		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox.setMaximumRowCount(20);
		comboBox.setBounds(771, 230, 334, 35);
		contentPane.add(comboBox);

		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Connecting to DATABASE");
				ph_no = textField_3.getText();
				System.out.println(ph_no);

				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					System.out.println("Connected to database");
					String query = "Delete from family_info where ph_no='" + textField_3.getText() + "'  ";
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
				textField_3.setText(null);
				comboBox.setSelectedItem(null);
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(394, 515, 140, 35);
		contentPane.add(btnNewButton_1);
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
					String query = "select * from family_info where sol_id=? ";
					PreparedStatement preparedStmt = connection.prepareStatement(query);
					preparedStmt.setString(1, (String) comboBox.getSelectedItem());
					ResultSet rs = preparedStmt.executeQuery();

					while (rs.next()) {
						textField_1.setText(rs.getString("name"));
						textField_2.setText(rs.getString("relationship"));
						textField_3.setText(rs.getString("ph_no"));
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