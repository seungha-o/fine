package fine.find.findInfo.controller;

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
import fine.find.findInfo.model.FindVO;
import fine.find.findInfo.service.FindService;

/**
 * Servlet implementation class Find_Lists
 */
@WebServlet("/find_Lists.do")
public class Find_Lists extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Find_Lists() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		FindService fService = new FindService();
		List<FindVO> list = new ArrayList<FindVO>();
		 
			int pageSize = 10; // 페이지당 읽어올 글수
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			int pageBlock = 10;
		

		int count = fService.getBoardCount(); 	
		System.out.println(count);
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
		
		list = fService.getFindInfo(startRnum, endRnum);
		System.out.println("안녕히세여 :" + list);
		request.setAttribute("list", list);
		
		RequestDispatcher dis = request.getRequestDispatcher("./view/find/fine_find_List.jsp");
		dis.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
