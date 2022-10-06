package tcp_sql_swing_demo.client.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class ResultForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public ResultForm(String fullName, String stuedntCode,String correctNumber) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(66, 83, 310, 90);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel txthoten = new JLabel("TRAN QUOC THAI");
		txthoten.setBounds(10, 20, 142, 26);
		panel.add(txthoten);
		txthoten.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel txtmssv = new JLabel("1234567890");
		txtmssv.setBounds(10, 56, 142, 34);
		panel.add(txtmssv);
		txtmssv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(123, 10, 174, 49);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("KẾT QUẢ");
		lblNewLabel.setBounds(47, 10, 84, 34);
		panel_1.add(lblNewLabel);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(66, 183, 310, 161);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel(String.format("%s Điểm", correctNumber));
		lblNewLabel_1_1.setBounds(73, 85, 174, 49);
		panel_2.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel(String.format("Số câu đúng: %s/10", correctNumber));
		lblNewLabel_1.setBounds(31, 20, 245, 55);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	}
}
