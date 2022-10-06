package model;

import java.io.Serializable;

public class KetQuaThi implements Serializable{
	private int id;
	private float diem;
	private int sinhVienId;
	private int deThiId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getDiem() {
		return diem;
	}
	public void setDiem(float diem) {
		this.diem = diem;
	}
	public int getSinhVienId() {
		return sinhVienId;
	}
	public void setSinhVienId(int sinhVienId) {
		this.sinhVienId = sinhVienId;
	}
	public int getDeThiId() {
		return deThiId;
	}
	public void setDeThiId(int deThiId) {
		this.deThiId = deThiId;
	}
	
	
}
