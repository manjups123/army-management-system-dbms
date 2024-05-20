import java.awt.EventQueue;
import javax.swing.*;
import java.sql.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WEAPON {

	private JFrame frame;
	private JFrame frmAddress;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBox;
	String url = "jdbc:mysql://localhost:33061/army";;
	String user = "root";
	String password = "root@123";
	public String sr_id;
	public String wp_id;
	public String wp_name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WEAPON window = new WEAPON();
					window.frmAddress.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
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

	public WEAPON() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frmAddress = new JFrame();
		frmAddress.getContentPane().setBackground(new Color(230, 230, 250));
		frmAddress.setTitle("ADDRESS");
		frmAddress.setBounds(100, 100, 1345, 752);
		frmAddress.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddress.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("SOLDIER ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(249, 206, 261, 40);
		frmAddress.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("WEAPON INFORMATION");
		lblNewLabel_1.setForeground(new Color(153, 102, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 48));
		lblNewLabel_1.setBounds(422, 47, 582, 40);
		frmAddress.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("WEAPON NAME");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setBounds(249, 357, 261, 40);
		frmAddress.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("WEAPON ID");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3.setBounds(249, 279, 261, 40);
		frmAddress.getContentPane().add(lblNewLabel_3);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_1.setBounds(542, 284, 370, 35);
		frmAddress.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_2.setBounds(542, 354, 370, 35);
		frmAddress.getContentPane().add(textField_2);
		textField_2.setColumns(10);

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
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_2.setBounds(38, 35, 65, 30);
		frmAddress.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton(" Delete And Update");
		btnNewButton_3.setBackground(new Color(204, 153, 0));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				WEAP2.main(new String[] {});
			}
		});
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setFont(new Font("Serif", Font.BOLD, 18));
		btnNewButton_3.setBounds(1022, 262, 200, 40);
		frmAddress.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_5 = new JButton("VIEW");
		btnNewButton_5.setForeground(new Color(0, 0, 0));
		btnNewButton_5.setBackground(new Color(204, 153, 0));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				VIEWW.main(new String[] {});
			}
		});
		btnNewButton_5.setFont(new Font("Serif", Font.BOLD, 14));
		btnNewButton_5.setBounds(1071, 312, 92, 30);
		frmAddress.getContentPane().add(btnNewButton_5);

		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_4.setBounds(1329, 10, 123, 40);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login.main(new String[] {});
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/login5.png")).getImage();

		btnNewButton_4.setIcon(new ImageIcon(img1));
		frmAddress.getContentPane().add(btnNewButton_4);

		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(153, 102, 0));
		btnNewButton.setBounds(422, 445, 105, 35);
		frmAddress.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Connecting to DATABASE");
				sr_id = comboBox.getSelectedItem().toString();
				wp_id = textField_1.getText();
				wp_name = textField_2.getText();

				System.out.println(sr_id);
				System.out.println(wp_id);
				System.out.println(wp_name);

				if (sr_id == null || sr_id.trim().length() == 0 || wp_id == null || wp_id.trim().length() == 0
						|| wp_name == null || wp_name.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Please Enter all the Fields");
				} else {
					try {
						Connection connection = DriverManager.getConnection(url, user, password);
						System.out.println("Connected to database");
						String query = "insert into weapon_info values(?,?,?)";
						PreparedStatement preparedStmt = connection.prepareStatement(query);
						preparedStmt.setString(1, sr_id);
						preparedStmt.setString(2, wp_id);
						preparedStmt.setString(3, wp_name);
						preparedStmt.execute();

						System.out.println("Inserted Successfully");
						// Search_CB.addItem(R_Name);
						JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
						connection.close();

					} catch (Exception e7) {
						JOptionPane.showMessageDialog(null, " Enter correct input");
					}
					textField_1.setText(null);
					textField_2.setText(null);
					comboBox.setSelectedItem(null);
				}

			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));

		JButton btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setForeground(new Color(153, 102, 0));
		btnNewButton_1.setBounds(652, 446, 105, 35);
		frmAddress.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// textField.setText(null);
				comboBox.setSelectedItem(null);
				textField_1.setText(null);
				textField_2.setText(null);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));

		comboBox = new JComboBox();
		comboBox.setMaximumRowCount(20);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox.setBounds(542, 220, 370, 35);
		frmAddress.getContentPane().add(comboBox);

		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setBackground(new Color(255, 255, 255));
		lblNewLabel_11.setBounds(1239, 440, 245, 193);
		frmAddress.getContentPane().add(lblNewLabel_11);
		Image img20 = new ImageIcon(this.getClass().getResource("/new.gif")).getImage();
		lblNewLabel_11.setIcon(new ImageIcon(img20));

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(0, -130, 1750, 1100);
		frmAddress.getContentPane().add(lblNewLabel_4);
		Image img3 = new ImageIcon(this.getClass().getResource("/background2.png")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(img3));
		fillComboBox();
	}
}