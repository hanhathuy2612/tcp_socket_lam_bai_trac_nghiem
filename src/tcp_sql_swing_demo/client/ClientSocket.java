package tcp_sql_swing_demo.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket {
	private static ClientSocket instance;
	
	private Socket socket;
	
	public Socket getSocket() {
		return socket;
	}
	
	public void setSocket(String host, int port) throws UnknownHostException, IOException{
		this.socket = new Socket(host, port);
	}

	public static ClientSocket getInstance() {
		if (instance == null) {
			instance = new ClientSocket();
		}
		return instance;
	}
	
}
