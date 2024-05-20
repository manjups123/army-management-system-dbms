import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class TRAIN2 extends JFrame {
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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TRAIN2 frame = new TRAIN2();
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

	public TRAIN2() {
		frame = new JFrame();
		setTitle("TRAINING");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1337, 737);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("TRAINING ");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setBounds(547, 35, 433, 42);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 48));
		contentPane.add(lblNewLabel);

		JButton btnNewButton_1_3 = new JButton("");
		btnNewButton_1_3.setBackground(new Color(255, 255, 255));
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				TRAINING.main(new String[] {});
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
		btnNewButton_1_2.setBounds(617, 121, 120, 32);
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

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(0, -140, 1750, 13);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_1 = new JLabel("SOLDIER ID");
		lblNewLabel_1.setBounds(333, 220, 184, 23);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JLabel lblNewLabel_2 = new JLabel("TYPE");
		lblNewLabel_2.setBounds(333, 291, 184, 23);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));

		textField_1 = new JTextField();
		textField_1.setBounds(797, 287, 280, 35);
		contentPane.add(textField_1);
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("REGIMENT NAME");
		lblNewLabel_3.setBounds(333, 359, 238, 23);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));

		textField_3 = new JTextField();
		textField_3.setBounds(797, 431, 280, 30);
		contentPane.add(textField_3);
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_3.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("DURATION");
		lblNewLabel_4.setBounds(333, 432, 200, 23);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JButton btnReset = new JButton("RESET");
		btnReset.setBackground(new Color(255, 255, 255));
		btnReset.setBounds(652, 515, 140, 35);
		contentPane.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setSelectedItem(null);
				textField_1.setText(null);
				comboBox1.setSelectedItem(null);
				textField_3.setText(null);
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(new Color(255, 0, 0));
		btnUpdate.setBackground(new Color(255, 255, 255));
		btnUpdate.setBounds(887, 515, 140, 35);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
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
						String query = "Update traininf_info set so_id='" + comboBox.getSelectedItem().toString()
								+ "',type='" + textField_1.getText() + "',r_name='"
								+ comboBox1.getSelectedItem().toString() + "',duration='" + textField_3.getText()
								+ "' where so_id='" + comboBox.getSelectedItem().toString() + "' ";
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
					textField_3.setText(null);

				}

			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 20));

		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setMaximumRowCount(20);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox.setBounds(797, 220, 280, 35);
		contentPane.add(comboBox);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					System.out.println("Connected to database");
					String query = "select * from traininf_info where so_id=? ";
					PreparedStatement preparedStmt = connection.prepareStatement(query);
					preparedStmt.setString(1, (String) comboBox.getSelectedItem());
					ResultSet rs = preparedStmt.executeQuery();

					while (rs.next()) {
						textField_1.setText(rs.getString("type"));
						textField_3.setText(rs.getString("duration"));
						comboBox1.setSelectedItem(rs.getString("r_name"));
					}
					connection.close();
					preparedStmt.close();

				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		});

		comboBox1 = new JComboBox();
		comboBox1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox1.setMaximumRowCount(20);
		comboBox1.setBackground(new Color(255, 255, 255));
		comboBox1.setBounds(797, 355, 280, 35);
		contentPane.add(comboBox1);

		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				so_id = comboBox.getSelectedItem().toString();

				// gender=comboBox.getItemAt(comboBox.getSelectedIndex());
				System.out.println(so_id);

				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					System.out.println("Connected to database");
					String query = "Delete from traininf_info where so_id='" + comboBox.getSelectedItem().toString()
							+ "'  ";
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
				comboBox1.setSelectedItem(null);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(441, 515, 140, 35);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(null);
		lblNewLabel_6.setBounds(0, -140, 1750, 1400);
		contentPane.add(lblNewLabel_6);
		Image img3 = new ImageIcon(this.getClass().getResource("/ba1.png")).getImage();
		lblNewLabel_6.setIcon(new ImageIcon(img3));

		fillComboBox();
		fillComboBox1();
	}
}