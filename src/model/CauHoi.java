package model;

public class CauHoi {
	private int id;
	private int stt;
	private String noiDung;
	private String dapAn;
	private String A;
	private String B;
	private String C;
	private String D;
	
	

	public CauHoi(int id, int stt, String noiDung, String dapAn, String a, String b, String c, String d) {
		super();
		this.id = id;
		this.stt = stt;
		this.noiDung = noiDung;
		this.dapAn = dapAn;
		A = a;
		B = b;
		C = c;
		D = d;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getDapAn() {
		return dapAn;
	}

	public void setDapAn(String dapAn) {
		this.dapAn = dapAn;
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
