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
 * Servlet implementation class Training_Search
 */
@WebServlet("/training_Search.do")
public class Training_Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Training_Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String kwd = request.getParameter("kwd");

		System.out.println(kwd);

		int pageSize = 2; // 페이지당 읽어올 글수
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		int pageBlock = 10;
		TrainingDAO dao = new TrainingDAO();
		int count = dao.getBoardCounts(kwd);

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
		System.out.println(startRnum+"서치 알넘");
		int endRnum = startRnum + pageSize - 1;
		System.out.println(endRnum + "서치엔드넘");

		request.setAttribute("kwd", kwd);
		request.setAttribute("currentPage", currentPage); 
		request.setAttribute("count", count);
		request.setAttribute("endPage", endPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("pagecount", pagecount);
		
		List<TrainingVO> list = new ArrayList<TrainingVO>();
		TrainingService tService = new TrainingService();
		list = tService.getSearchPage(startRnum, endRnum, kwd);
		request.setAttribute("list", list);
		System.out.println(list);
		RequestDispatcher dis = request
				.getRequestDispatcher("/view/training/fine_training_Search.jsp");
		System.out.println(kwd);
		dis.forward(request, response);

	}

}
