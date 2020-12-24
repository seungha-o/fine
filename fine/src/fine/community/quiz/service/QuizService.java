package fine.community.quiz.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fine.community.quiz.model.QuizDAO;
import fine.community.quiz.model.QuizVO;

public class QuizService {
	private static DataSource ds = null;
	private static Connection conn = null;

	public QuizService() {
		try {
			Context ctx = new InitialContext();
			Context ctx1 = (Context) ctx.lookup("java:/comp/env");
			ds = (DataSource) ctx1.lookup("jdbc/myoracles");
			try {
				conn = ds.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Connection 실패!");
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	public int quizWrite(QuizVO vo) {
		int result = 0;
		QuizDAO dao = new QuizDAO();
		result = dao.quiz_Write(vo, conn);
		return result;
	}

	public List<QuizVO> getQuizList(int startRnunm, int endRnum) {

		System.out.println(startRnunm + ":" + endRnum);
		List<QuizVO> list = new ArrayList<QuizVO>();
		QuizDAO dao = new QuizDAO();
		list = dao.getQuizList(startRnunm, endRnum, conn);
		return list;

	}

	public List<QuizVO> getQuizInfo(int no) {
		List<QuizVO> list = new ArrayList<QuizVO>();
		QuizDAO dao = new QuizDAO();
		list = dao.getQuizInfo(no, conn);
		return list;
	}

	public int quizUpdate(QuizVO vo) {
		QuizDAO dao = new QuizDAO();
		int result = dao.quizUpdate(conn, vo);
		return result;
	}

	public int quizDelete(QuizVO vo) {
		QuizDAO dao = new QuizDAO();
		int result = dao.quizDelete(conn, vo);
		return result;

	}

	public List<QuizVO> randomQuizList() {
		System.out.println("서비스 옴");
		List<QuizVO> list = new ArrayList<QuizVO>();
		QuizDAO dao = new QuizDAO();
		list = dao.randomQuizList(conn);
		System.out.println("list 다시  보냄");
		return list;
	}

	public int updateGrade(int gradeNO,String id) {
		int result = 0;
		QuizDAO dao = new QuizDAO();
		result = dao.updateGrade(gradeNO,id, conn);
		return result;
	}

}
