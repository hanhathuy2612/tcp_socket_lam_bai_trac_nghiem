package tcp_sql_swing_demo.client.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tcp_sql_swing_demo.connection.DbConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConnectDbForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtHost;
	private JTextField txtPort;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnectDbForm frame = new ConnectDbForm();
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
	public ConnectDbForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("HOST");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(124, 54, 65, 27);
		contentPane.add(lblNewLabel);

		txtHost = new JTextField();
		txtHost.setText("localhost");
		txtHost.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtHost.setColumns(10);
		txtHost.setBounds(124, 81, 189, 27);
		contentPane.add(txtHost);

		JLabel lblNewLabel_1 = new JLabel("CONNECT TO DATABASE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(102, 10, 234, 34);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("CONNECT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String host = txtHost.getText();
				String port = txtPort.getText();
				String username = txtUsername.getText();
				String password = txtPassword.getText();
				
				boolean isConnected = DbConnection.getInstance().isConnected(host, port, username, password);
				
				if (!isConnected) {
					JOptionPane.showMessageDialog(null, "Connection fail");
				}else {
					JOptionPane.showMessageDialog(null, "Connection successfull");
					dispose();
					new StudentForm().setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(159, 342, 119, 27);
		contentPane.add(btnNewButton);

		JLabel lblPort = new JLabel("PORT");
		lblPort.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPort.setBounds(124, 118, 65, 27);
		contentPane.add(lblPort);

		txtPort = new JTextField();
		txtPort.setText("1433");
		txtPort.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPort.setColumns(10);
		txtPort.setBounds(124, 145, 189, 27);
		contentPane.add(txtPort);

		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(124, 184, 137, 27);
		contentPane.add(lblUsername);

		txtUsername = new JTextField();
		txtUsername.setText("sa");
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUsername.setColumns(10);
		txtUsername.setBounds(124, 211, 189, 27);
		contentPane.add(txtUsername);

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(124, 248, 137, 27);
		contentPane.add(lblPassword);

		txtPassword = new JTextField();
		txtPassword.setText("123456");
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setColumns(10);
		txtPassword.setBounds(124, 275, 189, 27);
		contentPane.add(txtPassword);
	}

}
