package fine.qna.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import fine.qna.model.QnADAO;
import fine.qna.model.QnAVO;

public class QnAService {
	private static DataSource ds = null;
	private static Connection conn = null;
	private static QnADAO dao = new QnADAO();

	public QnAService() {
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

	public static List<QnAVO> qnaList(int start, int end) throws Exception {
		List<QnAVO> list = null;
		list = dao.qnaList(conn, start, end);
		
		return list;
	}

	public static List<QnAVO> qnaSearch(String searchWord, int start, int end) throws Exception {
		List<QnAVO> list = null;
		list = dao.qnaSearch(conn, searchWord, start, end);
		return list;
	}

	public QnAVO qnaDetail(int strQna_no) throws Exception {
		QnAVO vo = null;
		vo = dao.qnaDetail(conn, strQna_no);
		if(vo != null) {
			close();
		}
		
		return vo;
	}

	public int qnaWrite(String id, String title, String content, String pass, List<String> img) throws Exception {
		int result = 0;
		conn = ds.getConnection();
		result = dao.qnaWrite(conn, id, title, content, pass, img);
		close();
		
		return result;
	}

	public int qnaUpdate(String title, String content, int qna_no, List<String> saveFiles) throws Exception {
		int result = 0;
		result = dao.qnaUpdate(conn, title, content, qna_no, saveFiles);
		if (result != 0) {
			close();
		}

		return result;
	}

	public int qnaDelete(int qna_no) throws Exception {
		int result = 0;
		result = dao.qnaDelete(conn, qna_no);
		if (result != 0) {
			close();
		}

		return result;
	}

	public static int getBoardCount() throws Exception {
		int result = new QnADAO().getBoardCount(conn);

		return result;
	}

	public static int getSearchBoardCount(String searchWord) throws Exception {																						// 글 개수
		int result = new QnADAO().getSearchBoardCount(searchWord, conn);
		
		return result;
	}

	public QnAVO reply_view(String qna_no) {
		QnAVO vo = null;
		vo = dao.reply_view(conn, qna_no);
		if(vo != null) {
			close();
		}
		
		return vo;
	}
	
	public int reply(String id, String qna_title, String qna_content, String pass, 
			String ref, String ref_step, String ref_level) {
		int result = 0;
		result = dao.reply(conn, id, 
				qna_title, qna_content, pass, ref, ref_step, ref_level);
		
		return result;
	}
//	public int qnaComentWrite() {}
//	public int qnaComentDelete() {}
//	public int qnaComentUpdate() {}
	
//	public List<QnAVO> comparePass(int strQna_no, String pass) {
//		List<QnAVO> list = null;
//		list = dao.comparePass(conn, strQna_no, pass);
//		
//		return list;
//	}
}

























