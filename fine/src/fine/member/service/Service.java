package fine.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fine.member.member.model.MemberDAO;
import fine.member.member.model.MemberVO;

public class Service {
	private DataSource ds = null;
	private Connection conn = null;
	public Service() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:/comp/env/jdbc/myoracles");
			try {
				conn = ds.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}	
		}
	

	
	public List<MemberVO> memberList() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberDAO dao = new MemberDAO();
		list = dao.list_all(conn);
		dao.close(conn);
		return list;
	}
	
	public int memberRegister(MemberVO vo ,int a) {
		MemberDAO dao = new MemberDAO();
		int result = dao.memberRegister(conn,vo,a);
		dao.close(conn);
		return result;
	}
	public Boolean idCheck(String id) throws SQLException {
		MemberDAO dao = new MemberDAO();
		boolean result = dao.idCheck(conn, id);
		dao.close(conn);
		return result;
	}
	public Boolean emailCheck(String email) throws SQLException  {
		MemberDAO dao = new MemberDAO();
		boolean result = dao.emailCheck(conn, email);
		dao.close(conn);
		return result;
	}
	public Boolean phoneCheck(String phone) throws SQLException  {
		MemberDAO dao = new MemberDAO();
		boolean result = dao.phoneCheck(conn, phone);
		dao.close(conn);
		return result;
	}
	public int login(String id, String pw) {
		MemberDAO dao = new MemberDAO();
		int result = dao.login(conn,id,pw);
	
		return result;
	}
	public int emailCodeCheck(String emailcode) throws SQLException  {
		MemberDAO dao = new MemberDAO();
		int result = dao.emailCodeCheck(conn, emailcode);
		dao.close(conn);
		return result;
	}
	public String findId(String email) throws SQLException  {
		MemberDAO dao = new MemberDAO();
		String result = dao.findId(conn, email);
		dao.close(conn);
		return result;
	}
	public int findPw(String email, String id) throws SQLException {
		MemberDAO dao = new MemberDAO();
		int result = dao.findPw(conn,email,id); 
		dao.close(conn);
		return result;
	}
	public int changePw(String randpwd ,String to) throws SQLException {
		MemberDAO dao = new MemberDAO();
		int result = dao.changePw(conn, randpwd, to);
		dao.close(conn);
		return result;
	}
	public String memberLev(String id)  {
		System.out.println("vo옮");
		MemberDAO dao = new MemberDAO();
		String result = dao.memberLev(conn,id);
		dao.close(conn);
		return result;
	}
	

}
