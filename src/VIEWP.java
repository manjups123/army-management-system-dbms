import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.*;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.Font;

public class VIEWP {

	String url = "jdbc:mysql://localhost:33061/army";;
	String user = "root";
	String password = "root@123";

	private JFrame frame;

	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VIEWP window = new VIEWP();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VIEWP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.control);
		frame.getContentPane().setLayout(null);

		table = new JTable();
		Object[][] data = new Object[100][10];
		// headers for the table
		String[] columns = new String[] { "Soldier_id", "Soldier Name", "Gender", "DOB", "Blood Group", "Date of Join",
				"Regiment Name" };
		JButton btnView = new JButton("REFRESH");
		btnView.setBackground(new Color(255, 255, 255));
		btnView.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Image img2 = new ImageIcon(this.getClass().getResource("/refresh1.png")).getImage();
		btnView.setIcon(new ImageIcon(img2));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Connection connection = DriverManager.getConnection(url, user, password);
					System.out.println("Connected to database");

					String query = "select count(*)" + "from personal_info";
					Statement stmt = connection.createStatement();
					ResultSet rsone1 = stmt.executeQuery(query);

					int rowCount = 0;
					while (rsone1.next()) {
						rowCount = rsone1.getInt(1);
						System.out.println("Rowcount is now " + rowCount);
					}

					String sql = "select soldier_id ,s_name ,gender ,dob ,blood_group ,date_of_join ,regi_name "
							+ "from personal_info";
					Statement smt = connection.createStatement();
					ResultSet rstwo = smt.executeQuery(sql);
					ResultSetMetaData meta = rstwo.getMetaData();
					int colCount = meta.getColumnCount();

					if (rowCount == 0)
						JOptionPane.showMessageDialog(null, "No Results to Display");
					else {
						for (int i = 0; i < rowCount; i++) {
							int k = 1;
							if (rstwo.next()) {
								for (int j = 0; j < colCount; j++) {
									data[i][j] = rstwo.getString(k++);
								}
							}
						}
					}
					connection.close();

				} catch (Exception e7) {
					e7.printStackTrace();
				}
				frame.repaint();

			}
		});
		// btnView.setFont(new Font("Consolas", Font.PLAIN, 22));
		btnView.setBounds(453, 79, 179, 35);
		frame.getContentPane().add(btnView);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(163, 127, 762, 411);
		frame.getContentPane().add(scrollPane);

		table_1 = new JTable(data, columns);
		table_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		// table.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		scrollPane.setViewportView(table_1);

		JButton btnNewButton_1_3 = new JButton("");
		btnNewButton_1_3.setBackground(new Color(255, 255, 255));
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PERSONAL.main(new String[] {});
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/341.png")).getImage();
		btnNewButton_1_3.setIcon(new ImageIcon(img));
		btnNewButton_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1_3.setBounds(38, 35, 65, 30);
		frame.getContentPane().add(btnNewButton_1_3);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-10, -250, 2000, 1500);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(100, 100, 1300, 579);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image img1 = new ImageIcon(this.getClass().getResource("/view3.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));

		frame.setBounds(100, 100, 1205, 579);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Object[][] data = new Object[1000][4];
		// headers for the table
		// String[] columns = new String[]
		// {"Soldier_id","Name","Relationship","Phone_number"};
	}
}