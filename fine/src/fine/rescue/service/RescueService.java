package fine.rescue.service;

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
import fine.qna.model.QnAVO;
import fine.rescue.model.RescueDAO;
import fine.rescue.model.RescueVO;

public class RescueService {
	private static DataSource ds = null; // ds는 아파치에서 제공하는 DB Connection pool이다.
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	private static RescueDAO dao = new RescueDAO();

	public RescueService() {
		
	}



	public static List<RescueVO> rescueList(int start, int end) throws Exception {
		List<RescueVO> list = null;
		conn = JdbcTemplate.getConnection(conn, ds);
		list = dao.rescueList(conn, start, end,  pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);	
		
		return list;
	}

	public static List<RescueVO> rescueSearch(String searchWord, int start, int end) throws Exception {
		List<RescueVO> list = null;
		conn = JdbcTemplate.getConnection(conn, ds);
		list = dao.rescueSearch(conn, searchWord, start, end, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);	
		return list;
	}

	public RescueVO rescueDetail(int rec_no) throws Exception {
		RescueVO vo = null;
		conn = JdbcTemplate.getConnection(conn, ds);
		vo = dao.rescueDetail(conn, rec_no, pstmt, rs);
		
		JdbcTemplate.close(conn, pstmt, rs);	
		return vo;
	}

	public int rescueWrite(String id, String title, String content, List<String> img) throws Exception {
		int result = 0;
		conn = JdbcTemplate.getConnection(conn, ds);
		result = dao.rescueWrite(conn, id, title, content, img, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);	
		
		return result;
	}

	public int rescueUpdate(String title, String content, int rec_no, List<String> saveFiles) throws Exception {
		int result = 0;
		conn = JdbcTemplate.getConnection(conn, ds);
		result = dao.rescueUpdate(conn, title, content, rec_no, saveFiles, pstmt, rs);
	
		JdbcTemplate.close(conn, pstmt, rs);	

		return result;
	}

	public int rescueDelete(int rec_no) throws Exception {
		int result = 0;
		conn = JdbcTemplate.getConnection(conn, ds);
		result = dao.rescueDelete(conn, rec_no, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);	
		

		return result;
	}

	public static int getBoardCount() throws Exception {
		conn = JdbcTemplate.getConnection(conn, ds);
		int result = new RescueDAO().getBoardCount(conn , pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);	

		return result;
	}

	public static int getSearchBoardCount(String searchWord) throws Exception {																						// 글 개수
		conn = JdbcTemplate.getConnection(conn, ds);
		int result = new RescueDAO().getSearchBoardCount(searchWord, conn, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);	
		return result;
	}


	
	public int reply(String id, String rec_title, String rec_content,  
			String ref, String ref_step, String ref_level) {
		conn = JdbcTemplate.getConnection(conn, ds);
		int result = 0;
		result = dao.reply(conn, id, 
				rec_title, rec_content, ref, ref_step, ref_level,  pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);	
		
		
		return result;
	}



	public List<RescueVO> getComent(int rec_no) {
		List<RescueVO> list = new ArrayList<RescueVO>();
		conn = JdbcTemplate.getConnection(conn, ds);
		list = dao.getComent(rec_no, conn, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);				
		return list;
	}

//	public int adoptComentWrite() {}
//	public int adoptComentDelete() {}
//	public int adoptComentUpdate() {}
	
//	public List<adoptVO> comparePass(int stradopt_no, String pass) {
//		List<adoptVO> list = null;
//		list = dao.comparePass(conn, stradopt_no, pass);
//		
//		return list;
//	}
}
