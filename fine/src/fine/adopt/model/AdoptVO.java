package fine.adopt.model;

import java.sql.Date;
import java.util.List;

//	ADOPT_NO         NOT NULL NUMBER         
//	ID                        VARCHAR2(15)   
//	ADOPT_TITLE      NOT NULL VARCHAR2(100)  
//	ADOPT_CONTENTS   NOT NULL VARCHAR2(2000) 
//	ADOPT_COUNT      NOT NULL NUMBER         
//	ADOPT_WRITE_DATE          DATE           
//	ADOPT_IMG                 VARCHAR2(1000) 
//	REF                       NUMBER         
//	REF_STEP                  NUMBER         
//	REF_LEVEL                 NUMBER 

public class AdoptVO {
	private int adopt_no;
	private String id;
	private String adopt_title;
	private String adopt_contents;
	private int adopt_count;
	private Date adopt_write_date;
	private List<String> adopt_img;
	private int ref;
	private int ref_step;
	private int ref_level;
	
	public int getAdopt_no() {
		return adopt_no;
	}
	public void setAdopt_no(int adopt_no) {
		this.adopt_no = adopt_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAdopt_title() {
		return adopt_title;
	}
	public void setAdopt_title(String adopt_title) {
		this.adopt_title = adopt_title;
	}
	public String getAdopt_contents() {
		return adopt_contents;
	}
	public void setAdopt_contents(String adopt_contents) {
		this.adopt_contents = adopt_contents;
	}
	public int getAdopt_count() {
		return adopt_count;
	}
	public void setAdopt_count(int adopt_count) {
		this.adopt_count = adopt_count;
	}
	public Date getAdopt_write_date() {
		return adopt_write_date;
	}
	public void setAdopt_write_date(Date adopt_write_date) {
		this.adopt_write_date = adopt_write_date;
	}
	public List<String> getAdopt_img() {
		return adopt_img;
	}
	public void setAdopt_img(List<String> adopt_img) {
		this.adopt_img = adopt_img;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRef_step() {
		return ref_step;
	}
	public void setRef_step(int ref_step) {
		this.ref_step = ref_step;
	}
	public int getRef_level() {
		return ref_level;
	}
	public void setRef_level(int ref_level) {
		this.ref_level = ref_level;
	}
	
}
