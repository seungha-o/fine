package fine.rescue.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import fine.rescue.model.RescueDAO;
import fine.rescue.model.RescueVO;

public class RescueService {
	private static DataSource ds = null;
	private static Connection conn = null;
	private static RescueDAO dao = new RescueDAO();

	public RescueService() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:/comp/env/jdbc/myoracles");
			conn = ds.getConnection();
//			conn.setAutoCommit(false); // rollback때문에 자동으로 커밋되는거 막아야함.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<RescueVO> rescueList(int start, int end) throws Exception {
		List<RescueVO> list = null;
		list = dao.rescueList(conn, start, end);
		
		return list;
	}

	public static List<RescueVO> rescueSearch(String searchWord, int start, int end) throws Exception {
		List<RescueVO> list = null;
		list = dao.rescueSearch(conn, searchWord, start, end);
		return list;
	}

	public RescueVO rescueDetail(int rec_no) throws Exception {
		RescueVO vo = null;
		vo = dao.rescueDetail(conn, rec_no);
		if(vo != null) {
			close();
		}
		
		return vo;
	}

	public int rescueWrite(String id, String title, String content, List<String> img) throws Exception {
		int result = 0;
		conn = ds.getConnection();
		result = dao.rescueWrite(conn, id, title, content, img);
		close();
		
		return result;
	}

	public int rescueUpdate(String title, String content, int rec_no, List<String> saveFiles) throws Exception {
		int result = 0;
		result = dao.rescueUpdate(conn, title, content, rec_no, saveFiles);
		if (result != 0) {
			close();
		}

		return result;
	}

	public int rescueDelete(int rec_no) throws Exception {
		int result = 0;
		result = dao.rescueDelete(conn, rec_no);
		if (result != 0) {
			close();
		}

		return result;
	}

	public static int getBoardCount() throws Exception {
		int result = new RescueDAO().getBoardCount(conn);

		return result;
	}

	public static int getSearchBoardCount(String searchWord) throws Exception {																						// 글 개수
		int result = new RescueDAO().getSearchBoardCount(searchWord, conn);
		
		return result;
	}

	public RescueVO reply_view(String rec_no) {
		RescueVO vo = null;
		vo = dao.reply_view(conn, rec_no);
		if(vo != null) {
			close();
		}
		
		return vo;
	}
	
	public int reply(String id, String rec_title, String rec_content,  
			String ref, String ref_step, String ref_level) {
		int result = 0;
		result = dao.reply(conn, id, 
				rec_title, rec_content, ref, ref_step, ref_level);
		
		return result;
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
