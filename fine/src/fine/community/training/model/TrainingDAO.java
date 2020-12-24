package fine.community.training.model;

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

public class TrainingDAO {
	private DataSource ds = null; // ds는 아파치에서 제공하는 DB Connection pool이다.
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	public TrainingDAO() {
		Context initContext1;
		try {
			initContext1 = new InitialContext();
			/* Context envContext1 = (Context) initContext1.lookup("java:/comp/env"); 분리해두면 다른 db사용시에  이 객체만 호출해 사용하면 된다. */
			ds = (DataSource) initContext1.lookup("java:/comp/env/jdbc/myoracles");
	
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void close() {
		try{
		if(conn!=null) {
			conn.close();
			conn=null;
		}
		if(pstmt!=null) {
			pstmt.close();
			pstmt=null;
		}
		if(rs!=null) {
			rs.close();
			rs=null;
		}
	}catch (SQLException e) {
		// TODO: handle exception
	}
		
	}
	
	
	
	public List<TrainingVO> getSearchPage(int startRnum, int endRnum, String kwd, Connection conn) {
		 List<TrainingVO> list = new ArrayList<TrainingVO>();
	     String sql = "select * from(select rownum rnum, d.* from "
	     		+ "(select * from training where trn_title like ? order by trn_no desc) d) "
	     		+ "where rnum >= ? and rnum <= ?";
	     try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+kwd+"%");
			pstmt.setInt(2, startRnum);
	        pstmt.setInt(3, endRnum);
			rs = pstmt.executeQuery();
			System.out.println("ㅎㅇㅎㅇ");
			if(rs.next()) {
				do {
					TrainingVO vo = new TrainingVO();
					vo.setTrn_no(rs.getInt("trn_no"));
					vo.setTrn_title(rs.getString("trn_title"));
					vo.setContent(rs.getString("content"));
					vo.setWrite_date(rs.getDate("write_date"));
					vo.setMedia(rs.getString("media"));
					list.add(vo);
				}while(rs.next());
		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		 return list;
	}
	
	
	public List<TrainingVO> getBoardByPage(int startRnum, int endRnum, Connection conn) {
		 List<TrainingVO> list = new ArrayList<TrainingVO>();
	     String sql = "select * from(select rownum rnum, d.* from (select * from training order by trn_no desc) d) where rnum >= ? and rnum <= ?";
	     try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRnum);
	        pstmt.setInt(2, endRnum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					TrainingVO vo = new TrainingVO();
					vo.setTrn_no(rs.getInt("trn_no"));
					vo.setTrn_title(rs.getString("trn_title"));
					vo.setContent(rs.getString("content"));
					vo.setWrite_date(rs.getDate("write_date"));
					vo.setMedia(rs.getString("media"));
					list.add(vo);
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
	    String sql = "select count(*) from training";
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
	public int getBoardCounts(String kwd) {
		int cnt = 0;
	    String sql = "select count(*) from training where trn_title like ?";
	    try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+kwd+"%");
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
	
	public int training_Write(TrainingVO vo, Connection conn) {
		int result = 0;
		String sql = "insert into training values(SEQ_NO.NEXTVAL,?,?,sysdate,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTrn_title());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getMedia());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("실패!");
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
		
	}

	public List<TrainingVO> getTrainingInfo(int no, Connection conn) {
		 List<TrainingVO> list = new ArrayList<TrainingVO>();
	     String sql = "select * from training where trn_no = ?";
	     try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					TrainingVO vo = new TrainingVO();
					vo.setTrn_no(rs.getInt("trn_no"));
					vo.setTrn_title(rs.getString("trn_title"));
					vo.setContent(rs.getString("content"));
					vo.setWrite_date(rs.getDate("write_date"));
					vo.setMedia(rs.getString("media"));
					list.add(vo);
					System.out.println(list);
					}while(rs.next());
			}
		} catch (SQLException e) {
			System.out.println("실팽");
			e.printStackTrace();
		}finally {
			close();
		}
	     
		return list;
	}

	public int trainingDelete(Connection conn, TrainingVO vo) {
		int result = 0;
		String sql = "delete from training where trn_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getTrn_no());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return result;
	}

	public void getTrainingFileName(TrainingVO vo, Connection conn) {
	
		String sql = "select media from training where trn_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getTrn_no());
			rs = pstmt.executeQuery();
			if(rs.next()) {
					vo.setMedia(rs.getString("media"));
					System.out.println(vo);
			
			}
			System.out.println("데이터가 없습니다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int trainingUpdate(Connection conn, TrainingVO vo) {
		int result = 0;
		String sql = null;
		if(vo.getMedia() != null) {
			sql = "update training set media = ?, trn_title = ?, content = ? where trn_no = ?";
		}else {
			sql = "update training set trn_title = ?, content = ? where trn_no = ?";
			
		}
		try {
			pstmt = conn.prepareStatement(sql);
			
			if(vo.getMedia()!=null) {
				pstmt.setString(1, vo.getMedia());
				pstmt.setString(2, vo.getTrn_title());
				pstmt.setString(3, vo.getContent());
				pstmt.setInt(4, vo.getTrn_no());	
			}else {
				pstmt.setString(1, vo.getTrn_title());
				pstmt.setString(2, vo.getContent());
				pstmt.setInt(3, vo.getTrn_no());	
			}
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return result;
	}
	
	
	


}
