package tcp_sql_swing_demo.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import tcp_sql_swing_demo.connection.Question;
import tcp_sql_swing_demo.connection.QuestionDao;

public class Server {
	private static QuestionDao questionDao = new QuestionDao();
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Map<Integer, String> sentence_from_client = new HashMap<>();
		String sentence_to_client;

		ServerSocket welcomeSocket = new ServerSocket(6543);
		System.out.println("Conneting");
		Socket connectionSocket = welcomeSocket.accept();
		System.out.println("Conneted");
		
		while (true) {
			try {
				sentence_from_client = (Map<Integer, String>) receiveFromClient(connectionSocket);
				sentence_to_client = hanleData(sentence_from_client);

				sendToClient(connectionSocket, sentence_to_client);

			} catch (IOException e) {
				System.out.println("Reconneting");
				connectionSocket = welcomeSocket.accept();
				System.out.println("Conneted");
			}

		}
	}

	private static String hanleData(Map<Integer, String> data) {
		List<Question> questions = questionDao.getQuestion();
		int current = 1;
		int correct = 0;
		for (Question question: questions) {
			if(data.containsKey(current)) {
				System.out.println(data.get(current));
				System.out.println(question.getAnswer());
				
				if(data.get(current).equalsIgnoreCase(question.getAnswer())) {
					correct = correct + 1;
				}
			}
			current++;
		}
		System.out.println("numberOfCorrect: " + correct);
		return "" + correct;
	}

	private static Object receiveFromClient(Socket socket) throws IOException, ClassNotFoundException {
		ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
		return inputStream.readObject();
	}

	private static void sendToClient(Socket socket, Object data) throws IOException, ClassNotFoundException {
		ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
		outputStream.writeObject(data);
	}
}
