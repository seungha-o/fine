package fine.community.training.model;

import java.sql.Date;

/*TRN_NO     NOT NULL NUMBER         
TRN_TITLE  NOT NULL VARCHAR2(100)  
CONTENT    NOT NULL VARCHAR2(2000) 
WRITE_DATE NOT NULL DATE           
MEDIA      NOT NULL VARCHAR2(1000) */
public class TrainingVO {
	@Override
	public String toString() {
		return "TrainingVO [trn_no=" + trn_no + ", trn_title=" + trn_title + ", content=" + content + ", write_date="
				+ write_date + ", media=" + media + "]";
	}
	private int trn_no;
	private String trn_title;
	private String content;
	private Date write_date;
	private String media;
	public int getTrn_no() {
		return trn_no;
	}
	public void setTrn_no(int trn_no) {
		this.trn_no = trn_no;
	}
	public String getTrn_title() {
		return trn_title;
	}
	public void setTrn_title(String trn_title) {
		this.trn_title = trn_title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	
	
	
	
}
