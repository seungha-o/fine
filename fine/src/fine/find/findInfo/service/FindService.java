package fine.find.findInfo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import fine.community.training.model.TrainingDAO;
import fine.community.training.model.TrainingVO;
import fine.find.findInfo.model.FindDAO;
import fine.find.findInfo.model.FindVO;
import fine.jdbc.JdbcTemplate;

public class FindService {
	private DataSource ds = null; // ds는 아파치에서 제공하는 DB Connection pool이다.
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	public FindService() {
	}
	
	public int insertNoticeSysDate() {
		conn = JdbcTemplate.getConnection(conn, ds);
		int result = 0;
		FindDAO dao = new FindDAO();
		result = dao.insertNoticeSysDate(conn, pstmt);
		JdbcTemplate.close(conn, pstmt, rs);				
		return result;
		
		
	}
	public int getBoardCount() {
		int result = 0;
		FindDAO dao = new FindDAO();
		conn = JdbcTemplate.getConnection(conn, ds);
		result = dao.getBoardCount(conn, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);				
		return result;
	}
	public List<FindVO> getFindInfo(int startRnum, int endRnum) {
		conn = JdbcTemplate.getConnection(conn, ds);
		List<FindVO> list = new ArrayList<FindVO>();
		FindDAO dao = new FindDAO();
		list = dao.getFindInfo(startRnum, endRnum, conn, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);				
		return list;
	}

	public List<FindVO> getFindDetail(int no) {
		conn = JdbcTemplate.getConnection(conn, ds);
		FindDAO dao = new FindDAO();
		List<FindVO> list = new ArrayList<FindVO>();
		list = dao.getFindInfo(no, conn, pstmt, rs);
		System.out.println("============================");
		System.out.println(list);
		JdbcTemplate.close(conn, pstmt, rs);				
		return list;
	}

	public int getSearchBoardCount(String address, String dogKind, String happenDt) {
		System.out.println("서비스 : "+address);
		System.out.println("서비스 : "+dogKind);
		System.out.println("서비스 : "+happenDt);
		int count = 0;
		FindDAO dao = new FindDAO();
		conn = JdbcTemplate.getConnection(conn, ds);
		count = dao.getSearchBoardCount(address,dogKind,happenDt,conn, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);				
		return count;
	}

	public List<FindVO> getSearchDogPage(int startRnum, int endRnum, String address, String dogKind, String happenDt) {
		conn = JdbcTemplate.getConnection(conn, ds);
		FindDAO dao = new FindDAO();
		List<FindVO> list = new ArrayList<FindVO>();
		list = dao.getSearchDogPage(address, dogKind,happenDt, startRnum, endRnum, conn, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);				
		return list;
	}

	public List<FindVO> getFindAdoptInfo(int startRnum, int endRnum) {
		conn = JdbcTemplate.getConnection(conn, ds);
		FindDAO dao = new FindDAO();
		List<FindVO> list = new ArrayList<FindVO>();
		list = dao.getFindAdoptInfo(startRnum, endRnum, conn, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);				
		return list;
	}

	public int getAdoptListCount() {
		int count = 0;
		FindDAO dao = new FindDAO();
		conn = JdbcTemplate.getConnection(conn, ds);
		count = dao.getAdoptListCount(conn, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);				
		return count;
		}

	public int getAdoptSearchBoardCount(String address, String dogKind) {
		int count = 0;
		FindDAO dao = new FindDAO();
		conn = JdbcTemplate.getConnection(conn, ds);
		count = dao.getAdoptSearchBoardCount(address,dogKind,conn, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);				
		return count;
	}

	public List<FindVO> getAdoptSearchDogPage(int startRnum, int endRnum, String address, String dogKind) {
		conn = JdbcTemplate.getConnection(conn, ds);
		FindDAO dao = new FindDAO();
		List<FindVO> list = new ArrayList<FindVO>();
		list = dao.getAdoptSearchDogPage(address, dogKind,startRnum, endRnum, conn, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);				
		return list;
	}

	public int getManageAdoptBoardCount(String checkId, String lev) {
		int result = 0;
		FindDAO dao = new FindDAO();
		conn = JdbcTemplate.getConnection(conn, ds);
		result = dao.getManageAdoptBoardCount(checkId, lev, conn, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);				
		return result;
	}

	public List<FindVO> getFindManageList(String checkId, String lev, int startRnum, int endRnum) {
		conn = JdbcTemplate.getConnection(conn, ds);
		FindDAO dao = new FindDAO();
		List<FindVO> list = new ArrayList<FindVO>();
		list = dao.getFindManageList(checkId, lev, startRnum, endRnum, conn, pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);				
		return list;
	}

	public int FindMangerWrite(String checkId, FindVO vo) {
		System.out.println(checkId);
		conn = JdbcTemplate.getConnection(conn, ds);
		int result = 0;
		FindDAO dao = new FindDAO();
		result = dao.FindMangerWrite(checkId, vo, conn, pstmt);
		JdbcTemplate.close(conn, pstmt, rs);				
		return result;
	}

	public void FindDeleteFileName(FindVO vo) {
		conn = JdbcTemplate.getConnection(conn, ds);
		FindDAO dao = new FindDAO();
		dao.FindDeleteFileName(vo, conn,pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);				
	}

	public int FindDelete(FindVO vo) {
		conn = JdbcTemplate.getConnection(conn, ds);
		FindDAO dao = new FindDAO();
		int result = 0;
		result = dao.findDelete(conn, vo,pstmt, rs);
		JdbcTemplate.close(conn, pstmt, rs);				
		return result;
	}

	


}
