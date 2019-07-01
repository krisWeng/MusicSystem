package cn.edu.lingnan.dto;

public class MusicDTO {
	private String Unumber;
	private String Mnumber;
	private String Mname;
	private String Singer;
	private int IsDeleted;
	
	public String getUnumber() {
		return Unumber;
	}

	public void setUnumber(String unumber) {
		Unumber = unumber;
	}

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

	public String getSinger() {
		return Singer;
	}

	public void setSinger(String singer) {
		Singer = singer;
	}

	public int getIsDeleted() {
		return IsDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		IsDeleted = isDeleted;
	}
}