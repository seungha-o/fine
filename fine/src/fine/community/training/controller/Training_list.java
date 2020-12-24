package fine.community.training.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.community.training.model.TrainingDAO;
import fine.community.training.model.TrainingVO;
import fine.community.training.service.TrainingService;

/**
 * Servlet implementation class training_list
 */
@WebServlet("/training_list.do")
public class Training_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Training_list() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		 
			int pageSize = 1; // 페이지당 읽어올 글수
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
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
System.out.println(currentPage + " : " + startPage);
		
		List<TrainingVO> list = new ArrayList<TrainingVO>();
	      TrainingService tService = new TrainingService();
	      list = tService.getBoardByPage(startRnum, endRnum);
	      request.setAttribute("list", list);
	      request.setAttribute("currentPage", currentPage);
	      RequestDispatcher dis = request.getRequestDispatcher("/view/training/fine_training_list.jsp?pageNum="+currentPage);
	      dis.forward(request, response);

	}

}
