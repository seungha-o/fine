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




	public List<QnAVO> qnaList(Connection conn, PreparedStatement pstmt, ResultSet rs, int start, int end) throws SQLException, Exception {
		List<QnAVO> list = null;
		String sql = "SELECT *"
				+ " FROM (SELECT ROWNUM rnum, q.* FROM (SELECT * FROM qna where ref_step = 0 and ref_level = 0 ORDER BY qna_write_date DESC) q)"
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
			
		}
		return list;
	}

	public List<QnAVO> qnaSearch(Connection conn, PreparedStatement pstmt, ResultSet rs, String searchWord, int start, int end)
			throws SQLException, Exception {
		List<QnAVO> list = null;
		String sql = "select * from(select rownum rnum, d.* from "
				+ "(select * from qna where qna_title like ? and ref_step = 0 and ref_level = 0 order by qna_no desc) d) "
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
		
		return list;
	}

	public QnAVO qnaDetail(Connection conn, int strQna_no, PreparedStatement pstmt, ResultSet rs) {
		QnAVO vo = null;
		try {
			upCount(conn, strQna_no,pstmt,rs);
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

		
		return vo;
	}

	public int qnaWrite(Connection conn, String id, String title, String content, String pass, List<String> img,int passState, PreparedStatement pstmt, ResultSet rs) {
		int result1 = 0;
		int result2 = 0;
		String sql = "insert into qna (qna_no, id, Qna_title, Qna_contents,QNA_STATEMENT, Qna_pass, ref, ref_step, ref_level)"
				+ "values (QNA_SEQ.nextval, ?, ?, ?, ?, ?, QNA_SEQ.currval, 0, 0 )";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setInt(4, passState);
			pstmt.setString(5, pass);
			result1 = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
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
			} 
		}

		if (result1 != 0 && result2 != 0) {
			return 1;
		} else {
			return 0;
		}
	}

	public int qnaUpdate(Connection conn, String title, String content, int qna_no, List<String> saveFiles, PreparedStatement pstmt, ResultSet rs) throws SQLException, Exception {
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
		} 

		return result;
	}

	public int qnaDelete(Connection conn, int qna_no, PreparedStatement pstmt, ResultSet rs) throws SQLException, Exception {
		int result1 = 0;
		int result2 = 0;
		String sql = "DELETE FROM qna WHERE qna_no = ?";
//		INSERT INTO tbl_img (img_no, qna_no, img) VALUES(img_seq.nextval, QNA_SEQ.currval, ?)
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, qna_no);

		result1 = pstmt.executeUpdate();

		
		return result1;
	}

	public int getBoardCount(Connection conn, PreparedStatement pstmt, ResultSet rs) throws SQLException, Exception {
		// qna 목록 페이징 - qna 총 글 개수
		int cnt = 0;
		String sql = "select COUNT(*) from qna where ref_step = 0 and ref_level = 0";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery(sql);
		if (rs.next()) {
			cnt = rs.getInt(1); // What's that?
		}
		
		return cnt;
	}

	public int getSearchBoardCount(String searchWord, Connection conn, PreparedStatement pstmt, ResultSet rs) throws SQLException, Exception { // qna 목록 페이징 -
																										// qna 총 글 개수
		int count = 0;
		String sql = "select COUNT(*) from qna where qna_title like ? and ref_step = 0 and ref_level = 0";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%" + searchWord + "%");
		rs = pstmt.executeQuery();
		if (rs.next()) {
			count = rs.getInt(1);
		}
		
		return count;
	}


	

	private void replyShape(Connection conn, String ref, PreparedStatement pstmt, ResultSet rs, String ref_step) {
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

	public int upCount(Connection conn, int strQna_no, PreparedStatement pstmt, ResultSet rs) throws SQLException, Exception {
		String sql = "update qna set qna_count = qna_count + 1 where qna_no = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, strQna_no);

		int result = pstmt.executeUpdate();
	

		return result;
	}

	public List<QnAVO> getComent(int strQna_no, Connection conn, PreparedStatement pstmt, ResultSet rs) {
		List<QnAVO> list = new ArrayList<QnAVO>();
		String sql ="select * from qna where ref = ? and ref_step > 0 and ref_level <= 1";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, strQna_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					QnAVO vo = new QnAVO();
					vo.setQna_no(rs.getInt("qna_no"));
					vo.setId(rs.getString("id"));
					vo.setQna_contents(rs.getString("qna_contents"));
					vo.setQna_statement(rs.getString("qna_statement").charAt(0));
					vo.setQna_pass(rs.getString("qna_pass"));
					vo.setQna_count(rs.getInt("qna_count"));
					vo.setQna_write_date(rs.getDate("qna_write_date"));
					vo.setRef(rs.getInt("ref"));
					vo.setRef_step(rs.getInt("ref_step"));
					vo.setRef_level(rs.getInt("ref_level"));
					list.add(vo);
				}while(rs.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public String privateChk(int strQna_no, Connection conn, PreparedStatement pstmt, ResultSet rs) {
		String result = null;
		String sql = "select qna_statement from qna where qna_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, strQna_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString("qna_statement");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public int qnaPassChk(int qnaNo, int qnaPass, Connection conn, PreparedStatement pstmt, ResultSet rs) {
		int result = 0;
		String sql = "select qna_pass from qna where qna_no = ? and qna_pass = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaNo);
			pstmt.setInt(2, qnaPass);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int reply(Connection conn, String id, String qna_title, String qna_content, String ref, String ref_step,
			String ref_level, PreparedStatement pstmt, ResultSet rs) {
		replyShape(conn, ref, pstmt,rs, ref_step);

		int result = 0;

		try {
			String sql = "insert into qna (qna_no, id, Qna_title, Qna_contents, ref, ref_step, ref_level)"
					+ " values (QNA_SEQ.nextval, ?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, qna_title);
			pstmt.setString(3, qna_content);
			pstmt.setInt(4, Integer.parseInt(ref));
			pstmt.setInt(5, Integer.parseInt(ref_step)+1);
			pstmt.setInt(6, Integer.parseInt(ref_level));
			
//			vo.setQna_no(rs.getInt("qna_no"));
//			vo.setId(rs.getString("id"));
//			vo.setQna_contents(rs.getString("qna_contents"));
//			vo.setQna_statement(rs.getString("qna_statement").charAt(0));
//			vo.setQna_pass(rs.getString("qna_pass"));
//			vo.setQna_count(rs.getInt("qna_count"));
//			vo.setQna_write_date(rs.getDate("qna_write_date"));
//			vo.setRef(rs.getInt("ref"));
//			vo.setRef_step(rs.getInt("ref_step"));
//			vo.setRef_level(rs.getInt("ref_level"));


			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

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
