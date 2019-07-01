package cn.edu.lingnan.dto;

public class UserDTO {
	private String Unumber;
	private String Uname;
	private String Sex;
	private int Age;
	private String Password;
	private int superuser;
	private int IsDeleted;
	
	public String getUnumber() {
		return Unumber;
	}
	public void setUnumber(String unumber) {
		Unumber = unumber;
	}
	public String getUname() {
		return Uname;
	}
	public void setUname(String uname) {
		Uname = uname;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getSuperuser() {
		return superuser;
	}
	public void setSuperuser(int superuser) {
		this.superuser = superuser;
	}
	public int getIsDeleted() {
		return IsDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		IsDeleted = isDeleted;
	}
}