package fine.member.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	

	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Statement stmt = null;
	
	public void close(Connection conn) {
		try {
			if(rs!=null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if(pstmt!=null) {
				pstmt.close();
				pstmt = null;
			}
			if(conn!=null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void commit(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> list_all(Connection conn){
		List<MemberVO> list = new ArrayList<MemberVO>();
		String sql = "select * from member";
		try {
			pstmt = conn.prepareStatement(sql);
			if(rs.next()) {
				do {	
					MemberVO vo = new MemberVO();
						vo.setId(rs.getString("id"));
						vo.setName(rs.getString("name"));
						vo.setPassword(rs.getString("password"));
						vo.setPhone(rs.getString("phone"));
						vo.setEmail(rs.getString("email"));
						vo.setBirthday(rs.getDate("birthday"));
					list.add(vo);
				}while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return list;
	}
	
	public int memberRegister(Connection conn , MemberVO vo,int a) {
		int result = 0;
		System.out.println("dao");
		System.out.println(a);
		String sql1 = 	"insert into member(ID,care_no,name,password,phone,email,dog_kind_no,grade,lev,status,birthday,address,emailcode) " + 
						"VALUES(?,?,?,?,?,?,(select dog_kind_no from dog_kind where kind = ?),'1',1,1,?,?,?)";
		String sql2 = 	"insert into member(ID,care_no,name,password,phone,email,dog_kind_no,grade,lev,status,birthday,address,emailcode) " + 
						"VALUES(?,(select care_no from care where care_name = ?),?,?,?,?,(select dog_kind_no from dog_kind where kind = ?),'1',2,1,?,?,?)";
		try {
			if(a!=1) {
				pstmt = conn.prepareStatement(sql1);
				System.out.println("1");
			}else {
				pstmt = conn.prepareStatement(sql2);
				System.out.println("2");
			}
		
			pstmt.setString(1,vo.getId());
			pstmt.setString(2, vo.getCare_no());
			pstmt.setString(3,vo.getName());
			pstmt.setString(4,vo.getPassword());
			pstmt.setString(5,vo.getPhone());
			pstmt.setString(6,vo.getEmail());
			pstmt.setString(7,vo.getDog_kind_no());
			pstmt.setDate(8,vo.getBirthday());
			pstmt.setString(9, vo.getAddress());
			pstmt.setString(10, vo.getEmailcode());
			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean idCheck(Connection conn , String id)throws SQLException {
		String sql = "select id from Member where id=?";
		boolean flag = false;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()){
					flag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		return flag;
	}
	public boolean emailCheck(Connection conn , String email) throws SQLException  {
		String sql = "select email from Member where email=?";
		boolean flag = false;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, email);
				rs = pstmt.executeQuery();
				if(rs.next()){
					flag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		return flag;
	}
	public boolean phoneCheck(Connection conn , String phone) throws SQLException  {
		String sql = "select phone from Member where phone=?";
		boolean flag = false;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, phone);
				rs = pstmt.executeQuery();
				if(rs.next()){
					flag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		return flag;
	}
	public int login(Connection conn, String id, String pw) {
		String sql = "select password from member where id = ?";
		String dbPassword = "";
		int x = -1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dbPassword = rs.getString("password");
				if(dbPassword.equals(pw))
					x = 1; //비밀번호확인
				else 
					x = 0;//비밀번호다름 
			} else {
				x =-1;//아이디다름
			}
			return x;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	public int emailCodeCheck(Connection conn , String emilcode) throws SQLException  {
		String sql = "update member set status = '0' where emailcode = ?";
		int result = 0;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, emilcode);
				rs = pstmt.executeQuery();
				if(rs.next()){
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		return result;
	}
	public String findId(Connection conn , String email) throws SQLException {
		String sql = "select id from member where email = ? ";
		String result = "";
		
		try {
			System.out.println(email+"DAO");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString("id");
			}else {
				result = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	return result;
	}
	public int findPw(Connection conn, String email, String id) throws SQLException {
		String sql = "select password from member where email =? and id =?";
		int result =0;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, email);
				pstmt.setString(2, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result = 1;
				}else {
					result = 0;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return result;
	}
	public int changePw(Connection conn, String randpwd, String to) throws SQLException {
		String sql = "update member set password = ? where email = ?";
		int result = 0;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, randpwd);
				pstmt.setString(2, to);
				rs = pstmt.executeQuery();
				if(rs.next()){
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		return result;
	}
	public String memberLev(Connection conn, String id)  {
		System.out.println("dao옮");
		String sql = "select lev from member where id = ?";
		String result = "";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("값가지고옮");
				result = rs.getString("lev");
			}else {
				System.out.println("값x");
				result = null;
			}
		} catch (Exception e) {
			System.out.println("안가지고감");
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	//========================이서현
	
	// MyPage 로그인한 회원 정보만 보여줌
		public List<MemberVO> MyPageList(Connection conn, String lev,String id) {
			List<MemberVO> MyPagelist = new ArrayList<MemberVO>();
			
//		      String sql = "SELECT *  FROM member  where lev = ? ";
			String sql = "select member.id,member.name,member.password,member.phone,member.email,member.address, dog_kind.kind as kind,\r\n" + 
					"					DECODE(member.grade, 4,'다이아몬드',3,'골드',2,'실버',1,'브론즈') AS grade , DECODE(member.lev,1,'회원',2,'보호소직원', 3 ,'관리자' )AS lev ,\r\n" + 
					"					DECODE(member.status, 0, '승인','미승인')AS status, member.sign_date, member.birthday  FROM MEMBER, dog_kind  WHERE member.dog_kind_no = dog_kind.dog_kind_no and member.LEV = ? and member.id = ?";
			try {
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, lev);
				pstmt.setString(2, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					do {
						
						MemberVO vo = new MemberVO();
						vo.setId(rs.getString("id"));
						vo.setName(rs.getString("name"));
						vo.setDog_kind_no(rs.getString("kind"));
						vo.setGrade(rs.getString("grade"));
						vo.setPassword(rs.getString("password"));
						vo.setPhone(rs.getString("phone"));
						vo.setEmail(rs.getString("email"));
						vo.setAddress(rs.getString("address"));
						MyPagelist.add(vo);
					} while (rs.next());
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("꾀꼬닥");
			}
			return MyPagelist;
		}

		public int getMyPageCount(Connection conn) {
			int cnt = 0;
			String sql = "select COUNT(*) from member where lev = '1' or lev ='2'";
			
				try {
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					if (rs.next()) {
						cnt = rs.getInt(1);
					}
					stmt.close();
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			return cnt;
		}

		// 관리자가 보는 전체 회원정보 ==> 페이지 설정
		public List<MemberVO> getMyPageInfo(Connection conn, String lev, int start, int end) throws SQLException {
			List<MemberVO> myPageList = new ArrayList<MemberVO>();
			MemberVO vo = null;
//			String sql = " select id,name,password,phone,email,address,DECODE(dog_kind_no, 000111,'리트리버',000112,'말티즈',000113,'푸들')AS dog_kind_no, + 
//				"DECODE(grade, 4,'다이아몬드',3,'골드',2,'실버',1,'브론즈') AS grade,DECODE(lev,1,'회원',2,'보호소직원',3,'관리자')AS lev, + 
//				"DECODE(status, 0, '승인','미승인')AS status, sign_date,birthday from  (select rownum rnum, d.* from  + 
//				"(select * from member order by id asc)  d) where rnum >= ? and rnum <= ?";
		
			String sql = "select * from" + "(select rownum rnum, d.* from " + "(select * from member order by id asc) "
					+ " d)" + "where rnum >= ? and rnum <= ? and lev = 1 and lev = 2";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
				pstmt.setString(3, lev);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					myPageList = new ArrayList<MemberVO>();
					do {
						vo = new MemberVO();
						vo.setId(rs.getString("id"));
						vo.setCare_no(rs.getString("care_no"));
						vo.setName(rs.getString("name"));
						vo.setPassword(rs.getString("password"));
						vo.setPhone(rs.getString("phone"));
						vo.setEmail(rs.getString("email"));
						vo.setAddress(rs.getString("address"));
						vo.setDog_kind_no(rs.getString("dog_kind-no"));// CHAR
						vo.setGrade(rs.getString("grade"));// CHAR
						vo.setLev(rs.getString("lev")); // CHAR
						vo.setStatus(rs.getString("status"));// CHAR
						vo.setSign_date(rs.getDate("sign_date"));
						vo.setBirthday(rs.getDate("birthday"));
						myPageList.add(vo);
					} while (rs.next());
				}
			} finally {
				pstmt.close();
			}
			return myPageList;
		}

		// 관리자 전체 회원 정보 보기 Admin
		public List<MemberVO> MyPageListAdmin(int startRnum, int endRnum, Connection conn) {
			List<MemberVO> myPageList = new ArrayList<MemberVO>();
//			   String sql = "select id, name, password, phone, email, address, " + 
//			   		"DECODE(dog_kind_no, 000111, '리트리버',000112,'말티즈',000113,'푸들') AS dog_kind_no , " + 
//			   		"DECODE(grade, 4,'다이아몬드',3,'골드',2,'실버',1,'브론즈') AS grade, " + 
//			   		"DECODE(lev, 1,'회원',2,'보호소직원',3,'관리자') AS lev, " + 
//			   		"DECODE(status, 0, '승인','미승인')AS status, sign_date, birthday " + 
//			   		"from member where lev = 1 or lev = 2";
			
			   String sql ="select * from (select rownum rnum, d.* from(select * from member where lev = '1' or lev = '2')d) where rnum >= ? and rnum <= ?";
			/* String sql =
			 * "select * from(select rownum rnum, d.* from (select * from member ) d) where rnum >= ? and rnum <= ?"
			 * ;
			 */
			try {
				pstmt = conn.prepareStatement(sql);
				 pstmt.setInt(1, startRnum); 
				 pstmt.setInt(2, endRnum); 
				 rs = pstmt.executeQuery();
				 			 
				if (rs.next()) {
					do {
						MemberVO vo = new MemberVO();
						vo.setId(rs.getString("id"));
						vo.setCare_no(rs.getString("care_no"));
						vo.setName(rs.getString("name"));
						vo.setPassword(rs.getString("password"));
						vo.setPhone(rs.getString("phone"));
						vo.setEmail(rs.getString("email"));
						vo.setAddress(rs.getString("address"));
						vo.setDog_kind_no(rs.getString("dog_kind_no"));// CHAR	
						vo.setGrade(rs.getString("grade"));// CHAR
						vo.setLev(rs.getString("lev")); // CHAR	
						vo.setStatus(rs.getString("status"));// CHAR			
						vo.setSign_date(rs.getDate("sign_date"));
						vo.setBirthday(rs.getDate("birthday"));					
						myPageList.add(vo);
						
					} while (rs.next());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return myPageList;
		}

		// Id 찾기에서 유사한 Id의를 찾아 보여 주기
		public List<MemberVO> SearchId(Connection conn, int startRnum, int endRnum, String searchId) {
			List<MemberVO> searchPageList = new ArrayList<MemberVO>();
		    String sql ="select * from (select rownum rnum, d.* from(select * from member where lev = '1' or lev = '2') d where ID = ?) where rnum >= ? and rnum <= ?";
		//	String sql = " select count(*) from  member  where Id like ? ";
			
		    System.out.println("dao : "+searchId);
		    try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, searchId);
				pstmt.setInt(2, startRnum); 
				pstmt.setInt(3, endRnum); 
				rs = pstmt.executeQuery();
				 
				if (rs.next()) {
					do {
						System.out.println("담으러와따1");
						MemberVO vo = new MemberVO();
						vo.setId(rs.getString("id"));
						vo.setCare_no(rs.getString("care_no"));
						vo.setName(rs.getString("name"));
						vo.setPassword(rs.getString("password"));
						vo.setPhone(rs.getString("phone"));
						vo.setEmail(rs.getString("email"));
						vo.setAddress(rs.getString("address"));
						vo.setDog_kind_no(rs.getString("dog_kind_no"));// CHAR	
						vo.setGrade(rs.getString("grade"));// CHAR
						vo.setLev(rs.getString("lev")); // CHAR	
						vo.setStatus(rs.getString("status"));// CHAR			
						vo.setSign_date(rs.getDate("sign_date"));
						vo.setBirthday(rs.getDate("birthday"));					
						searchPageList.add(vo);					
					} while (rs.next());				
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return searchPageList;
		}

		
		// 기존 사용자의 정보를 수정하여 DB의 데이터를 수정
		public int updateMember(Connection conn, MemberVO vo,String id ) throws SQLException {
			int result = 0;
			String sql = "update member set dog_kind_no = (select dog_kind_no from dog_kind where kind = ?) , address = ? , phone = ? , email = ? where id = ?";
			try {
				System.out.println("업데이드 확인");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getDog_kind_no());
				pstmt.setString(2, vo.getAddress());
				pstmt.setString(3, vo.getPhone());
				pstmt.setString(4, vo.getEmail());
				pstmt.setString(5, id);
				result = pstmt.executeUpdate();
				if(result == 1) {
					System.out.println("리절트에 1넣");
					result = 1;
				}
			} catch (SQLException e) {
				System.out.println("캐치");
				e.printStackTrace();
			} 
			return result;
		}

		// 기존 사용자를탈퇴시 DB에서 삭제하는 메소드
		public int checkDeleteMember(Connection con, String id, String password) throws SQLException {
			int result = 0;
			String sql = "select password from Member WHERE ID = ?";
			String dbPassword = "";
			System.out.println("a6:" + id);
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					dbPassword = rs.getString("password");
					if (dbPassword.equals(password))
						result = 1; // 비밀번호확인
					else
						result = 0;// 비밀번호다름
				} else {
					result = -1;// 아이디가 없음.
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				pstmt.close();
			}
			return result;
		}
	//  관리자 페이지에서  삭제 버튼 클릭시
		public int adminDelete(Connection conn, String id) {
			int result = 0;
			String sql = "delete from member where id = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}		
			return result;
		}

		

		// MyPage 에서 정보 탈퇴  다시 비밀번호 체크
		public int PwCheck(Connection conn, String id, String password) {
			String sql = "select password from member where id = ?";
			String dbPassword = "";
			int x = -1;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					dbPassword = rs.getString("password");
					if (dbPassword.equals(password))
						x = 1; // 비밀번호확인
					else
						x = 0;// 비밀번호다름
				} else {
					x = -1;// 아이디가 없음.
				}
				return x;
			} catch (Exception e) {
				e.printStackTrace();
			} 
			return x;

		}
		public int deleteMember(String id, Connection conn) {
			int result = 0;
			String sql = "delete from member where id = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
		}

	

}