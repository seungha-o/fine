package fine.find.findInfo.model;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import fine.community.training.model.TrainingVO;
import fine.find.dogList.XmlDataVO;
import fine.find.dogList.XmlParser;

public class FindDAO {
	
	
	public FindDAO() {
		
		System.out.println("===========================DB연결=========================");
	}
	public List<FindVO> findAdress(String address, Connection conn, PreparedStatement pstmt, ResultSet rs) {
		List<FindVO> list = new ArrayList<FindVO>();
		String sql = "select * from dog where orgNm like ?";
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("===========================sql실행=========================");
			pstmt.setString(1, "%"+address+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					FindVO vo = new FindVO();
					vo.setDesertionNo(rs.getString("desertionNo"));
					vo.setHappenPlace(rs.getString("happenplace"));
					vo.setAge(rs.getString("age"));
					vo.setCareAddr(rs.getString("careaddr"));
					vo.setCareNm(rs.getString("carenm"));
					vo.setCareTel(rs.getString("caretel"));
					vo.setColorCd(rs.getString("colorcd"));
					vo.setFilename(rs.getString("filename"));
					vo.setHappenDt(rs.getString("happendt"));
					vo.setKindCd(rs.getString("DOG_KIND_NO"));
					vo.setNeuterYn(rs.getString("neuteryn"));
					vo.setNoticeEdt(rs.getString("noticeEdt"));
					vo.setNoticeSdt(rs.getString("noticeSdt"));
					vo.setOfficetel(rs.getString("officetel"));
					vo.setOrgNm(rs.getString("orgnm"));
					vo.setPopfile(rs.getString("popfile"));
					vo.setProcessState(rs.getString("processstate"));
					vo.setSexCd(rs.getString("sexcd"));
					vo.setSpecialMark(rs.getString("specialMark"));
					vo.setWeight(rs.getString("weight"));
					list.add(vo);
					
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
		
	}
	
	public int insertNoticeSysDate(Connection conn, PreparedStatement pstmt) {
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ("yyyyMMdd", Locale.KOREA );
		Date currentTime = new Date ();
		String mTime = mSimpleDateFormat.format ( currentTime );
		System.out.println ( mTime );


		int result = 0;
		File file = new File("C:\\eclips_java\\fine\\dogNotice.xml");
		XmlParser xmlParser = new XmlParser(file);
		List<XmlDataVO> tmp = xmlParser.parse("item");
		System.out.println("******tmp size: "+tmp.size());

//			  String sql = "insert into dog_kind(dog_kind_no, kind) values(?,?)";
			  String sql = "insert into dog(desertionNo, happenPlace, age,   care_adress, care_name, care_Tel, colorCd, filename, happenDt," + 
				  		"dog_kind_no, neuterYn, noticeEdt, noticeSdt, officetel, orgNm, popfile, processState, sexCd, specialMark, weight) "
				  		+ "values(SEQ_dog_NO.NEXTVAL, ?, ?,  ?, ?, ?, ?, ?, ?, (select distinct dog_kind_no from dog_kind where kind like ?), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			  int numOfRow = 0;
			  try {
				  for(int i=0; i<tmp.size() ; i++){
//					  System.out.println("vo값:"+Integer.parseInt(tmp.get(i).getNoticeSdt()));
//					  System.out.println("오늘날자"+Integer.parseInt(mTime));
				   	pstmt = conn.prepareStatement(sql);
				    if(Integer.parseInt(tmp.get(i).getNoticeSdt())<Integer.parseInt(mTime)) {
				    	System.out.println("전에있던 데이터입니다. 건너뜀");
				    	continue;
				    }
				    if(Integer.parseInt(tmp.get(i).getNoticeSdt())==Integer.parseInt(mTime)) {
				    	System.out.println("오늘날짜 데이터 입니다. 건너뜀");
				    	continue;
				    }
				    
				    pstmt.setString(1, tmp.get(i).getHappenPlace());
				    pstmt.setString(2, tmp.get(i).getAge());
				    pstmt.setString(3, tmp.get(i).getCareAddr());
				    pstmt.setString(4, tmp.get(i).getCareNm());
				    pstmt.setString(5, tmp.get(i).getCareTel());
				    pstmt.setString(6, tmp.get(i).getColorCd());
				    pstmt.setString(7, tmp.get(i).getFilename());
				    pstmt.setString(8, tmp.get(i).getHappenDt());
				    pstmt.setString(9, tmp.get(i).getKindCd()); //푸들 치와와
				    pstmt.setString(10, tmp.get(i).getNeuterYn());
				    pstmt.setString(11, tmp.get(i).getNoticeEdt());
				    pstmt.setString(12, tmp.get(i).getNoticeSdt());
				    pstmt.setString(13, tmp.get(i).getOfficetel());
				    pstmt.setString(14, tmp.get(i).getOrgNm());
				    pstmt.setString(15, tmp.get(i).getPopfile());
				    pstmt.setString(16, tmp.get(i).getProcessState());
				    pstmt.setString(17, tmp.get(i).getSexCd());
				    pstmt.setString(18, tmp.get(i).getSpecialMark());
				    pstmt.setString(19, tmp.get(i).getWeight());
				    
				
				    
				    
				    int r1 = pstmt.executeUpdate();
				   numOfRow++;
				    if(pstmt!=null) pstmt.close();
				    if(r1==1) System.out.println("insert ok");
				    else { 
				    	System.out.println("insert fail : " + r1);
				    	break;
				    }
			   }
			    System.out.println("sucess to save" + numOfRow);
			  } catch (SQLException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
		  }finally {
			  try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
			return result;

		
	}
	public int getBoardCount(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		int result = 0;
		String sql = "select count(*) from dog";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					result = rs.getInt(1);
				}while(rs.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<FindVO> getFindInfo(int startRnum, int endRnum, Connection conn, PreparedStatement pstmt, ResultSet rs) {
		List<FindVO> list = new ArrayList<FindVO>();
		String sql = "select * from(select rownum rnum, d.* from (select * from dog order by desertionNo desc) d) where rnum >= ? and rnum <= ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRnum);
			pstmt.setInt(2, endRnum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					FindVO vo = new FindVO();
					vo.setDesertionNo(rs.getString("desertionNo"));
					vo.setHappenPlace(rs.getString("happenplace"));
					vo.setAge(rs.getString("age"));
					vo.setCareAddr(rs.getString("care_adress"));
					vo.setCareNm(rs.getString("care_name"));
					vo.setCareTel(rs.getString("care_tel"));
					vo.setColorCd(rs.getString("colorcd"));
					vo.setFilename(rs.getString("filename"));
					vo.setHappenDt(rs.getString("happendt"));
					vo.setKindCd(rs.getString("DOG_KIND_NO"));
					vo.setNeuterYn(rs.getString("neuteryn"));
					vo.setNoticeEdt(rs.getString("noticeEdt"));
					vo.setNoticeSdt(rs.getString("noticeSdt"));
					vo.setOfficetel(rs.getString("officetel"));
					vo.setOrgNm(rs.getString("orgnm"));
					vo.setPopfile(rs.getString("popfile"));
					vo.setProcessState(rs.getString("processstate"));
					vo.setSexCd(rs.getString("sexcd"));
					vo.setSpecialMark(rs.getString("specialMark"));
					vo.setWeight(rs.getString("weight"));
					list.add(vo);
					
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
		
	}
	public List<FindVO> getFindInfo(int no, Connection conn, PreparedStatement pstmt, ResultSet rs) {
		 List<FindVO> list = new ArrayList<FindVO>();
	     String sql = "select * from dog where desertionno=?";
	     try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					FindVO vo = new FindVO();
					vo.setDesertionNo(rs.getString("desertionNo"));
					vo.setHappenPlace(rs.getString("happenplace"));
					vo.setAge(rs.getString("age"));
					vo.setCareAddr(rs.getString("care_adress"));
					vo.setCareNm(rs.getString("care_name"));
					vo.setCareTel(rs.getString("care_tel"));
					vo.setColorCd(rs.getString("colorcd"));
					vo.setFilename(rs.getString("filename"));
					vo.setHappenDt(rs.getString("happendt"));
					vo.setKindCd(rs.getString("DOG_KIND_NO"));
					vo.setNeuterYn(rs.getString("neuteryn"));
					vo.setNoticeEdt(rs.getString("noticeEdt"));
					vo.setNoticeSdt(rs.getString("noticeSdt"));
					vo.setOfficetel(rs.getString("officetel"));
					vo.setOrgNm(rs.getString("orgnm"));
					vo.setPopfile(rs.getString("popfile"));
					vo.setProcessState(rs.getString("processstate"));
					vo.setSexCd(rs.getString("sexcd"));
					vo.setSpecialMark(rs.getString("specialMark"));
					vo.setWeight(rs.getString("weight"));
					list.add(vo);
					System.out.println(list);
					}while(rs.next());
			}
		} catch (SQLException e) {
			System.out.println("실팽");
			e.printStackTrace();
		}
	     
		return list;
	}
	public int getSearchBoardCount(String address, String dogKind, String happenDt, Connection conn, PreparedStatement pstmt,
			ResultSet rs) {
			int cnt = 0;
			System.out.println("다오: "+ address);
			System.out.println("다오: "+dogKind);
			System.out.println("다오: "+happenDt);
			String sql = "select count(*) from dog where care_adress like ?  and dog_kind_no in (select dog_kind_no from dog_kind where kind like ?) and happenDt > ?";
			
	    try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+address+"%");
			pstmt.setString(2, "%"+dogKind+"%");
			pstmt.setString(3, happenDt);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					cnt = rs.getInt(1);
				System.out.println(cnt);
				}while(rs.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    System.out.println("검색개수!!!!" + cnt);
		return cnt;
		
	}
	public List<FindVO> getSearchDogPage(String address, String dogKind, String happenDt, int startRnum, int endRnum, Connection conn,
			PreparedStatement pstmt, ResultSet rs) {
		 List<FindVO> list = new ArrayList<FindVO>();
	     
		 String sql = "select * from(select rownum rnum, d.* from "
	     		+ "(select * from dog where dog_kind_no = (select dog_kind_no from dog_kind where kind like ?) and care_adress like ? and happenDt > ?) d) "
	     		+ "where rnum >= ? and rnum <= ?";
	     try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+dogKind+"%");
			pstmt.setString(2, "%"+address+"%");
			pstmt.setString(3, happenDt);
			pstmt.setInt(4, startRnum);
			pstmt.setInt(5, endRnum);
			rs = pstmt.executeQuery();
			System.out.println("ㅎㅇㅎㅇ");
			if(rs.next()) {
				do {
					FindVO vo = new FindVO();
					vo.setDesertionNo(rs.getString("desertionNo"));
					vo.setHappenPlace(rs.getString("happenplace"));
					vo.setAge(rs.getString("age"));
					vo.setCareAddr(rs.getString("care_adress"));
					vo.setCareNm(rs.getString("care_name"));
					vo.setCareTel(rs.getString("care_tel"));
					vo.setColorCd(rs.getString("colorcd"));
					vo.setFilename(rs.getString("filename"));
					vo.setHappenDt(rs.getString("happendt"));
					vo.setKindCd(rs.getString("DOG_KIND_NO"));
					vo.setNeuterYn(rs.getString("neuteryn"));
					vo.setNoticeEdt(rs.getString("noticeEdt"));
					vo.setNoticeSdt(rs.getString("noticeSdt"));
					vo.setOfficetel(rs.getString("officetel"));
					vo.setOrgNm(rs.getString("orgnm"));
					vo.setPopfile(rs.getString("popfile"));
					vo.setProcessState(rs.getString("processstate"));
					vo.setSexCd(rs.getString("sexcd"));
					vo.setSpecialMark(rs.getString("specialMark"));
					vo.setWeight(rs.getString("weight"));
					list.add(vo);
				}while(rs.next());
		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return list;
		
	}
	public List<FindVO> getFindAdoptInfo(int startRnum, int endRnum, Connection conn, PreparedStatement pstmt,
			ResultSet rs) {
			List<FindVO> list = new ArrayList<FindVO>();
			SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ("yyyyMMdd", Locale.KOREA );
			Date currentTime = new Date ();
			String mTime = mSimpleDateFormat.format ( currentTime );
			System.out.println ( mTime );
			
			String sql = "select * from(select rownum rnum, d.* from (select * from dog where noticeEdt < "+mTime+" order by desertionNo desc) d) where rnum >= ? and rnum <= ?";
			 try {
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, startRnum);
					pstmt.setInt(2, endRnum);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						do {
							FindVO vo = new FindVO();
							vo.setDesertionNo(rs.getString("desertionNo"));
							vo.setHappenPlace(rs.getString("happenplace"));
							vo.setAge(rs.getString("age"));
							vo.setCareAddr(rs.getString("care_adress"));
							vo.setCareNm(rs.getString("care_name"));
							vo.setCareTel(rs.getString("care_tel"));
							vo.setColorCd(rs.getString("colorcd"));
							vo.setFilename(rs.getString("filename"));
							vo.setHappenDt(rs.getString("happendt"));
							vo.setKindCd(rs.getString("DOG_KIND_NO"));
							vo.setNeuterYn(rs.getString("neuteryn"));
							vo.setNoticeEdt(rs.getString("noticeEdt"));
							vo.setNoticeSdt(rs.getString("noticeSdt"));
							vo.setOfficetel(rs.getString("officetel"));
							vo.setOrgNm(rs.getString("orgnm"));
							vo.setPopfile(rs.getString("popfile"));
							vo.setProcessState(rs.getString("processstate"));
							vo.setSexCd(rs.getString("sexcd"));
							vo.setSpecialMark(rs.getString("specialMark"));
							vo.setWeight(rs.getString("weight"));
							list.add(vo);
						}while(rs.next());
				
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				 return list;
				
	}
	public int getAdoptListCount(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ("yyyyMMdd", Locale.KOREA );
		Date currentTime = new Date ();
		String mTime = mSimpleDateFormat.format ( currentTime );
		System.out.println ( mTime );
		int result = 0 ;
		String sql = "select count(*) from dog where noticeEdt < "+mTime;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					result = rs.getInt(1);
				}while(rs.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;		
	}
	public int getAdoptSearchBoardCount(String address, String dogKind, Connection conn, PreparedStatement pstmt,
			ResultSet rs) {
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ("yyyyMMdd", Locale.KOREA );
		Date currentTime = new Date ();
		String mTime = mSimpleDateFormat.format ( currentTime );
		System.out.println ( mTime );
		int cnt = 0;
		String sql = "select count(*) from dog where care_adress like ?  and dog_kind_no in (select dog_kind_no from dog_kind where kind like ?) and noticeEdt <"+mTime;
		
	    try {
			
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+address+"%");
				pstmt.setString(2, "%"+dogKind+"%");
				rs = pstmt.executeQuery();
				if(rs.next()) {
					do {
						cnt = rs.getInt(1);
					System.out.println(cnt);
					}while(rs.next());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    System.out.println("검색개수!!!!" + cnt);
			return cnt;
	}
	public List<FindVO> getAdoptSearchDogPage(String address, String dogKind, int startRnum, int endRnum,
			Connection conn, PreparedStatement pstmt, ResultSet rs) {
 List<FindVO> list = new ArrayList<FindVO>();
 SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ("yyyyMMdd", Locale.KOREA );
	Date currentTime = new Date ();
	String mTime = mSimpleDateFormat.format ( currentTime );
	System.out.println ( mTime );
		 String sql = "select * from(select rownum rnum, d.* from "
	     		+ "(select * from dog where dog_kind_no = (select dog_kind_no from dog_kind where kind like ?) and care_adress like ? and noticeEdt <"+mTime+") d) "
	     		+ "where rnum >= ? and rnum <= ?";
	     try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+dogKind+"%");
			pstmt.setString(2, "%"+address+"%");
			pstmt.setInt(3, startRnum);
			pstmt.setInt(4, endRnum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					FindVO vo = new FindVO();
					vo.setDesertionNo(rs.getString("desertionNo"));
					vo.setHappenPlace(rs.getString("happenplace"));
					vo.setAge(rs.getString("age"));
					vo.setCareAddr(rs.getString("care_adress"));
					vo.setCareNm(rs.getString("care_name"));
					vo.setCareTel(rs.getString("care_tel"));
					vo.setColorCd(rs.getString("colorcd"));
					vo.setFilename(rs.getString("filename"));
					vo.setHappenDt(rs.getString("happendt"));
					vo.setKindCd(rs.getString("DOG_KIND_NO"));
					vo.setNeuterYn(rs.getString("neuteryn"));
					vo.setNoticeEdt(rs.getString("noticeEdt"));
					vo.setNoticeSdt(rs.getString("noticeSdt"));
					vo.setOfficetel(rs.getString("officetel"));
					vo.setOrgNm(rs.getString("orgnm"));
					vo.setPopfile(rs.getString("popfile"));
					vo.setProcessState(rs.getString("processstate"));
					vo.setSexCd(rs.getString("sexcd"));
					vo.setSpecialMark(rs.getString("specialMark"));
					vo.setWeight(rs.getString("weight"));
					list.add(vo);
				}while(rs.next());
		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return list;
	}
	public int getManageAdoptBoardCount(String checkId, String lev, Connection conn, PreparedStatement pstmt, ResultSet rs) {
		int cnt = 0;
		String sql = "select count(*) from dog where care_name = (select care_name from care where care_no = (select care_no from member where id = ? and lev = ?))";
		
	    try {
			
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, checkId);
				pstmt.setString(2, lev);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					do {
						cnt = rs.getInt(1);
					System.out.println(cnt);
					}while(rs.next());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    System.out.println("검색개수!!!!" + cnt);
			return cnt;
	}
	public List<FindVO> getFindManageList(String checkId, String lev , int startRnum, int endRnum, Connection conn,
			PreparedStatement pstmt, ResultSet rs) {
		 List<FindVO> list = new ArrayList<FindVO>();
				 String sql = "select * from(select rownum rnum, d.* from (select * from dog where care_name = (select care_name from care where care_no =(select care_no from member where id = ? and lev = ?))order by desertionNo desc) d) where rnum >= ? and rnum <= ?";
			     try {
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, checkId);
					pstmt.setString(2, lev);
					pstmt.setInt(3, startRnum);
					pstmt.setInt(4, endRnum);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						do {
							FindVO vo = new FindVO();
							vo.setDesertionNo(rs.getString("desertionNo"));
							vo.setHappenPlace(rs.getString("happenplace"));
							vo.setAge(rs.getString("age"));
							vo.setCareAddr(rs.getString("care_adress"));
							vo.setCareNm(rs.getString("care_name"));
							vo.setCareTel(rs.getString("care_tel"));
							vo.setColorCd(rs.getString("colorcd"));
							vo.setFilename(rs.getString("filename"));
							vo.setHappenDt(rs.getString("happendt"));
							vo.setKindCd(rs.getString("DOG_KIND_NO"));
							vo.setNeuterYn(rs.getString("neuteryn"));
							vo.setNoticeEdt(rs.getString("noticeEdt"));
							vo.setNoticeSdt(rs.getString("noticeSdt"));
							vo.setOfficetel(rs.getString("officetel"));
							vo.setOrgNm(rs.getString("orgnm"));
							vo.setPopfile(rs.getString("popfile"));
							vo.setProcessState(rs.getString("processstate"));
							vo.setSexCd(rs.getString("sexcd"));
							vo.setSpecialMark(rs.getString("specialMark"));
							vo.setWeight(rs.getString("weight"));
							list.add(vo);
						}while(rs.next());
				
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				 return list;
	}
	public int FindMangerWrite(String checkId, FindVO vo,  Connection conn, PreparedStatement pstmt) {
//		FindVO vo = new FindVO();		
//		vo.setHappenPlace(happenPlace);
//		vo.setAge(age);
//		vo.setColorCd(colorCd);
//		vo.setHappenDt(happenDt);
//		vo.setKindCd(kindCd);
//		vo.setNeuterYn(neuterYn);
//		vo.setNoticeEdt(noticeEdt);
//		vo.setOfficetel(officetel);
//		vo.setOrgNm(orgNm);
//		vo.setSexCd(sexCd);
//		vo.setSpecialMark(specialMark);
//		vo.setWeight(weight);
//		vo.setFilename(file);
		System.out.println(checkId);
		 SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ("yyyyMMdd", Locale.KOREA );
			Date currentTime = new Date ();
			String mTime = mSimpleDateFormat.format ( currentTime );
			System.out.println ( mTime );
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
		        cal.add(Calendar.DATE, +10);
		        System.out.println("10일 뒤 날짜 : "+mSimpleDateFormat.format(cal.getTime()));
		int result = 0;
		String sql = "insert into dog(desertionno, care_name, care_adress, care_tel, happenPlace, age, colorcd, filename, happendt, dog_kind_no, neuteryn, noticeEdt, noticeSdt, officeTel, orgNm, popFile, processstate, sexcd, specialmark, weight)" + 
				"values(SEQ_dog_NO.NEXTVAL,(select care_name from care where care_no = (select care_no from member where id = ?)),(select adress from care where care_no = (select care_no from member where id = ?)),(select tel from care where care_no = (select care_no from member where id = ?))" + 
				",?,?,?,?,?,(select dog_kind_no from dog_kind where kind = ?), ?, "+mSimpleDateFormat.format(cal.getTime())+","+mTime+", (select phone from member where id=?),?,?,'보호중',?,?,?)";
	    try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, checkId);
			System.out.println("1");
			pstmt.setString(2, checkId);
			System.out.println("1");
			pstmt.setString(3, checkId);
			System.out.println("1");
			pstmt.setString(4, vo.getHappenPlace());
			System.out.println("1");
			pstmt.setString(5, vo.getAge());
			System.out.println("1");
			pstmt.setString(6, vo.getColorCd());
			System.out.println("1");
			pstmt.setString(7, vo.getFilename());
			System.out.println("1");
			pstmt.setString(8, vo.getHappenDt());
			System.out.println("1");
			pstmt.setString(9, vo.getKindCd());
			System.out.println("1");
			pstmt.setString(10, vo.getNeuterYn());
			System.out.println("1");
//			pstmt.setString(11, vo.getNoticeEdt() );
//			System.out.println("1");
			pstmt.setString(11, checkId);
			System.out.println("1");
			pstmt.setString(12, vo.getOrgNm());
			System.out.println("1");
			pstmt.setString(13, vo.getFilename());
			System.out.println("1");
			pstmt.setString(14, vo.getSexCd());
			System.out.println("1");
			pstmt.setString(15, vo.getSpecialMark());
			System.out.println("1");
			pstmt.setString(16, vo.getWeight());
			System.out.println("1");
			System.out.println(sql);
			result = pstmt.executeUpdate();
			System.out.println(result);
			if(result == 1) {
				return result;
			}else {
				System.out.println("유기견입력실패");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	    
	
	    
	    
		return result;
	}
	public void FindDeleteFileName(FindVO vo, Connection conn, PreparedStatement pstmt, ResultSet rs) {
		// TODO Auto-generated method stub
		String sql = "select filename from dog where desertionNo = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getDesertionNo());
			rs = pstmt.executeQuery();
			if(rs.next()) {
					vo.setFilename(rs.getString("filename"));
					System.out.println("파일이름 : "+vo.getFilename());
			
			}
			System.out.println("데이터가 없습니다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int findDelete(Connection conn, FindVO vo, PreparedStatement pstmt, ResultSet rs) {
		int result = 0;
		String sql = "delete from dog where desertionNo = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getDesertionNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	
	}
	

}
