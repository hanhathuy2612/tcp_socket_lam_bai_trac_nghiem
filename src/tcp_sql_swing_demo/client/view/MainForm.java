package tcp_sql_swing_demo.client.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tcp_sql_swing_demo.client.ClientSocket;
import tcp_sql_swing_demo.connection.Question;
import tcp_sql_swing_demo.connection.QuestionDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.awt.event.ActionEvent;

public class MainForm extends JFrame {

	private JPanel contentPane;
	private JTextArea txtQuestion;
	private JRadioButton rdbtnA;
	private JRadioButton rdbtnB;
	private JRadioButton rdbtnC;
	private JRadioButton rdbtnD;
	private JLabel lbCounter;
	private JLabel lbNextQuestion;

	private QuestionDao questionDao = new QuestionDao();

	private Timer timer;
	private int count = 10;
	private int maxCount = 30;
	private int currentQuestion = 1;
	private List<Question> questions = new ArrayList<>();
	private Map<Integer, String> resource = new HashMap<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
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
	public MainForm() {
		questions = questionDao.getQuestion();
		System.out.println(questions.size());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 364);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("BÀI THI");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(293, 26, 118, 49);
		contentPane.add(lblNewLabel);
		ButtonGroup buttonGroup = new ButtonGroup();

		rdbtnA = new JRadioButton("A. Xanh");
		rdbtnA.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnA.setBounds(42, 201, 103, 21);
		contentPane.add(rdbtnA);

		rdbtnB = new JRadioButton("B. Đỏ");
		rdbtnB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnB.setBounds(206, 201, 103, 21);
		contentPane.add(rdbtnB);

		rdbtnD = new JRadioButton("D. Tím");
		rdbtnD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnD.setBounds(521, 201, 103, 21);
		contentPane.add(rdbtnD);

		rdbtnC = new JRadioButton("C. Vàng");
		rdbtnC.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnC.setBounds(357, 201, 103, 21);
		contentPane.add(rdbtnC);

		buttonGroup.add(rdbtnA);
		buttonGroup.add(rdbtnB);
		buttonGroup.add(rdbtnC);
		buttonGroup.add(rdbtnD);

		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					aceptAnswer();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(574, 279, 103, 21);
		contentPane.add(btnNewButton);

		JButton btnBQu = new JButton("Bỏ qua");
		btnBQu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					skip();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBQu.setBounds(479, 279, 85, 21);
		contentPane.add(btnBQu);

		lbCounter = new JLabel("30");
		lbCounter.setForeground(Color.RED);
		lbCounter.setHorizontalAlignment(SwingConstants.CENTER);
		lbCounter.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbCounter.setBounds(593, 20, 72, 49);
		contentPane.add(lbCounter);

		txtQuestion = new JTextArea();
		txtQuestion.setEditable(false);
		txtQuestion.setWrapStyleWord(true);
		txtQuestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtQuestion.setLineWrap(true);
		txtQuestion.setText(
				"Câu 1: A gọi B bằng bác, B gọi C là ông nội , C kêu D là cậu, D kêu E là dì, E kêu F là chú, F gọi Z là con. Hỏi A gọi Z bằng gì?");
		txtQuestion.setBounds(41, 124, 624, 57);
		contentPane.add(txtQuestion);

		lbNextQuestion = new JLabel("1/10");
		lbNextQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lbNextQuestion.setForeground(Color.RED);
		lbNextQuestion.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbNextQuestion.setBounds(10, 20, 72, 40);
		contentPane.add(lbNextQuestion);

		// my code
		setup();
	}

	private void setup() {
		count = maxCount;
		currentQuestion = 1;
		nextQuestion(currentQuestion);

		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				count--;
				if (count <= 0) {
					count = maxCount;
					currentQuestion++;
					if (currentQuestion > questions.size()) {
						((Timer) (e.getSource())).stop();
					} else {
						nextQuestion(currentQuestion);
					}

				}

				lbCounter.setText(Integer.toString(count));

			}
		});
		timer.setInitialDelay(0);
		timer.start();
	}

	private void nextQuestion(int currentQuestion) {
		
		if (currentQuestion > questions.size()) {
			return;
		}
		
		Optional<Question> questionOpt = questions.stream().filter(x -> x.getStt() == currentQuestion).findFirst();
		Question question = questionOpt.get();

		count = maxCount;
		txtQuestion.setText(String.format("Câu %d: %s", question.getStt(), question.getQuestion()));
		rdbtnA.setText("A." + question.getA());
		rdbtnB.setText("B." + question.getB());
		rdbtnC.setText("C." + question.getC());
		rdbtnD.setText("D." + question.getD());

		lbNextQuestion.setText(question.getStt() + "/" + questions.size());
	}

	protected void skip() throws ClassNotFoundException, IOException {
		resource.put(currentQuestion, "");
		currentQuestion++;
		if (currentQuestion > questions.size()) {
			sendResultToServer(resource);
		}
		
		count = maxCount;
		nextQuestion(currentQuestion);
		timer.restart();
	}

	protected void aceptAnswer() throws ClassNotFoundException, IOException {
		
		if (currentQuestion > questions.size()) {
			sendResultToServer(resource);
		}

		String answer = "";

		if (rdbtnA.isSelected())
			answer = "A";
		if (rdbtnB.isSelected())
			answer = "B";
		if (rdbtnC.isSelected())
			answer = "C";
		if (rdbtnD.isSelected())
			answer = "D";

		resource.put(currentQuestion, answer);
		
		currentQuestion++;
		
		

		count = maxCount;
		nextQuestion(currentQuestion);
		timer.restart();
	}

	private void sendResultToServer(Map<Integer, String> resource) throws IOException, ClassNotFoundException {
		Socket socket = ClientSocket.getInstance().getSocket();
		System.out.println(resource.get(1));
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
		objectOutputStream.writeObject(resource);

		ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
		String result = (String) inputStream.readObject();
		dispose();
		
		new ResultForm("TRẦN QUỐC THÁI", "0123456789", result)
		.setVisible(true);
		
	}
}
