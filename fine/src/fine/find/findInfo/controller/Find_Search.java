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

import fine.community.training.model.TrainingVO;
import fine.community.training.service.TrainingService;
import fine.find.findInfo.model.FindVO;
import fine.find.findInfo.service.FindService;

/**
 * Servlet implementation class Find_Search
 */
@WebServlet("/find_Search.do")
public class Find_Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Find_Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String sido = request.getParameter("sido");
		String sigungu = request.getParameter("sigungu");
		String address = sido+ " "+ sigungu;
		String dogKind = request.getParameter("dogKind");
		String happenDt = request.getParameter("happenDt");
		System.out.println("서블릿 : " + happenDt);
		System.out.println("서블릿 : "+ address);
		System.out.println("서블릿 : "+dogKind);
		if(dogKind == null) {
			System.out.println("견종못불러옴");
		}else {
			
			System.out.println("견종" + dogKind);
		}
		
		
		FindService fService = new FindService();
		List<FindVO> list = new ArrayList<FindVO>();
		 
			int pageSize = 10; // 페이지당 읽어올 글수
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			int pageBlock = 10;
		

		int count = fService.getSearchBoardCount(address,dogKind, happenDt);	
		System.out.println("불러온 개수: " + count);
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
		
		
		
		request.setAttribute("sido", sido);
		request.setAttribute("sigungu", sigungu);
		request.setAttribute("dogKind", dogKind);
		request.setAttribute("happenDt", happenDt);
		request.setAttribute("currentPage", currentPage); 
		request.setAttribute("count", count);
		request.setAttribute("endPage", endPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("pagecount", pagecount);
		list = fService.getSearchDogPage(startRnum, endRnum, address, dogKind, happenDt);
		request.setAttribute("list", list);
		System.out.println(list);
		RequestDispatcher dis = request.getRequestDispatcher("/view/find/fine_find_search.jsp");
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
