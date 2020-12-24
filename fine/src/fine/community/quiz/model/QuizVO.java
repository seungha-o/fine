package fine.community.quiz.model;

//QUIZ_NO      NOT NULL NUMBER        
//ID                    VARCHAR2(15)  
//QULZ_CONTENT NOT NULL VARCHAR2(100) 
//ANSWER       NOT NULL VARCHAR2(100) 
public class QuizVO {
	private int quiz_no;
	private String id;
	private String quiz_content;
	private String answer;
	private String user_answer; // 유저의 답을 담기위한 vo를 생성

	public int getQuiz_no() {
		return quiz_no;
	}

	public void setQuiz_no(int quiz_no) {
		this.quiz_no = quiz_no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuiz_content() {
		return quiz_content;
	}

	public void setQuiz_content(String quiz_content) {
		this.quiz_content = quiz_content;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getUser_answer() {
		return user_answer;
	}

	public void setUser_answer(String user_answer) {
		this.user_answer = user_answer;
	}


	/* 
	 * @Override public String toString() { return "QuizVO [quiz_no=" + quiz_no +
	 * ", id=" + id + ", quiz_content=" + quiz_content + ", answer=" + answer + "]";
	 * }
	 */
	

}
