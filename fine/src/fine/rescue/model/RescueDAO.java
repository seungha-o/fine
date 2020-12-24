package fine.rescue.model;

// (R*3) -> (C -> U -> D)*2
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RescueDAO {
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	public void close(ResultSet rs, Statement stmt) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<RescueVO> rescueList(Connection conn, int start, int end) throws SQLException, Exception {
		List<RescueVO> list = null;
		String sql = "SELECT *"
				+ " FROM (SELECT ROWNUM rnum, q.* FROM (SELECT * FROM rescue ORDER BY rec_write_date DESC) q)"
				+ " WHERE rnum >= ? AND rnum <= ?" + " ORDER BY ref desc, ref_level, ref_step";

		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, start);
		pstmt.setInt(2, end);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			list = new ArrayList<RescueVO>();
			do {
				RescueVO vo = new RescueVO();
				vo.setRec_no(rs.getInt("Rec_no"));
				vo.setId(rs.getString("id"));
				vo.setRec_title(rs.getString("Rec_title"));
				vo.setRec_count(rs.getInt("Rec_count"));
				vo.setRec_write_date(rs.getDate("Rec_write_date"));

				list.add(vo);
			} while (rs.next());
			close(rs, pstmt);
		}
		return list;
	}

	public List<RescueVO> rescueSearch(Connection conn, String searchWord, int start, int end)
			throws SQLException, Exception {
		List<RescueVO> list = null;
		String sql = "select * from(select rownum rnum, d.* from "
				+ "(select * from rescue where rec_title like ? order by rec_no desc) d) "
				+ "where rnum >= ? and rnum <= ?";

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%" + searchWord + "%");
		pstmt.setInt(2, start);
		pstmt.setInt(3, end);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			list = new ArrayList<RescueVO>();
			do {
				RescueVO vo = new RescueVO();
				vo.setRec_no(rs.getInt("rec_no"));
				vo.setId(rs.getString("id"));
				vo.setRec_title(rs.getString("rec_title"));
				vo.setRec_count(rs.getInt("rec_count"));
				vo.setRec_write_date(rs.getDate("rec_write_date"));

				list.add(vo);
			} while (rs.next());
		}
		close(rs, pstmt);
		return list;
	}

	public RescueVO rescueDetail(Connection conn, int rec_no) {
		RescueVO vo = null;
		try {
			upCount(conn, rec_no);
			String sql = "SELECT * FROM rescue where rec_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rec_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new RescueVO();
				vo.setRec_no(rs.getInt("rec_no"));
				vo.setId(rs.getString("id"));
				vo.setRec_title(rs.getString("rec_title"));
				vo.setRec_contents(rs.getString("rec_contents"));
				vo.setRec_count(rs.getInt("rec_count"));
				vo.setRec_write_date(rs.getDate("rec_write_date"));
				vo.setRef(rs.getInt("ref"));
				vo.setRef_step(rs.getInt("ref_step"));
				vo.setRef_level(rs.getInt("ref_level"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			String sql = "SELECT * FROM tbl_img where rec_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rec_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				List<String> imgList = new ArrayList<String>();
				do {
					imgList.add(rs.getString("img"));
				} while (rs.next());
				vo.setRec_img(imgList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		close(rs, pstmt);
		return vo;
	}
// 여기부터
	public int rescueWrite(Connection conn, String id, String title, String content, List<String> img) {
		int result1 = 0;
		int result2 = 0;
		String sql = "insert into rescue (rec_no, id, rec_title, rec_contents, ref, ref_step, ref_level)"
				+ "values (REC_SEQ.nextval, ?, ?, ?, REC_SEQ.currval, 0, 0 )";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			result1 = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}
		
		// ------------------------------------
		for (int i = 0; i < img.size(); i++) {
			sql = "INSERT INTO tbl_img (img_no, rec_no, img) VALUES(img_seq.nextval, REC_SEQ.currval, ? )";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, (String) img.get(i));
				System.out.println(img);
				result2 = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rs, pstmt);
			}
		}

		if (result1 != 0 && result2 != 0) {
			return 1;
		} else {
			return 0;
		}
	}

	public int rescueUpdate(Connection conn, String title, String content, int rec_no, List<String> saveFiles) throws SQLException, Exception {
		// List<String>을 받아올 필요가 있나??
		int result = 0;
		String sql = "UPDATE rescue SET rec_title = ?, rec_contents = ? WHERE rec_no = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, rec_no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}

		return result;
	}

	public int rescueDelete(Connection conn, int rec_no) throws SQLException, Exception {
		int result = 0;
		String sql = "DELETE FROM rescue WHERE rec_no = ?";

		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, rec_no);

		result = pstmt.executeUpdate();

		close(rs, pstmt);
		return result;
	}

	public int getBoardCount(Connection conn) throws SQLException, Exception {
		int cnt = 0;
		String sql = "select COUNT(*) from rescue";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		if (rs.next()) {
			cnt = rs.getInt(1); // What's that?
		}
		close(rs, stmt);
		return cnt;
	}

	public int getSearchBoardCount(String searchWord, Connection conn) throws SQLException, Exception { // qna 목록 페이징 -
																										// qna 총 글 개수
		int count = 0;
		String sql = "select COUNT(*) from rescue where rec_title like ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%" + searchWord + "%");
		rs = pstmt.executeQuery();
		if (rs.next()) {
			count = rs.getInt(1);
		}
		close(rs, stmt);
		return count;
	}

	public RescueVO reply_view(Connection conn, String adopt_no) {
		RescueVO vo = null;
		String query = "SELECT * FROM rescue WHERE rec_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(adopt_no));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new RescueVO();
				vo.setRec_no(rs.getInt("rec_no"));
				vo.setId(rs.getString("id"));
				vo.setRec_title(rs.getString("rec_title"));
				vo.setRec_contents(rs.getString("rec_contents"));
				vo.setRec_count(rs.getInt("rec_count"));
				vo.setRec_write_date(rs.getDate("rec_write_date"));
				vo.setRef(rs.getInt("ref"));
				vo.setRef_step(rs.getInt("ref_step"));
				vo.setRef_level(rs.getInt("ref_level"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vo;
	}

	public int reply(Connection conn, String id, String rec_title, String rec_contents, String ref,
			String ref_step, String ref_level) {
		replyShape(conn, ref, ref_step);

		int result = 0;

		try {
			String sql = "insert into rescue (rec_no, id, rec_title, rec_contents, ref, ref_step, ref_level)"
					+ " values (REC_SEQ.nextval, ?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, rec_title);
			pstmt.setString(3, rec_contents);
			pstmt.setInt(4, Integer.parseInt(ref));
			pstmt.setInt(5, Integer.parseInt(ref_step) + 1);
			pstmt.setInt(6, Integer.parseInt(ref_level) + 1);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	private void replyShape(Connection conn, String ref, String ref_step) {
		try {
			String query = "update rescue set ref_step = ref_step + 1 where ref = ? and ref_step > ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(ref));
			pstmt.setInt(2, Integer.parseInt(ref_step));

			int rn = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int upCount(Connection conn, int rec_no) throws SQLException, Exception {
		String sql = "update rescue set rec_count = rec_count + 1 where rec_no = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, rec_no);

		int result = pstmt.executeUpdate();
		close(rs, pstmt);

		return result;
	}

}
//	public List<QnAVO> comparePass(Connection conn, int strQna_no, String pass) {
//		List<QnAVO> list = null;
//		QnAVO vo = null;
//		String sql = "SELECT * FROM qna WHERE qna_no = ? AND qna_pass = ?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, strQna_no);
//			pstmt.setString(2, pass);
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				list = new ArrayList<QnAVO>();
//				vo = new QnAVO();
//				vo.setQna_no(strQna_no);
//				vo.setQna_pass(pass);
//				
//				list.add(vo);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return list;
//	}

//	public int qnaComentWrite() {}
//	public int qnaComentDelete() {}
//	public int qnaComentUpdate() {}
