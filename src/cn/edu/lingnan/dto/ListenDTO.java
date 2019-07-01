package cn.edu.lingnan.dto;

public class ListenDTO {
	private String Mnumber;
	private String Mname;
	private String Unumber;
	private int IsDeleted;

	public String getMnumber() {
		return Mnumber;
	}

	public void setMnumber(String mnumber) {
		Mnumber = mnumber;
	}

	public String getMname() {
		return Mname;
	}

	public void setMname(String mname) {
		Mname = mname;
	}

	public String getUnumber() {
		return Unumber;
	}

	public void setUnumber(String unumber) {
		Unumber = unumber;
	}

	public int getIsDeleted() {
		return IsDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		IsDeleted = isDeleted;
	}
}