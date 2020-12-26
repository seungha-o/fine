package fine.notice.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fine.notice.model.NoticeDAO;
import fine.notice.model.NoticeVO;

public class NoticeService {
	private DataSource ds = null;
	private Connection conn = null;
	private static NoticeDAO dao = new NoticeDAO();
	public NoticeService() {
		try {
			Context context = new InitialContext();
			Context env = (Context) context.lookup("java:/comp/env");
			ds = (DataSource) env.lookup("jdbc/myoracles");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int writeNotice(String id,  String title, String contents, List<String> img, int pin) {
		int result = 0;
		int count = 0;
		try {
			conn = ds.getConnection();
			count = dao.getCountNotice(conn);
			System.out.println(count);
			if (count > 4) {
				System.out.println("a");
				result = -1;
				System.out.println(result);
			}
			result = dao.writeNotice(conn, id, title, contents, img, pin);
			close();
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
		}return result;
	}
	public NoticeVO detailNotice(int no) {
		NoticeVO vo = null;
		try {
			conn = ds.getConnection();
			vo = dao.detailNotice(conn, no);
		if (vo !=null) 
			close();
		}catch(Exception e) {
			e.printStackTrace();
		}return vo;
		
	}
	public List<NoticeVO> listNotice() {
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		try {
			conn = ds.getConnection();
			list = dao.listNotice(conn);
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int getSearchBoardCount(String word) {
		int result = 0;
		try {
			conn = ds.getConnection();
			result = dao.getSerchBoardCount(conn, word);
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<NoticeVO> searchNotice(String word, int startRnum, int endRnum) {
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		try {
			conn = ds.getConnection();
			list = dao.SearchNotice(conn, word, startRnum, endRnum);
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int getBoardCount() throws SQLException {
		conn = ds.getConnection();
		int result = new NoticeDAO().getBoardCount(conn);
		conn.close();
		return result;
	}
	

	public List<NoticeVO> getBoardPage(int start, int end) throws SQLException {
		conn = ds.getConnection();
		List<NoticeVO> list = new NoticeDAO().getBoardPage(conn, start, end);
		conn.close();
		return list;
	}
	public int DeleteNotice(int no) {
		int result = 0;
		try {
			conn = ds.getConnection();
			result = dao.DeleteNotice(conn, no);
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int upCount(int no) throws Exception {
		conn = ds.getConnection();
		int result = dao.upCount(conn, no);
		conn.close();
		return result;
	}

	public int UpdateNotice(String title, String content, int no, List<String> img) {
		int result = 0;
		try {
			conn = ds.getConnection();
			result = dao.UpdateNotice(conn, title, content, no, img);
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	public int getCountNotice()  throws Exception {
		int result = 0;
		conn = ds.getConnection();
		result = dao.getCountNotice(conn);
		conn.close();
		return result;
	}

}
