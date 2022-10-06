package tcp_sql_swing_demo.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.CauHoi;

public class CauHoiDao {
	public List<CauHoi> getQuestion() {
		List<CauHoi> questions = new ArrayList<>();
		String query = "select * from cau_hoi order by stt asc";
		try {
			Connection connection = DbConnection.getInstance().getConnection("localhost", "1433", "sa", "123456");
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			;
			while (rs.next()) {
				int id = rs.getInt("id");
				int stt = rs.getInt("stt");
				String noiDung = rs.getString("noi_dung");
				String dapAn = rs.getString("dap_an");
				String A = rs.getString("A");
				String B = rs.getString("B");
				String C = rs.getString("C");
				String D = rs.getString("D");
				questions.add(new CauHoi(id,stt, noiDung, dapAn, A, B, C, D));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return questions;
	}

}
