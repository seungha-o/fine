package fine.notice.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NoticeDAO {
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	private void close(ResultSet rs, PreparedStatement pstmt) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	public int upload(String fileName, String fileRealName) {
//		String sql = "INSERT INTO notice (notice_no, notice_title, notice_contents, notice_img, notice_count) VALUES(notice_no_seq.nextval, ?, ?,?, 0)";
//	}
	// 글입력
	public int getCountNotice(Connection conn) {
		int count = 0;
		String sql = "select count(pin) from notice where pin=1" ;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs, pstmt);
		}
		return count;
	}
	public int writeNotice(Connection conn, String title, String contents, List<String> img, int pin) {
		int result1 = 0;
		int result2 = 0;
		String query = "INSERT INTO notice (notice_no, notice_title, notice_contents,notice_count,pin) VALUES(notice_no_seq.nextval, ?, ?, 0, ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, contents);
			pstmt.setInt(3, pin);
			result1 = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		} 
		if (img == null) {
			result2 =1;
		}else {
		for (int i = 0; i < img.size(); i++) {
			query = "INSERT INTO tbl_img (img_no, notice_no, img) VALUES(img_seq.nextval, notice_no_seq.currval, ? )";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, (String)img.get(i));
				result2 = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs, pstmt);
			}
		}
		}
		if (result1 != 0 && result2 != 0 ) 
			return 1;
			else return 0;
	}

	public List<NoticeVO> listNotice(Connection conn) {
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		String sql = "select * from notice order by pin desc, notice_write_date desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				NoticeVO vo = new NoticeVO();
				vo.setNotice_no(rs.getInt("notice_no"));
				vo.setId(rs.getString("id"));
				vo.setNotice_count(rs.getInt("notice_count"));
				vo.setNotice_title(rs.getString("notice_title"));
				vo.setNotice_contents(rs.getString("notice_contents"));
				vo.setNotice_write_date(rs.getTimestamp("Notive_write_date"));
				vo.setPin(rs.getInt("pin"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<NoticeVO> SearchNotice(Connection conn, String word, int startRnum, int endRnum) {
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		String sql = "select * from(select rownum rnum, d.* from "
				+ "(select * from notice where notice_title like ? order by pin desc, notice_no desc) d) "
				+ "where rnum >= ? and rnum <= ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + word + "%");
			pstmt.setInt(2, startRnum);
			pstmt.setInt(3, endRnum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list = new ArrayList<NoticeVO>();
				do {
					NoticeVO vo = new NoticeVO();
					vo.setNotice_no(rs.getInt("notice_no"));
					vo.setId(rs.getString("id"));
					vo.setNotice_count(rs.getInt("notice_count"));
					vo.setNotice_title(rs.getString("notice_title"));
					vo.setNotice_contents(rs.getString("notice_contents"));
					vo.setNotice_write_date(rs.getTimestamp("Notive_write_date"));
					list.add(vo);
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}
		return list;
	}

	public int getSerchBoardCount(Connection conn, String word) {
		int count = 0;
		String sql = "SELECT count(*) " + "FROM notice WHERE notice_title LIKE ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + word + "%");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}
		return count;
	}

	// 공지사항 목록 페이징 - 공지사항 총 글 개수
	public int getBoardCount(Connection conn) throws SQLException {
		int cnt = 0;
		String sql = "select COUNT(*) from notice";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				cnt = rs.getInt(1);
			}
		} finally {
			close(rs, pstmt);
		}
		return cnt;
	}

	// 공지사항 목록
	public List<NoticeVO> getBoardPage(Connection conn, int start, int end) throws SQLException {
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		NoticeVO vo = null;
		String sql = "select * from (select ROWNUM rnum, n.* from (select * from notice order by pin desc, notice_no desc) n) where rnum >= ? and rnum <= ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					vo = new NoticeVO();
					vo.setNotice_no(rs.getInt("notice_no"));
					vo.setId(rs.getString("id"));
					vo.setNotice_count(rs.getInt("notice_count"));
					vo.setNotice_title(rs.getString("notice_title"));
					vo.setNotice_contents(rs.getString("notice_contents"));
					vo.setNotice_write_date(rs.getTimestamp("notive_write_date"));
					list.add(vo);
				} while (rs.next());
			}
		} finally {
			close(rs, pstmt);
		}
		return list;
	}

	public NoticeVO detailNotice(Connection conn, int no) {
		NoticeVO vo = new NoticeVO();
		try {
			upCount(conn, no);
			String sql = "SELECT * FROM notice where notice_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo.setNotice_no(rs.getInt("notice_no"));
				vo.setId(rs.getString("id"));
				vo.setNotice_count(rs.getInt("notice_count"));
				vo.setNotice_title(rs.getString("notice_title"));
				vo.setNotice_contents(rs.getString("notice_contents"));
				vo.setNotice_write_date(rs.getTimestamp("Notive_write_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String sql = "SELECT * FROM tbl_img where notice_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				List<String> imgList = new ArrayList<String>();
				do {
					imgList.add(rs.getString("img"));
				} while(rs.next());
				vo.setNotice_img(imgList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close(rs, pstmt);
		return vo;
	}

	public int DeleteNotice(Connection conn, int no) {
		// NoticeVO vo = new NoticeVO();
		String sql = "DELETE FROM notice WHERE notice_no = ?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}
		return result;
	}

	public int UpdateNotice(Connection conn, String title, String content, int no , List<String> img) {
		String sql = "update notice set notice_title = ?, notice_contents = ?" + "where notice_no = ?";
		int result = 0;
		int result2 = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}
		for (int i = 0; i < img.size(); i++) {
			sql = "update tbl_img set img = ? where notice_no = ? ";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, (String)img.get(i));
				pstmt.setInt(2, no);
				System.out.println(img);
				result2 = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs, pstmt);
			}
		}
		if (result != 0 && result2 != 0 ) 
			return 1;
			else return 0;
	}
	public int upCount(Connection conn, int no) throws SQLException, Exception {
		String sql = "update notice set notice_count = notice_count + 1 where notice_no = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		int result = pstmt.executeUpdate();
		close(rs, pstmt);
		return result;
	}
}
