package fine.community.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fine.community.training.model.TrainingDAO;
import fine.community.training.model.TrainingVO;
import fine.community.training.service.TrainingService;

/**
 * Servlet implementation class Training_List_manager
 */

@WebServlet("/trmListManager.do")
public class Training_List_manager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Training_List_manager() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		excute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		excute(request, response);
	}

	private void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		 
		//세션 
		String lev ="3"; 
		request.getSession().setAttribute("lev", lev);
		
		
			int pageSize = 10; // 페이지당 읽어올 글수
			int pageBlock = 10;
		

		TrainingDAO dao = new TrainingDAO();
		int count = dao.getBoardCount();	
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);


		int pagecount = (count / pageSize) + (count % pageSize == 0 ? 0 : 1);
		int startPage = 1;
		int endPage = 1;
		if (currentPage % 10 == 0) {

			startPage = ((currentPage / 10) - 1) * pageBlock + 1;
		} else {
			startPage = ((currentPage / 10)) * pageBlock + 1;
		}

		endPage = startPage + pageBlock;
		if (endPage > pagecount) {
			endPage = pagecount;
		}
		 
		

		

		int startRnum = (currentPage - 1) * pageSize + 1;
		int endRnum = startRnum + pageSize - 1;
		
		
		
		request.setAttribute("currentPage", currentPage); 
		request.setAttribute("count", count);
		request.setAttribute("endPage", endPage);
		request.setAttribute("startPage", startPage);
		
		request.setAttribute("pagecount", pagecount);
		
		List<TrainingVO> list = new ArrayList<TrainingVO>();
		TrainingService tService = new TrainingService();

		list = tService.getBoardByPage(startRnum, endRnum);
		
		request.setAttribute("list", list);
		RequestDispatcher dis = request.getRequestDispatcher("/view/training/fine_training_manage_List.jsp");
		dis.forward(request, response);
	
	
	}
}
