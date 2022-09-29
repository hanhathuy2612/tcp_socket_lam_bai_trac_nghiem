package tcp_sql_swing_demo.connection;

public class Question {
	private int stt;
	private String question;
	private String answer;
	private String A;
	private String B;
	private String C;
	private String D;
	
	

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int stt, String question, String answer, String a, String b, String c, String d) {
		super();
		this.stt = stt;
		this.question = question;
		this.answer = answer;
		A = a;
		B = b;
		C = c;
		D = d;
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getA() {
		return A;
	}

	public void setA(String a) {
		A = a;
	}

	public String getB() {
		return B;
	}

	public void setB(String b) {
		B = b;
	}

	public String getC() {
		return C;
	}

	public void setC(String c) {
		C = c;
	}

	public String getD() {
		return D;
	}

	public void setD(String d) {
		D = d;
	}

}
