package fine.member.member.model;

import java.sql.Date;

public class MemberVO {
//	ID          NOT NULL VARCHAR2(15)  
//	CARE_NO              VARCHAR2(20)  
//	NAME        NOT NULL VARCHAR2(15)  
//	PASSWORD    NOT NULL VARCHAR2(20)  
//	PHONE       NOT NULL VARCHAR2(20)  
//	EMAIL       NOT NULL VARCHAR2(50)  
//	DOG_KIND_NO          VARCHAR2(200) 
//	GRADE                CHAR(1)       
//	LEV                  CHAR(1)       
//	STATUS               CHAR(1)       
//	SIGN_DATE            DATE          
//	BIRTHDAY    NOT NULL DATE   
	private String id;
	private String care_no;
	private String name;
	private String password;
	private String phone;
	private String email;
	private String dog_kind_no;
	private String grade;
	private String lev;
	private String status;
	private Date sign_date;
	private Date birthday;
	private String address;
	private String emailcode;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCare_no() {
		return care_no;
	}
	public void setCare_no(String care_no) {
		this.care_no = care_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDog_kind_no() {
		return dog_kind_no;
	}
	public void setDog_kind_no(String dog_kind_no) {
		this.dog_kind_no = dog_kind_no;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getLev() {
		return lev;
	}
	public void setLev(String lev) {
		this.lev = lev;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getSign_date() {
		return sign_date;
	}
	public void setSign_date(Date sign_date) {
		this.sign_date = sign_date;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailcode() {
		return emailcode;
	}
	public void setEmailcode(String emailcode) {
		this.emailcode = emailcode;
	}
	
	
	
	
}
