package fine.rescue.model;

import java.sql.Date;
import java.util.List;

//	REC_NO         NOT NULL NUMBER         
//	ID                      VARCHAR2(15)   
//	REC_TITLE      NOT NULL VARCHAR2(100)  
//	REC_CONTENTS   NOT NULL VARCHAR2(2000) 
//	REC_COUNT               NUMBER         
//	REC_WRITE_DATE          DATE           
//	REC_IMG                 VARCHAR2(1000) 
//	REF                     NUMBER         
//	REF_STEP                NUMBER         
//	REF_LEVEL               NUMBER

public class RescueVO {
	private int rec_no;
	private String id;
	private String rec_title;
	private String rec_contents;
	private int rec_count;
	private Date rec_write_date;
	private List<String> rec_img;
	private int ref;
	private int ref_step;
	private int ref_level;
	
	public int getRec_no() {
		return rec_no;
	}
	public void setRec_no(int rec_no) {
		this.rec_no = rec_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRec_title() {
		return rec_title;
	}
	public void setRec_title(String rec_title) {
		this.rec_title = rec_title;
	}
	public String getRec_contents() {
		return rec_contents;
	}
	public void setRec_contents(String rec_contents) {
		this.rec_contents = rec_contents;
	}
	public int getRec_count() {
		return rec_count;
	}
	public void setRec_count(int rec_count) {
		this.rec_count = rec_count;
	}
	public Date getRec_write_date() {
		return rec_write_date;
	}
	public void setRec_write_date(Date rec_write_date) {
		this.rec_write_date = rec_write_date;
	}
	public List<String> getRec_img() {
		return rec_img;
	}
	public void setRec_img(List<String> rec_img) {
		this.rec_img = rec_img;
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
