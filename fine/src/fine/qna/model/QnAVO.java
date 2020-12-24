package fine.qna.model;

import java.sql.Date;
import java.util.List;

// qna_no number PRIMARY KEY,
// ID varchar2(15),	
// Qna_title varchar2(100) NOT NULL,
// Qna_contents	varchar2(2000) NOT NULL,
// Qna_statement char(1)  DEFAULT '0' CHECK(Qna_statement IN('0','1')),	
// Qna_pass	char(4)	NULL,
// Qna_count number NOT NULL,
// qna_write_date date DEFAULT SYSDATE,
// qna_img varchar2(100) NULL,		
// ref number NULL,
// ref_step	number	NULL,
// ref_level number	NULL,
public class QnAVO {
	private int qna_no;
	private String id;
	private String qna_title;
	private String qna_contents;
	private Character qna_statement;
	private String qna_pass;
	private int qna_count;
	private Date qna_write_date;
	private List<String> qna_img;
	private int ref;
	private int ref_step;
	private int ref_level;
	
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_contents() {
		return qna_contents;
	}
	public void setQna_contents(String qna_contents) {
		this.qna_contents = qna_contents;
	}
	public Character getQna_statement() {
		return qna_statement;
	}
	public void setQna_statement(Character qna_statement) {
		this.qna_statement = qna_statement;
	}
	public String getQna_pass() {
		return qna_pass;
	}
	public void setQna_pass(String qna_pass) {
		this.qna_pass = qna_pass;
	}
	public int getQna_count() {
		return qna_count;
	}
	public void setQna_count(int qna_count) {
		this.qna_count = qna_count;
	}
	public Date getQna_write_date() {
		return qna_write_date;
	}
	public void setQna_write_date(Date qna_write_date) {
		this.qna_write_date = qna_write_date;
	}
	public List<String> getQna_img() {
		return qna_img;
	}
	public void setQna_img(List<String> qna_img) {
		this.qna_img = qna_img;
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
