package fine.community.training.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fine.community.training.model.TrainingDAO;
import fine.community.training.model.TrainingVO;

public class TrainingService {
	private static DataSource ds = null;
	private static Connection conn = null;
	public TrainingService() {
		try {
			Context ctx = new InitialContext();
			Context ctx1 = (Context) ctx.lookup("java:/comp/env");
			ds = (DataSource) ctx1.lookup("jdbc/myoracles");
			try {
				conn = ds.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Connection 실패!");
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int trainingWrite(TrainingVO vo) {
		 int result = 0;
		 TrainingDAO dao = new TrainingDAO(); 
		 result = dao.training_Write(vo, conn);
		 try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return result;
	}

	public List<TrainingVO> getBoardByPage(int startRnum, int endRnum) {
		TrainingDAO dao = new TrainingDAO();
		List<TrainingVO> list = new ArrayList<TrainingVO>();
		list = dao.getBoardByPage(startRnum, endRnum, conn);
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<TrainingVO> getTrainingInfo(int no) {
		TrainingDAO dao = new TrainingDAO();
		List<TrainingVO> list = new ArrayList<TrainingVO>();
		list = dao.getTrainingInfo(no, conn);
		System.out.println("============================");
		System.out.println(list);
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int trainingDelete(TrainingVO vo) {
		TrainingDAO dao = new TrainingDAO();
		int result = 0;
		result = dao.trainingDelete(conn, vo);
		return result;
	}

	public void TrainingDeleteFileName(TrainingVO vo) {
		TrainingDAO dao = new TrainingDAO();
		dao.getTrainingFileName(vo, conn);
		
	}

	public int trainingUpdate(TrainingVO vo) {
		TrainingDAO dao = new TrainingDAO();
		int result = 0;
		result = dao.trainingUpdate(conn, vo);
		return result;
	}

	public List<TrainingVO> getSearchPage(int startRnum, int endRnum, String kwd) {
		TrainingDAO dao = new TrainingDAO();
		List<TrainingVO> list = new ArrayList<TrainingVO>();
		list = dao.getSearchPage(startRnum, endRnum, kwd, conn);
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}


	
	
}
