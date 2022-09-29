package tcp_sql_swing_demo.client.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tcp_sql_swing_demo.client.ClientSocket;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class ConnectServerForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtHost;
	private JTextField txtPort;
	private Socket clientSocket = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnectServerForm frame = new ConnectServerForm();
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
	public ConnectServerForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("HOST");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(104, 85, 65, 27);
		contentPane.add(lblNewLabel);

		txtHost = new JTextField();
		txtHost.setText("127.0.0.1");
		txtHost.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtHost.setBounds(104, 112, 189, 27);
		contentPane.add(txtHost);
		txtHost.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("CONNECT TO SERVER");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(104, 33, 189, 34);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("CONNECT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String host = txtHost.getText();
				int port = Integer.parseInt(txtPort.getText());
				try {
					
					ClientSocket.getInstance().setSocket(host, port);
					
				} catch (UnknownHostException e1) {
					JOptionPane.showMessageDialog(null, "HOST NOT FOUND");
					return;
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "PORT INCORRECT");
					return;
				}
				dispose();
				new ConnectDbForm().setVisible(true);
			}
		});
		btnNewButton.setBounds(138, 223, 119, 27);
		contentPane.add(btnNewButton);

		JLabel lblPort = new JLabel("PORT");
		lblPort.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPort.setBounds(104, 149, 65, 27);
		contentPane.add(lblPort);

		txtPort = new JTextField();
		txtPort.setText("6543");
		txtPort.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPort.setColumns(10);
		txtPort.setBounds(104, 176, 189, 27);
		contentPane.add(txtPort);
	}
}
