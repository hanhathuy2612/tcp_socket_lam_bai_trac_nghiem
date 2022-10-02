package tcp_sql_swing_demo.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DbConnection {
	private String connectionString = "jdbc:sqlserver://%s:%s;databaseName=trac_nghiem_socket;";
	private static DbConnection instance = null;
	private Connection cn = null;
	
	public static DbConnection getInstance() {
		if (instance == null) {
			instance = new DbConnection();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return cn;
	}

	public Connection getConnection(String host, String port, String username, String password) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn = DriverManager.getConnection(
					String.format(connectionString, host, port), 
					username, 
					password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cn;
	}
	
	public boolean isConnected(String host, String port, String username, String password) {
		var connection = getConnection(host, port, username, password);
		return connection != null;
	}

	public static void main(String[] args) {
		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection("localhost", "1433", "sa", "123456");
		if (con != null) {
			System.out.println("Connect successfull");
		}
	}
}
