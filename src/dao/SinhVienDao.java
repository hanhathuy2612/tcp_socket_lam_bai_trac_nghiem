package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.SinhVien;
import tcp_sql_swing_demo.connection.DbConnection;

public class SinhVienDao {
	Connection connection = DbConnection.getInstance().getConnection();

	public int add(SinhVien sv) {
		int kq = 0;
		String query = "INSERT INTO sinh_vien VALUES ( ?, ?, ?)";
		try {

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, sv.getMaSinhVien());
			ps.setString(2, sv.getHoTen());
			ps.setString(3, sv.getSoDienThoai());
			kq = ps.executeUpdate();
			ps.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return kq;
	}

	public SinhVien getById(int id) {
		List<SinhVien> students = new ArrayList<>();
		try {
			String query = "select*from SV where ID=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String mssv = rs.getString("ma_sinh_vien");
				String hoTen = rs.getString("ho_ten");
				String soDienThoai = rs.getString("so_dien_thoai");

				float dtb = rs.getFloat("DTB");
				return new SinhVien(mssv, hoTen, soDienThoai);
			}

			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public SinhVien getByMssv(String mssv) {
		List<SinhVien> students = new ArrayList<>();
		try {
			String query = "select * from sinh_vien where ma_sinh_vien=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, mssv);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String hoTen = rs.getString("ho_ten");
				String soDienThoai = rs.getString("so_dien_thoai");
				
				return new SinhVien(mssv, hoTen, soDienThoai);
			}

			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
