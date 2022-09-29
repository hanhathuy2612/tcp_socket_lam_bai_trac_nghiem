package tcp_sql_swing_demo.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String sentence_to_server;
		String sentence_from_server;
		Socket clientSocket = new Socket("127.0.0.1", 6543);

		while (true) {

			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

			System.out.print("Input from client: ");
			sentence_to_server = new Scanner(System.in).nextLine();
			
			sendToServer(clientSocket, sentence_to_server);

			sentence_from_server = (String) receiveFromServer(clientSocket);

			System.out.println("FROM SERVER: " + sentence_from_server);

		}

	}

	@SuppressWarnings("unused")
	private static String hanleData(String data) {
		return data + " (Server accepted!)\n";
	}

	private static Object receiveFromServer(Socket socket) throws IOException, ClassNotFoundException {
		ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
		return inputStream.readObject();
	}

	private static void sendToServer(Socket socket, Object data) throws IOException, ClassNotFoundException {
		ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
		outputStream.writeObject(data);
	}

}
