package fine.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JdbcTemplate {
	
	
	public JdbcTemplate() {
		
		
	}
	public static Connection getConnection(Connection conn, DataSource ds) {
		try {
			Context ctx = new InitialContext();
			Context ctx1 = (Context) ctx.lookup("java:/comp/env");
			ds = (DataSource) ctx1.lookup("jdbc/myoracles");
			try {
				conn = ds.getConnection();
				System.out.println(conn);
				System.out.println("연결!");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Connection 실패!");
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	public void close(Connection conn, PreparedStatement pstmt) {
		try{
		if(conn!=null) {
			conn.close();
			conn=null;
			System.out.println("conn닫음!!");
		}
		if(pstmt!=null) {
			pstmt.close();
			pstmt=null;
			System.out.println("pstmt닫음!!");
		}
	
	}catch (SQLException e) {
		// TODO: handle exception
	}
		
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try{
		if(conn!=null) {
			conn.close();
			conn=null;
			System.out.println("conn닫음!!");
		}
		if(pstmt!=null) {
			pstmt.close();
			pstmt=null;
			System.out.println("pstmt닫음!!");
		}
		if(rs!=null) {
			rs.close();
			rs=null;
			System.out.println("rs닫음!!");
		}
	}catch (SQLException e) {
		// TODO: handle exception
	}
		
	}
	
}
