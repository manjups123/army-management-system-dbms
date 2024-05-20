import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;

public class HOME extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HOME frame = new HOME();
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
	public HOME() {
		frame = new JFrame();
		setBackground(new Color(230, 230, 250));
		setTitle("HOME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1511, 740);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setForeground(new Color(240, 255, 255));
		panel.setBounds(10, 10, 1501, 159);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("ARMY MANAGEMENT");
		lblNewLabel.setBounds(571, 9, 469, 43);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(72, 61, 139));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 34));

		JButton btnNewButton_1 = new JButton("PERSONAL");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(245, 108, 136, 43);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PERSONAL.main(new String[] {});
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));

		JButton btnNewButton_6 = new JButton("REGIMENT");
		buttonGroup.add(btnNewButton_6);
		btnNewButton_6.setBackground(new Color(255, 255, 255));
		btnNewButton_6.setBounds(50, 108, 136, 43);
		panel.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				REGIMENT.main(new String[] {});
			}
		});
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 15));

		JButton btnNewButton_3 = new JButton("FAMILY");
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setBounds(664, 108, 136, 43);
		panel.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				FAMILY.main(new String[] {});
			}
		});

		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 15));

		JButton btnNewButton_4 = new JButton("WEAPON");
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setBounds(887, 108, 136, 43);
		panel.add(btnNewButton_4);
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 15));

		JButton btnNewButton_5 = new JButton("AWARDS");
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.setBounds(1095, 108, 136, 43);
		panel.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AWARDS.main(new String[] {});
			}
		});
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 15));

		JButton btnNewButton_2 = new JButton("ADDRESS ");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(458, 108, 136, 43);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ADDRESS.main(new String[] {});
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));

		JButton btnNewButton_7 = new JButton("TRAINING");
		btnNewButton_7.setBackground(new Color(255, 255, 255));
		btnNewButton_7.setBounds(1311, 108, 136, 43);
		panel.add(btnNewButton_7);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				TRAINING.main(new String[] {});
			}
		});
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 15));

		JButton btnNewButton_10 = new JButton("Logout");
		btnNewButton_10.setBackground(new Color(255, 255, 255));
		btnNewButton_10.setBounds(1329, 10, 123, 40);
		panel.add(btnNewButton_10);
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login.main(new String[] {});
			}
		});

		Image img = new ImageIcon(this.getClass().getResource("/login5.png")).getImage();

		btnNewButton_10.setIcon(new ImageIcon(img));
		btnNewButton_10.setForeground(new Color(0, 0, 0));
		btnNewButton_10.setFont(new Font("Times New Roman", Font.BOLD, 14));

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 169, 1552, 610);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\VIBHA\\OneDrive\\Pictures\\down1.png"));

		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				WEAPON.main(new String[] {});
			}
		});

	}
}