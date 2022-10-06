package model;

public class SinhVien {
	private int id; 
	private String  maSinhVien;
	private String hoTen;
	private String soDienThoai;
	public String getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public SinhVien(String maSinhVien, String hoTen, String soDienThoai) {
		super();
		this.maSinhVien = maSinhVien;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
	}
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
