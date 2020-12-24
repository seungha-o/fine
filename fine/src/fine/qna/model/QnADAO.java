package fine.qna.model;

// (R*3) -> (C -> U -> D)*2
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QnADAO {
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

	public List<QnAVO> qnaList(Connection conn, int start, int end) throws SQLException, Exception {
		List<QnAVO> list = null;
		String sql = "SELECT *"
				+ " FROM (SELECT ROWNUM rnum, q.* FROM (SELECT * FROM qna ORDER BY qna_write_date DESC) q)"
				+ " WHERE rnum >= ? AND rnum <= ?" + " ORDER BY ref desc, ref_level, ref_step";

		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, start);
		pstmt.setInt(2, end);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			list = new ArrayList<QnAVO>();
			do {
				QnAVO vo = new QnAVO();
				vo.setQna_no(rs.getInt("qna_no"));
				vo.setId(rs.getString("id"));
				vo.setQna_title(rs.getString("qna_title"));
				vo.setQna_statement(rs.getString("qna_statement").charAt(0));
				vo.setQna_count(rs.getInt("qna_count"));
				vo.setQna_write_date(rs.getDate("qna_write_date"));

				list.add(vo);
			} while (rs.next());
			close(rs, pstmt);
		}
		return list;
	}

	public List<QnAVO> qnaSearch(Connection conn, String searchWord, int start, int end)
			throws SQLException, Exception {
		List<QnAVO> list = null;
		String sql = "select * from(select rownum rnum, d.* from "
				+ "(select * from qna where qna_title like ? order by qna_no desc) d) "
				+ "where rnum >= ? and rnum <= ?";

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%" + searchWord + "%");
		pstmt.setInt(2, start);
		pstmt.setInt(3, end);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			list = new ArrayList<QnAVO>();
			do {
				QnAVO vo = new QnAVO();
				vo.setQna_no(rs.getInt("qna_no"));
				vo.setId(rs.getString("id"));
				vo.setQna_title(rs.getString("qna_title"));
				vo.setQna_statement(rs.getString("qna_statement").charAt(0));
				vo.setQna_count(rs.getInt("qna_count"));
				vo.setQna_write_date(rs.getDate("qna_write_date"));

				list.add(vo);
			} while (rs.next());
		}
		close(rs, pstmt);
		return list;
	}

	public QnAVO qnaDetail(Connection conn, int strQna_no) {
		QnAVO vo = null;
		try {
			upCount(conn, strQna_no);
			String sql = "SELECT * FROM qna where qna_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, strQna_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new QnAVO();
				vo.setQna_no(rs.getInt("qna_no"));
				vo.setId(rs.getString("id"));
				vo.setQna_title(rs.getString("qna_title"));
				vo.setQna_contents(rs.getString("qna_contents"));
				vo.setQna_statement(rs.getString("qna_statement").charAt(0));
				vo.setQna_pass(rs.getString("qna_pass"));
				vo.setQna_count(rs.getInt("qna_count"));
				vo.setQna_write_date(rs.getDate("qna_write_date"));
				vo.setRef(rs.getInt("ref"));
				vo.setRef_step(rs.getInt("ref_step"));
				vo.setRef_level(rs.getInt("ref_level"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			String sql = "SELECT * FROM tbl_img where qna_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, strQna_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				List<String> imgList = new ArrayList<String>();
				do {
					imgList.add(rs.getString("img"));
				} while (rs.next());
				vo.setQna_img(imgList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		close(rs, pstmt);
		return vo;
	}

	public int qnaWrite(Connection conn, String id, String title, String content, String pass, List<String> img) {
		int result1 = 0;
		int result2 = 0;
		String sql = "insert into qna (qna_no, id, Qna_title, Qna_contents, Qna_pass, ref, ref_step, ref_level)"
				+ "values (QNA_SEQ.nextval, ?, ?, ?, ?, QNA_SEQ.currval, 0, 0 )";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setString(4, pass);
			result1 = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}
		// ------------------------------------
		for (int i = 0; i < img.size(); i++) {
			sql = "INSERT INTO tbl_img (img_no, qna_no, img) VALUES(img_seq.nextval, QNA_SEQ.currval, ? )";
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

	public int qnaUpdate(Connection conn, String title, String content, int qna_no, List<String> saveFiles) throws SQLException, Exception {
		int result = 0;
		String sql = "UPDATE qna SET Qna_title = ?, Qna_contents = ? " + "WHERE qna_no = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, qna_no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}

		return result;
	}

	public int qnaDelete(Connection conn, int qna_no) throws SQLException, Exception {
		int result1 = 0;
		int result2 = 0;
		String sql = "DELETE FROM qna WHERE qna_no = ?";
//		INSERT INTO tbl_img (img_no, qna_no, img) VALUES(img_seq.nextval, QNA_SEQ.currval, ?)
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, qna_no);

		result1 = pstmt.executeUpdate();

		close(rs, pstmt);
		return result1;
	}

	public int getBoardCount(Connection conn) throws SQLException, Exception {
		// qna 목록 페이징 - qna 총 글 개수
		int cnt = 0;
		String sql = "select COUNT(*) from qna";
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
		String sql = "select COUNT(*) from qna where qna_title like ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%" + searchWord + "%");
		rs = pstmt.executeQuery();
		if (rs.next()) {
			count = rs.getInt(1);
		}
		close(rs, stmt);
		return count;
	}

	public QnAVO reply_view(Connection conn, String qna_no) {
		QnAVO vo = null;
		String query = "SELECT * FROM qna WHERE qna_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(qna_no));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new QnAVO();
				vo.setQna_no(rs.getInt("qna_no"));
				vo.setId(rs.getString("id"));
				vo.setQna_title(rs.getString("qna_title"));
				vo.setQna_contents(rs.getString("qna_contents"));
				vo.setQna_statement(rs.getString("qna_statement").charAt(0));
				vo.setQna_pass(rs.getString("qna_pass"));
				vo.setQna_count(rs.getInt("qna_count"));
				vo.setQna_write_date(rs.getDate("qna_write_date"));
				vo.setRef(rs.getInt("ref"));
				vo.setRef_step(rs.getInt("ref_step"));
				vo.setRef_level(rs.getInt("ref_level"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vo;
	}

	public int reply(Connection conn, String id, String qna_title, String qna_contents, String pass, String ref,
			String ref_step, String ref_level) {
		replyShape(conn, ref, ref_step);

		int result = 0;

		try {
			String sql = "insert into qna (qna_no, id, Qna_title, Qna_contents, Qna_pass, ref, ref_step, ref_level)"
					+ " values (QNA_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, qna_title);
			pstmt.setString(3, qna_contents);
			pstmt.setString(4, pass);
			pstmt.setInt(5, Integer.parseInt(ref));
			pstmt.setInt(6, Integer.parseInt(ref_step) + 1);
			pstmt.setInt(7, Integer.parseInt(ref_level) + 1);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	private void replyShape(Connection conn, String ref, String ref_step) {
		try {
			String query = "update qna set ref_step = ref_step + 1 where ref = ? and ref_step > ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(ref));
			pstmt.setInt(2, Integer.parseInt(ref_step));

			int rn = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int upCount(Connection conn, int strQna_no) throws SQLException, Exception {
		String sql = "update qna set qna_count = qna_count + 1 where qna_no = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, strQna_no);

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
