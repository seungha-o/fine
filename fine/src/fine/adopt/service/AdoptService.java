package fine.adopt.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import fine.adopt.model.AdoptDAO;
import fine.adopt.model.AdoptVO;
import fine.jdbc.JdbcTemplate;
import fine.qna.model.QnAVO;

public class AdoptService {
	private static DataSource ds = null; // ds는 아파치에서 제공하는 DB Connection pool이다.
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	private static AdoptDAO dao = new AdoptDAO();

	public AdoptService() {
		
	}

	

	public static List<AdoptVO> adoptList(int start, int end) throws Exception {
		List<AdoptVO> list = null;
		conn = JdbcTemplate.getConnection(conn, ds);
		list = dao.adoptList(conn, start, end, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);	
		
		return list;
	}

	public static List<AdoptVO> adoptSearch(String searchWord, int start, int end) throws Exception {
		List<AdoptVO> list = null;
		conn = JdbcTemplate.getConnection(conn, ds);
		list = dao.adoptSearch(conn, searchWord, start, end, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);	
		return list;
	}

	public AdoptVO adoptDetail(int adopt_no) throws Exception {
		AdoptVO vo = null;
		conn = JdbcTemplate.getConnection(conn, ds);
		vo = dao.adoptDetail(conn, adopt_no , pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);	

		
		return vo;
	}

	public int adoptWrite(String id, String title, String content, List<String> img) throws Exception {
		int result = 0;
		conn = JdbcTemplate.getConnection(conn, ds);
		result = dao.adoptWrite(conn, id, title, content, img,  pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);	
		
		return result;
	}

	public int adoptUpdate(String title, String content, int adopt_no, List<String> saveFiles) throws Exception {
		int result = 0;
		conn = JdbcTemplate.getConnection(conn, ds);
		result = dao.adoptUpdate(conn, title, content, adopt_no, saveFiles, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);	


		return result;
	}

	public int adoptDelete(int adopt_no) throws Exception {
		int result = 0;
		conn = JdbcTemplate.getConnection(conn, ds);
		result = dao.adoptDelete(conn, adopt_no, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);	
		return result;
	}

	public static int getBoardCount() throws Exception {
		conn = JdbcTemplate.getConnection(conn, ds);
		int result = new AdoptDAO().getBoardCount(conn, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);	

		return result;
	}

	public static int getSearchBoardCount(String searchWord) throws Exception {																						// 글 개수
		conn = JdbcTemplate.getConnection(conn, ds);
		int result = new AdoptDAO().getSearchBoardCount(searchWord, conn, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);	
		
		return result;
	}

	public AdoptVO reply_view(String adopt_no) {
		AdoptVO vo = null;
		conn = JdbcTemplate.getConnection(conn, ds);
		vo = dao.reply_view(conn, adopt_no, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);	
	
		
		return vo;
	}
	
	public int reply(String id, String adopt_title, String adopt_content,  
			String ref, String ref_step, String ref_level) {
		conn = JdbcTemplate.getConnection(conn, ds);
		int result = 0;
		result = dao.reply(conn, id, 
				adopt_title, adopt_content, ref, ref_step, ref_level, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);	
		
		return result;
	}



	public List<AdoptVO> getComent(int adopt_no) {
		List<AdoptVO> list = new ArrayList<AdoptVO>();
		conn = JdbcTemplate.getConnection(conn, ds);
		list = dao.getComent(adopt_no, conn, pstmt, rs);
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
