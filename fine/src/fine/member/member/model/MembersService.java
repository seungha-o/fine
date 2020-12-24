package fine.member.member.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MembersService {
	private DataSource ds = null;
	private Connection conn = null;

	// DBCP
	public MembersService() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:/comp/env/jdbc/myoracles");
			try {
				conn = ds.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
//로그인
	public int login(String id, String password) {
		MemberDAO dao = new MemberDAO();
		int result = dao.login(conn, id, password);
		return result;
	}

	// 관리자 MyPage 회원정보 전체 보기 / Admin에서  Page넘버까지
	public List<MemberVO> MyPageListAdmin(int startRnum, int endRnum) {
//		 Connection conn = getConnection();
		List<MemberVO> myPageList = new ArrayList<MemberVO>();
		MemberDAO dao = new MemberDAO();
		myPageList = dao.MyPageListAdmin(startRnum, endRnum, conn);
		dao.close(conn);
		return myPageList;
	}


	// MyPage 일반회원,보호소 직원  로그인한 회원 정보보여줌
	public List<MemberVO> MyPageList(String lev,String id) {
		System.out.println("마이페이지 서비스");
		List<MemberVO> myPageList = new ArrayList<MemberVO>();
		MemberDAO dao = new MemberDAO();
		myPageList = dao.MyPageList(conn, lev,id);
		dao.close(conn);
		return myPageList;
	}
	// 관리자 MyPage 회원정보 전체 보기 / Admin에서 Searchid 와  Page넘버까지
	public List<MemberVO> SearchId(int startRnum, int endRnum, String SearchId) {
		List<MemberVO> searchPageList = new ArrayList<MemberVO>();
		MemberDAO dao = new MemberDAO();
		searchPageList = dao.SearchId(conn,startRnum, endRnum, SearchId);	
		dao.close(conn);
		return searchPageList;
	}

	public int getMyPageCount(){
		MemberDAO dao = new MemberDAO();
		int result = dao.getMyPageCount(conn);
		
		return result;
	}

	// 기존 사용자를 탈퇴시 DB에서 삭제요청시
	public int checkDeleteMember(String id, String password) throws SQLException {
		MemberDAO dao = new MemberDAO();
		int result = dao.checkDeleteMember(conn, id, password);
//		if(result > 0) {	
//			conn.commit();
//	      }else {
//	    	conn.rollback();
//	      }

		return result;
	}
//비밀번호 체크 후 삭제
	public int deleteMember(String id) {
		MemberDAO dao = new MemberDAO();
		int result = 0;
		result = dao.deleteMember(id, conn);
		dao.close(conn);
		return result;
	}
	// 마이페이지 정보수정
	public int updateMember(MemberVO vo , String id ) throws SQLException {
		System.out.println("업데이트 서비스");
		MemberDAO dao = new MemberDAO();
		int result = 0;
		result = dao.updateMember(conn, vo, id);
		dao.close(conn);
		return result;
	}


	// 탈퇴 시 다시 비밀번호 체크 Form
	public int PwCheck(String id, String password) {
		MemberDAO dao = new MemberDAO();
		int result = dao.login(conn, id, password);
		dao.close(conn);
		return result;
	}

	public String memberLev(String id) {
		System.out.println("===================");
		MemberDAO dao = new MemberDAO();
		String result = dao.memberLev(conn, id);
		dao.close(conn);
		return result;
	}

//여기부터 주형씨 소스  
//회원가입
//	public int memberRegister(MemberVO vo , int a) {
//		MemberDAO dao = new MemberDAO();
//		int result = dao.memberRegister(conn,vo,a);
//		if(result > 0) {
//			
//		}
//		return result;
//	}
	

	public Boolean idCheck(String id) throws SQLException {
		MemberDAO dao = new MemberDAO();
		boolean result = dao.idCheck(conn, id);
		return result;
	}
	//여기부터 주형씨 소스  	
//	public Boolean emailCheck(String email) throws SQLException {
//		MemberDAO dao = new MemberDAO();
//		boolean result = dao.emailCheck(conn, email);
//		return result;
//	}
//
//	public Boolean phoneCheck(String phone) throws SQLException {
//		MemberDAO dao = new MemberDAO();
//		boolean result = dao.phoneCheck(conn, phone);
//		return result;
//	}
	public int PwCheck2(String id, String password) {
		MemberDAO dao = new MemberDAO();
		int result = dao.login(conn, id, password);
		return result;
	}
	public int adminDelete(String id) {
		MemberDAO dao = new MemberDAO();
		int result = dao.adminDelete(conn, id);
		return result;
	}
	
}
