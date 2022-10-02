package tcp_sql_swing_demo.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {
	public List<Question> getQuestion() {
		List<Question> questions = new ArrayList<>();
		String query = "select * from cau_hoi order by stt asc";
		try {
			Connection connection = DbConnection.getInstance().getConnection("localhost", "1433", "sa", "123456");
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			;
			while (rs.next()) {
				int stt = rs.getInt("stt");
				String question = rs.getString("noi_dung");
				String answer = rs.getString("dap_an");
				String A = rs.getString("A");
				String B = rs.getString("B");
				String C = rs.getString("C");
				String D = rs.getString("D");
				questions.add(new Question(stt, question, answer, A, B, C, D));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return questions;
	}

}
