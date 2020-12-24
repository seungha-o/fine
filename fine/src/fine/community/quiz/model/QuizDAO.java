package fine.community.quiz.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class QuizDAO {
	private DataSource ds = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public QuizDAO() {
		Context iniContext1;

		try {
			iniContext1 = new InitialContext();
			ds = (DataSource) iniContext1.lookup("java:/comp/env/jdbc/myoracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int quiz_Write(QuizVO vo, Connection conn) {
		int result = 0;
		String sql = "insert into quiz values(SEQ_NO2.NEXTVAL,'hcare',?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getQuiz_content()); 
			pstmt.setString(2, vo.getAnswer());
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println("실패!!");
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public int quiz_Delete(int quiz_no, Connection conn) {
		int result = 0;

		String sql = "delete from quiz where quiz_no=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, quiz_no);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close();
		}
		return result;
	}
	
//	public List<QuizVO> quiz_list(int no, Connection conn) {
//		 List<QuizVO> list = new ArrayList<QuizVO>();
//	     String sql = "select * from quiz where quiz_no = ?";
//	     try {
//			pstmt=conn.prepareStatement(sql);
//			pstmt.setInt(1, no);
//			rs=pstmt.executeQuery();
//			if(rs.next()) {
//				do {
//					QuizVO vo = new QuizVO();
//					vo.setQuiz_no(rs.getInt("quiz_no"));
//					vo.setId(rs.getString("id"));
//					vo.setQuiz_content(rs.getString("quiz_content"));
//					vo.setAnswer(rs.getString("answer"));
//					list.add(vo);
//					System.out.println(list);
//					}while(rs.next());
//			}
//		} catch (SQLException e) {
//			System.out.println("실팽");
//			e.printStackTrace();
//		}finally {
//			close();
//		}
//	     
//		return list;
//	}
	
	/*quiz_no	number	PRIMARY KEY ,
	ID	varchar2(15)	NULL,	
	quiz_content varchar2(100) not null,		
	answer	varchar2(100) not null*/

	public List<QuizVO> getQuizList(int startRnum, int endRnum, Connection conn) {
		 List<QuizVO> list = new ArrayList<QuizVO>();
	     String sql = "select * from(select rownum rnum, d.* from (select * from quiz order by quiz_no desc) d) where rnum >= ? and rnum <= ?";
	     try {
	    	System.out.println("DAO"+startRnum);
	    	System.out.println("DAO"+endRnum);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRnum);
			pstmt.setInt(2, endRnum);
	        System.out.println("ㅎㅇ");
			rs = pstmt.executeQuery();
			System.out.println("ㅎㅇㅎㅇ");
			if(rs.next()) {
				do {
					QuizVO vo = new QuizVO();
					vo.setQuiz_no(Integer.parseInt(rs.getString("quiz_no")));
					vo.setId(rs.getString("ID"));
					vo.setQuiz_content(rs.getString("quiz_content"));
					vo.setAnswer(rs.getString("answer"));
					list.add(vo);
					System.out.println(list);
				}while(rs.next());
		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		 return list;
	}

	public int getBoardCount() {
		int cnt = 0;
	    String sql = "select count(*) from quiz";
	    try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					cnt = rs.getInt(1);
				}while(rs.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	    
		return cnt;
		
		
	}
	
	public int getBoardCounts() {
		int cnt = 0;
	    String sql = "select count(*) from(select rownum rnum from quiz) where rnum<=10"; 
	    		
	    try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					cnt = rs.getInt(1);
				}while(rs.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	    
		return cnt;
		
		
	}

	public List<QuizVO> getQuizInfo(int no, Connection conn) {
		List<QuizVO> list = new ArrayList<QuizVO>();
		String sql = "select * from quiz where quiz_no = ?";
		try {	
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					QuizVO vo = new QuizVO();
					
					vo.setQuiz_no(rs.getInt("quiz_no"));
					vo.setQuiz_content(rs.getString("quiz_content"));
					vo.setAnswer(rs.getString("answer"));
					
					list.add(vo);
					System.out.println(list);
				}while(rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	}

	public int quizUpdate(Connection conn,QuizVO vo) {
		String sql = "update quiz set quiz_content = ?,answer =? where quiz_no = ?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getQuiz_content());
			pstmt.setString(2, vo.getAnswer());
			pstmt.setInt(3, vo.getQuiz_no());
			result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("업데이트 완료");
			}else {
				System.out.println("업데이트 실패");
			}
		} catch (Exception e) {
			System.out.println("업데이트 실패");
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}

	public int quizDelete(Connection conn, QuizVO vo) {
		String sql = "delete from quiz where quiz_no=?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getQuiz_no());
			result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("삭제완료");
			}else {
				System.out.println("삭제실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			close();
		}
		return result;
	}

	public List<QuizVO> randomQuizList(Connection conn) {
		List<QuizVO> list = new ArrayList<QuizVO>();
		String sql = "select * from(select * from quiz order by dbms_random.value)where rownum<=10";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("dao까지옴");
			if(rs.next()){
				do {
					QuizVO vo = new QuizVO();
					vo.setId(rs.getString("id"));
					vo.setQuiz_no(rs.getInt("quiz_no"));
					vo.setQuiz_content(rs.getString("quiz_content"));
					vo.setAnswer(rs.getString("answer"));
					list.add(vo);
					System.out.println("dao 와서 담음");
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("dao 와서 못담음");
			e.printStackTrace();
		
		} finally {
			close();
		}
		return list;
	}

	public int updateGrade(int gradeNO,String id, Connection conn) {
		String sql = "update member set grade = ? where id=?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gradeNO);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("업데이트 완료");
			}else {
				System.out.println("업데이트 실패");
			}
		} catch (Exception e) {
			System.out.println("업데이트 실패");
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
}
