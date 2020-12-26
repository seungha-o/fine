package fine.notice.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


public class NoticeVO {

	private int notice_no;
	private String id;
	private int notice_count;
	private String notice_title;
	private String notice_contents;
	private Date notice_write_date;
	private List<String> notice_img;
	private int pin;
	

	public NoticeVO() {
	}

	public NoticeVO( String notice_title, String notice_contents, int pin) {
		super();
		this.notice_title = notice_title;
		this.notice_contents = notice_contents;
		this.pin = pin;
	}
	public int getPin() {
		return pin;
	}
	
	public void setPin(int pin) {
		this.pin = pin;
	}
	public int getNotice_no() {
		return notice_no;
	}
	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNotice_count() {
		return notice_count;
	}
	public void setNotice_count(int notice_count) {
		this.notice_count = notice_count;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_contents() {
		return notice_contents;
	}
	public void setNotice_contents(String notice_contents) {
		this.notice_contents = notice_contents;
	}
	public Date getNotice_write_date() {
		return notice_write_date;
	}
	public void setNotice_write_date(Date notice_write_date) {
		this.notice_write_date = notice_write_date;
	}
	public List<String> getNotice_img() {
		return notice_img;
	}
	public void setNotice_img(List<String> notice_img) {
		this.notice_img = notice_img;
	}
	
}
