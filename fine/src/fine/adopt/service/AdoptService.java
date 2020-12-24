package fine.adopt.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import fine.adopt.model.AdoptDAO;
import fine.adopt.model.AdoptVO;

public class AdoptService {
	private static DataSource ds = null;
	private static Connection conn = null;
	private static AdoptDAO dao = new AdoptDAO();

	public AdoptService() {
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

	public static List<AdoptVO> adoptList(int start, int end) throws Exception {
		List<AdoptVO> list = null;
		list = dao.adoptList(conn, start, end);
		
		return list;
	}

	public static List<AdoptVO> adoptSearch(String searchWord, int start, int end) throws Exception {
		List<AdoptVO> list = null;
		list = dao.adoptSearch(conn, searchWord, start, end);
		return list;
	}

	public AdoptVO adoptDetail(int adopt_no) throws Exception {
		AdoptVO vo = null;
		vo = dao.adoptDetail(conn, adopt_no);
		if(vo != null) {
			close();
		}
		
		return vo;
	}

	public int adoptWrite(String id, String title, String content, List<String> img) throws Exception {
		int result = 0;
		conn = ds.getConnection();
		result = dao.adoptWrite(conn, id, title, content, img);
		close();
		
		return result;
	}

	public int adoptUpdate(String title, String content, int adopt_no, List<String> saveFiles) throws Exception {
		int result = 0;
		result = dao.adoptUpdate(conn, title, content, adopt_no, saveFiles);
		if (result != 0) {
			close();
		}

		return result;
	}

	public int adoptDelete(int adopt_no) throws Exception {
		int result = 0;
		result = dao.adoptDelete(conn, adopt_no);
		if (result != 0) {
			close();
		}

		return result;
	}

	public static int getBoardCount() throws Exception {
		int result = new AdoptDAO().getBoardCount(conn);

		return result;
	}

	public static int getSearchBoardCount(String searchWord) throws Exception {																						// 글 개수
		int result = new AdoptDAO().getSearchBoardCount(searchWord, conn);
		
		return result;
	}

	public AdoptVO reply_view(String adopt_no) {
		AdoptVO vo = null;
		vo = dao.reply_view(conn, adopt_no);
		if(vo != null) {
			close();
		}
		
		return vo;
	}
	
	public int reply(String id, String adopt_title, String adopt_content,  
			String ref, String ref_step, String ref_level) {
		int result = 0;
		result = dao.reply(conn, id, 
				adopt_title, adopt_content, ref, ref_step, ref_level);
		
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
