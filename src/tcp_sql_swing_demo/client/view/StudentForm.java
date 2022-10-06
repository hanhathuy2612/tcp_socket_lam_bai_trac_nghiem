package tcp_sql_swing_demo.client.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.SinhVienDao;
import model.SinhVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentForm extends JFrame {

	private JPanel contentPane;
	private JTextField txthoten;
	private JTextField txtmsv;
	private JTextField txtsdt;
	SinhVienDao sinhVienDao = new SinhVienDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentForm frame = new StudentForm();
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
	public StudentForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("THÔNG TIN SINH VIÊN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(79, 10, 286, 39);
		contentPane.add(lblNewLabel);

		txthoten = new JTextField();
		txthoten.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txthoten.setBounds(130, 104, 181, 24);
		contentPane.add(txthoten);
		txthoten.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Họ tên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(130, 73, 61, 24);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Mã sinh viên");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(130, 138, 132, 24);
		contentPane.add(lblNewLabel_1_1);

		txtmsv = new JTextField();
		txtmsv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtmsv.setColumns(10);
		txtmsv.setBounds(130, 169, 181, 24);
		contentPane.add(txtmsv);

		JLabel lblNewLabel_1_2 = new JLabel("Số điện thoại");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(130, 203, 132, 24);
		contentPane.add(lblNewLabel_1_2);

		txtsdt = new JTextField();
		txtsdt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtsdt.setColumns(10);
		txtsdt.setBounds(130, 234, 181, 24);
		contentPane.add(txtsdt);

		JButton btntieptuc = new JButton("Tiếp tục");

		btntieptuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txthoten.getText().isEmpty() || txtmsv.getText().isEmpty() || txtsdt.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Bạn phải điền đủ thông tin để tiếp tục");
				} else {

					if (checkExist(txtmsv.getText())) {
						JOptionPane.showMessageDialog(null, "Ma sinh vien da ton tai, vui long nhap lai");
					} else {
						SinhVien sinhVien = new SinhVien();
						sinhVien.setMaSinhVien(txtmsv.getText());
						sinhVien.setHoTen(txthoten.getText());
						sinhVien.setSoDienThoai(txtsdt.getText());

						sinhVienDao.add(sinhVien);
						
						new MainForm().setVisible(true);
						dispose();
					}

				}
			}
		});

		btntieptuc.setBounds(175, 291, 85, 39);
		contentPane.add(btntieptuc);
	}

	public boolean checkExist(String mssv) {
		SinhVien student = sinhVienDao.getByMssv(mssv);
		if (student != null)
			return true;
		return false;
	}

}
