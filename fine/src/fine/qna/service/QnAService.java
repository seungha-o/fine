package fine.qna.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import fine.jdbc.JdbcTemplate;
import fine.qna.model.QnADAO;
import fine.qna.model.QnAVO;

public class QnAService {
	private static DataSource ds = null; // ds는 아파치에서 제공하는 DB Connection pool이다.
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	private static QnADAO dao = new QnADAO();

	public QnAService() {
		
	}

	

	public static List<QnAVO> qnaList(int start, int end) throws Exception {
		conn = JdbcTemplate.getConnection(conn, ds);
		List<QnAVO> list = null;
		list = dao.qnaList(conn, pstmt, rs,start, end);
		JdbcTemplate.close(conn, pstmt, rs);		
		return list;
	}

	public static List<QnAVO> qnaSearch(String searchWord, int start, int end) throws Exception {
		conn = JdbcTemplate.getConnection(conn, ds);
		List<QnAVO> list = null;
		list = dao.qnaSearch(conn,pstmt,rs, searchWord, start, end);
		JdbcTemplate.close(conn, pstmt, rs);		
		return list;
	}

	public QnAVO qnaDetail(int strQna_no) throws Exception {
		conn = JdbcTemplate.getConnection(conn, ds);
		QnAVO vo = null;
		vo = dao.qnaDetail(conn, strQna_no, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);		
		
		
		return vo;
	}

	public int qnaWrite(String id, String title, String content, String pass, List<String> img, int passState) throws Exception {
		int result = 0;
		conn = JdbcTemplate.getConnection(conn, ds);
		result = dao.qnaWrite(conn, id, title, content, pass, img ,passState, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);		
		return result;
	}
	

	public int qnaUpdate(String title, String content, int qna_no, List<String> saveFiles) throws Exception {
		conn = JdbcTemplate.getConnection(conn, ds);
		int result = 0;
		result = dao.qnaUpdate(conn, title, content, qna_no, saveFiles, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);				
		return result;
	}

	public int qnaDelete(int qna_no) throws Exception {
		int result = 0;
		conn = JdbcTemplate.getConnection(conn, ds);
		result = dao.qnaDelete(conn, qna_no, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);				
		return result;
	}

	public static int getBoardCount() throws Exception {
		conn = JdbcTemplate.getConnection(conn, ds);
		int result = new QnADAO().getBoardCount(conn, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);				
		return result;
	}

	public static int getSearchBoardCount(String searchWord) throws Exception {																						// 글 개수
		conn = JdbcTemplate.getConnection(conn, ds);
		int result = new QnADAO().getSearchBoardCount(searchWord, conn , pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);				
		
		return result;
	}

	
	
	public int reply(String id, String qna_title, String qna_content, String ref, String ref_step, String ref_level) {
		int result = 0;
		conn = JdbcTemplate.getConnection(conn, ds);
		result = dao.reply(conn, id, qna_title, qna_content, ref ,ref_step, ref_level, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);				
		return result;
	}




	public List<QnAVO> getComent(int strQna_no) {
		List<QnAVO> list = new ArrayList<QnAVO>();
		conn = JdbcTemplate.getConnection(conn, ds);
		list = dao.getComent(strQna_no, conn, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);				
		return list;
	}

	public String privateChk(int strQna_no) {
		conn = JdbcTemplate.getConnection(conn, ds);
		String result = null;
		result = dao.privateChk(strQna_no, conn, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);				
		return result;
	}

	public int qnaPassChk(int qnaNo, int qnaPass) {
		int result = 0;
		conn = JdbcTemplate.getConnection(conn, ds);
		result = dao.qnaPassChk(qnaNo, qnaPass, conn , pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);				
		return result;
	}
	
//	public List<QnAVO> comparePass(int strQna_no, String pass) {
//		List<QnAVO> list = null;
//		list = dao.comparePass(conn, strQna_no, pass);
//		
//		return list;
//	}
}

























